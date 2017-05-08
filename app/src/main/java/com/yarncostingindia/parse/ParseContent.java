package com.yarncostingindia.parse;

import android.app.Activity;
import android.util.Log;
import com.yarncostingindia.Utils.AndyConstants;
import com.yarncostingindia.Utils.AppLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseContent {

    private final String KEY_SUCCESS = "ack";
    private final String KEY_MSG = "ack_msg";
    private final String KEY_DATA = "data";


    private Activity activity;


    ArrayList<HashMap<String, String>> arraylist;

    public ParseContent(Activity activity) {
        this.activity = activity;
    }

    public boolean isSuccess(String response) {

        try {
            JSONObject jsonObject = new JSONObject(response);

            return jsonObject.optString(KEY_SUCCESS).equals("1");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }


    public String getErrorCode(String response) {

        try {
            AppLog.Log("TAG", response);
            JSONObject jsonObject = new JSONObject(response);
            return jsonObject.getString(KEY_MSG);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "No data";
    }

    public ArrayList<HashMap<String, String>> getDetail(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(KEY_SUCCESS).equals("1")) {

                arraylist = new ArrayList<HashMap<String, String>>();
                JSONArray jsonArray = jsonObject.getJSONArray("result");

                for (int i = 0; i < jsonArray.length(); i++) {

                    HashMap<String, String> map = new HashMap<String, String>();
                    JSONObject obj = jsonArray.getJSONObject(i);
                  //  JSONObject job = obj.getJSONObject("User");


                    Log.d("obj", obj.toString());

                    map.put(AndyConstants.Params.IMEI, obj.getString(AndyConstants.Params.IMEI));
                    map.put(AndyConstants.Params.ID, obj.getString(AndyConstants.Params.ID));
                    map.put(AndyConstants.Params.NAME, obj.getString(AndyConstants.Params.NAME));
                    map.put(AndyConstants.Params.EMAIL, obj.getString(AndyConstants.Params.EMAIL));
                    map.put(AndyConstants.Params.MOBILE, obj.getString(AndyConstants.Params.MOBILE));
                    map.put(AndyConstants.Params.CITY, obj.getString(AndyConstants.Params.CITY));
                    map.put(AndyConstants.Params.VERSION, obj.getString(AndyConstants.Params.VERSION));
                    map.put(AndyConstants.Params.DAYS_LEFT, obj.getString(AndyConstants.Params.DAYS_LEFT));
                    map.put(AndyConstants.Params.ISACTIVE, obj.getString(AndyConstants.Params.ISACTIVE));

                    Log.d("map", map.toString());
                    arraylist.add(map);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arraylist;
    }

    public ArrayList<HashMap<String, String>> getDetaillogin(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(KEY_SUCCESS).equals("1")) {

                arraylist = new ArrayList<HashMap<String, String>>();
                JSONObject jsonArray = jsonObject.getJSONObject("result");

                for (int i = 0; i < jsonArray.length(); i++) {

                    HashMap<String, String> map = new HashMap<String, String>();
                    JSONObject obj = jsonArray;
                    //  JSONObject job = obj.getJSONObject("User");

                    map.put(AndyConstants.Params.IMEI, obj.getString(AndyConstants.Params.IMEI));
                    map.put(AndyConstants.Params.ID, obj.getString(AndyConstants.Params.ID));
                    map.put(AndyConstants.Params.NAME, obj.getString(AndyConstants.Params.NAME));
                    map.put(AndyConstants.Params.MOBILE, obj.getString(AndyConstants.Params.MOBILE));
                    map.put(AndyConstants.Params.CITY, obj.getString(AndyConstants.Params.CITY));
                    map.put(AndyConstants.Params.VERSION, obj.getString(AndyConstants.Params.VERSION));
                    map.put(AndyConstants.Params.DAYS_LEFT, obj.getString(AndyConstants.Params.DAYS_LEFT));
                    map.put(AndyConstants.Params.INSTALL_DATE, obj.getString(AndyConstants.Params.INSTALL_DATE));
                    arraylist.add(map);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arraylist;
    }

    public ArrayList<HashMap<String, String>> getDetailVersionCheck(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString(KEY_SUCCESS).equals("1")) {

                arraylist = new ArrayList<HashMap<String, String>>();
                JSONObject jsonArray = jsonObject.getJSONObject("result");

                for (int i = 0; i < jsonArray.length(); i++) {

                    HashMap<String, String> map = new HashMap<String, String>();
                    JSONObject obj = jsonArray;

                    map.put(AndyConstants.Params.VERSIONDB, obj.getString(AndyConstants.Params.VERSIONDB));
                    map.put(AndyConstants.Params.ISCOMPLUSORY, obj.getString(AndyConstants.Params.ISCOMPLUSORY));
                    arraylist.add(map);
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arraylist;
    }

    public String getPaymentURL(String response){
        String url = null;
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONObject jsonArray = jsonObject.getJSONObject("payment_request");
            url = jsonArray.getString(AndyConstants.Params.PAYMENTREQUESTURL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("PAYMENT URL: "+url);
        return url;
    }

}
