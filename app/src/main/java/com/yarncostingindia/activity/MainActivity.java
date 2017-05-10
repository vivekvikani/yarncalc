package com.yarncostingindia.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.yarncostingindia.R;
import com.yarncostingindia.Utils.AppRater;
import com.yarncostingindia.fragments.OneFragment;
import com.yarncostingindia.fragments.ThreeFragment;
import com.yarncostingindia.fragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    public  ViewPager viewPager;

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

        AppRater.app_launched(this);
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


















   /* private EditText etA, etB, etC, etD, etE, etF, etG, etH, etI, etJ, etK, etL;
    private TextView tvProfit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etA = (EditText) findViewById(R.id.etboxA);
        etB = (EditText) findViewById(R.id.etboxB);
        etC = (EditText) findViewById(R.id.etboxC);
        etD = (EditText) findViewById(R.id.etboxD);
        etE = (EditText) findViewById(R.id.etboxE);
        etF = (EditText) findViewById(R.id.etboxF);
        etG = (EditText) findViewById(R.id.etboxG);
        etH = (EditText) findViewById(R.id.etboxH);
        etI = (EditText) findViewById(R.id.etboxI);
        etJ = (EditText) findViewById(R.id.etboxJ);
        etK = (EditText) findViewById(R.id.etboxK);
        etL = (EditText) findViewById(R.id.etboxL);

        tvProfit = (TextView) findViewById(R.id.tvprofit);

       // etA.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(5, 1)});
        etB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!etB.getText().toString().equals("")){
                    float ans = (float) (Float.parseFloat(etB.getText().toString())/355.6164);
                    etC.setText(String.valueOf(ans));
                }
                else {
                    etC.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etC.getText().toString().equals("")){

                    etF.setText("");
                }else if(!etC.getText().toString().equals("") && !etD.getText().toString().equals("") && !etE.getText().toString().equals("")){
                    float ans = (float)  ( Float.parseFloat(etC.getText().toString())*100 / Float.parseFloat(etD.getText().toString())) - Float.parseFloat(etE.getText().toString());
                    etF.setText(String.valueOf(ans));
                }
                else if(!etC.getText().toString().equals("") && !etD.getText().toString().equals("")){

                    float ans = (float)  ( Float.parseFloat(etC.getText().toString())*100 / Float.parseFloat(etD.getText().toString()));
                    etF.setText(String.valueOf(ans));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etD.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(! (etC.getText().toString().equals("") || etD.getText().toString().equals("")) && etE.getText().toString().equals("")){

                    float ans = (float)  ( Float.parseFloat(etC.getText().toString())*100 / Float.parseFloat(etD.getText().toString()));
                    etF.setText(String.valueOf(ans));

                }else if(!etC.getText().toString().equals("") && !etD.getText().toString().equals("") && !etE.getText().toString().equals("")){
                    float ans = (float)  ( Float.parseFloat(etC.getText().toString())*100 / Float.parseFloat(etD.getText().toString())) - Float.parseFloat(etE.getText().toString());
                    etF.setText(String.valueOf(ans));
                }
                else  {
                    etF.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etE.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if((!etC.getText().toString().equals("") && !etD.getText().toString().equals("")) && etE.getText().toString().equals("")){

                    float ans = (float)  ( Float.parseFloat(etC.getText().toString())*100 / Float.parseFloat(etD.getText().toString()));
                    etF.setText(String.valueOf(ans));
                }
                else {
                    float ans = (float)  ( Float.parseFloat(etC.getText().toString())*100 / Float.parseFloat(etD.getText().toString())) - Float.parseFloat(etE.getText().toString());
                    etF.setText(String.valueOf(ans));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etI.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")){

                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                                         ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                                         ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) )) +
                                         ( Float.parseFloat(etI.getText().toString()));
                    etJ.setText(String.valueOf(ans));
                }
               else if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")){
                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                            ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                            ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) ));
                    etJ.setText(String.valueOf(ans));
                }
            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etK.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if((!etJ.getText().toString().equals("") && !etK.getText().toString().equals(""))){

                    float ans = (float)  ( Float.parseFloat(etK.getText().toString()) - Float.parseFloat(etJ.getText().toString()));

                    if( Float.parseFloat(etJ.getText().toString()) > Float.parseFloat(etK.getText().toString())){

                        tvProfit.setText("Loss");
                        ans = ans - (ans*2);
                        etL.setText(String.valueOf(ans));
                    }else {

                        tvProfit.setText("Profit");
                        etL.setText(String.valueOf(ans));
                    }
                }
                else if(etJ.getText().toString().equals("") || etK.getText().toString().equals("")) {


                    etL.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etJ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if((!etJ.getText().toString().equals("") && !etK.getText().toString().equals(""))){

                    float ans = (float)  ( Float.parseFloat(etK.getText().toString()) - Float.parseFloat(etJ.getText().toString()));

                    if( Float.parseFloat(etJ.getText().toString()) > Float.parseFloat(etK.getText().toString())){

                        tvProfit.setText("Loss");
                        ans = ans - (ans*2);
                        etL.setText(String.valueOf(ans));
                    }else {

                        tvProfit.setText("Profit");
                        etL.setText(String.valueOf(ans));
                    }
                }
                else if(etJ.getText().toString().equals("") || etK.getText().toString().equals("")) {


                    etL.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")){

                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                            ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                            ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) )) +
                            ( Float.parseFloat(etI.getText().toString()));
                    etJ.setText(String.valueOf(ans));
                } else if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")){
                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                            ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                            ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) ));
                    etJ.setText(String.valueOf(ans));
                }
                else if(etA.getText().toString().equals("")){

                    etJ.setText("");
                }
            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etF.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")){

                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                            ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                            ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) )) +
                            ( Float.parseFloat(etI.getText().toString()));
                    etJ.setText(String.valueOf(ans));
                } else if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")){
                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                            ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                            ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) ));
                    etJ.setText(String.valueOf(ans));
                }
                else if(etF.getText().toString().equals("")){

                    etJ.setText("");
                }
            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etG.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")){

                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                            ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                            ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) )) +
                            ( Float.parseFloat(etI.getText().toString()));
                    etJ.setText(String.valueOf(ans));
                } else if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")){
                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                            ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                            ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) ));
                    etJ.setText(String.valueOf(ans));
                }
                else if(etG.getText().toString().equals("")){

                    etJ.setText("");
                }
            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")){

                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                            ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                            ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) )) +
                            ( Float.parseFloat(etI.getText().toString()));
                    etJ.setText(String.valueOf(ans));
                } else if((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")){
                    float ans = (float)  ( Float.parseFloat(etF.getText().toString()) ) +
                            ( Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()) ) +
                            ( Float.parseFloat(etF.getText().toString()) * ( (Float.parseFloat(etH.getText().toString()) / 100) ));
                    etJ.setText(String.valueOf(ans));
                }
                else if(etH.getText().toString().equals("")){

                    etJ.setText("");
                }
            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public class DecimalDigitsInputFilter implements InputFilter {

        Pattern mPattern;

        public DecimalDigitsInputFilter(int digitsBeforeZero,int digitsAfterZero) {
            mPattern= Pattern.compile("[0-9]{0," + (digitsBeforeZero - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) + "})?)||(\\.)?");
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            Matcher matcher=mPattern.matcher(dest);
            if(!matcher.matches())
                return "";
            return null;
        }

    }*/

