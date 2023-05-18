package Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.love_shayari.R;

public class ExpandAdapter extends BaseAdapter {

    Activity activity;
    int[] gcarr;
    String shayari;

    public ExpandAdapter(Activity activity, int[] gcarr, String shayari) {
        this.activity = activity;
        this.gcarr = gcarr;
        this.shayari = shayari;
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
        view = LayoutInflater.from(activity).inflate(R.layout.gridview_itemfile,viewGroup,false);
        TextView textView = view.findViewById(R.id.gridview_itemfile_txt);
        textView.setBackgroundResource(gcarr[i]);
        TextView textView1 = view.findViewById(R.id.gridview_itemfile_txt);
        textView1.setText(shayari);
        return view;
    }
}
