package com.example.projekt13_11;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    private int Zdj[]= {
            R.drawable.k1,
            R.drawable.k2,
            R.drawable.k3,
            R.drawable.k4
    };


    ImageAdapter(Context c){
        mContext = c;
    }


    @Override
    public int getCount() {
        return Zdj.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0L;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView foto;

        if(view == null){           // potrzebny init

            foto = new ImageView(mContext);
            foto.setLayoutParams(new ViewGroup.LayoutParams(550,550));
            foto.setScaleType(ImageView.ScaleType.CENTER_CROP);
            foto.setPadding(15,15,15,15);

        }else{
            foto = (ImageView) view;
        }

        foto.setImageResource(Zdj[i]);


        return foto;
    }
}

