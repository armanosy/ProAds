package com.armandroid.sdkads.config;

import android.app.Activity;

import com.armandroid.sdkads.cennections.ConnectionPromote;
import com.armandroid.sdkads.interfaces.OnConnectedListener;
import com.armandroid.sdkads.interfaces.OnPromoteAppListener;

public class AppPromote {
    public static OnPromoteAppListener onPromoteAppListener;
    public static void initializeAppPromote(Activity activity){
            ConnectionPromote connectionPromote = new ConnectionPromote(activity,"https://");
            connectionPromote.setOnPromoteConnected(new OnConnectedListener() {
                @Override
                public void onAppConnected() {
                    if (onPromoteAppListener != null){
                        onPromoteAppListener.onInitializeSuccessful();
                    }
                }

                @Override
                public void onAppFailed(String error) {
                    if (onPromoteAppListener != null){
                        onPromoteAppListener.onInitializeFailed(error);
                    }
                }
            });

    }
}
