package com.yarncostingindia.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.yarncostingindia.Utils.AndyConstants.SP;
import java.util.Calendar;
import java.util.GregorianCalendar;

//Checks and reduces days left daily locally

public class DaysLeftDaily {
    private static SharedPreferences appdata;
    private static SharedPreferences.Editor editor;

    public static void daysLeftCheckLocal(Context context){
         appdata = PreferenceManager.getDefaultSharedPreferences(context);
         editor = appdata.edit();

        int daysLeft = appdata.getInt(SP.DAYSLEFT, 0);
        if (daysLeft == 0){
            editor.putBoolean(SP.TRIALEXPIRED, true);
            editor.putBoolean(SP.FULLVERSIONACTIVE, false);
            editor.commit();
        }
        else
        {
            editor.putBoolean(SP.TRIALEXPIRED, false);
            editor.commit();
        }
        decreaseDaysLeftinSP();
    }

    private static void decreaseDaysLeftinSP() {
        System.out.println("DECREASE DAYS");
        Calendar calendar = new GregorianCalendar();
        int todayDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int lastAccessDayOfMonth = appdata.getInt(SP.LASTACCESSDAY, 0);
        System.out.println("Last Access Day: " + lastAccessDayOfMonth);

        if (todayDayOfMonth != lastAccessDayOfMonth && lastAccessDayOfMonth != 0) {
            int daysLeft = appdata.getInt(SP.DAYSLEFT, 0);
            System.out.println("DAYS LEFT :" + daysLeft);
            if (daysLeft > 0) {
                daysLeft = daysLeft - 1;
            }
            editor.putInt(SP.DAYSLEFT, daysLeft);
            System.out.println("DAYS PUT: " + daysLeft);
        }
        lastAccessDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        editor.putInt(SP.LASTACCESSDAY, lastAccessDayOfMonth);
        editor.commit();
    }
}
