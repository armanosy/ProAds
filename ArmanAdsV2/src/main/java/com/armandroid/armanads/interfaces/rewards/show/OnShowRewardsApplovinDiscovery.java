package com.armandroid.armanads.interfaces.rewards.show;

public interface OnShowRewardsApplovinDiscovery {
    void userRewardVerified();
    void userOverQuota();
    void userRewardRejected();
    void validationRequestFailed();
    void adDisplayed();
    void adHidden();

}
