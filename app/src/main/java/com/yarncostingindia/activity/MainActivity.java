package com.yarncostingindia.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.yarncostingindia.R;
import com.yarncostingindia.Utils.AndyConstants;
import com.yarncostingindia.Utils.AndyUtils;
import com.yarncostingindia.Utils.AppRater;
import com.yarncostingindia.Utils.DaysLeftDaily;
import com.yarncostingindia.fragments.OneFragment;
import com.yarncostingindia.fragments.ThreeFragment;
import com.yarncostingindia.fragments.TwoFragment;
import com.yarncostingindia.parse.AsyncTaskCompleteListener;
import com.yarncostingindia.parse.HttpRequester;
import com.yarncostingindia.Utils.AndyConstants.SP;
import com.yarncostingindia.parse.ParseContent;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AsyncTaskCompleteListener{


    private TabLayout tabLayout;
    public  ViewPager viewPager;
    private ParseContent parseContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

       // getSupportActionBar().setHomeAsUpIndicator(R.mipmap.back_button);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View headerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.custome_tab, null, false);
        TextView tabOne = (TextView) headerView.findViewById(R.id.tvtab1);
        TextView tabTwo = (TextView) headerView.findViewById(R.id.tvtab2);
        TextView tabThree = (TextView) headerView.findViewById(R.id.tvtab3);

        tabLayout.getTabAt(0).setCustomView(tabOne);
        tabLayout.getTabAt(1).setCustomView(tabTwo);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        parseContent = new ParseContent(this);
        DaysLeftDaily.daysLeftCheckLocal(this); //Checks and reduces days left daily locally
        AppRater.app_launched(this);
        checkDaysLeftonServer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DaysLeftDaily.daysLeftCheckLocal(this); //Checks and reduces days left daily locally
    }

    private void checkDaysLeftonServer() {
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        if (!AndyUtils.isNetworkAvailable(MainActivity.this)) {
            AndyUtils.showToast(
                    "Internet is not available!",
                    MainActivity.this);
        }
        SharedPreferences appdata = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(AndyConstants.URL, AndyConstants.ServiceType.LOGIN);

        map.put(AndyConstants.Params.IMEI, appdata.getString(SP.IMEI,"0"));
        map.put(AndyConstants.Params.VERSION, getString(R.string.version_number));
        map.put(AndyConstants.Params.DAYS_LEFT, String.valueOf(appdata.getInt(SP.DAYSLEFT, 0)));
        map.put(AndyConstants.Params.LAST_ACCESS, currentDateTimeString);
        map.put(AndyConstants.Params.NOTIFICATION_TOKEN, appdata.getString(SP.FIREBASETOKEN, null));

        new HttpRequester(MainActivity.this, map,
                AndyConstants.ServiceCode.LOGIN, this);
    }

    @Override
    public void onTaskCompleted(String response, int serviceCode) {
        Log.d("responsejson login", response);
        switch (serviceCode) {
            case AndyConstants.ServiceCode.LOGIN:

                if (parseContent.isSuccess(response)) {

                    SharedPreferences appdata = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    SharedPreferences.Editor editor = appdata.edit();

                    ArrayList<HashMap<String, String>> alldetails = parseContent.getDetaillogin(response);
                    System.out.println("DAYS LEFT HTTP SERVER: " + alldetails.get(0).get(AndyConstants.Params.DAYS_LEFT));
                    editor.putInt(SP.DAYSLEFT, Integer.parseInt(alldetails.get(0).get(AndyConstants.Params.DAYS_LEFT)));
                    editor.commit();
                } else {
                    String msg = parseContent.getErrorCode(response);
                    Log.d("Login error", msg);
                }
                break;
            default:
                break;
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "ONE");
        adapter.addFragment(new TwoFragment(), "TWO");
        adapter.addFragment(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem item = menu.findItem(R.id.action_aboutus);
        item.setActionView(R.layout.customemenu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if(id == R.id.action_aboutus){

            startActivity(new Intent(this,AboutusActivity.class));
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void aboutusClicked(View v){
        startActivity(new Intent(this,AboutusActivity.class));
    }
}

