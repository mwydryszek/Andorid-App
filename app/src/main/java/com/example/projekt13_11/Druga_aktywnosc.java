package com.example.projekt13_11;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Druga_aktywnosc extends Activity {

    int i = 0;

    int ilosc = 0;

    int par = -2;


    int Zdj[] = {R.drawable.k1, R.drawable.k2, R.drawable.k3, R.drawable.k4};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.druga_akt);


        Button tyl = (Button) findViewById(R.id.button);
        Button wyj = (Button) findViewById(R.id.button2);
        Button prz = (Button) findViewById(R.id.button3);

        Intent intent = getIntent();
        par = intent.getIntExtra("par", -1);  //odbieranie

        ImageView mainokno = (ImageView) findViewById(R.id.imageView);

        Bitmap f1 = BitmapFactory.decodeResource(getResources(), Zdj[par]);

        Bitmap f2 = Bitmap.createScaledBitmap(f1, 480, 320, false);

        mainokno.setImageBitmap(f2);

        tyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView okno = (ImageView) findViewById(R.id.imageView);

                if(i == 0)
                    i = Zdj.length-1;
                else
                    --i;

                Bitmap foto = BitmapFactory.decodeResource(getResources(), Zdj[i]);

                Bitmap foto1 = Bitmap.createScaledBitmap(foto, 480, 320, false);

                okno.setImageBitmap(foto1);

                ++ilosc;


            }
        });

        wyj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                intent.putExtra("par", ilosc); //odeslanie
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        prz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageView okno = (ImageView) findViewById(R.id.imageView);

                if(i == Zdj.length-1)
                    i = 0;
                else
                    ++i;

                Bitmap foto = BitmapFactory.decodeResource(getResources(), Zdj[i]);

                Bitmap foto1 = Bitmap.createScaledBitmap(foto, 480, 320, false);

                okno.setImageBitmap(foto1);

                ++ilosc;

            }
        });



    }
}
