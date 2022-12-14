package com.kimganteng.myapplication;

import static com.kimganteng.myapplication.SettingsAlien.BackupBanner;
import static com.kimganteng.myapplication.SettingsAlien.BackupNatives;
import static com.kimganteng.myapplication.SettingsAlien.MainBanner;
import static com.kimganteng.myapplication.SettingsAlien.MainNatives;
import static com.kimganteng.myapplication.SettingsAlien.Select_Backup_Ads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.armandroid.armanads.ArmandroidBanner;
import com.armandroid.armanads.ArmandroidNative;
import com.armandroid.armanads.interfaces.natives.OnLoadMediumNativesAdmob;

public class NativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);

        RelativeLayout laySmallAds = findViewById(R.id.laySmallNatives);
        ArmandroidNative.SmallNativeAdmob(this, laySmallAds,Select_Backup_Ads,MainNatives,BackupNatives,"",
                "","","","");

        RelativeLayout layMediumAds = findViewById(R.id.layMediumNatives);

        ArmandroidNative.onLoadMediumNativesAdmob = new OnLoadMediumNativesAdmob() {
            @Override
            public void onNativeAdLoaded() {
                Toast.makeText(NativeActivity.this,"Iklan Terload",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(String error) {
                Toast.makeText(NativeActivity.this,"Iklan Gagal Terload",
                        Toast.LENGTH_SHORT).show();
            }
        };

    }
}