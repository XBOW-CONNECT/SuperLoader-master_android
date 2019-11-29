package superloader.sandiplayek.com.quickloader.pushnotification;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class FirebasePushNotification {

    public FirebasePushNotification(Context context, String url, JSONObject jsonObjectData, final Map hashMapAuth, final HitService hitService) {

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObjectData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            response.put("responseCode","200");
                            response.put("responseMessage","Successfully Send Notification");
                            hitService.onHitService(response);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject();
                            jsonObject.put("responseCode","400");
                            jsonObject.put("responseMessage",error.getMessage());
                            hitService.onHitService(jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return hashMapAuth;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        int socketTimeout = 1000 * 60;// 60 seconds
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsObjRequest.setRetryPolicy(policy);
        jsObjRequest.setShouldCache(false);
        requestQueue.add(jsObjRequest);
    }

    public FirebasePushNotification(final GetServiceToken getServiceToken){
        FirebaseInstanceId.getInstance().getInstanceId()
            .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                @Override
                public void onComplete(@NonNull Task<InstanceIdResult> task) {
                    if (!task.isSuccessful()) {
                        try{
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("responseCode","400");
                            jsonObject.put("responseMessage",task.getException());

                            getServiceToken.onGetToken(jsonObject);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }else{
                        try{
                            // Get new Instance ID token
                            String token = task.getResult().getToken();

                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("responseCode","200");
                            jsonObject.put("responseMessage","SUCCESSFULLY FETCH TOKEN");
                            jsonObject.put("token",token);

                            getServiceToken.onGetToken(jsonObject);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
        });
    }

    public interface HitService {
        void onHitService(JSONObject response);
    }

    public interface GetServiceToken{
        void onGetToken(JSONObject jsonObject);
    }
}
