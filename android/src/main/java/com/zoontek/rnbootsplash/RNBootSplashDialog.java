package com.zoontek.rnbootsplash;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

public class RNBootSplashDialog extends Dialog {

  @NonNull
  private final Activity mActivity;
  public final boolean mFade;

  public RNBootSplashDialog(@NonNull Activity activity, @StyleRes int themeResId, boolean fade) {
    super(activity, themeResId);

    mActivity = activity;
    mFade = fade;

    setCancelable(false);
    setCanceledOnTouchOutside(false);
  }

  @Override
  public void onBackPressed() {
    mActivity.moveTaskToBack(true);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    final Window window = this.getWindow();

    if (window != null) {
      window.setLayout(
        WindowManager.LayoutParams.MATCH_PARENT,
        WindowManager.LayoutParams.MATCH_PARENT
      );

      if (mFade) {
        window.setWindowAnimations(R.style.BootSplashFadeOutAnimation);
      }
    }

    super.onCreate(savedInstanceState);
  }

  public boolean hasFade() {
    return mFade;
  }
}