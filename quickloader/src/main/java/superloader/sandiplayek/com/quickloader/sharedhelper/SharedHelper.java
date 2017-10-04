package superloader.sandiplayek.com.quickloader.sharedhelper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Android on 03-08-2017.
 */

public class SharedHelper {
    public static void savePreference(Context context,String sharedPrefName,String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String fetchPreference(Context context,String sharedPrefName,String key){
        String value="";
        SharedPreferences sp=context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        value=sp.getString(key, "");
        return value;
    }
    public static void removePreference(Context context,String sharedPrefName,String key){
        SharedPreferences settings = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        settings.edit().remove(key).commit();
    }
}
