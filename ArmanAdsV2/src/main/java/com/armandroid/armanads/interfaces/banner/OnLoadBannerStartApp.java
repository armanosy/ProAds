package com.armandroid.armanads.interfaces.banner;

public interface OnLoadBannerStartApp {
    void onReceiveAd();
    void onFailedToReceiveAd(String error);
    void onImpression();
    void onClick();

}
