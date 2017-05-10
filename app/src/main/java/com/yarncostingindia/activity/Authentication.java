package com.yarncostingindia.activity;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.yarncostingindia.R;
import com.yarncostingindia.Utils.AndyUtils;
import com.yarncostingindia.Utils.AndyConstants;
import com.yarncostingindia.parse.HttpRequester;
import com.yarncostingindia.parse.AsyncTaskCompleteListener;
import com.yarncostingindia.parse.ParseContent;
import java.util.ArrayList;
import java.util.HashMap;

public class Authentication extends AppCompatActivity implements AsyncTaskCompleteListener{

    Button btnenter;
    EditText etName, etNumber;
    String VersionNumber;
    public String operatorName;
    public String IMEI;
    public String simID;
    private ArrayList<HashMap<String,String>> alldetails;
    private static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 1;
    TelephonyManager telephonyManager;
    ProgressDialog progress;
    ParseContent parseContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progress = new ProgressDialog(this);
        progress.setTitle("Preparing App");
        progress.setMessage("This may take a few seconds...");
        progress.setCancelable(false);
        progress.show();

        setContentView(R.layout.activity_authentication);
        VersionNumber= getString(R.string.version_number);
        btnenter = (Button) findViewById(R.id.btnenter);
        etName = (EditText) findViewById(R.id.etname);
        etNumber = (EditText) findViewById(R.id.etnumber);

        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        operatorName = telephonyManager.getNetworkOperatorName();
        checkPermission();

        btnenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nameS = etName.getText().toString();
                final String numberS = etNumber.getText().toString();

                if (nameS.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                } else if (numberS.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                } else if (numberS.length() < 10 || numberS.length() > 13) {
                    Toast.makeText(getApplicationContext(), "Mobile Number should 10 to 13 digit long", Toast.LENGTH_SHORT).show();
                } else {
                    btnenter.setEnabled(false);

                    progress = new ProgressDialog(Authentication.this);
                    progress.setTitle("Activating Free Trial");
                    progress.setMessage("Wait while contacting server...");
                    progress.setCancelable(false);
                    progress.show();
                    btnenter.setEnabled(true);

                    final boolean[] bool = {true};
                    final Handler handler = new Handler();
                    final Thread thread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                while (bool[0]) {
                                    checkAndSave(nameS,numberS);
                                    Looper.prepare();
                                    handler.post(this);
                                    bool[0] = false;
                                }
                            }catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    thread.start();
                }
            }
        });
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        }else
        {
            continueLaunch();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_PHONE_STATE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    continueLaunch();

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Authentication.this);
                    builder.setCancelable(false);
                    builder.setTitle("Permission Required");
                    builder.setMessage("This permission is required to continue using the app.");
                    builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            checkPermission();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }
        }
    }

    public void continueLaunch(){
        IMEI = telephonyManager.getDeviceId();
        simID = telephonyManager.getSimSerialNumber();
        parseContent = new ParseContent(this);
        checkIMEI();
    }

    private void checkIMEI() {
        if (!AndyUtils.isNetworkAvailable(Authentication.this)) {
            AndyUtils.showToast(
                    "Internet is not available!",
                    Authentication.this);
            progress.dismiss();
            return;
        }

        HashMap<String, String> map = new HashMap<String, String>();
        map.put(AndyConstants.URL, AndyConstants.ServiceType.CHECKIMEI);

        map.put(AndyConstants.Params.IMEI, IMEI);
        new HttpRequester(Authentication.this, map,
                AndyConstants.ServiceCode.CHECKIMEI, this);
    }

    private void checkAndSave(String name, String number) {
        if (!AndyUtils.isNetworkAvailable(Authentication.this)) {
            AndyUtils.showToast(
                    "Internet is not available!",
                    Authentication.this);
            progress.dismiss();
        }else{
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(AndyConstants.URL, AndyConstants.ServiceType.REGISTERATION);

            map.put(AndyConstants.Params.IMEI, IMEI);
            map.put(AndyConstants.Params.VERSION, VersionNumber);
            map.put(AndyConstants.Params.DAYS_LEFT, getString(R.string.days_left));
            map.put(AndyConstants.Params.NAME, name);
            map.put(AndyConstants.Params.MOBILE, number);
            map.put(AndyConstants.Params.CITY, "Not checking Location");
            new HttpRequester(Authentication.this, map,
                    AndyConstants.ServiceCode.REGISTER, this);
        }
    }

    @Override
    public void onTaskCompleted(String response, int serviceCode) {
        switch (serviceCode) {
            case AndyConstants.ServiceCode.REGISTER:

                if (parseContent.isSuccess(response)) {
                    SharedPreferences appdata = PreferenceManager.getDefaultSharedPreferences(Authentication.this);
                    SharedPreferences.Editor editor = appdata.edit();
                    alldetails = parseContent.getDetaillogin(response);
                    editor.putInt("daysLeft", Integer.parseInt(alldetails.get(0).get(AndyConstants.Params.DAYS_LEFT)));
                    editor.putString("userName", alldetails.get(0).get(AndyConstants.Params.NAME));
                    editor.putString("phnNumber", alldetails.get(0).get(AndyConstants.Params.MOBILE));
                    editor.putBoolean("nameNumberEntered", true);
                    //editor.putBoolean("parseEntryDone", true);
                    //editor.putInt("userRegistered", 0);
                    editor.commit();

                    progress.dismiss();

                    Intent myIntent = new Intent(Authentication.this, MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }else {
                    AndyUtils.showToast(
                            "Unable to register",
                            Authentication.this);
                    progress.dismiss();
                }
                break;

            case AndyConstants.ServiceCode.CHECKIMEI:

                if (parseContent.isSuccess(response)) {

                    SharedPreferences appdata = PreferenceManager.getDefaultSharedPreferences(Authentication.this);
                    SharedPreferences.Editor editor = appdata.edit();

                    alldetails = parseContent.getDetaillogin(response);
                    editor.putInt("daysLeft", Integer.parseInt(alldetails.get(0).get(AndyConstants.Params.DAYS_LEFT)));
                    editor.putString("userName", alldetails.get(0).get(AndyConstants.Params.NAME));
                    editor.putString("phnNumber", alldetails.get(0).get(AndyConstants.Params.MOBILE));
                    editor.putBoolean("nameNumberEntered", true);
                    //editor.putBoolean("parseEntryDone", true);
                    //editor.putInt("userRegistered", 0);
                    editor.commit();

                    progress.dismiss();

                    Intent myIntent = new Intent(Authentication.this, MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
                else
                {
                    progress.dismiss();
                }
                break;

            default:
                break;
        }
    }
}
