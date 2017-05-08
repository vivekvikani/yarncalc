package com.yarncostingindia.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.yarncostingindia.R;
import com.yarncostingindia.Utils.AndyConstants;
import com.yarncostingindia.parse.DecimalUtils;
import com.yarncostingindia.parse.shareScreenShot;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OneFragment extends Fragment {

    private EditText etA, etB, etC, etD, etE, etF, etG, etH, etI, etJ, etK, etL;
    private TextView tvProfit, tvJ, tvJunit;
    private NestedScrollView scrollView;
    private TableRow rowJ, rowK, rowL;
    private Button btnReset, btnWhatsapp;

    private float initialX, initialY;
    private Date date1;
    private Context ctx;
    protected View mView;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        mView = view;

        etA = (EditText) view.findViewById(R.id.etboxA);
        etB = (EditText) view.findViewById(R.id.etboxB);
        etC = (EditText) view.findViewById(R.id.etboxC);
        etD = (EditText) view.findViewById(R.id.etboxD);
        etE = (EditText) view.findViewById(R.id.etboxE);
        etF = (EditText) view.findViewById(R.id.etboxF);
        etG = (EditText) view.findViewById(R.id.etboxG);
        etH = (EditText) view.findViewById(R.id.etboxH);
        etI = (EditText) view.findViewById(R.id.etboxI);
        etJ = (EditText) view.findViewById(R.id.etboxJ);
        etK = (EditText) view.findViewById(R.id.etboxK);
        etL = (EditText) view.findViewById(R.id.etboxL);

        tvProfit = (TextView) view.findViewById(R.id.tvprofit);
        tvJ = (TextView) view.findViewById(R.id.tvJ);
        tvJunit = (TextView) view.findViewById(R.id.tvJunit);

        btnReset = (Button) view.findViewById(R.id.btnreset);
        btnWhatsapp = (Button) view.findViewById(R.id.btnwhatsapp);

        rowJ = (TableRow) view.findViewById(R.id.rowJ);
        rowK = (TableRow) view.findViewById(R.id.rowK);
        rowL = (TableRow) view.findViewById(R.id.rowL);

        scrollView = (NestedScrollView) view.findViewById(R.id.scrollView);

        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume(){

        super.onResume();

       // etB.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(4, 2)});


        String currentTime = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        Log.d("timeStamp", currentTime);
        Calendar date = new GregorianCalendar(2016, Calendar.MARCH, 26);
        date.add(Calendar.DAY_OF_WEEK, 0);
        String expireTime = new SimpleDateFormat("yyyyMMdd").format(date.getTime());

        int intcurrentTime = Integer.parseInt(currentTime);
        int intexpireTime = Integer.parseInt(expireTime);

        AndyConstants.currentTime = intcurrentTime;
        AndyConstants.expireTime = intexpireTime;

        if(intcurrentTime == intexpireTime || intcurrentTime > intexpireTime ) {

           tvJ.setText("Trial period expired!!");
           tvJ.setTypeface(null, Typeface.BOLD);
           tvJ.setTextColor(Color.RED);

           tvJunit.setVisibility(View.GONE);
           etJ.setVisibility(View.GONE);
           rowK.setVisibility(View.GONE);
           rowL.setVisibility(View.GONE);

           int maxLengthofEditText = 0;
           etA.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLengthofEditText)});
           etB.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLengthofEditText)});
       }

        Log.d("timeStamp2", expireTime);


        etA.setSelection(etA.getText().length());
        etB.setSelection(etB.getText().length());
        etC.setSelection(etC.getText().length());
        etD.setSelection(etD.getText().length());
        etE.setSelection(etE.getText().length());
        etF.setSelection(etF.getText().length());
        etG.setSelection(etG.getText().length());
        etH.setSelection(etH.getText().length());
        etI.setSelection(etI.getText().length());
        etJ.setSelection(etJ.getText().length());
        etK.setSelection(etK.getText().length());
        etL.setSelection(etL.getText().length());

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(false);
                builder.setTitle("Confirm");
                builder.setMessage("Reset all Values?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etA.setText("");
                        etB.setText("");
                        etC.setText("");
                        etD.setText("");
                        etE.setText("");
                        etF.setText("");
                        etG.setText("");
                        etH.setText("");
                        etI.setText("");
                        etJ.setText("");
                        etK.setText("");
                        etL.setText("");

                        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.toggleSoftInputFromWindow(etA.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                        etA.requestFocus();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view =  mView.findViewById(R.id.scrollView1);
                shareScreenShot obj = new shareScreenShot();
                obj.shareScreenShotM(view, (NestedScrollView) view);
                if(isPackageInstalled("com.whatsapp",getActivity())){

                    startActivity(obj.shareIntent);

                }else{

                    Toast.makeText(getActivity(), "Please Install Whatsapp", Toast.LENGTH_LONG).show();
                }



                etA.requestFocus();
                // InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                // imm.showSoftInput(etA, InputMethodManager.SHOW_IMPLICIT);
                // imm.showSoftInput(etA, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });



        etB.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        if (etB.getText().toString().startsWith(".")) {
                            etB.getText().insert(0, "0");
                        }

                        if (!etB.getText().toString().equals("")) {
                            float ans = (float) (Float.parseFloat(etB.getText().toString()) / 355.6164);

                            double number = ans;
                            double roundedNumber = DecimalUtils.round(number, 2);
                            float finalAns = (float) roundedNumber;
                            String money = String.format("%.2f", finalAns);

                            etC.setText(money);
                        } else {
                            etC.setText("");
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        String str = etB.getText().toString();
                        if (str.isEmpty()) return;
                        String str2 = PerfectDecimal(str, 7, 2);

                        if (!str2.equals(str)) {
                            etB.setText(str2);
                            int pos = etB.getText().length();
                            etB.setSelection(pos);
                        }
                    }
                });

        etC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etC.getText().toString().startsWith(".")){
                    etC.getText().insert(0,"0");
                }



                if (etC.getText().toString().equals("")) {

                    etF.setText("");
                } else if (!etC.getText().toString().equals("") && !etD.getText().toString().equals("") && !etE.getText().toString().equals("")) {

                    if(etD.getText().toString().equals("0") || etD.getText().toString().equals("0.")){
                        etF.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC.getText().toString()) * 100 / Float.parseFloat(etD.getText().toString())) - Float.parseFloat(etE.getText().toString());
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF.setText(money);
                    }
                } else if (!etC.getText().toString().equals("") && !etD.getText().toString().equals("")) {

                    if(etD.getText().toString().equals("0") || etD.getText().toString().equals("0.")){
                        etF.setText("");
                    }
                   else {
                        float ans = (float) (Float.parseFloat(etC.getText().toString()) * 100 / Float.parseFloat(etD.getText().toString()));
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF.setText(money);
                    }
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

                if(etD.getText().toString().startsWith(".")){
                    etD.getText().insert(0,"0");
                }

                if (!(etC.getText().toString().equals("") || etD.getText().toString().equals("")) && etE.getText().toString().equals("")) {

                    if(etD.getText().toString().equals("0") || etD.getText().toString().equals("0.")){
                        etF.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC.getText().toString()) * 100 / Float.parseFloat(etD.getText().toString()));
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF.setText(money);
                    }

                } else if (!etC.getText().toString().equals("") && !etD.getText().toString().equals("") && !etE.getText().toString().equals("")) {
                    if(etD.getText().toString().equals("0") || etD.getText().toString().equals("0.")){
                        etF.setText("");
                    }
                   else {
                        float ans = (float) (Float.parseFloat(etC.getText().toString()) * 100 / Float.parseFloat(etD.getText().toString())) - Float.parseFloat(etE.getText().toString());
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF.setText(money);
                    }
                } else {
                    etF.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = etD.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 2, 2);

                if (!str2.equals(str)) {
                    etD.setText(str2);
                    int pos = etD.getText().length();
                    etD.setSelection(pos);
                }
            }
        });

        etE.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etE.getText().toString().startsWith(".")){
                    etE.getText().insert(0,"0");
                }

                if ((!etC.getText().toString().equals("") && !etD.getText().toString().equals("")) && etE.getText().toString().equals("")) {

                    if(etD.getText().toString().equals("0") || etD.getText().toString().equals("0.")){
                        etF.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC.getText().toString()) * 100 / Float.parseFloat(etD.getText().toString()));
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF.setText(money);
                    }
                } else if((!etC.getText().toString().equals("") && !etD.getText().toString().equals("")) && !etE.getText().toString().equals("")) {

                    if(etD.getText().toString().equals("0") || etD.getText().toString().equals("0.")){
                        etF.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC.getText().toString()) * 100 / Float.parseFloat(etD.getText().toString())) - Float.parseFloat(etE.getText().toString());
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF.setText(money);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = etE.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etE.setText(str2);
                    int pos = etE.getText().length();
                    etE.setSelection(pos);
                }
            }
        });

        etI.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etI.getText().toString().startsWith(".")){
                    etI.getText().insert(0,"0");
                }
                if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else{
                    etJ.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String str = etI.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etI.setText(str2);
                    int pos = etI.getText().length();
                    etI.setSelection(pos);
                }
            }
        });

        etK.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if(etK.getText().toString().startsWith(".")){
                    etK.getText().insert(0,"0");
                }

                if ((!etJ.getText().toString().equals("") && !etK.getText().toString().equals(""))) {

                    float ans = (float) (Float.parseFloat(etK.getText().toString()) - Float.parseFloat(etJ.getText().toString()));

                    if (Float.parseFloat(etJ.getText().toString()) > Float.parseFloat(etK.getText().toString())) {

                        tvProfit.setText("Loss");
                        ans = ans - (ans * 2);
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL.setText(money);
                        etL.setBackgroundResource(R.drawable.ans_loss);
                    } else {

                        tvProfit.setText("Profit");
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL.setText(money);
                        etL.setBackgroundResource(R.drawable.ans_rounded_corner_edittext);
                    }
                } else if (etJ.getText().toString().equals("") || etK.getText().toString().equals("")) {


                    etL.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = etK.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etK.setText(str2);
                    int pos = etK.getText().length();
                    etK.setSelection(pos);
                }
            }
        });

        etJ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etJ.getText().toString().startsWith(".")){
                    etJ.getText().insert(0,"0");
                }

                if ((!etJ.getText().toString().equals("") && !etK.getText().toString().equals(""))) {

                    float ans = (float) (Float.parseFloat(etK.getText().toString()) - Float.parseFloat(etJ.getText().toString()));

                    if (Float.parseFloat(etJ.getText().toString()) > Float.parseFloat(etK.getText().toString())) {

                        tvProfit.setText("Loss");
                        ans = ans - (ans * 2);
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL.setText(money);
                        etL.setBackgroundResource(R.drawable.ans_loss);
                    } else {

                        tvProfit.setText("Profit");
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL.setText(money);
                        etL.setBackgroundResource(R.drawable.ans_rounded_corner_edittext);
                    }
                } else if (etJ.getText().toString().equals("") || etK.getText().toString().equals("")) {


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

                if(etA.getText().toString().startsWith(".")){
                    etA.getText().insert(0,"0");
                }

                if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else{
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

                if(etF.getText().toString().startsWith(".")){
                    etF.getText().insert(0,"0");
                }

                if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else{
                    etJ.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

                String str = etF.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etF.setText(str2);
                    int pos = etF.getText().length();
                    etF.setSelection(pos);
                }
            }
        });

        etG.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etG.getText().toString().startsWith(".")){
                    etG.getText().insert(0,"0");
                }

                if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else{
                    etJ.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String str = etG.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etG.setText(str2);
                    int pos = etG.getText().length();
                    etG.setSelection(pos);
                }
            }
        });

        etH.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etH.getText().toString().startsWith(".")){
                    etH.getText().insert(0,"0");
                }

                if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && !etH.getText().toString().equals("") && etI.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                            (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                } else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && !etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString())) +
                           // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else if ((!etF.getText().toString().equals("") && !etA.getText().toString().equals("")) && !etG.getText().toString().equals("") && etH.getText().toString().equals("") && etI.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF.getText().toString())) +
                            (Float.parseFloat(etA.getText().toString()) * Float.parseFloat(etG.getText().toString()));
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ.setText(money);
                }else{
                    etJ.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String str = etH.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 2, 2);

                if (!str2.equals(str)) {
                    etH.setText(str2);
                    int pos = etH.getText().length();
                    etH.setSelection(pos);
                }
            }
        });

    }

    private boolean isPackageInstalled(String packagename, Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public String PerfectDecimal(String str, int MAX_BEFORE_POINT, int MAX_DECIMAL){
        if(str.charAt(0) == '.') str = "0"+str;
        int max = str.length();

        String rFinal = "";
        boolean after = false;
        int i = 0, up = 0, decimal = 0; char t;
        while(i < max){
            t = str.charAt(i);
            if(t != '.' && after == false){
                up++;
                if(up > MAX_BEFORE_POINT) return rFinal;
            }else if(t == '.'){
                after = true;
            }else{
                decimal++;
                if(decimal > MAX_DECIMAL)
                    return rFinal;
            }
            rFinal = rFinal + t;
            i++;
        }return rFinal;
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

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences appdata = PreferenceManager.getDefaultSharedPreferences(this.getActivity());


        etA.setText(appdata.getString("A", ""));
        etB.setText(appdata.getString("B", ""));
        etC.setText(appdata.getString("C", ""));
        etD.setText(appdata.getString("D", ""));
        etE.setText(appdata.getString("E", ""));
        etF.setText(appdata.getString("F", ""));
        etG.setText(appdata.getString("G", ""));
        etH.setText(appdata.getString("H", ""));
        etI.setText(appdata.getString("I", ""));
        etJ.setText(appdata.getString("J", ""));
        etK.setText(appdata.getString("K", ""));
        etL.setText(appdata.getString("L", ""));

        Log.d("pro",appdata.getString("tvprofit",""));
        if(appdata.getString("tvprofit","").equals("Loss")){
            tvProfit.setText("Loss");
            etL.setBackgroundResource(R.drawable.ans_loss);
        }
    }

  /*  @Override
    public void onPause(){

        super.onPause();
        SharedPreferences appdata = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        SharedPreferences.Editor editor = appdata.edit();

        editor.clear();
        editor.putString("A", etA.getText().toString());
        editor.putString("B", etB.getText().toString());
        editor.putString("C", etC.getText().toString());
        editor.putString("D", etD.getText().toString());
        editor.putString("E", etE.getText().toString());
        editor.putString("F", etF.getText().toString());
        editor.putString("G", etG.getText().toString());
        editor.putString("H", etH.getText().toString());
        editor.putString("I", etI.getText().toString());
        editor.putString("J", etJ.getText().toString());
        editor.putString("K", etK.getText().toString());
        editor.putString("L", etL.getText().toString());
        editor.commit();

        Log.d("pause", "pause called");

    }*/

    @Override
    public void onStop() {
        super.onStop();

        SharedPreferences appdata = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        SharedPreferences.Editor editor = appdata.edit();

        //editor.clear();

        editor.putString("A", etA.getText().toString());
        editor.putString("B", etB.getText().toString());
        editor.putString("C", etC.getText().toString());
        editor.putString("D", etD.getText().toString());
        editor.putString("E", etE.getText().toString());
        editor.putString("F", etF.getText().toString());
        editor.putString("G", etG.getText().toString());
        editor.putString("H", etH.getText().toString());
        editor.putString("I", etI.getText().toString());
        editor.putString("J", etJ.getText().toString());
        editor.putString("K", etK.getText().toString());
        editor.putString("L", etL.getText().toString());
        editor.putString("tvprofit",tvProfit.getText().toString());

        editor.commit();
    }

}






