package com.example.love_shayari;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import Adapter.ExpandAdapter;

public class Shayari_Thirdpage extends AppCompatActivity {

    TextView textView,index;
    ImageView reload,pencil,expand,copy,next,back;
    String shayari[];
    int count=0,i=0,a=0,b=1;
    GridView gridViewAda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdpage_toolspage);
        textView = findViewById(R.id.thirdpagetool_shayaritxt);
        reload = findViewById(R.id.thirdpagetool_Reload);
        pencil = findViewById(R.id.thirdpagetool_Pencil);
        expand = findViewById(R.id.thirdpagetool_Expand);
        copy = findViewById(R.id.thirdpagetool_Copy);
        next = findViewById(R.id.thirdpagetool_Next);
        back = findViewById(R.id.thirdpagetool_Back);
        index = findViewById(R.id.thirdpagetool_txt1);

        int position = getIntent().getIntExtra("pos",0);
        String shayari[] = getIntent().getStringArrayExtra("shayari");

        textView.setText(shayari[position]);

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<15)
                {
                    textView.setBackgroundResource(Configfile.gcarr[i]);
                    i++;
                    count++;
                }else
                {
                    i=0;
                    count=0;
                }
            }
        });

        pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shayari_Thirdpage.this, Forthpage.class);
                intent.putExtra("pos",position);
                intent.putExtra("shayari",shayari);
                startActivity(intent);
            }
        });

        a=position;
        b=a+1;
        index.setText(""+b+"/"+shayari.length);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a<shayari.length-1)
                {
                    a++;
                    b=a+1;
                    textView.setText(""+shayari[a]);
                    index.setText(""+b+"/"+shayari.length);
                }
            }
        });

        a=position;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(a>0)
                {
                    a--;
                    b--;
                    textView.setText(""+shayari[a]);
                    index.setText(""+b+"/"+shayari.length);
                }
            }
        });

        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Shayari_Thirdpage.this);
                bottomSheetDialog.setContentView(R.layout.gridview);
                ExpandAdapter adapter = new ExpandAdapter(Shayari_Thirdpage.this,Configfile.gcarr,shayari[position]);
                gridViewAda=bottomSheetDialog.findViewById(R.id.Expand_Gridview);
                gridViewAda.setAdapter(adapter);
                bottomSheetDialog.show();

                gridViewAda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setBackgroundResource(Configfile.gcarr[i]);
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}