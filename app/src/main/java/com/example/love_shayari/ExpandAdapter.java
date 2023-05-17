package com.example.love_shayari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ExpandAdapter extends BaseAdapter {

    Shayari_Thirdpage shayari_thirdpage;
    int [] gcarr;
    TextView textView;

    public ExpandAdapter(Shayari_Thirdpage shayari_thirdpage, int[] gcarr) {
        this.shayari_thirdpage = shayari_thirdpage;
        this.gcarr = gcarr;
    }

    @Override
    public int getCount() {
        return gcarr.length;
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
        textView.setBackgroundResource(gcarr[i]);
        return view;
    }
}
