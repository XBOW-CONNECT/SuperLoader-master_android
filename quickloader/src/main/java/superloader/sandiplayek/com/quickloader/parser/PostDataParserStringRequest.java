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
public class PostDataParserStringRequest {
    ProgressDialog dialog;

    private void showpDialog() {
        if (!dialog.isShowing())
            dialog.show();
    }

    private void hidepDialog() {
        if (dialog.isShowing())
            dialog.dismiss();
    }

    //--------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit
    public PostDataParserStringRequest(final Context context, String url, final Map<String, String> params, final boolean flag, final OnPostStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onPostStringResponse(null);
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
                            listner.onPostStringResponse(response);
                        } catch (Exception e) {
                            listner.onPostStringResponse(null);
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
                listner.onPostStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
                //TastyToast.makeText(context, "Network error.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
            /*@Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                if (AppData.sToken != null) {
                    headers.put("token", AppData.sToken);
                }
                return headers;
            }*/
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(postRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }

    //--------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public PostDataParserStringRequest(final Context context, String url, final Map<String, String> params, final boolean flag, final View view, final OnPostStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onPostStringResponse(null);
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
                            listner.onPostStringResponse(response);
                        } catch (Exception e) {
                            listner.onPostStringResponse(null);
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
                listner.onPostStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
                //TastyToast.makeText(context, "Network error.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(postRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }
    //--------------------------------------------------------------------------------------------------------------------
    //Header Request Auth Hit WebService
    public PostDataParserStringRequest(final Context context, String url,final Map<String,String> headers, final Map<String, String> params, final boolean flag, final OnPostStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            listner.onPostStringResponse(null);
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
                            listner.onPostStringResponse(response);
                        } catch (Exception e) {
                            listner.onPostStringResponse(null);
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
                listner.onPostStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
                //TastyToast.makeText(context, "Network error.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);

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
        //AppController.getInstance().addToRequestQueue(postRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }

    //--------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public PostDataParserStringRequest(final Context context, String url, final Map<String, String> headerParams,final Map<String, String> params, final boolean flag, final View view, final OnPostStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror),view);
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onPostStringResponse(null);
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
                            listner.onPostStringResponse(response);
                        } catch (Exception e) {
                            listner.onPostStringResponse(null);
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
                listner.onPostStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
                //TastyToast.makeText(context, "Network error.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headerParams;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(postRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }
    //--------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public PostDataParserStringRequest(final Context context, String url, final String header,final Map<String, String> params, final boolean flag, final OnPostStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onPostStringResponse(null);
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
                            listner.onPostStringResponse(response);
                        } catch (Exception e) {
                            listner.onPostStringResponse(null);
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
                listner.onPostStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
                //TastyToast.makeText(context, "Network error.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String>hashMap=new HashMap<>();
                hashMap.put("JETTOKEN",header);
                return hashMap;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(postRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }

    //--------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public PostDataParserStringRequest(final String customLoader, final Context context, String url, final Map<String, String> params, final boolean flag, final OnPostStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onPostStringResponse(null);
            return;
        }
        if (flag) {
            dialog= CallingProgressDialog.chooseDialog(context,customLoader);
            dialog.setCancelable(false);
            dialog.setMessage("Please wait...");
            showpDialog();
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            listner.onPostStringResponse(response);
                        } catch (Exception e) {
                            listner.onPostStringResponse(null);
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
                listner.onPostStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
                //TastyToast.makeText(context, "Network error.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            /*@Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String,String>hashMap=new HashMap<>();
                hashMap.put("JETTOKEN",header);
                return hashMap;
            }*/
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(postRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }

    //--------------------------------------------------------------------------------------------------------------------
    //Normal WebService Hit with view that means Only View Refresh when Network Error
    public PostDataParserStringRequest(final String customLoader, final Context context, String url, final Map<String,String> headerHashMap,final Map<String, String> params, final boolean flag, final OnPostStringResponseListner listner) {
        if (!Util.isConnected(context)) {
            Util.showSnakBar(context,context.getResources().getString(R.string.internectconnectionerror));
            //TastyToast.makeText(context, "No internet connections.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
            listner.onPostStringResponse(null);
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
                            listner.onPostStringResponse(response);
                        } catch (Exception e) {
                            listner.onPostStringResponse(null);
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
                listner.onPostStringResponse(null);
                VolleyLog.d("Error: " + error.getMessage());
                //TastyToast.makeText(context, "Network error.", TastyToast.LENGTH_SHORT, TastyToast.ERROR);

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headerHashMap;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //AppController.getInstance().addToRequestQueue(postRequest);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(postRequest);
    }

    public interface OnPostStringResponseListner {
        void onPostStringResponse(String response);
    }
}
