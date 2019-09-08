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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import superloader.sandiplayek.com.quickloader.R;
import superloader.sandiplayek.com.quickloader.customprogress.CallingProgressDialog;
import superloader.sandiplayek.com.quickloader.customprogress.MyCustomProgressDialog;
import superloader.sandiplayek.com.quickloader.util.Util;

public class RawDataParserObjectRequestUnCastHM {
    AlertDialog dialog;

    private void showpDialog() {
        if(dialog!=null){
            if (!dialog.isShowing()) dialog.show();
        }
    }

    private void hidepDialog() {
        if(dialog!=null){
            if (dialog.isShowing()) dialog.dismiss();
        }
    }

    //1 ................................................................................................................
    public RawDataParserObjectRequestUnCastHM(final Context context, String url, HashMap hashMap, final boolean flag, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        });
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }
    //2 ................................................................................................................
    public RawDataParserObjectRequestUnCastHM(final Context context, String url, HashMap hashMap, final boolean flag, final View view, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror),view);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        });
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }
    //3 ...............................................................................................................
    public RawDataParserObjectRequestUnCastHM(final Context context, String url,HashMap hashMap, final boolean flag, final View view, final String oAuthCode, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror),view);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String>hashMap=new HashMap<>();
                hashMap.put("JWTTOKEN",oAuthCode);
                return hashMap;
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }
    //4 ................................................................................................................
    public RawDataParserObjectRequestUnCastHM(final Context context, String url,HashMap hashMap, final String oAuthCode, final boolean flag, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("JWTTOKEN",oAuthCode);
                return headers;
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }
    //5 ................................................................................................................
    public RawDataParserObjectRequestUnCastHM(final Context context, String url,HashMap hashMap, final HashMap<String,String>hashMapAuthCode, final boolean flag, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return hashMapAuthCode;
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }

    //6 ................................................................................................................
    public RawDataParserObjectRequestUnCastHM(final Context context, String url,HashMap hashMap, final HashMap<String,String>hashMapAuthCode, final boolean flag,final View v, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),v);
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror),v);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return hashMapAuthCode;
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }
    //1.1 ................................................................................................................
    //Simple get data parser with Custom loader
    public RawDataParserObjectRequestUnCastHM(final String customLoader, final Context context, String url,HashMap hashMap, final boolean flag, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog= CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        });
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }

    //2.2 ................................................................................................................
    public RawDataParserObjectRequestUnCastHM(final String customLoader, final Context context, String url, HashMap hashMap, final boolean flag, final View view, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog= CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror),view);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        });
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }
    //3.3 ...............................................................................................................
    public RawDataParserObjectRequestUnCastHM(final String customLoader, final Context context, String url,HashMap hashMap, final boolean flag, final View view, final String oAuthCode, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog= CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror),view);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String>hashMap=new HashMap<>();
                hashMap.put("JWTTOKEN",oAuthCode);
                return hashMap;
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }
    //4.4 ................................................................................................................
    public RawDataParserObjectRequestUnCastHM(final String customLoader, final Context context, String url,HashMap hashMap, final String oAuthCode, final boolean flag, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog= CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("JWTTOKEN",oAuthCode);
                return headers;
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }

    //5.5 ................................................................................................................
    public RawDataParserObjectRequestUnCastHM(final String customLoader, final Context context, String url,HashMap hashMap, final HashMap<String,String>hashMapAuthCode, final boolean flag, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog= CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror));
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return hashMapAuthCode;
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }

    //6.6 ................................................................................................................
    public RawDataParserObjectRequestUnCastHM(final String customLoader, final Context context, String url,HashMap hashMap, final HashMap<String,String>hashMapAuthCode, final boolean flag,final View v, final RawDataParserObjectRequestUnCastHM.OnGetObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),v);
            listner.onGetObjectResponse(null);
            return;
        }
        if (flag) {
            dialog= CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listner.onGetObjectResponse(response);
                } catch (Exception e) {
                    listner.onGetObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag)
                    hidepDialog();
                Util.showSnakBar(context,context.getResources().getString(R.string.networkerror),v);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onGetObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return hashMapAuthCode;
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        jsonObjReq.setShouldCache(false);
        queue.add(jsonObjReq);
    }

    public interface OnGetObjectResponseListner {
        void onGetObjectResponse(JSONObject response);
    }
}
