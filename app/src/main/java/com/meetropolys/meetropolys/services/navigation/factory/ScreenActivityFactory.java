package com.meetropolys.meetropolys.services.navigation.factory;

import android.app.Activity;
import android.content.Intent;
import com.meetropolys.meetropolys.MeetroopolysApplication;
import com.meetropolys.meetropolys.services.navigation.Screen;
import com.meetropolys.meetropolys.ui.screen.authorization.BaseAuthorizationActivity;

public class ScreenActivityFactory {
    public Intent getActivityByType(Screen type) {
        Class<? extends Activity> clazz = getActivityClassByType(type);
        return new Intent(MeetroopolysApplication.instance.getApplicationContext(), clazz);
    }

    public Class<? extends Activity> getActivityClassByType(Screen type) {
        switch (type) {
            case AUTHORIZATION_ACTIVITY:
                return BaseAuthorizationActivity.class;
        }
        return BaseAuthorizationActivity.class;
    }
}
