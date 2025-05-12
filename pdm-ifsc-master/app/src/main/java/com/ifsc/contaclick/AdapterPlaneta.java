package com.ifsc.contaclick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterPlaneta extends ArrayAdapter<Planeta> {
    int mresourcer;


    public AdapterPlaneta(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        convertView= layoutInflater.inflate(mresourcer,parent, false);

        //preenchendo o intem, da view
        TextView tvnome = convertView.findViewById(R.id.textView);

        tvnome.setText(this.getItem(position).nome);

return convertView;
       // return super.getView(position, convertView, parent);
    }
}
