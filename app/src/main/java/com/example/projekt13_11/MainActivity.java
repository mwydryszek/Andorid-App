package com.example.projekt13_11;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int kod = 1010;

    int par = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView mGrid = (GridView) findViewById(R.id.gridview);
        mGrid.setAdapter(new ImageAdapter(MainActivity.this));

        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, Druga_aktywnosc.class);

                intent.putExtra("par", i); //wysylanie

               startActivityForResult(intent, kod);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == kod && resultCode == RESULT_OK){
            par = data.getExtras().getInt("par");
            Toast.makeText(MainActivity.this, " "+par, Toast.LENGTH_LONG).show();
        }

    }
}