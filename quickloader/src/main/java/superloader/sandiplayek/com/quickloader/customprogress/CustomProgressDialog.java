package superloader.sandiplayek.com.quickloader.customprogress;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Android on 12/14/2017.
 */

public class CustomProgressDialog {
    ProgressDialog pd;
    public CustomProgressDialog(Context context,boolean flag,String dialogStyleNumber){
        pd=chooseDialog(context,dialogStyleNumber);
        if(flag==true){
            pd.show();
        }else{
            pd.dismiss();
        }
    }
    public ProgressDialog chooseDialog(Context context, String dialogNumber){
        ProgressDialog dialog = null;
        if(dialogNumber.equals("1")){
            dialog = MyCustomProgressDialogBallBeat.ctor(context);
        }else if(dialogNumber.equals("2")){
            dialog = MyCustomProgressDialogBallClipRotate.ctor(context);
        }else if(dialogNumber.equals("3")){
            dialog = MyCustomProgressDialogBallClipRotateMultiple.ctor(context);
        }else if(dialogNumber.equals("4")){
            dialog = MyCustomProgressDialogBallClipRotatePlus.ctor(context);
        }else if(dialogNumber.equals("5")){
            dialog = MyCustomProgressDialogBallGridBeat.ctor(context);
        }else if(dialogNumber.equals("6")){
            dialog = MyCustomProgressDialogBallGridPlus.ctor(context);
        }else if(dialogNumber.equals("7")){
            dialog = MyCustomProgressDialogBallPlus.ctor(context);
        }else if(dialogNumber.equals("8")){
            dialog = MyCustomProgressDialogBallPlusRise.ctor(context);
        }else if(dialogNumber.equals("9")){
            dialog = MyCustomProgressDialogBallPlusSyns.ctor(context);
        }else if(dialogNumber.equals("10")){
            dialog = MyCustomProgressDialogBallRotate.ctor(context);
        }else if(dialogNumber.equals("11")){
            dialog = MyCustomProgressDialogBallScale.ctor(context);
        }else if(dialogNumber.equals("12")){
            dialog = MyCustomProgressDialogBallScaleMultiple.ctor(context);
        }else if(dialogNumber.equals("13")){
            dialog = MyCustomProgressDialogBallScaleRipple.ctor(context);
        }else if(dialogNumber.equals("14")){
            dialog = MyCustomProgressDialogBallScaleRippleMultiple.ctor(context);
        }else if(dialogNumber.equals("15")){
            dialog = MyCustomProgressDialogBallSpinFadeLoader.ctor(context);
        }else if(dialogNumber.equals("16")){
            dialog = MyCustomProgressDialogBallTrainglePath.ctor(context);
        }else if(dialogNumber.equals("17")){
            dialog = MyCustomProgressDialogBallZigZag.ctor(context);
        }else if(dialogNumber.equals("18")){
            dialog = MyCustomProgressDialogBallZigZagDiflect.ctor(context);
        }else if(dialogNumber.equals("19")){
            dialog = MyCustomProgressDialogCubeTransaction.ctor(context);
        }else if(dialogNumber.equals("20")){
            dialog = MyCustomProgressDialogLineScale.ctor(context);
        }else if(dialogNumber.equals("21")){
            dialog = MyCustomProgressDialogLineScaleParty.ctor(context);
        }else if(dialogNumber.equals("22")){
            dialog = MyCustomProgressDialogLineScalePlusOut.ctor(context);
        }else if(dialogNumber.equals("23")){
            dialog = MyCustomProgressDialogLineScalePlusOutRapid.ctor(context);
        }else if(dialogNumber.equals("24")){
            dialog = MyCustomProgressDialogLineSpinFadeLoader.ctor(context);
        }else if(dialogNumber.equals("25")){
            dialog = MyCustomProgressDialogPacMan.ctor(context);
        }else if(dialogNumber.equals("26")){
            dialog = MyCustomProgressDialogSemiCircleSpin.ctor(context);
        }else if(dialogNumber.equals("27")){
            dialog = MyCustomProgressDialogSquareSpin.ctor(context);
        }else if(dialogNumber.equals("28")){
            dialog = MyCustomProgressDialogTraingleSkeqSpin.ctor(context);
        }else {
            dialog = MyCustomProgressDialog.ctor(context);
        }
        return dialog;
    }
}
