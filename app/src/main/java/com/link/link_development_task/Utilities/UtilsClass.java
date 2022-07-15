package com.link.link_development_task.Utilities;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;


import com.link.link_development_task.R;

import java.util.Objects;

public class UtilsClass {
    public static ProgressDialog progressDialog;

    public static void Show_Toast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void Show_Progress_Dialog() {
        if (!progressDialog.isShowing()) {
            progressDialog.show();
            Log.d("dialogType", "show");

        }
    }
    public static void Hide_Progress_Dialog() {
        if ( progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }


    public static void init_Progress_Dialog(Context ctx) {
        progressDialog = new ProgressDialog(ctx, R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait...");
    }

    /**
     * This method is used to hide keyboard
     *
     * @param activity
     */
    public static void hideKeyboardFrom(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(Objects.requireNonNull(activity.getCurrentFocus()).getWindowToken(), 0);
        }
    }


    public static void fadeIn(View view) {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(3000);

        // Animation fadeOut = new AlphaAnimation(1, 0);
        // fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        // fadeOut.setStartOffset(1000);
        // fadeOut.setDuration(1000);

        AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeIn);
        //animation.addAnimation(fadeOut);
        view.setAnimation(animation);
    }



}
