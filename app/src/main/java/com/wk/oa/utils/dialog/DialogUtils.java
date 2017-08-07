package com.wk.oa.utils.dialog;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

//import com.oztech.idstagent.R;
//import com.oztech.idstagent.component.widget.dialog.MaterialNormalDialog;
//import com.oztech.idstagent.component.widget.progressflower.ACProgressConstant;
//import com.oztech.idstagent.component.widget.progressflower.ACProgressFlower;


/**
 * DialogUtils
 * dialog工具类
 **/
public class DialogUtils {
    private static Context sContext;

    public static Toast mToast;

    public static void init(Context context) {
        sContext = context;
    }

    /**
     * <dialogBuilder>
     * 弹出询问窗口
     *
     * @param instance
     * @param title
     * @param message
     * @param callBack
     **/
    public static void dialogBuilder(Context instance, String title,
                                     String message, final DialogCallBack callBack) {
        Builder builder = new Builder(instance);
        builder.setMessage(message);
        builder.setTitle(title);

        // 确定操作
        builder.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        callBack.callBack(true);
                    }
                });

        // 取消操作
        builder.setNegativeButton(android.R.string.no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        callBack.callBack(false);
                    }
                });

        builder.create().show();
    }

    public static void dialogBuilder(Context instance, String title,
                                     String message, int positive, int negative, final DialogCallBack callBack) {
        Builder builder = new Builder(instance);
        builder.setMessage(message);
        builder.setTitle(title);

        // 确定操作
        builder.setPositiveButton(positive,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        callBack.callBack(true);
                    }
                });

        // 取消操作
        builder.setNegativeButton(negative,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        callBack.callBack(false);
                    }
                });

        builder.create().show();
    }

    public static void dialogBuilder(Context instance, String message, final DialogCallBack callBack) {
        Builder builder = new Builder(instance);
        builder.setMessage(message);

        // 确定操作
        builder.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        callBack.callBack(true);
                    }
                });

        builder.create().show();
    }


//    public static ACProgressFlower flowerDialog(Context contxt, String text, boolean isCancel) {
//        ACProgressFlower dialog = new ACProgressFlower.Builder(contxt)
//                .direction(ACProgressConstant.DIRECT_CLOCKWISE)
//                .themeColor(Color.WHITE)
//                .bgAlpha(0)
//                .bgColor(contxt.getResources().getColor(android.R.color.darker_gray))
//                .borderPadding(0.573f)
//                .centerPadding(0.25f)
//                .textMarginTop(contxt.getResources().getDimensionPixelSize(R.dimen.len_30px))
//                .sizeRatio(0.25f)
//                .text(text)
//                .textSize((int) TypedValue.applyDimension(
//                        TypedValue.COMPLEX_UNIT_PX, contxt.getResources().getDimensionPixelSize(R.dimen.text_size_24px), contxt.getResources().getDisplayMetrics()))
//                .textColor(contxt.getResources().getColor(android.R.color.white))
//                .fadeColor(R.color.color_flower_dialog_fade).build();
//        dialog.setCanceledOnTouchOutside(isCancel);
//        dialog.setCancelable(true);
//        return dialog;
//    }
//
//    public static ACProgressFlower flowerDialog(Context contxt, int text, boolean isCancel) {
//        ACProgressFlower dialog = new ACProgressFlower.Builder(contxt)
//                .direction(ACProgressConstant.DIRECT_CLOCKWISE)
//                .themeColor(Color.WHITE)
//                .bgAlpha(0)
//                .bgColor(contxt.getResources().getColor(android.R.color.darker_gray))
//                .borderPadding(0.573f)
//                .centerPadding(0.25f)
//                .sizeRatio(0.25f)
//                .textMarginTop(contxt.getResources().getDimensionPixelSize(R.dimen.len_30px))
//                .text(text)
//                .textSize((int) TypedValue.applyDimension(
//                        TypedValue.COMPLEX_UNIT_PX, contxt.getResources().getDimensionPixelSize(R.dimen.text_size_24px), contxt.getResources().getDisplayMetrics()))
//                .textColor(contxt.getResources().getColor(android.R.color.white))
//                .fadeColor(R.color.color_flower_dialog_fade).build();
//        dialog.setCanceledOnTouchOutside(isCancel);
//        dialog.setCancelable(true);
//        return dialog;
//    }

    public static Toast toast(int content) {
        return getDialogToast(content);
    }

    public static Toast toast(String content) {
        return getDialogToast(content);
    }

    public static Toast getDialogToast(int content) {
        if (mToast == null) {
            mToast = Toast.makeText(sContext.getApplicationContext(),
                    sContext.getResources().getString(content), Toast.LENGTH_SHORT);
        } else {
            mToast.setText(sContext.getResources().getString(content));
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);
        return mToast;
    }

    public static Toast getDialogToast(String content) {
        if (mToast == null) {
            mToast = Toast.makeText(sContext.getApplicationContext(), content, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(content);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);
        return mToast;
    }

//    public static MaterialNormalDialog.Builder buildMaterialNormalDialog(Context ctx) {
//        MaterialNormalDialog.Builder dialog = new MaterialNormalDialog.Builder(ctx);
//        return dialog;
//    }

//    public static void showLoadFailToast(int resId) {
//        View layout = LayoutInflater.from(sContext).inflate(R.layout.toast_load_fail, null);
//        TextView infoTv = (TextView) layout.findViewById(R.id.load_fail_info_txt);
//        infoTv.setText(resId);
//        Toast toast = new Toast(sContext);
//        toast.setView(layout);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();
//    }

//    public static void showLoadFailToast(String desc) {
//        View layout = LayoutInflater.from(sContext).inflate(R.layout.toast_load_fail, null);
//        TextView infoTv = (TextView) layout.findViewById(R.id.load_fail_info_txt);
//        infoTv.setText(desc);
//        Toast toast = new Toast(sContext);
//        toast.setView(layout);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();
//    }

    public static void setBackgroundCompat(View view, Drawable d) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            //noinspection deprecation
            view.setBackgroundDrawable(d);
        } else {
            view.setBackground(d);
        }
    }

}
