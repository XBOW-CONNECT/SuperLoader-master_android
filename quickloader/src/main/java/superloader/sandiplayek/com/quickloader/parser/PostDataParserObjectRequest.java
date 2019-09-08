package superloader.sandiplayek.com.quickloader.parser;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import superloader.sandiplayek.com.quickloader.R;
import superloader.sandiplayek.com.quickloader.appcontroller.AppController;
import superloader.sandiplayek.com.quickloader.customprogress.CallingProgressDialog;
import superloader.sandiplayek.com.quickloader.customprogress.MyCustomProgressDialog;
import superloader.sandiplayek.com.quickloader.customprogress.MyCustomProgressDialogChanges;
import superloader.sandiplayek.com.quickloader.util.Util;


/**
 * Created on 16/9/16.
 * @author Sandip
 */
public class PostDataParserObjectRequest {
    ProgressDialog dialog;

    Dialog d;


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

    //1 --------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit
    public PostDataParserObjectRequest(final Context context, String url, final Map<String, String> params, final boolean flag, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onPostObjectResponse(null);
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
                            Util util = new Util();
                            JSONObject jobj = util.getjsonobject(response);
                            listner.onPostObjectResponse(jobj);
                        } catch (Exception e) {
                            listner.onPostObjectResponse(null);
                            e.printStackTrace();
                        } finally {
                            if (flag) hidepDialog();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag) hidepDialog();
                Util.showSnakBar(context,error.getMessage());
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //2 --------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public PostDataParserObjectRequest(final Context context, String url, final Map<String, String> params, final boolean flag, final View view, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onPostObjectResponse(null);
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
                            Util util = new Util();
                            JSONObject jobj = util.getjsonobject(response);
                            listner.onPostObjectResponse(jobj);
                        } catch (Exception e) {
                            listner.onPostObjectResponse(null);
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
                Util.showSnakBar(context,error.getMessage(),view);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }
    //3 --------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public PostDataParserObjectRequest(final Context context, String url, final Map<String,String> headers, final Map<String, String> params, final boolean flag, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onPostObjectResponse(null);
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
                            JSONObject jobj = new JSONObject(response);
                            listner.onPostObjectResponse(jobj);
                        } catch (Exception e) {
                            listner.onPostObjectResponse(null);
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
                Util.showSnakBar(context,error.getMessage());
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //4 --------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public PostDataParserObjectRequest(final Context context, String url, final Map<String,String> headers, final Map<String, String> params, final boolean flag, final View v, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),v);
            listner.onPostObjectResponse(null);
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
                    JSONObject jobj = new JSONObject(response);
                    listner.onPostObjectResponse(jobj);
                } catch (Exception e) {
                    listner.onPostObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag) hidepDialog();
                Util.showSnakBar(context,error.getMessage(),v);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //5 --------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public PostDataParserObjectRequest(final Context context, String url, final String headers, final Map<String, String> params, final boolean flag, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onPostObjectResponse(null);
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
                    JSONObject jobj = new JSONObject(response);
                    listner.onPostObjectResponse(jobj);
                } catch (Exception e) {
                    listner.onPostObjectResponse(null);
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
                Util.showSnakBar(context,error.getMessage());
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String>header=new HashMap<>();
                header.put("JWTTOKEN",headers);
                return header;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //6 --------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public PostDataParserObjectRequest(final Context context, String url, final String headers, final Map<String, String> params, final boolean flag,final View v, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),v);
            listner.onPostObjectResponse(null);
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
                    JSONObject jobj = new JSONObject(response);
                    listner.onPostObjectResponse(jobj);
                } catch (Exception e) {
                    listner.onPostObjectResponse(null);
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
                Util.showSnakBar(context,error.getMessage(),v);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String>header=new HashMap<>();
                header.put("JWTTOKEN",headers);
                return header;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //1.1 ------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit custom Loader
    public PostDataParserObjectRequest(final String customLoader, final Context context, String url, final Map<String, String> params, final boolean flag, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onPostObjectResponse(null);
            return;
        }
        if (flag) {
            dialog=CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Util util = new Util();
                            JSONObject jobj = util.getjsonobject(response);
                            listner.onPostObjectResponse(jobj);
                        } catch (Exception e) {
                            listner.onPostObjectResponse(null);
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
                Util.showSnakBar(context,error.getMessage());
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //2.2 --------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public PostDataParserObjectRequest(final String customLoader, final Context context, String url, final Map<String, String> params, final boolean flag, final View view, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            listner.onPostObjectResponse(null);
            return;
        }
        if (flag) {
            dialog=CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Util util = new Util();
                            JSONObject jobj = util.getjsonobject(response);
                            listner.onPostObjectResponse(jobj);
                        } catch (Exception e) {
                            listner.onPostObjectResponse(null);
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
                Util.showSnakBar(context,error.getMessage(),view);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //3.3 -------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService custom Loader
    public PostDataParserObjectRequest(final String customLoader, final Context context, String url, final Map<String,String> headersHashMap, final Map<String, String> params, final boolean flag, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onPostObjectResponse(null);
            return;
        }
        if (flag) {
            dialog=CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jobj = new JSONObject(response);
                    listner.onPostObjectResponse(jobj);
                } catch (Exception e) {
                    listner.onPostObjectResponse(null);
                    e.printStackTrace();
                }finally {
                    if (flag) hidepDialog();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (flag) hidepDialog();
                Util.showSnakBar(context,error.getMessage());
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headersHashMap;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //4.4 --------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public PostDataParserObjectRequest(final String customLoader, final Context context, String url, final Map<String,String> headers, final Map<String, String> params, final boolean flag, final View v, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),v);
            listner.onPostObjectResponse(null);
            return;
        }
        if (flag) {
            dialog=CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jobj = new JSONObject(response);
                    listner.onPostObjectResponse(jobj);
                } catch (Exception e) {
                    listner.onPostObjectResponse(null);
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
                Util.showSnakBar(context,error.getMessage(),v);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //5.5 --------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public PostDataParserObjectRequest(final String customLoader, final Context context, String url, final String headers, final Map<String, String> params, final boolean flag, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onPostObjectResponse(null);
            return;
        }
        if (flag) {
            dialog=CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jobj = new JSONObject(response);
                    listner.onPostObjectResponse(jobj);
                } catch (Exception e) {
                    listner.onPostObjectResponse(null);
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
                Util.showSnakBar(context,error.getMessage());
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String>header=new HashMap<>();
                header.put("JWTTOKEN",headers);
                return header;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    //6.6 --------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public PostDataParserObjectRequest(final String customLoader, final Context context, String url, final String headers, final Map<String, String> params, final boolean flag,final View v, final OnPostObjectResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),v);
            listner.onPostObjectResponse(null);
            return;
        }
        if (flag) {
            dialog=CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jobj = new JSONObject(response);
                    listner.onPostObjectResponse(jobj);
                } catch (Exception e) {
                    listner.onPostObjectResponse(null);
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
                Util.showSnakBar(context,context.getResources().getString(R.string.volley_error),v);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject();
                    jsonObject.put("responseCode","400");
                    jsonObject.put("responseMessage",error.getMessage());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listner.onPostObjectResponse(jsonObject);
                VolleyLog.d("Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String>header=new HashMap<>();
                header.put("JWTTOKEN",headers);
                return header;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        RequestQueue queue = Volley.newRequestQueue(context);
        postRequest.setShouldCache(false);
        queue.add(postRequest);
    }

    public interface OnPostObjectResponseListner {
        void onPostObjectResponse(JSONObject response);
    }
}
