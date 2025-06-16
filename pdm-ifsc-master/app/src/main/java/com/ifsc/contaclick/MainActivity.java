package com.ifsc.contaclick;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity{
    PackageManager pm;

    List<ApplicationInfo> applicationInfoList;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.listView);
        pm=getPackageManager();

       applicationInfoList= pm.getInstalledApplications(PackageManager.MATCH_ALL);

       AppAdapter appAdapter = new AppAdapter(this,R.layout.app_item,applicationInfoList);
       lv.setAdapter(appAdapter);
       lv.setOnItemClickListener((adapter, view, position, id) ->{
           ApplicationInfo applicationInfo= (ApplicationInfo) adapter.getItemAtPosition(position);
           Intent i =pm.getLaunchIntentForPackage(applicationInfo.packageName);
           if(i!= null){
               startActivity(i);
           }else{
               Toast.makeText(getApplicationContext(), "App não lançavel", Toast.LENGTH_LONG);
           }
        });
    }



}