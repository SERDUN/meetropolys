package com.meetropolys.meetropolys.services.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.meetropolys.meetropolys.R;
import com.meetropolys.meetropolys.services.navigation.factory.ScreenActivityFactory;
import com.meetropolys.meetropolys.services.navigation.factory.ScreenFragmentFactory;
import com.meetropolys.meetropolys.ui.base.BaseActivity;
import org.jetbrains.annotations.NotNull;

public class ScreenNavigationManager implements NavigationController {
    private static final String TAG = ScreenNavigationManager.class.getSimpleName();
    private final static String EXTRA_ACTIVE_SCREEN = "ScreenNavigationManager.activeScreen";
    private int currentNavigationContainer;
    private final BaseActivity activity;
    private Screen activeScreen = Screen.NONE;
    private Screen previousScreen = Screen.NONE;
    private final ScreenFragmentFactory fragmentFactory;
    private final ScreenActivityFactory activityFactory;

    public ScreenNavigationManager(BaseActivity activity) {
        this.activity = activity;
        fragmentFactory = new ScreenFragmentFactory();
        activityFactory = new ScreenActivityFactory();
    }

    @Override
    public void navigateTo(@NotNull Screen screen, @NotNull ScreenType type) {
        navigateTo(screen, type, null);

    }

    @Override
    public void navigateTo(@NotNull Screen screen, @NotNull ScreenType type, @NotNull Bundle bundle) {
        switch (type) {
            case ACTIVITY:
                navigateToActivity(screen, bundle);
                break;
            case FRAGMENT:
                navigateToFragment(screen, bundle);
                break;

        }
    }

    private void navigateToFragment(Screen screen, Bundle bundle) {
        switch (screen) {
            case SIGN_IN_FRAGMENT:
                navigateToSignInFragment(bundle);
                break;
        }

    }

    private void navigateToSignInFragment(Bundle bundle) {
        activeScreen = Screen.SIGN_IN_FRAGMENT;
        switchFragmentScreen(Screen.SIGN_IN_FRAGMENT, bundle, true, false,currentNavigationContainer);
    }

    private void navigateToActivity(Screen screen, Bundle bundle) {
        switch (screen) {
            case AUTHORIZATION_ACTIVITY:
                navigateToRegisterActivity(bundle);
                break;

        }

    }

    private void navigateToRegisterActivity(Bundle bundle) {
        switchActivityScreen(Screen.AUTHORIZATION_ACTIVITY, bundle, ScreenAnimType.FADE_TYPE);

        activity.hideKeyboard();
        activity.finish();
        activity.freeMemory();
    }

    private void switchActivityScreen(Screen type, Bundle bundle, ScreenAnimType animate) {
        Intent intent = activityFactory.getActivityByType(type);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        if (bundle != null && !bundle.isEmpty()) {
            intent.putExtras(bundle);
        }

        activity.startActivity(intent);
        switch (animate) {
            case FADE_TYPE:
                activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case RIGHT_TO_LEFT_TYPE:
                activity.overridePendingTransition(R.anim.right_to_left_in, R.anim.right_to_left_out);
                break;
            case LEFT_TO_RIGHT_TYPE:
                activity.overridePendingTransition(R.anim.left_to_right_in, R.anim.left_to_right_out);
                break;
            case UP_TO_DOWN_TYPE:
                activity.overridePendingTransition(R.anim.up_to_down_in, R.anim.up_to_down_out);
                break;
        }
    }

    private void switchFragmentScreen(Screen type, Bundle bundle, boolean animate, boolean addToBackStack, int idContainer) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction tran = fragmentManager.beginTransaction();
        if (animate) {
            tran.setCustomAnimations(R.anim.popup_in, R.anim.popup_out);
        }

        Fragment fragment = fragmentFactory.getFragmentByType(type);
        if (bundle != null && !bundle.isEmpty()) {
            fragment.setArguments(bundle);
        }
        if (addToBackStack) {
            if (animate) {
                tran.setCustomAnimations(R.anim.right_to_left_in, R.anim.right_to_left_out, R.anim.left_to_right_in, R.anim.left_to_right_out);
            }
            tran.replace(idContainer, fragment, fragment.getClass().getSimpleName());
            tran.addToBackStack(fragment.getClass().getSimpleName());
        } else {
            if (animate) {
                tran.setCustomAnimations(R.anim.popup_in, R.anim.popup_out);
            }
            tran.replace(idContainer, fragment);
        }
        try {
            tran.commitAllowingStateLoss();
        } catch (Exception e) {
            Log.e(TAG, "Activity destroyed");
        }
    }


    @Override
    public void onBack() {

    }


    @Override
    public void setNavigationContainer(int i) {
        this.currentNavigationContainer = i;
    }
}
