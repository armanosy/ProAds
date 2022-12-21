package com.kimganteng.myapplication;

import static com.kimganteng.myapplication.SettingsAlien.BackupBanner;
import static com.kimganteng.myapplication.SettingsAlien.MainBanner;
import static com.kimganteng.myapplication.SettingsAlien.Select_Backup_Ads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.armandroid.armanads.ArmandroidBanner;
import com.armandroid.armanads.ArmandroidMediumBanner;
import com.armandroid.armanads.interfaces.banner.OnLoadBannerAdmob;

public class BannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        /*
        Load Relativelayout from acitivty_banner.xml
         */
        RelativeLayout laySmallAds = findViewById(R.id.lay320x50);
        RelativeLayout layMediumAds = findViewById(R.id.lay300x250);

        /*
        Small Banner 320x50
         */
        ArmandroidBanner.SmallBannerAdmob(this, laySmallAds,Select_Backup_Ads,MainBanner,BackupBanner,
        "","","","","");
        ArmandroidBanner.onLoadBannerAdmob = new OnLoadBannerAdmob() {
            @Override
            public void onAdLoaded() {
                Toast.makeText(BannerActivity.this,"Iklan Terload",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(String error) {
                Toast.makeText(BannerActivity.this,"Tidak Ada Iklan",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {

            }

            @Override
            public void onAdClicked() {

            }

            @Override
            public void onAdClosed() {

            }
        };

        /*
        Medium Banner 300x250
         */
        ArmandroidMediumBanner.MediumBannerApplovinMax(this, layMediumAds,Select_Backup_Ads,MainBanner,BackupBanner);
        ArmandroidMediumBanner.onLoadBannerAdmob = new OnLoadBannerAdmob() {
            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdFailedToLoad(String error) {

            }

            @Override
            public void onAdOpened() {

            }

            @Override
            public void onAdClicked() {

            }

            @Override
            public void onAdClosed() {

            }
        };

    }
}