package com.kimganteng.myapplication;

import static com.kimganteng.myapplication.SettingsAlien.AppIDMediationAds;
import static com.kimganteng.myapplication.SettingsAlien.AppIDViewAds;
import static com.kimganteng.myapplication.SettingsAlien.Backup_Initialize;
import static com.kimganteng.myapplication.SettingsAlien.Main_Initialize;
import static com.kimganteng.myapplication.SettingsAlien.ONLOADOPEN;
import static com.kimganteng.myapplication.SettingsAlien.Select_Backup_Ads;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.armandroid.armanads.AlienNotif;
import com.armandroid.armanads.AlienOpenAds;
import com.armandroid.armanads.ArmandroidInitialize;
import com.armandroid.armanads.MyApplication;
import com.armandroid.armanads.interfaces.open.OnLoadOpenAppAdmob;
import com.armandroid.armanads.interfaces.open.OnShowOpenAppAdmob;
import com.armandroid.sdkads.config.AppPromote;
import com.armandroid.sdkads.config.InitializeAlienAds;
import com.armandroid.sdkads.interfaces.OnOpenViewAdListener;
import com.armandroid.sdkads.type.view.AlienViewAds;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        /*
        Armandroid have 2 ads (view and mediation)
        type view ads = Banner, Interstitial and Open Ads
        type mediation Ads = Banner, Interstitial, Rewards and Natives
         */
        /*
        Initilize for Alien Mediation Ads
         */
        InitializeAlienAds.LoadSDK();
        ArmandroidInitialize.SelectAdsApplovinMax(this,Select_Backup_Ads,Backup_Initialize);
        if (SettingsAlien.Select_Open_Ads.equals("1")){
            AlienNotif.LoadOneSignal("535dc774-9fe3-44ae-839e-09e4133aebe9");
         AlienOpenAds.LoadOpenAds("ca-app-pub-3940256099942544/3419835294",true);
         AlienOpenAds.AppOpenAdManager.showAdIfAvailable(SplashActivity.this, new AlienOpenAds.OnShowAdCompleteListener() {
             @Override
             public void onShowAdComplete() {
                 startActivity(true);
             }
         });

        } else {
            startActivity(true);
        }


    }

    private void startActivity(boolean useTime){
        if (useTime){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                }
            },1000*3);
        }else {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

    }


}
