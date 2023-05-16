package com.example.love_shayari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter_secondpage extends BaseAdapter {

    Listview_secondpage listview_secondpage;
    int imgarr1;
    String[] shayaricategari;

    public MyAdapter_secondpage(Listview_secondpage listview_secondpage, int imgarr1, String[] shayaricategari) {
        this.listview_secondpage = listview_secondpage;
        this.imgarr1 = imgarr1;
        this.shayaricategari = shayaricategari;
    }

    public int getCount() {
        return shayaricategari.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(listview_secondpage).inflate(R.layout.activity_imgsecondpage,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.secondpage_img);
        TextView textView = view.findViewById(R.id.imgsecondpage_txt1);

        imageView.setImageResource(imgarr1);
        textView.setText(shayaricategari[position]);
        return view;
    }
}
