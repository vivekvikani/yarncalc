package com.yarncostingindia.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.widget.Button;
import com.yarncostingindia.R;

/**
 * Created by vivek.vikani on 5/10/17.
 */

public class AppRater{
    private final static String APP_TITLE = "RP Yarn Calculator";// App Name
    private final static String APP_PNAME = "com.yarncostingindia.Utils";// Package Name

    private final static int DAYS_UNTIL_PROMPT = 0;//Min number of days
    private final static int LAUNCHES_UNTIL_PROMPT = 1;//Min number of launches

    public static void app_launched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) { return ; }

        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch +
                    (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showAlertDialog(mContext, editor);
            }
        }
        editor.commit();
    }

    private static void showAlertDialog(final Context context, final SharedPreferences.Editor editor){

        AlertDialog.Builder alertDialogBuilder =
                new AlertDialog.Builder(context, R.style.AlertDialogCustom)
                        .setTitle("Rate App")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("Loving " + APP_TITLE + "?")
                        .setCancelable(false)
                        .setPositiveButton("Give 5 Stars!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Needs Improvement", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (editor != null) {
                                    editor.putBoolean("dontshowagain", true);
                                    editor.commit();
                                }
                                dialog.dismiss();
                            }
                        });

        final AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button nButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                nButton.setAllCaps(false);
                nButton.setTextColor(Color.DKGRAY);
            }
        });

        alertDialog.show();
    }
}
