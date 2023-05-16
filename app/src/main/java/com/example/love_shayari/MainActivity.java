package com.example.love_shayari;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    int imgarr[] = {R.drawable.bewfa,R.drawable.god,R.drawable.holiimg,R.drawable.husband,R.drawable.kanjoos,
                    R.drawable.love,R.drawable.loveshayari,R.drawable.married,R.drawable.officework,R.drawable.politics};

    String shayariname[] = {"bewfa","god","holiimg","husband","kanjoos",
                            "love","loveshayari","married","officework","politics"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,imgarr,shayariname);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this,Listview_secondpage.class);
                intent.putExtra("pos",position);
                intent.putExtra("imgarr",imgarr);
                intent.putExtra("shayariname",shayariname);
                startActivity(intent);
            }
        });
    }
}