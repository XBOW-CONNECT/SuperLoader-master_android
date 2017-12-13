package sandiplayek.com.superloader;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import superloader.sandiplayek.com.quickloader.MyView;
import superloader.sandiplayek.com.quickloader.customprogress.MyCustomProgressDialog;
import superloader.sandiplayek.com.quickloader.parser.PostDataParserObjectRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String url="";  //Enter Here Your Login URL
    String pass="",phone="", succ ="",msg="";
    EditText et_ph,et_pass;
    Button btn_chk;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIds();

    }

    private void findIds() {
        et_ph=(EditText)findViewById(R.id.et_ph);
        et_pass=(EditText)findViewById(R.id.et_pass);
        btn_chk=(Button) findViewById(R.id.btn_chk);
        btn_chk.setOnClickListener(this);
    }

    public void check_login(){
        HashMap<String,String>hashMap=new HashMap<>();
        hashMap.put("", phone);     //Enter KEY value for phone and pass
        hashMap.put("", pass);
        new PostDataParserObjectRequest(MainActivity.this, url, hashMap, true, new PostDataParserObjectRequest.OnPostObjectResponseListner() {
            @Override
            public void onPostObjectResponse(JSONObject response) {
                try {
                    succ = response.getString("responseCode");
                    msg = response.getString("message");
                    if (succ.equals("1")) {
                        Toast.makeText(MainActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v==btn_chk){
            phone=et_ph.getText().toString().trim();
            pass=et_pass.getText().toString().trim();
            if(phone.equals("")||pass.equals("")){
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            check_login();
        }
    }
}
