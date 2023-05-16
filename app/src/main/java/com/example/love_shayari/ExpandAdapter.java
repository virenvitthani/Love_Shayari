package com.example.love_shayari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ExpandAdapter extends BaseAdapter {

    Shayari_Thirdpage shayari_thirdpage;
    int [] expandAdapter;

    public ExpandAdapter(Shayari_Thirdpage shayari_thirdpage, int[] expandAdapter) {
        this.shayari_thirdpage = shayari_thirdpage;
        this.expandAdapter = expandAdapter;
    }

    @Override
    public int getCount() {
        return expandAdapter.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(shayari_thirdpage).inflate(R.layout.gridview_itemfile,viewGroup,false);
        TextView textView = view.findViewById(R.id.gridview_itemfile_txt);
        return view;
    }
}
