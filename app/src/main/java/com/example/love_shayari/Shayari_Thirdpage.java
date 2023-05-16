package com.example.love_shayari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Shayari_Thirdpage extends AppCompatActivity {

    TextView textView;
    ImageView reload,pencil,expand;
    int count=0,i=0;
    int gcarr[] = {R.drawable.gc_1,R.drawable.gc_2,R.drawable.gc_3,R.drawable.gc_4,R.drawable.gc_5,
                   R.drawable.gc_6,R.drawable.gc_7,R.drawable.gc_8,R.drawable.gc_9,R.drawable.gc_10,
                   R.drawable.gc_11,R.drawable.gc_12,R.drawable.gc_13,R.drawable.gc_14,R.drawable.gc_15};

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdpage_toolspage);
        textView = findViewById(R.id.thirdpagetool_shayaritxt);
        reload = findViewById(R.id.thirdpagetool_Reload);
        pencil = findViewById(R.id.thirdpagetool_Pencil);
        expand = findViewById(R.id.thirdpagetool_Expand);

        int position = getIntent().getIntExtra("pos",0);
        String shayari[] = getIntent().getStringArrayExtra("shayari");

        textView.setText(shayari[position]);

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<15)
                {
                    textView.setBackgroundResource(gcarr[i]);
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
                Intent intent = new Intent(Shayari_Thirdpage.this, Forthpage_pencil_edit.class);
                intent.putExtra("pos",i);
                intent.putExtra("shayari",shayari);
                startActivity(intent);
            }
        });

        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
                bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
            }
        });
    }
}