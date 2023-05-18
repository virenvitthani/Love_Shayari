package com.example.love_shayari;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import Adapter.BackgroundAdapter;
import Adapter.ExpandAdapter;

public class Forthpage extends AppCompatActivity {

    TextView textView,background,textcolor;
    ImageView forthpage_Reload,forthpage_expand;
    int count=0,i=0;

    GridView gridView,gridView1,gridView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forthpage);
        textView = findViewById(R.id.forthpage_txt);
        background = findViewById(R.id.forthpage_Background);
        textcolor = findViewById(R.id.forthpage_TextColor);
        forthpage_Reload = findViewById(R.id.forthpage_Reload);
        forthpage_expand = findViewById(R.id.forthpage_Expand);

        int position = getIntent().getIntExtra("pos",0);
        String shayari[] = getIntent().getStringArrayExtra("shayari");

        textView.setText(shayari[position]);

        forthpage_Reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<15)
                {
                    textView.setBackgroundResource(Configfile.forthgcarr[i]);
                    i++;
                    count++;
                }else
                {
                    i=0;
                    count=0;
                }
            }
        });

        forthpage_expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Forthpage.this);
                bottomSheetDialog.setContentView(R.layout.gridview);
                ExpandAdapter adapter = new ExpandAdapter(Forthpage.this,Configfile.forthgcarr,shayari[position]);
                gridView=bottomSheetDialog.findViewById(R.id.Expand_Gridview);
                gridView.setAdapter(adapter);
                bottomSheetDialog.show();

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(Configfile.forthgcarr[i]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(Forthpage.this);
                bottomSheetDialog1.setContentView(R.layout.background_gridview);
                BackgroundAdapter backgroundAdapter = new BackgroundAdapter(Forthpage.this,Configfile.bgcolorarr);
                gridView1=bottomSheetDialog1.findViewById(R.id.background);
                gridView1.setAdapter(backgroundAdapter);
                bottomSheetDialog1.show();

                gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(Configfile.bgcolorarr[i]);
                        bottomSheetDialog1.dismiss();
                    }
                });
            }
        });

        textcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(Forthpage.this);
                bottomSheetDialog2.setContentView(R.layout.textcolor_gridview);
                BackgroundAdapter backgroundAdapter = new BackgroundAdapter(Forthpage.this,Configfile.textcolorarr);
                gridView2=bottomSheetDialog2.findViewById(R.id.textcolor);
                gridView2.setAdapter(backgroundAdapter);
                bottomSheetDialog2.show();

                gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setTextColor(getResources().getColor(Configfile.textcolorarr[i]));
                        bottomSheetDialog2.dismiss();
                    }
                });
            }
        });
    }
}
