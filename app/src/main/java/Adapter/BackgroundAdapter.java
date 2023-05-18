package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.love_shayari.Forthpage;
import com.example.love_shayari.R;

public class BackgroundAdapter extends BaseAdapter {

    Forthpage forthpage;
    int[] bgcolorarr;

    public BackgroundAdapter(Forthpage forthpage, int[] bgcolorarr) {
        this.forthpage = forthpage;
        this.bgcolorarr = bgcolorarr;
    }

    @Override
    public int getCount() {
        return bgcolorarr.length;
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
        view = LayoutInflater.from(forthpage).inflate(R.layout.background_itemfile,viewGroup,false);

        TextView textView = view.findViewById(R.id.background_txt);
        textView.setBackgroundResource(bgcolorarr[i]);
        return view;
    }
}
