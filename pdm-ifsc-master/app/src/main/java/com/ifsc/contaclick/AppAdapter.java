package com.ifsc.contaclick;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter  extends ArrayAdapter<ApplicationInfo> {
    int mresource;

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects){
        super(context, resource, objects);
        mresource = resource;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
         View v = layoutInflater.inflate(mresource,parent,false);
        ImageView imageView=v.findViewById(R.id.imageView);
        TextView tv=v.findViewById(R.id.textView);
        LinearLayout ll=v.findViewById(R.id.linearlayout) ;

        ApplicationInfo appinfo=getItem(position);

        tv.setText(appinfo.loadLabel(getContext().getPackageManager()));
        imageView.setImageDrawable(appinfo.loadIcon(getContext().getPackageManager()));

        TextView tvpackName=new TextView(getContext());
        tvpackName.setText(appinfo.packageName);

        ll.addView(tvpackName);

        TextView Storage=new TextView(getContext());
        Storage.setText(appinfo.dataDir);

        ll.addView(Storage);

        tv=new  TextView(getContext());
        tv.setText(appinfo.className);

        ll.addView(tv);

        tv=new  TextView(getContext());
        tv.setText("src: "+appinfo.sourceDir);

        ll.addView(tv);






        return v;

    }
}
