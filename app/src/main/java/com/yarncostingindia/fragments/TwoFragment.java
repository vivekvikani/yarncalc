package com.yarncostingindia.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TwoFragment extends Fragment {

    private EditText etA2, etB2, etC2, etD2, etE2, etF2, etG2, etH2, etI2, etJ2, etK2, etL2;
    private TextView tvProfit2, tvJ2, tvJ2unit;
    private NestedScrollView scrollView;
    private TableRow rowK2, rowL2;
    private Button btnReset2, btnWhatsapp2;
    protected View mView2;


    float initialX, initialY;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        mView2 = view;

        etA2 = (EditText) view.findViewById(R.id.etboxA2);
        etB2 = (EditText) view.findViewById(R.id.etboxB2);
        etC2= (EditText) view.findViewById(R.id.etboxC2);
        etD2 = (EditText) view.findViewById(R.id.etboxD2);
        etE2 = (EditText) view.findViewById(R.id.etboxE2);
        etF2 = (EditText) view.findViewById(R.id.etboxF2);
        etG2 = (EditText) view.findViewById(R.id.etboxG2);
        etH2 = (EditText) view.findViewById(R.id.etboxH2);
        etI2 = (EditText) view.findViewById(R.id.etboxI2);
        etJ2 = (EditText) view.findViewById(R.id.etboxJ2);
        etK2 = (EditText) view.findViewById(R.id.etboxK2);
        etL2 = (EditText) view.findViewById(R.id.etboxL2);

        tvProfit2 = (TextView) view.findViewById(R.id.tvprofit2);
        tvJ2 = (TextView) view.findViewById(R.id.tvJ2);
        tvJ2unit = (TextView) view.findViewById(R.id.tvJ2unit);

        btnReset2 = (Button) view.findViewById(R.id.btnreset2);
        btnWhatsapp2 = (Button) view.findViewById(R.id.btnwhatsapp2);

        rowK2 = (TableRow) view.findViewById(R.id.rowK2);
        rowL2 = (TableRow) view.findViewById(R.id.rowL2);

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
       /* String currentTime = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        Log.d("timeStamp", currentTime);
        Calendar date = new GregorianCalendar(2016, Calendar.MARCH, 26);
        date.add(Calendar.DAY_OF_WEEK, 0);
        String expireTime = new SimpleDateFormat("yyyyMMdd").format(date.getTime());

        int intcurrentTime = Integer.parseInt(currentTime);
        int intexpireTime = Integer.parseInt(expireTime);
*/
        if(AndyConstants.currentTime == AndyConstants.expireTime || AndyConstants.currentTime > AndyConstants.expireTime ) {


            tvJ2.setText("Trial period expired!!");
            tvJ2.setTypeface(null, Typeface.BOLD);
            tvJ2.setTextColor(Color.RED);

            tvJ2unit.setVisibility(View.GONE);
            etJ2.setVisibility(View.GONE);
            rowK2.setVisibility(View.GONE);
            rowL2.setVisibility(View.GONE);

            int maxLengthofEditText = 0;
            etA2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLengthofEditText)});
            etB2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLengthofEditText)});


          //  Log.d("timeStamp2", expireTime);
        }

        etA2.setSelection(etA2.getText().length());
        etB2.setSelection(etB2.getText().length());
        etC2.setSelection(etC2.getText().length());
        etD2.setSelection(etD2.getText().length());
        etE2.setSelection(etE2.getText().length());
        etF2.setSelection(etF2.getText().length());
        etG2.setSelection(etG2.getText().length());
        etH2.setSelection(etH2.getText().length());
        etI2.setSelection(etI2.getText().length());
        etJ2.setSelection(etJ2.getText().length());
        etK2.setSelection(etK2.getText().length());
        etL2.setSelection(etL2.getText().length());

        btnReset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(false);
                builder.setTitle("Confirm");
                builder.setMessage("Reset all Values?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etA2.setText("");
                        etB2.setText("");
                        etC2.setText("");
                        etD2.setText("");
                        etE2.setText("");
                        etF2.setText("");
                        etG2.setText("");
                        etH2.setText("");
                        etI2.setText("");
                        etJ2.setText("");
                        etK2.setText("");
                        etL2.setText("");

                        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.toggleSoftInputFromWindow(etA2.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                        etA2.requestFocus();
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

        btnWhatsapp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view =  mView2.findViewById(R.id.scrollView2);
                shareScreenShot obj = new shareScreenShot();
                obj.shareScreenShotM(view, (NestedScrollView) view);
                if(isPackageInstalled("com.whatsapp",getActivity())){

                    startActivity(obj.shareIntent);

                }else{

                    Toast.makeText(getActivity(), "Please Install Whatsapp", Toast.LENGTH_LONG).show();
                }



                etA2.requestFocus();
                // InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                // imm.showSoftInput(etA, InputMethodManager.SHOW_IMPLICIT);
                // imm.showSoftInput(etA, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        etB2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etB2.getText().toString().startsWith(".")){
                    etB2.getText().insert(0,"0");
                }

                if (!etB2.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etB2.getText().toString()) / 355.6164);

                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etC2.setText(money);
                } else {
                    etC2.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = etB2.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 7, 2);

                if (!str2.equals(str)) {
                    etB2.setText(str2);
                    int pos = etB2.getText().length();
                    etB2.setSelection(pos);
                }
            }
        });

        etC2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etC2.getText().toString().startsWith(".")){
                    etC2.getText().insert(0,"0");
                }



                if (etC2.getText().toString().equals("")) {

                    etF2.setText("");
                } else if (!etC2.getText().toString().equals("") && !etD2.getText().toString().equals("") && !etE2.getText().toString().equals("")) {

                    if(etD2.getText().toString().equals("0") || etD2.getText().toString().equals("0.")){
                        etF2.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC2.getText().toString()) * 100 / Float.parseFloat(etD2.getText().toString())) - Float.parseFloat(etE2.getText().toString());
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF2.setText(money);
                    }
                } else if (!etC2.getText().toString().equals("") && !etD2.getText().toString().equals("")) {

                    if(etD2.getText().toString().equals("0") || etD2.getText().toString().equals("0.")){
                        etF2.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC2.getText().toString()) * 100 / Float.parseFloat(etD2.getText().toString()));
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF2.setText(money);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etD2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etD2.getText().toString().startsWith(".")){
                    etD2.getText().insert(0,"0");
                }

                if (!(etC2.getText().toString().equals("") || etD2.getText().toString().equals("")) && etE2.getText().toString().equals("")) {

                    if(etD2.getText().toString().equals("0") || etD2.getText().toString().equals("0.")){
                        etF2.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC2.getText().toString()) * 100 / Float.parseFloat(etD2.getText().toString()));
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF2.setText(money);
                    }

                } else if (!etC2.getText().toString().equals("") && !etD2.getText().toString().equals("") && !etE2.getText().toString().equals("")) {
                    if(etD2.getText().toString().equals("0") || etD2.getText().toString().equals("0.")){
                        etF2.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC2.getText().toString()) * 100 / Float.parseFloat(etD2.getText().toString())) - Float.parseFloat(etE2.getText().toString());
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF2.setText(money);
                    }
                } else {
                    etF2.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = etD2.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 2, 2);

                if (!str2.equals(str)) {
                    etD2.setText(str2);
                    int pos = etD2.getText().length();
                    etD2.setSelection(pos);
                }
            }
        });

        etE2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etE2.getText().toString().startsWith(".")){
                    etE2.getText().insert(0,"0");
                }

                if ((!etC2.getText().toString().equals("") && !etD2.getText().toString().equals("")) && etE2.getText().toString().equals("")) {

                    if(etD2.getText().toString().equals("0") || etD2.getText().toString().equals("0.")){
                        etF2.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC2.getText().toString()) * 100 / Float.parseFloat(etD2.getText().toString()));
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF2.setText(money);
                    }
                } else if((!etC2.getText().toString().equals("") && !etD2.getText().toString().equals("")) && !etE2.getText().toString().equals("")) {

                    if(etD2.getText().toString().equals("0") || etD2.getText().toString().equals("0.")){
                        etF2.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC2.getText().toString()) * 100 / Float.parseFloat(etD2.getText().toString())) - Float.parseFloat(etE2.getText().toString());
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF2.setText(money);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = etE2.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etE2.setText(str2);
                    int pos = etE2.getText().length();
                    etE2.setSelection(pos);
                }
            }
        });

        etI2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etI2.getText().toString().startsWith(".")){
                    etI2.getText().insert(0,"0");
                }

                if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else {
                    etJ2.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String str = etI2.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etI2.setText(str2);
                    int pos = etI2.getText().length();
                    etI2.setSelection(pos);
                }
            }
        });

        etK2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etK2.getText().toString().startsWith(".")){
                    etK2.getText().insert(0,"0");
                }

                if ((!etJ2.getText().toString().equals("") && !etK2.getText().toString().equals(""))) {

                    float ans = (float) (Float.parseFloat(etK2.getText().toString()) - Float.parseFloat(etJ2.getText().toString()));

                    if (Float.parseFloat(etJ2.getText().toString()) > Float.parseFloat(etK2.getText().toString())) {

                        tvProfit2.setText("Loss");
                        ans = ans - (ans * 2);
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL2.setText(money);
                        etL2.setBackgroundResource(R.drawable.ans_loss);
                    } else {

                        tvProfit2.setText("Profit");
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL2.setText(money);
                        etL2.setBackgroundResource(R.drawable.ans_rounded_corner_edittext);
                    }
                } else if (etJ2.getText().toString().equals("") || etK2.getText().toString().equals("")) {


                    etL2.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = etK2.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etK2.setText(str2);
                    int pos = etK2.getText().length();
                    etK2.setSelection(pos);
                }
            }
        });

        etJ2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etJ2.getText().toString().startsWith(".")){
                    etJ2.getText().insert(0,"0");
                }


                if ((!etJ2.getText().toString().equals("") && !etK2.getText().toString().equals(""))) {

                    float ans = (float) (Float.parseFloat(etK2.getText().toString()) - Float.parseFloat(etJ2.getText().toString()));

                    if (Float.parseFloat(etJ2.getText().toString()) > Float.parseFloat(etK2.getText().toString())) {

                        tvProfit2.setText("Loss");
                        ans = ans - (ans * 2);
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL2.setText(money);
                        etL2.setBackgroundResource(R.drawable.ans_loss);
                    } else {

                        tvProfit2.setText("Profit");
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL2.setText(money);
                        etL2.setBackgroundResource(R.drawable.ans_rounded_corner_edittext);
                    }
                } else if (etJ2.getText().toString().equals("") || etK2.getText().toString().equals("")) {


                    etL2.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etA2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etA2.getText().toString().startsWith(".")){
                    etA2.getText().insert(0,"0");
                }

                if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else {
                    etJ2.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etF2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etF2.getText().toString().startsWith(".")){
                    etF2.getText().insert(0,"0");
                }

                if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else {
                    etJ2.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

                String str = etF2.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etF2.setText(str2);
                    int pos = etF2.getText().length();
                    etF2.setSelection(pos);
                }
            }
        });

        etG2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etG2.getText().toString().startsWith(".")){
                    etG2.getText().insert(0,"0");
                }


                if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else {
                    etJ2.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String str = etG2.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etG2.setText(str2);
                    int pos = etG2.getText().length();
                    etG2.setSelection(pos);
                }
            }
        });

        etH2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etH2.getText().toString().startsWith(".")){
                    etH2.getText().insert(0,"0");
                }

                if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && !etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            (Float.parseFloat(etF2.getText().toString()) * ((Float.parseFloat(etH2.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && !etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI2.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else if ((!etF2.getText().toString().equals("") && !etA2.getText().toString().equals("")) && !etG2.getText().toString().equals("") && etH2.getText().toString().equals("") && etI2.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF2.getText().toString())) +
                            (Float.parseFloat(etA2.getText().toString()) * Float.parseFloat(etG2.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ2.setText(money);
                } else {
                    etJ2.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String str = etH2.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 2, 2);

                if (!str2.equals(str)) {
                    etH2.setText(str2);
                    int pos = etH2.getText().length();
                    etH2.setSelection(pos);
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
        SharedPreferences appdata2 = PreferenceManager.getDefaultSharedPreferences(this.getActivity());


        etA2.setText(appdata2.getString("A2", ""));
        etB2.setText(appdata2.getString("B2", ""));
        etC2.setText(appdata2.getString("C2", ""));
        etD2.setText(appdata2.getString("D2", ""));
        etE2.setText(appdata2.getString("E2", ""));
        etF2.setText(appdata2.getString("F2", ""));
        etG2.setText(appdata2.getString("G2", ""));
        etH2.setText(appdata2.getString("H2", ""));
        etI2.setText(appdata2.getString("I2", ""));
        etJ2.setText(appdata2.getString("J2", ""));
        etK2.setText(appdata2.getString("K2", ""));
        etL2.setText(appdata2.getString("L2", ""));

        Log.d("create", "create called");
        Log.d("pro2", appdata2.getString("tvprofit", ""));
        if (appdata2.getString("tvprofit2", "").equals("Loss")) {
            tvProfit2.setText("Loss");
            etL2.setBackgroundResource(R.drawable.ans_loss);
        }
    }
  /*  @Override
    public void onPause(){

        super.onPause();
        SharedPreferences appdata = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        SharedPreferences.Editor editor = appdata.edit();

        editor.clear();
        editor.putString("A", etA2.getText().toString());
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

        SharedPreferences appdata2 = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        SharedPreferences.Editor editor2 = appdata2.edit();

      //  editor2.clear();

        editor2.putString("A2", etA2.getText().toString());
        editor2.putString("B2", etB2.getText().toString());
        editor2.putString("C2", etC2.getText().toString());
        editor2.putString("D2", etD2.getText().toString());
        editor2.putString("E2", etE2.getText().toString());
        editor2.putString("F2", etF2.getText().toString());
        editor2.putString("G2", etG2.getText().toString());
        editor2.putString("H2", etH2.getText().toString());
        editor2.putString("I2", etI2.getText().toString());
        editor2.putString("J2", etJ2.getText().toString());
        editor2.putString("K2", etK2.getText().toString());
        editor2.putString("L2", etL2.getText().toString());
        editor2.putString("tvprofit2",tvProfit2.getText().toString());
        editor2.commit();

        Log.d("stop", "stop called");
    }

}






