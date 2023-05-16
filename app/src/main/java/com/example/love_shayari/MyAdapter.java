package com.example.love_shayari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    MainActivity mainActivity;

    int[] imgarr;
    String[] shayariname;

    public MyAdapter(MainActivity mainActivity, int[] imgarr, String[] shayariname) {
        this.mainActivity = mainActivity;
        this.imgarr = imgarr;
        this.shayariname = shayariname;
    }

    @Override
    public int getCount() {
        return shayariname.length;
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
        view = LayoutInflater.from(mainActivity).inflate(R.layout.activity_imgfirstpage,viewGroup,false);
        ImageView imageView = view.findViewById(R.id.firstpage_img);
        TextView textView = view.findViewById(R.id.imgfirstpage_txt1);

        imageView.setImageResource(imgarr[position]);
        textView.setText(shayariname[position]);

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity);
//                builder.setTitle("Alter");
//                builder.setMessage("Are You Sure Open Imges");
//                builder.setPositiveButton();
//            }
//        });
        return view;
    }
}
