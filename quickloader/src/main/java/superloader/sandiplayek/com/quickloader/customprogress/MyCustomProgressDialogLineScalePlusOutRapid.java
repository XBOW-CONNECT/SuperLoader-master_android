package superloader.sandiplayek.com.quickloader.customprogress;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import superloader.sandiplayek.com.quickloader.R;

public class MyCustomProgressDialogLineScalePlusOutRapid extends ProgressDialog {
  public static ProgressDialog ctor(Context context) {
    MyCustomProgressDialogLineScalePlusOutRapid dialog = new MyCustomProgressDialogLineScalePlusOutRapid(context, R.style.MyTheme);
      //CircleProgressBar circleProgressBar=new CircleProgressBar(context);
    dialog.setIndeterminate(true);
    dialog.setCancelable(false);
      //circleProgressBar.setShowArrow(true);
      //circleProgressBar.setCircleBackgroundEnabled(false);
    return dialog;
  }
  public MyCustomProgressDialogLineScalePlusOutRapid(Context context) {
    super(context);
  }
  public MyCustomProgressDialogLineScalePlusOutRapid(Context context, int theme) {
    super(context, R.style.MyTheme);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.view_custom_progress_dialog_line_scale_plusout_rapid);
  }
}
