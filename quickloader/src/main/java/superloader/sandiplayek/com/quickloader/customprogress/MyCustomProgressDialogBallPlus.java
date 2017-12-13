package superloader.sandiplayek.com.quickloader.customprogress;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import superloader.sandiplayek.com.quickloader.R;

public class MyCustomProgressDialogBallPlus extends ProgressDialog {
  public static ProgressDialog ctor(Context context) {
    MyCustomProgressDialogBallPlus dialog = new MyCustomProgressDialogBallPlus(context, R.style.MyTheme);
      //CircleProgressBar circleProgressBar=new CircleProgressBar(context);
    dialog.setIndeterminate(true);
    dialog.setCancelable(false);
      //circleProgressBar.setShowArrow(true);
      //circleProgressBar.setCircleBackgroundEnabled(false);
    return dialog;
  }
  public MyCustomProgressDialogBallPlus(Context context) {
    super(context);
  }
  public MyCustomProgressDialogBallPlus(Context context, int theme) {
    super(context, R.style.MyTheme);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.view_custom_progress_dialog_ball_plus);
  }
}
