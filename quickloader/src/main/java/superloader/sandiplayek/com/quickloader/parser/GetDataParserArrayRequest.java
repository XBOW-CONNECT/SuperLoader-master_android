package superloader.sandiplayek.com.quickloader.parser;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import superloader.sandiplayek.com.quickloader.R;
import superloader.sandiplayek.com.quickloader.appcontroller.AppController;
import superloader.sandiplayek.com.quickloader.customprogress.MyCustomProgressDialog;
import superloader.sandiplayek.com.quickloader.util.Util;


/**
 * Created by root on 16/9/16.
 */
public class GetDataParserArrayRequest {
    AlertDialog dialog;

    private void showpDialog() {
        if (!dialog.isShowing())
            dialog.show();
    }

    private void hidepDialog() {
        if (dialog.isShowing())
            dialog.dismiss();
    }
    //---------------------------------------------------------------------------------
    //Normal Get API ARRAY Request
    public GetDataParserArrayRequest(final Context context, String url, final boolean flag, final OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onGetArrayResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }

        final JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    listner.onGetArrayResponse(jsonArray);
                } catch (Exception e) {
                    listner.onGetArrayResponse(null);
                    e.printStackTrace();
                }
                if (flag)
                    hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                listner.onGetArrayResponse(null);
                VolleyLog.d("Error: " + volleyError.getMessage());
            }
        });
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsonArrayRequest);
    }

    //---------------------------------------------------------------------------------
    //Normal Get API ARRAY Request with view
    public GetDataParserArrayRequest(final Context context, String url, final boolean flag, final View view, final OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onGetArrayResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }

        final JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    listner.onGetArrayResponse(jsonArray);
                } catch (Exception e) {
                    listner.onGetArrayResponse(null);
                    e.printStackTrace();
                }
                if (flag)
                    hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                listner.onGetArrayResponse(null);
                VolleyLog.d("Error: " + volleyError.getMessage());
            }
        });
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsonArrayRequest);
    }

    //---------------------------------------------------------------------------------
    //Normal Get API ARRAY Request with Oth Code
    public GetDataParserArrayRequest(final Context context, String url, final String oAuthCode, final boolean flag, final View view, final OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onGetArrayResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }

        final JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    listner.onGetArrayResponse(jsonArray);
                } catch (Exception e) {
                    listner.onGetArrayResponse(null);
                    e.printStackTrace();
                }
                if (flag)
                    hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                listner.onGetArrayResponse(null);
                VolleyLog.d("Error: " + volleyError.getMessage());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                if (oAuthCode != null) {
                    headers.put("JWTTOKEN",oAuthCode);
                }
                return headers;
            }
        };
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsonArrayRequest);
    }

    //---------------------------------------------------------------------------------
    //Get API ARRAY Request with header
    public GetDataParserArrayRequest(final Context context, String url, final String oAuthCode, final boolean flag, final OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onGetArrayResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }

        final JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    listner.onGetArrayResponse(jsonArray);
                } catch (Exception e) {
                    listner.onGetArrayResponse(null);
                    e.printStackTrace();
                }
                if (flag)
                    hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                listner.onGetArrayResponse(null);
                VolleyLog.d("Error: " + volleyError.getMessage());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                if (oAuthCode != null) {
                    headers.put("JWTTOKEN",oAuthCode);
                }
                return headers;

            }
        };
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsonArrayRequest);
    }

    //Get API ARRAY Request with header
    public GetDataParserArrayRequest(final Context context, String url, final HashMap<String,String> hashMapAuthCode, final boolean flag, final OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onGetArrayResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }

        final JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    listner.onGetArrayResponse(jsonArray);
                } catch (Exception e) {
                    listner.onGetArrayResponse(null);
                    e.printStackTrace();
                }
                if (flag)
                    hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                listner.onGetArrayResponse(null);
                VolleyLog.d("Error: " + volleyError.getMessage());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return hashMapAuthCode;
            }
        };
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(jsonArrayRequest);
    }

    public interface OnGetObjectResponseListner {
        void onGetArrayResponse(JSONArray response);
    }
}
