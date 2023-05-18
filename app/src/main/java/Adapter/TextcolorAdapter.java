package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.love_shayari.Forthpage;
import com.example.love_shayari.R;

public class TextcolorAdapter extends BaseAdapter {

    Forthpage forthpage;
    int[] fontcolorarr;

    public TextcolorAdapter(Forthpage forthpage, int[] fontcolorarr) {
        this.forthpage = forthpage;
        this.fontcolorarr = fontcolorarr;
    }

    @Override
    public int getCount() {
        return fontcolorarr.length;
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
        view = LayoutInflater.from(forthpage).inflate(R.layout.textcolor_itemfile, viewGroup,false);

        TextView textView = view.findViewById(R.id.textcolor_txt);
        textView.setBackgroundResource(fontcolorarr[i]);

        return view;
    }
}
