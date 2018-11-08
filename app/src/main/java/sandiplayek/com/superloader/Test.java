package sandiplayek.com.superloader;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import java.util.HashMap;

public class Test extends Activity{
    HashMap hashMapParams=new HashMap();
    Button btn_chk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
