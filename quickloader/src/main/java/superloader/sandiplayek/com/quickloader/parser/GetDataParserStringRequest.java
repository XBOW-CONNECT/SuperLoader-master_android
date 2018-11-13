package superloader.sandiplayek.com.quickloader.parser;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import superloader.sandiplayek.com.quickloader.R;
import superloader.sandiplayek.com.quickloader.customprogress.CallingProgressDialog;
import superloader.sandiplayek.com.quickloader.customprogress.MyCustomProgressDialog;
import superloader.sandiplayek.com.quickloader.util.Util;


/**
 * Created on 16/9/16.
 * @author Sandip
 */
public class GetDataParserStringRequest {
    ProgressDialog dialog;

    private void showpDialog() {
        if (!dialog.isShowing())
            dialog.show();
    }

    private void hidepDialog() {
        if (dialog.isShowing())
            dialog.dismiss();
    }

    //1 --------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit
    public GetDataParserStringRequest(final Context context, String url, final boolean flag, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            listner.onGetStringResponse(response);
                        } catch (Exception e) {
                            listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
            }
        });
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }

    //2 --------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public GetDataParserStringRequest(final Context context, String url, final boolean flag, final View view, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            listner.onGetStringResponse(response);
                        } catch (Exception e) {
                            listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
            }
        });
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }
    //3 ----------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public GetDataParserStringRequest(final Context context, String url, final boolean flag, final View view,final String oAuthCode, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            listner.onGetStringResponse(response);
                        } catch (Exception e) {
                            listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
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
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }
    //4 --------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public GetDataParserStringRequest(final Context context, String url, final boolean flag, final String oAuthCode, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    listner.onGetStringResponse(response);
                } catch (Exception e) {
                    listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                if (oAuthCode != null) {
                    headers.put("JWTTOKEN", oAuthCode);
                }
                return headers;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }
    //5 ------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public GetDataParserStringRequest(final Context context, String url, final boolean flag, final HashMap<String,String> HashMapOAuthCode, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = MyCustomProgressDialog.ctor(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    listner.onGetStringResponse(response);
                } catch (Exception e) {
                    listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return HashMapOAuthCode;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }

    //1.1 --------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit
    public GetDataParserStringRequest(final String customLoader,final Context context, String url, final boolean flag, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            listner.onGetStringResponse(response);
                        } catch (Exception e) {
                            listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
                //TastyToast.makeText(context, "Network error.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);

            }
        });
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }

    //2.2 --------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public GetDataParserStringRequest(final String customLoader, final Context context, String url, final boolean flag, final View view, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            listner.onGetStringResponse(response);
                        } catch (Exception e) {
                            listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
            }
        });
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }
    //3.3 ----------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public GetDataParserStringRequest(final String customLoader, final Context context, String url, final boolean flag, final View view,final String oAuthCode, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            listner.onGetStringResponse(response);
                        } catch (Exception e) {
                            listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
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
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }
    //4.4 --------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public GetDataParserStringRequest(final String customLoader, final Context context, String url, final boolean flag, final String oAuthCode, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    listner.onGetStringResponse(response);
                } catch (Exception e) {
                    listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                if (oAuthCode != null) {
                    headers.put("JWTTOKEN", oAuthCode);
                }
                return headers;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }
    //5.5 ------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public GetDataParserStringRequest(final String customLoader,final Context context, String url, final boolean flag, final HashMap<String,String> HashMapOAuthCode, final OnGetStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onGetStringResponse(null);
            return;
        }
        if (flag) {
            dialog = CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    listner.onGetStringResponse(response);
                } catch (Exception e) {
                    listner.onGetStringResponse(null);
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
                listner.onGetStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return HashMapOAuthCode;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }

    public interface OnGetStringResponseListner {
        void onGetStringResponse(String response);
    }
}
