package com.jonyker.lib;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.jonyker.lib.delegate.ApplicationDelegate;
import com.jonyker.lib.router.JMRouteManager;
import com.jonyker.lib.tools.ActivityManager;
import com.jonyker.lib.tools.SingleContainer;
import com.lzh.compiler.parceler.Parceler;

public final class BaseApplication extends ApplicationDelegate {

    @Override
    public int getLevel() {
        return LEVEL_BASE_LIB;
    }

    @Override
    public Class[] subDelegates() {
        return null;
    }

    @Override
    public void onCreateDelegate() {
        JMRouteManager.get().init();
        SingleContainer.init(getApplicationContext());
        ((Application) getApplicationContext()).registerActivityLifecycleCallbacks(new ActivityCallback());
    }

    private static class ActivityCallback implements ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            ActivityManager.add(activity);
            Parceler.toEntity(activity, activity.getIntent());
        }

        @Override
        public void onActivityStarted(Activity activity) {}

        @Override
        public void onActivityResumed(Activity activity) {}

        @Override
        public void onActivityPaused(Activity activity) {}

        @Override
        public void onActivityStopped(Activity activity) {}

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Parceler.toBundle(activity, outState);
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            ActivityManager.pop(activity);
        }
    }
}

