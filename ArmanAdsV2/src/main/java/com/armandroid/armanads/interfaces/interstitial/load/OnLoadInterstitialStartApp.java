package com.armandroid.armanads.interfaces.interstitial.load;

public interface OnLoadInterstitialStartApp {
    void onReceiveAd();
    void onFailedToReceiveAd(String error);
}
