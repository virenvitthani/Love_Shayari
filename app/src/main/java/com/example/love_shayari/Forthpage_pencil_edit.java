package com.example.love_shayari;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Forthpage_pencil_edit extends AppCompatActivity {

    TextView forthpage_txt;
    ImageView forthpage_Reload;
    int count=0,i=0;
    int forthgcarr[] = {R.drawable.gc_1,R.drawable.gc_2,R.drawable.gc_3,R.drawable.gc_4,R.drawable.gc_5,
            R.drawable.gc_6,R.drawable.gc_7,R.drawable.gc_8,R.drawable.gc_9,R.drawable.gc_10,
            R.drawable.gc_11,R.drawable.gc_12,R.drawable.gc_13,R.drawable.gc_14,R.drawable.gc_15};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forthpage_pencil_editimg);
        forthpage_txt = findViewById(R.id.forthpage_txt);
        forthpage_Reload = findViewById(R.id.forthpage_Reload);

        int position = getIntent().getIntExtra("pos",0);
        String shayari[] = getIntent().getStringArrayExtra("shayari");

        forthpage_txt.setText(shayari[position]);

        forthpage_Reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count<15)
                {
                    forthpage_txt.setBackgroundResource(forthgcarr[i]);
                    i++;
                    count++;
                }else
                {
                    i=0;
                    count=0;
                }
            }
        });

    }
}
