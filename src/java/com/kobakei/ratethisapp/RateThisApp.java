package com.kobakei.ratethisapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RateThisApp {
    public static final boolean DEBUG = false;
    private static final String KEY_ASK_LATER_DATE = "rta_ask_later_date";
    private static final String KEY_INSTALL_DATE = "rta_install_date";
    private static final String KEY_LAUNCH_TIMES = "rta_launch_times";
    private static final String KEY_OPT_OUT = "rta_opt_out";
    private static final String PREF_NAME = "RateThisApp";
    private static final String TAG = RateThisApp.class.getSimpleName();
    private static Date mAskLaterDate = new Date();
    private static Date mInstallDate = new Date();
    private static int mLaunchTimes = 0;
    private static boolean mOptOut = false;
    private static Callback sCallback = null;
    private static Config sConfig = new Config();
    private static WeakReference<AlertDialog> sDialogRef = null;

    public interface Callback {
        void onCancelClicked();

        void onNoClicked();

        void onYesClicked();
    }

    public static class Config {
        private int mCancelButton;
        private boolean mCancelable;
        private int mCriteriaInstallDays;
        private int mCriteriaLaunchTimes;
        private int mMessageId;
        private int mNoButtonId;
        private int mTitleId;
        private String mUrl;
        private int mYesButtonId;

        public Config() {
            this(7, 10);
        }

        public Config(int i, int i2) {
            this.mUrl = null;
            this.mTitleId = 0;
            this.mMessageId = 0;
            this.mYesButtonId = 0;
            this.mNoButtonId = 0;
            this.mCancelButton = 0;
            this.mCancelable = true;
            this.mCriteriaInstallDays = i;
            this.mCriteriaLaunchTimes = i2;
        }

        public void setTitle(int i) {
            this.mTitleId = i;
        }

        public void setMessage(int i) {
            this.mMessageId = i;
        }

        public void setYesButtonText(int i) {
            this.mYesButtonId = i;
        }

        public void setNoButtonText(int i) {
            this.mNoButtonId = i;
        }

        public void setCancelButtonText(int i) {
            this.mCancelButton = i;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }

        public void setCancelable(boolean z) {
            this.mCancelable = z;
        }
    }

    private static void log(String str) {
    }

    public static void init(Config config) {
        sConfig = config;
    }

    public static void setCallback(Callback callback) {
        sCallback = callback;
    }

    public static void onCreate(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        Editor edit = sharedPreferences.edit();
        String str = KEY_INSTALL_DATE;
        if (sharedPreferences.getLong(str, 0) == 0) {
            storeInstallDate(context, edit);
        }
        String str2 = KEY_LAUNCH_TIMES;
        int i = sharedPreferences.getInt(str2, 0) + 1;
        edit.putInt(str2, i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Launch times; ");
        stringBuilder.append(i);
        log(stringBuilder.toString());
        edit.apply();
        mInstallDate = new Date(sharedPreferences.getLong(str, 0));
        mLaunchTimes = sharedPreferences.getInt(str2, 0);
        mOptOut = sharedPreferences.getBoolean(KEY_OPT_OUT, false);
        mAskLaterDate = new Date(sharedPreferences.getLong(KEY_ASK_LATER_DATE, 0));
        printStatus(context);
    }

    @Deprecated
    public static void onStart(Context context) {
        onCreate(context);
    }

    public static boolean showRateDialogIfNeeded(Context context) {
        if (!shouldShowRateDialog()) {
            return false;
        }
        showRateDialog(context);
        return true;
    }

    public static boolean showRateDialogIfNeeded(Context context, int i) {
        if (!shouldShowRateDialog()) {
            return false;
        }
        showRateDialog(context, i);
        return true;
    }

    public static boolean shouldShowRateDialog() {
        if (mOptOut) {
            return false;
        }
        if (mLaunchTimes >= sConfig.mCriteriaLaunchTimes) {
            return true;
        }
        long toMillis = TimeUnit.DAYS.toMillis((long) sConfig.mCriteriaInstallDays);
        if (new Date().getTime() - mInstallDate.getTime() < toMillis || new Date().getTime() - mAskLaterDate.getTime() < toMillis) {
            return false;
        }
        return true;
    }

    public static void showRateDialog(Context context) {
        showRateDialog(context, new Builder(context));
    }

    public static void showRateDialog(Context context, int i) {
        showRateDialog(context, new Builder(context, i));
    }

    public static void stopRateDialog(Context context) {
        setOptOut(context, true);
    }

    public static int getLaunchCount(Context context) {
        return context.getSharedPreferences(PREF_NAME, 0).getInt(KEY_LAUNCH_TIMES, 0);
    }

    private static void showRateDialog(final Context context, Builder builder) {
        WeakReference weakReference = sDialogRef;
        if (weakReference == null || weakReference.get() == null) {
            int access$200 = sConfig.mTitleId != 0 ? sConfig.mTitleId : R.string.rta_dialog_title;
            int access$300 = sConfig.mMessageId != 0 ? sConfig.mMessageId : R.string.rta_dialog_message;
            int access$400 = sConfig.mCancelButton != 0 ? sConfig.mCancelButton : R.string.rta_dialog_cancel;
            int access$500 = sConfig.mNoButtonId != 0 ? sConfig.mNoButtonId : R.string.rta_dialog_no;
            int access$600 = sConfig.mYesButtonId != 0 ? sConfig.mYesButtonId : R.string.rta_dialog_ok;
            builder.setTitle(access$200);
            builder.setMessage(access$300);
            builder.setCancelable(sConfig.mCancelable);
            builder.setPositiveButton(access$600, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    String str = "android.intent.action.VIEW";
                    if (RateThisApp.sCallback != null) {
                        RateThisApp.sCallback.onYesClicked();
                    }
                    String packageName = context.getPackageName();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("market://details?id=");
                    stringBuilder.append(packageName);
                    packageName = stringBuilder.toString();
                    if (!TextUtils.isEmpty(RateThisApp.sConfig.mUrl)) {
                        packageName = RateThisApp.sConfig.mUrl;
                    }
                    try {
                        context.startActivity(new Intent(str, Uri.parse(packageName)));
                    } catch (ActivityNotFoundException unused) {
                        Context context = context;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("http://play.google.com/store/apps/details?id=");
                        stringBuilder2.append(context.getPackageName());
                        context.startActivity(new Intent(str, Uri.parse(stringBuilder2.toString())));
                    }
                    RateThisApp.setOptOut(context, true);
                }
            });
            builder.setNeutralButton(access$400, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (RateThisApp.sCallback != null) {
                        RateThisApp.sCallback.onCancelClicked();
                    }
                    RateThisApp.clearSharedPreferences(context);
                    RateThisApp.storeAskLaterDate(context);
                }
            });
            builder.setNegativeButton(access$500, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (RateThisApp.sCallback != null) {
                        RateThisApp.sCallback.onNoClicked();
                    }
                    RateThisApp.setOptOut(context, true);
                }
            });
            builder.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    if (RateThisApp.sCallback != null) {
                        RateThisApp.sCallback.onCancelClicked();
                    }
                    RateThisApp.clearSharedPreferences(context);
                    RateThisApp.storeAskLaterDate(context);
                }
            });
            builder.setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    RateThisApp.sDialogRef.clear();
                }
            });
            sDialogRef = new WeakReference(builder.show());
        }
    }

    private static void clearSharedPreferences(Context context) {
        Editor edit = context.getSharedPreferences(PREF_NAME, 0).edit();
        edit.remove(KEY_INSTALL_DATE);
        edit.remove(KEY_LAUNCH_TIMES);
        edit.apply();
    }

    private static void setOptOut(Context context, boolean z) {
        Editor edit = context.getSharedPreferences(PREF_NAME, 0).edit();
        edit.putBoolean(KEY_OPT_OUT, z);
        edit.apply();
        mOptOut = z;
    }

    private static void storeInstallDate(Context context, Editor editor) {
        Date date = new Date();
        if (VERSION.SDK_INT >= 9) {
            try {
                date = new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime);
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        editor.putLong(KEY_INSTALL_DATE, date.getTime());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("First install: ");
        stringBuilder.append(date.toString());
        log(stringBuilder.toString());
    }

    private static void storeAskLaterDate(Context context) {
        Editor edit = context.getSharedPreferences(PREF_NAME, 0).edit();
        edit.putLong(KEY_ASK_LATER_DATE, System.currentTimeMillis());
        edit.apply();
    }

    private static void printStatus(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        log("*** RateThisApp Status ***");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Install Date: ");
        stringBuilder.append(new Date(sharedPreferences.getLong(KEY_INSTALL_DATE, 0)));
        log(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("Launch Times: ");
        stringBuilder.append(sharedPreferences.getInt(KEY_LAUNCH_TIMES, 0));
        log(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("Opt out: ");
        stringBuilder.append(sharedPreferences.getBoolean(KEY_OPT_OUT, false));
        log(stringBuilder.toString());
    }
}
