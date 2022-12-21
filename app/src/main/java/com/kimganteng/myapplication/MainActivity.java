package com.kimganteng.myapplication;

import static android.content.ContentValues.TAG;
import static com.kimganteng.myapplication.SettingsAlien.AppIDViewAds;
import static com.kimganteng.myapplication.SettingsAlien.BackupIntertitial;
import static com.kimganteng.myapplication.SettingsAlien.BackupReward;
import static com.kimganteng.myapplication.SettingsAlien.Backup_Initialize;
import static com.kimganteng.myapplication.SettingsAlien.MainIntertitial;
import static com.kimganteng.myapplication.SettingsAlien.MainRewards;
import static com.kimganteng.myapplication.SettingsAlien.Select_Backup_Ads;
import static com.kimganteng.myapplication.SettingsAlien.Select_Main_Ads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.armandroid.armanads.ArmanGDPR;
import com.armandroid.armanads.ArmandroidInitialize;
import com.armandroid.armanads.ArmandroidIntertitial;
import com.armandroid.armanads.ArmandroidReward;
import com.armandroid.armanads.interfaces.interstitial.admob.OnFullScreenContentCallbackAdmob;
import com.armandroid.armanads.interfaces.interstitial.load.OnLoadInterstitialAdmob;
import com.armandroid.armanads.interfaces.interstitial.show.OnShowInterstitialAdmob;
import com.armandroid.armanads.interfaces.rewards.load.OnLoadRewardsAdmob;
import com.armandroid.sdkads.config.AppPromote;
import com.armandroid.sdkads.config.InitializeAlienAds;
import com.armandroid.sdkads.config.QWERTY;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppPromote.initializeAppPromote(this);
        InitializeAlienAds.LoadSDK();
        /*
        if (SettingsAlien.Select_Open_Ads.equals("2")) {

            AlienViewAds.OpenApp(MainActivity.this,AppIDViewAds);
        }
         */
        ArmandroidInitialize.SelectAdsApplovinMax(this,Select_Backup_Ads,Backup_Initialize);
        ArmanGDPR.loadGdpr(this,Select_Main_Ads,true);
        ArmandroidIntertitial.LoadIntertitialApplovinMax(MainActivity.this,Select_Backup_Ads,MainIntertitial,BackupIntertitial);

        ArmandroidIntertitial.onShowInterstitialAdmob = new OnShowInterstitialAdmob() {
            @Override
            public void onAdSuccess() {
                ArmandroidIntertitial.onFullScreenContentCallbackAdmob = new OnFullScreenContentCallbackAdmob() {
                    @Override
                    public void onAdClicked() {

                    }

                    @Override
                    public void onAdDismissedFullScreenContent() {
                        Intent open = new Intent(MainActivity.this,BannerActivity.class);
                        startActivity(open);
                    }

                    @Override
                    public void onAdImpression() {

                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent() {

                    }
                };
            }

            @Override
            public void onAdFailedShow() {
                Intent open = new Intent(MainActivity.this,BannerActivity.class);
                startActivity(open);
            }
        };

        ArmandroidReward.LoadRewardApplovinMax(this,Select_Backup_Ads,MainRewards,BackupReward);
        ArmandroidReward.onLoadRewardsAdmob = new OnLoadRewardsAdmob() {
            @Override
            public void onAdFailedToLoad() {

            }

            @Override
            public void onAdLoaded(String error) {

            }
        };

    }

    public void BANNER(View view){
        Intent open = new Intent(MainActivity.this,BannerActivity.class);
        startActivity(open);

    }

    public void VIEWADS(View view){
        Intent open = new Intent(MainActivity.this,ViewAdsActivity.class);
        startActivity(open);

    }

    public void NATIVES(View view){
        Intent open = new Intent(MainActivity.this,NativeActivity.class);
        startActivity(open);

    }


    public void MEDIATION(View view){
        Intent open = new Intent(MainActivity.this,MediationAdsActivity.class);
        startActivity(open);

    }

    public void INTERSTITIAL(View view){
        ArmandroidIntertitial.ShowIntertitialAdmob(MainActivity.this,Select_Backup_Ads,MainIntertitial,BackupIntertitial,0,"",
        "","","","");
    }

    public void REWARD(View view){
        ArmandroidReward.ShowRewardAdmob(MainActivity.this,Select_Backup_Ads,MainRewards,BackupReward);
    }

    public void onBackPressed(){
        finishAffinity();
        System.exit(0);
    }
}