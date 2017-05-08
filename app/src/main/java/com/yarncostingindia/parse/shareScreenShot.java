package com.yarncostingindia.parse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Vivek on 22-Dec-15.
 */
public class shareScreenShot {
    public static Intent shareIntent;
    private static File file;
    public  Bitmap bm;

    public void shareScreenShotM(View view, NestedScrollView scrollView){
        shareIntent = new Intent(Intent.ACTION_SEND);
         bm = takeScreenShot(view,scrollView);
        File file = savePic(bm);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Shared via RP Yarn Calculator");
        Uri uri = Uri.fromFile(new File(file.getAbsolutePath()));
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("image/*");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.setPackage("com.whatsapp");
    }

    public Bitmap takeScreenShot(View u, NestedScrollView   z)
    {
        u.setDrawingCacheEnabled(true);
        int totalHeight = z.getChildAt(0).getHeight();
        int totalWidth = z.getChildAt(0).getWidth();

        Log.d("yoheight",""+ totalHeight);
        Log.d("yowidth",""+ totalWidth);
        u.layout(0, 0, totalWidth, totalHeight);
        u.buildDrawingCache();
        Bitmap b = Bitmap.createBitmap(u.getDrawingCache());
        u.setDrawingCacheEnabled(false);
        u.destroyDrawingCache();
        /*View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();

        Bitmap b = Bitmap.createBitmap(b1, 0, 0, width, height  - statusBarHeight);
        view.destroyDrawingCache();*/
        return b;
    }
    public static File savePic(Bitmap bm)
    {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        File sdCardDirectory = new File(Environment.getExternalStorageDirectory() + "/RPYarnCalC");

        if (!sdCardDirectory.exists()) {
            sdCardDirectory.mkdirs();
        }
      //  File file = new File(dir, fileName);
        try {
            file = new File(sdCardDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            file.createNewFile();
            new FileOutputStream(file).write(bytes.toByteArray());
            Log.d("Fabsolute", "File Saved::--->" + file.getAbsolutePath());
            Log.d("Sabsolute", "File Saved::--->" + sdCardDirectory.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
