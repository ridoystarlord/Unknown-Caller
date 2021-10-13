package com.ridoy.unknowncaller.SharedPreferencemanager;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    private static final String SHARED_PREF_NAME = "unknowncaller";
    private static final String KEY_Video1 = "Video1";
    private static final String KEY_Video2 = "Video2";
    private static final String KEY_Video3 = "Video3";
    private static final String KEY_Video4 = "Video4";
    private static final String KEY_Video5 = "Video5";
    private static final String KEY_Video6 = "Video6";
    private static final String KEY_Video7 = "Video7";
    private static final String KEY_Video8 = "Video8";
    private static final String KEY_Video9 = "Video9";
    private static final String KEY_Video10 = "Video10";
    private static final String KEY_Video11 = "Video11";
    private static final String KEY_Video12 = "Video12";


    public boolean setVideo1Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video1, status);
        editor.apply();

        return true;
    }
    public int getVideo1Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video1, 0);
    }
    public boolean setVideo2Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video2, status);
        editor.apply();

        return true;
    }
    public int getVideo2Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video2, 0);
    }
    public boolean setVideo3Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video3, status);
        editor.apply();

        return true;
    }
    public int getVideo3Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video3, 0);
    }
    public boolean setVideo4Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video4, status);
        editor.apply();

        return true;
    }
    public int getVideo4Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video4, 0);
    }
    public boolean setVideo5Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video5, status);
        editor.apply();

        return true;
    }
    public int getVideo5Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video5, 0);
    }
    public boolean setVideo6Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video6, status);
        editor.apply();

        return true;
    }
    public int getVideo6Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video6, 0);
    }
    public boolean setVideo7Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video7, status);
        editor.apply();

        return true;
    }
    public int getVideo7Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video7, 0);
    }
    public boolean setVideo8Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video8, status);
        editor.apply();

        return true;
    }
    public int getVideo8Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video8, 0);
    }
    public boolean setVideo9Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video9, status);
        editor.apply();

        return true;
    }
    public int getVideo9Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video9, 0);
    }
    public boolean setVideo10Status(int status) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_Video10, status);
        editor.apply();

        return true;
    }
    public int getVideo10Status() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_Video10, 0);
    }


}
