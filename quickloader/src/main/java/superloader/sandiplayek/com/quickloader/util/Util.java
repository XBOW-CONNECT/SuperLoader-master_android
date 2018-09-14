package superloader.sandiplayek.com.quickloader.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import superloader.sandiplayek.com.quickloader.R;
import superloader.sandiplayek.com.quickloader.meterialdesign.MaterialRippleLayout;


/**
 * Created by root on 12/4/16.
 */
public class Util {
    private static NetworkInfo networkInfo;
    private static int countryCode;
    private static Context c=null;

    /**
     * Is there internet connection
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
                return true;
            }else{
                networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
                if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
                    return true;
                }else{
                    networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                    if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
       /* // test for connection for WIFI
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return true;
        }*/

        /*networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        // test for connection for Mobile
        return networkInfo != null
                && networkInfo.isAvailable()
                && networkInfo.isConnected();*/

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static JSONObject  getjsonobject(String responce) {
        JSONObject jobj = null;
        try {
            jobj = new JSONObject(responce);
        } catch (Exception e) {

        }
        return jobj;
    }

    public static JSONArray getjsonarray(String responce) {
        JSONArray jrr = null;
        try {
            jrr = new JSONArray(responce);
        } catch (Exception e) {

        }
        return jrr;
    }

    public static final boolean isValidPhoneNumber(CharSequence target) {
        if (target.length() != 10) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(target).matches();
        }
    }

    public static String changeAnyDateFormat(String reqdate, String dateformat, String reqformat) {
        //String	date1=reqdate;

        if (reqdate.equalsIgnoreCase("") || dateformat.equalsIgnoreCase("") || reqformat.equalsIgnoreCase(""))
            return "";
        SimpleDateFormat format = new SimpleDateFormat(dateformat);
        String changedate = "";
        Date dt = null;
        if (!reqdate.equals("") && !reqdate.equals("null")) {
            try {
                dt = format.parse(reqdate);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //SimpleDateFormat your_format = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat your_format = new SimpleDateFormat(reqformat);
            changedate = your_format.format(dt);
        }
        return changedate;
    }

    public static void showSnakBar(final Context context, String message) {
        if (c!=context) {
            Snackbar.with(context) // context
                    .text(message) // text to display
                    .actionLabel("Try Again") // action button label
                    .duration(Snackbar.SnackbarDuration.LENGTH_INDEFINITE)
                    .animation(true)
                    .actionListener(new ActionClickListener() {
                        @Override
                        public void onActionClicked(Snackbar snackbar) {
                            Activity a = (Activity) context;
                            Intent i = a.getIntent();
                            a.overridePendingTransition(0, 0);
                            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            a.finish();
                            a.overridePendingTransition(0, 0);
                            a.startActivity(i);

                        }
                    })
                    .show((Activity) context);
        }
        c=context;

    }
    public static void showSnakBar(final Context context, String message, final View view) {
        if (c!=context) {

            Snackbar.with(context) // context
                    .text(message) // text to display
                    .actionLabel("Try Again") // action button label
                    .duration(Snackbar.SnackbarDuration.LENGTH_INDEFINITE)
                    .animation(true)
                    .actionListener(new ActionClickListener() {
                        @Override
                        public void onActionClicked(Snackbar snackbar) {
                            view.performClick();
                        }
                    })
                    .show((Activity) context);
        }
        c=context;
    }


    public static void openKeyBoard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static void closeKeyBoard(Context context) {
        View view = ((Activity) context).getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void addRippleEffect(View v) {
        MaterialRippleLayout.on(v).rippleColor(Color.parseColor("#000000")).rippleAlpha(0.1f).rippleHover(true).create();
    }

    public static String encode(String value) {
        try {
            value = URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
    /*public static void showTime(final Context context, final LinearLayout mLnTimeSlot){
        LayoutInflater inflater=LayoutInflater.from(context);
        final View v=inflater.inflate(R.layout.dayfragmentrow,null);
        final ImageView iv_cross=(ImageView)v.findViewById(R.id.iv_cross);
        iv_cross.setTag(AppData.flag);
        iv_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+iv_cross.getTag(), Toast.LENGTH_SHORT).show();
                mLnTimeSlot.removeView(v);
            }
        });
        mLnTimeSlot.addView(v);
    }
    public static boolean isTimeAfter(Date startTime, Date endTime) {
        if (endTime.before(startTime)) { //Same way you can check with after() method also.
            return false;
        } else {
            return true;
        }
    }
    public static boolean isTimeBefore(Date startTime, Date endTime) {
        if (startTime.after(endTime)) { //Same way you can check with after() method also.
            return false;
        } else {
            return true;
        }
    }*/
    public static boolean nullChecker(String value){
        return (value.equals("")||value.equals("null")||value.isEmpty()||value==null)?true:false;
    }
    public static String getFreshValue(String value){
        return (value.equals("")||value.equals("null")||value.isEmpty()||value==null)?"":value;
    }
    public static boolean viewNullValueChecker(EditText v){
        return (v.getText().toString().trim().equals("")?true:false);
    }

    public static void setImage(Context context,ImageView imageView,String url){
        Picasso.with(context).load(url).placeholder(R.drawable.ic_warning).error(R.drawable.ic_warning).into(imageView);
    }

    private static void SaveIamge(Context context,Bitmap finalBitmap,String folder_name,String file_name) {
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/" + folder_name);
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = file_name+".jpg";
        File file = new File (myDir, fname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            Toast.makeText(context, "File Saved under "+folder_name+" folder. named: "+fname, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
