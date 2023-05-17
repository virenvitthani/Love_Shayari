package com.example.love_shayari;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class Forthpage extends AppCompatActivity {

    TextView textView;
    ImageView forthpage_Reload,forthpage_expand;
    int count=0,i=0;

    GridView gridViewAda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forthpage);
        textView = findViewById(R.id.forthpage_txt);
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
                gridViewAda=bottomSheetDialog.findViewById(R.id.Expand_Gridview);
                gridViewAda.setAdapter(adapter);
                bottomSheetDialog.show();

                gridViewAda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(Configfile.forthgcarr[i]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

    }
}
