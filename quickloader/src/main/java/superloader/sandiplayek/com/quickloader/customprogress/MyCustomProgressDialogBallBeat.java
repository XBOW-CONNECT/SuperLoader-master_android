package superloader.sandiplayek.com.quickloader.customprogress;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;



import superloader.sandiplayek.com.quickloader.R;

public class MyCustomProgressDialogBallBeat extends ProgressDialog {
  public static ProgressDialog ctor(Context context) {
    MyCustomProgressDialogBallBeat dialog = new MyCustomProgressDialogBallBeat(context, R.style.MyTheme);
    dialog.setIndeterminate(true);
    dialog.setCancelable(false);
    return dialog;
  }
  public MyCustomProgressDialogBallBeat(Context context) {
    super(context);
  }
  public MyCustomProgressDialogBallBeat(Context context, int theme) {
    super(context, R.style.MyTheme);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.view_custom_progress_dialog_ball_beat);
  }
}
