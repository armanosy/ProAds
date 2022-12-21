package com.armandroid.armanads.interfaces.banner;

public interface OnLoadBannerAlienMediation {
    void onBannerAdLoaded();
    void onBannerAdClicked();
    void onBannerAdFailedToLoad(String error);
}
