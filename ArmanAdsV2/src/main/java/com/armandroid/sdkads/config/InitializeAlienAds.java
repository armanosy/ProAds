package com.armandroid.sdkads.config;

public class InitializeAlienAds {
    public static com.armandroid.armanads.MyApplication application;

    public InitializeAlienAds(com.armandroid.armanads.MyApplication myApplication) {
        application = myApplication;
    }

    public static void LoadSDK() {
        Connection.SDKMediation(application, AppsConfig.APPKEY);
    }

}
