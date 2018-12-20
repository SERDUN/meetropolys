package com.meetropolys.meetropolys.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.meetropolys.meetropolys.services.navigation.NavigationController;
import com.meetropolys.meetropolys.services.navigation.ScreenNavigationManager;

public class BaseActivity extends AppCompatActivity {
    protected final String TAG = getClass().getSimpleName();
    private NavigationController navigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, " onCreate()" + (savedInstanceState != null ? " recreating" : ""));
        navigationController = new ScreenNavigationManager(this);
        super.onCreate(savedInstanceState);


    }


    public void hideKeyboard() {
        try {
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                IBinder windowToken = getWindow().getDecorView().getRootView().getWindowToken();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(windowToken, 0);
            }, 100);

        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
    }

    public void freeMemory() {
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }

    public NavigationController getNavigationController() {
        return navigationController;
    }
}
