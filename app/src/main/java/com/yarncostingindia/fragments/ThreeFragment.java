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


public class ThreeFragment extends Fragment {

    private EditText etA3, etB3, etC3, etD3, etE3, etF3, etG3, etH3, etI3, etJ3, etK3, etL3;
    private TextView tvProfit3, tvJ3, tvJ3unit;
    private NestedScrollView scrollView;
    private TableRow rowK3, rowL3;
    private Button btnReset3, btnWhatsapp3;
    protected View mView3;

    float initialX, initialY;

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        mView3 = view;

        etA3 = (EditText) view.findViewById(R.id.etboxA3);
        etB3 = (EditText) view.findViewById(R.id.etboxB3);
        etC3 = (EditText) view.findViewById(R.id.etboxC3);
        etD3 = (EditText) view.findViewById(R.id.etboxD3);
        etE3 = (EditText) view.findViewById(R.id.etboxE3);
        etF3 = (EditText) view.findViewById(R.id.etboxF3);
        etG3 = (EditText) view.findViewById(R.id.etboxG3);
        etH3 = (EditText) view.findViewById(R.id.etboxH3);
        etI3 = (EditText) view.findViewById(R.id.etboxI3);
        etJ3 = (EditText) view.findViewById(R.id.etboxJ3);
        etK3 = (EditText) view.findViewById(R.id.etboxK3);
        etL3 = (EditText) view.findViewById(R.id.etboxL3);

        tvProfit3 = (TextView) view.findViewById(R.id.tvprofit3);
        tvJ3 = (TextView) view.findViewById(R.id.tvJ3);
        tvJ3unit = (TextView) view.findViewById(R.id.tvJ3unit);

        rowK3 = (TableRow) view.findViewById(R.id.rowK3);
        rowL3 = (TableRow) view.findViewById(R.id.rowL3);

        btnReset3 = (Button) view.findViewById(R.id.btnreset3);
        btnWhatsapp3 = (Button) view.findViewById(R.id.btnwhatsapp3);

        scrollView = (NestedScrollView) view.findViewById(R.id.scrollView);

        return view;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {

        super.onResume();

        // etB.setFilters(new InputFilter[]{new DecimalDigitsInputFilter(4, 2)});
      /*  String currentTime = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        Log.d("timeStamp", currentTime);
        Calendar date = new GregorianCalendar(2016, Calendar.MARCH, 26);
        date.add(Calendar.DAY_OF_WEEK, 0);
        String expireTime = new SimpleDateFormat("yyyyMMdd").format(date.getTime());

        int intcurrentTime = Integer.parseInt(currentTime);
        int intexpireTime = Integer.parseInt(expireTime);*/

        if(AndyConstants.currentTime == AndyConstants.expireTime || AndyConstants.currentTime > AndyConstants.expireTime ) {

            tvJ3.setText("Trial period expired!!");
            tvJ3.setTypeface(null, Typeface.BOLD);
            tvJ3.setTextColor(Color.RED);

            tvJ3unit.setVisibility(View.GONE);
            etJ3.setVisibility(View.GONE);
            rowK3.setVisibility(View.GONE);
            rowL3.setVisibility(View.GONE);

            int maxLengthofEditText = 0;
            etA3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLengthofEditText)});
            etB3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLengthofEditText)});
        }

      //  Log.d("timeStamp2", expireTime);


        etA3.setSelection(etA3.getText().length());
        etB3.setSelection(etB3.getText().length());
        etC3.setSelection(etC3.getText().length());
        etD3.setSelection(etD3.getText().length());
        etE3.setSelection(etE3.getText().length());
        etF3.setSelection(etF3.getText().length());
        etG3.setSelection(etG3.getText().length());
        etH3.setSelection(etH3.getText().length());
        etI3.setSelection(etI3.getText().length());
        etJ3.setSelection(etJ3.getText().length());
        etK3.setSelection(etK3.getText().length());
        etL3.setSelection(etL3.getText().length());

        btnReset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(false);
                builder.setTitle("Confirm");
                builder.setMessage("Reset all Values?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etA3.setText("");
                        etB3.setText("");
                        etC3.setText("");
                        etD3.setText("");
                        etE3.setText("");
                        etF3.setText("");
                        etG3.setText("");
                        etH3.setText("");
                        etI3.setText("");
                        etJ3.setText("");
                        etK3.setText("");
                        etL3.setText("");

                        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.toggleSoftInputFromWindow(etA3.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
                        etA3.requestFocus();
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

        btnWhatsapp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view =  mView3.findViewById(R.id.scrollView3);
                shareScreenShot obj = new shareScreenShot();
                obj.shareScreenShotM(view, (NestedScrollView) view);
                if(isPackageInstalled("com.whatsapp",getActivity())){

                    startActivity(obj.shareIntent);

                }else{

                    Toast.makeText(getActivity(), "Please Install Whatsapp", Toast.LENGTH_LONG).show();
                }



                etA3.requestFocus();
                // InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                // imm.showSoftInput(etA, InputMethodManager.SHOW_IMPLICIT);
                // imm.showSoftInput(etA, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        etB3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etB3.getText().toString().startsWith(".")){
                    etB3.getText().insert(0,"0");
                }
                if (!etB3.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etB3.getText().toString()) / 355.6164);

                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etC3.setText(money);
                } else {
                    etC3.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = etB3.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 7, 2);

                if (!str2.equals(str)) {
                    etB3.setText(str2);
                    int pos = etB3.getText().length();
                    etB3.setSelection(pos);
                }
            }
        });

        etC3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etC3.getText().toString().startsWith(".")){
                    etC3.getText().insert(0,"0");
                }



                if (etC3.getText().toString().equals("")) {

                    etF3.setText("");
                } else if (!etC3.getText().toString().equals("") && !etD3.getText().toString().equals("") && !etE3.getText().toString().equals("")) {

                    if(etD3.getText().toString().equals("0") || etD3.getText().toString().equals("0.")){
                        etF3.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC3.getText().toString()) * 100 / Float.parseFloat(etD3.getText().toString())) - Float.parseFloat(etE3.getText().toString());
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF3.setText(money);
                    }
                } else if (!etC3.getText().toString().equals("") && !etD3.getText().toString().equals("")) {

                    if(etD3.getText().toString().equals("0") || etD3.getText().toString().equals("0.")){
                        etF3.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC3.getText().toString()) * 100 / Float.parseFloat(etD3.getText().toString()));
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF3.setText(money);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etD3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etD3.getText().toString().startsWith(".")){
                    etD3.getText().insert(0,"0");
                }

                if (!(etC3.getText().toString().equals("") || etD3.getText().toString().equals("")) && etE3.getText().toString().equals("")) {

                    if(etD3.getText().toString().equals("0") || etD3.getText().toString().equals("0.")){
                        etF3.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC3.getText().toString()) * 100 / Float.parseFloat(etD3.getText().toString()));
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF3.setText(money);
                    }

                } else if (!etC3.getText().toString().equals("") && !etD3.getText().toString().equals("") && !etE3.getText().toString().equals("")) {
                    if(etD3.getText().toString().equals("0") || etD3.getText().toString().equals("0.")){
                        etF3.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC3.getText().toString()) * 100 / Float.parseFloat(etD3.getText().toString())) - Float.parseFloat(etE3.getText().toString());
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF3.setText(money);
                    }
                } else {
                    etF3.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = etD3.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 2, 2);

                if (!str2.equals(str)) {
                    etD3.setText(str2);
                    int pos = etD3.getText().length();
                    etD3.setSelection(pos);
                }
            }
        });

        etE3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etE3.getText().toString().startsWith(".")){
                    etE3.getText().insert(0,"0");
                }

                if ((!etC3.getText().toString().equals("") && !etD3.getText().toString().equals("")) && etE3.getText().toString().equals("")) {

                    if(etD3.getText().toString().equals("0") || etD3.getText().toString().equals("0.")){
                        etF3.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC3.getText().toString()) * 100 / Float.parseFloat(etD3.getText().toString()));
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF3.setText(money);
                    }
                } else if((!etC3.getText().toString().equals("") && !etD3.getText().toString().equals("")) && !etE3.getText().toString().equals("")) {

                    if(etD3.getText().toString().equals("0") || etD3.getText().toString().equals("0.")){
                        etF3.setText("");
                    }
                    else {
                        float ans = (float) (Float.parseFloat(etC3.getText().toString()) * 100 / Float.parseFloat(etD3.getText().toString())) - Float.parseFloat(etE3.getText().toString());
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etF3.setText(money);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = etE3.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etE3.setText(str2);
                    int pos = etE3.getText().length();
                    etE3.setSelection(pos);
                }
            }
        });

        etI3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etI3.getText().toString().startsWith(".")){
                    etI3.getText().insert(0,"0");
                }

                if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else {
                    etJ3.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String str = etI3.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etI3.setText(str2);
                    int pos = etI3.getText().length();
                    etI3.setSelection(pos);
                }
            }
        });

        etK3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etK3.getText().toString().startsWith(".")){
                    etK3.getText().insert(0,"0");
                }

                if ((!etJ3.getText().toString().equals("") && !etK3.getText().toString().equals(""))) {

                    float ans = (float) (Float.parseFloat(etK3.getText().toString()) - Float.parseFloat(etJ3.getText().toString()));

                    if (Float.parseFloat(etJ3.getText().toString()) > Float.parseFloat(etK3.getText().toString())) {

                        tvProfit3.setText("Loss");
                        ans = ans - (ans * 2);
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL3.setText(money);
                        etL3.setBackgroundResource(R.drawable.ans_loss);
                    } else {

                        tvProfit3.setText("Profit");
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL3.setText(money);
                        etL3.setBackgroundResource(R.drawable.ans_rounded_corner_edittext);
                    }
                } else if (etJ3.getText().toString().equals("") || etK3.getText().toString().equals("")) {


                    etL3.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = etK3.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etK3.setText(str2);
                    int pos = etK3.getText().length();
                    etK3.setSelection(pos);
                }
            }
        });

        etJ3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etJ3.getText().toString().startsWith(".")){
                    etJ3.getText().insert(0,"0");
                }

                if ((!etJ3.getText().toString().equals("") && !etK3.getText().toString().equals(""))) {

                    float ans = (float) (Float.parseFloat(etK3.getText().toString()) - Float.parseFloat(etJ3.getText().toString()));

                    if (Float.parseFloat(etJ3.getText().toString()) > Float.parseFloat(etK3.getText().toString())) {

                        tvProfit3.setText("Loss");
                        ans = ans - (ans * 2);
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL3.setText(money);
                        etL3.setBackgroundResource(R.drawable.ans_loss);
                    } else {

                        tvProfit3.setText("Profit");
                        double number = ans;
                        double roundedNumber = DecimalUtils.round(number, 2);
                        float finalAns = (float) roundedNumber;
                        String money = String.format("%.2f", finalAns);

                        etL3.setText(money);
                        etL3.setBackgroundResource(R.drawable.ans_rounded_corner_edittext);
                    }
                } else if (etJ3.getText().toString().equals("") || etK3.getText().toString().equals("")) {


                    etL3.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etA3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etA3.getText().toString().startsWith(".")){
                    etA3.getText().insert(0,"0");
                }

                if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else {
                    etJ3.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etF3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etF3.getText().toString().startsWith(".")){
                    etF3.getText().insert(0,"0");
                }

                if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else {
                    etJ3.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

                String str = etF3.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etF3.setText(str2);
                    int pos = etF3.getText().length();
                    etF3.setSelection(pos);
                }
            }
        });

        etG3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etG3.getText().toString().startsWith(".")){
                    etG3.getText().insert(0,"0");
                }

                if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else {
                    etJ3.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String str = etG3.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 6, 2);

                if (!str2.equals(str)) {
                    etG3.setText(str2);
                    int pos = etG3.getText().length();
                    etG3.setSelection(pos);
                }
            }
        });

        etH3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(etH3.getText().toString().startsWith(".")){
                    etH3.getText().insert(0,"0");
                }

                if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && !etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {
                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            (Float.parseFloat(etF3.getText().toString()) * ((Float.parseFloat(etH3.getText().toString()) / 100)));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && !etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString())) +
                            // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                            (Float.parseFloat(etI3.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else if ((!etF3.getText().toString().equals("") && !etA3.getText().toString().equals("")) && !etG3.getText().toString().equals("") && etH3.getText().toString().equals("") && etI3.getText().toString().equals("")) {

                    float ans = (float) (Float.parseFloat(etF3.getText().toString())) +
                            (Float.parseFloat(etA3.getText().toString()) * Float.parseFloat(etG3.getText().toString()));
                    // (Float.parseFloat(etF.getText().toString()) * ((Float.parseFloat(etH.getText().toString()) / 100))) +
                    //(Float.parseFloat(etI.getText().toString()));
                    double number = ans;
                    double roundedNumber = DecimalUtils.round(number, 2);
                    float finalAns = (float) roundedNumber;
                    String money = String.format("%.2f", finalAns);

                    etJ3.setText(money);
                } else {
                    etJ3.setText("");
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                String str = etH3.getText().toString();
                if (str.isEmpty()) return;
                String str2 = PerfectDecimal(str, 2, 2);

                if (!str2.equals(str)) {
                    etH3.setText(str2);
                    int pos = etH3.getText().length();
                    etH3.setSelection(pos);
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

    public String PerfectDecimal(String str, int MAX_BEFORE_POINT, int MAX_DECIMAL) {
        if (str.charAt(0) == '.') str = "0" + str;
        int max = str.length();

        String rFinal = "";
        boolean after = false;
        int i = 0, up = 0, decimal = 0;
        char t;
        while (i < max) {
            t = str.charAt(i);
            if (t != '.' && after == false) {
                up++;
                if (up > MAX_BEFORE_POINT) return rFinal;
            } else if (t == '.') {
                after = true;
            } else {
                decimal++;
                if (decimal > MAX_DECIMAL)
                    return rFinal;
            }
            rFinal = rFinal + t;
            i++;
        }
        return rFinal;
    }


    public class DecimalDigitsInputFilter implements InputFilter {

        Pattern mPattern;

        public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {
            mPattern = Pattern.compile("[0-9]{0," + (digitsBeforeZero - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) + "})?)||(\\.)?");
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            Matcher matcher = mPattern.matcher(dest);
            if (!matcher.matches())
                return "";
            return null;
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences appdata3 = PreferenceManager.getDefaultSharedPreferences(this.getActivity());


        etA3.setText(appdata3.getString("A3", ""));
        etB3.setText(appdata3.getString("B3", ""));
        etC3.setText(appdata3.getString("C3", ""));
        etD3.setText(appdata3.getString("D3", ""));
        etE3.setText(appdata3.getString("E3", ""));
        etF3.setText(appdata3.getString("F3", ""));
        etG3.setText(appdata3.getString("G3", ""));
        etH3.setText(appdata3.getString("H3", ""));
        etI3.setText(appdata3.getString("I3", ""));
        etJ3.setText(appdata3.getString("J3", ""));
        etK3.setText(appdata3.getString("K3", ""));
        etL3.setText(appdata3.getString("L3", ""));

        Log.d("pro3", appdata3.getString("tvprofit3", ""));
        if (appdata3.getString("tvprofit3", "").equals("Loss")) {
            tvProfit3.setText("Loss");
            etL3.setBackgroundResource(R.drawable.ans_loss);
        }
    }

   /* @Override
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

        SharedPreferences appdata3 = PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        SharedPreferences.Editor editor3 = appdata3.edit();

      //  editor3.clear();
        editor3.putString("A3", etA3.getText().toString());
        editor3.putString("B3", etB3.getText().toString());
        editor3.putString("C3", etC3.getText().toString());
        editor3.putString("D3", etD3.getText().toString());
        editor3.putString("E3", etE3.getText().toString());
        editor3.putString("F3", etF3.getText().toString());
        editor3.putString("G3", etG3.getText().toString());
        editor3.putString("H3", etH3.getText().toString());
        editor3.putString("I3", etI3.getText().toString());
        editor3.putString("J3", etJ3.getText().toString());
        editor3.putString("K3", etK3.getText().toString());
        editor3.putString("L3", etL3.getText().toString());
        editor3.putString("tvprofit3",tvProfit3.getText().toString());
        editor3.commit();

    }
}





