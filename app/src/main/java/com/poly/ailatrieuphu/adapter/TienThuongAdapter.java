package com.poly.ailatrieuphu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.poly.ailatrieuphu.R;

import java.util.ArrayList;
import java.util.List;

public class TienThuongAdapter extends ArrayAdapter<String>{
    Context mContext;
    ArrayList<String> arrayList;
    int viTriQuestion = 1;

    public TienThuongAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.arrayList = new ArrayList<>(objects);
    }

    public void setViTriQuestion(int viTriQuestion) {
        this.viTriQuestion = viTriQuestion;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_lever, null);
        }
        if (arrayList.size() > 0){
            int pos = 15 - position;
            TextView  tvTienThuong = convertView.findViewById(R.id.tvTienThuong);
            if (pos % 5 == 0){
                tvTienThuong.setTextColor(Color.WHITE);
            }else {
                tvTienThuong.setTextColor(Color.BLACK);
            }
            String khoangTrang;
            if (pos/10>0){
                khoangTrang = "     ";
            }else {
                khoangTrang = "      ";
            }
            String textHienThi = pos+ khoangTrang +"$"+arrayList.get(position);
            tvTienThuong.setText(textHienThi);

            if (pos == viTriQuestion){
                tvTienThuong.setBackgroundColor(Color.parseColor("#FF9800"));
                tvTienThuong.setTextColor(Color.parseColor("#151515"));
            }else{
                tvTienThuong.setBackgroundColor(Color.parseColor("#02FF9800"));
            }
         }
        return convertView;
    }
}
