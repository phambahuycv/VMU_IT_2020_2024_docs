package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class N04_12 extends AppCompatActivity {
    private View viw1;
    private View viw2;
    private View viw3;
    private View viw4;
    private View theFirstView = null;
    private View theSecondView = null;
    private void findViews() {
        viw1 = findViewById(R.id.viw10412);
        viw2 = findViewById(R.id.viw20412);
        viw3 = findViewById(R.id.viw30412);
        viw4 = findViewById(R.id.viw40412);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0412);
        findViews();
    }

    public void viw_Clicked(View view) {
        view.setVisibility(View.INVISIBLE);
        if (viw1.getVisibility() == View.INVISIBLE && viw2.getVisibility() == View.INVISIBLE && viw3.getVisibility() == View.INVISIBLE && viw4.getVisibility() == View.INVISIBLE) {
            viw1.setVisibility(View.VISIBLE);
            viw2.setVisibility(View.VISIBLE);
            viw3.setVisibility(View.VISIBLE);
            viw4.setVisibility(View.VISIBLE);
        }
        /*if (theFirstView == null)
            theFirstView = view;
        else {
            theSecondView = view;
            int temp = ((ColorDrawable)theFirstView.getBackground()).getColor();
            theFirstView.setBackgroundColor(((ColorDrawable)theSecondView.getBackground()).getColor());
            theSecondView.setBackgroundColor(temp);
            theFirstView = null;
            theSecondView = null;
        }*/

        /*view.bringToFront();
        ColorDrawable drawable = (ColorDrawable)view.getBackground();
        Toast.makeText(this,Integer.toHexString(drawable.getColor()),Toast.LENGTH_LONG).show();*/
    }

    public void btn1_Clicked(View view) {
        if (viw1.getVisibility() == View.VISIBLE)
            viw1.setVisibility(View.INVISIBLE);
        else
            viw1.setVisibility(View.VISIBLE);
    }

    public void btn2_Clicked(View view) {
        if (viw2.getVisibility() == View.VISIBLE)
            viw2.setVisibility(View.INVISIBLE);
        else
            viw2.setVisibility(View.VISIBLE);
    }

    public void btn3_Clicked(View view) {
        if (viw3.getVisibility() == View.VISIBLE)
            viw3.setVisibility(View.INVISIBLE);
        else
            viw3.setVisibility(View.VISIBLE);
    }

    public void btn4_Clicked(View view) {
        if (viw4.getVisibility() == View.VISIBLE)
            viw4.setVisibility(View.INVISIBLE);
        else
            viw4.setVisibility(View.VISIBLE);
    }

    public void btn1_1_Clicked(View view) {
        ViewGroup.LayoutParams params = viw1.getLayoutParams();
        if (viw1.getWidth() == 200)
            params.width = 250;
        else
            params.width = 200;
        viw1.setLayoutParams(params);
    }

    public void btn2_1_Clicked(View view) {
        ViewGroup.LayoutParams params = viw2.getLayoutParams();
        if (viw2.getWidth() == 200)
            params.width = 250;
        else
            params.width = 200;
        viw2.setLayoutParams(params);
    }

    public void btn3_1_Clicked(View view) {
        ViewGroup.LayoutParams params = viw3.getLayoutParams();
        if (viw3.getWidth() == 200)
            params.width = 250;
        else
            params.width = 200;
        viw3.setLayoutParams(params);
    }

    public void btn4_1_Clicked(View view) {
        ViewGroup.LayoutParams params = viw4.getLayoutParams();
        if (viw4.getWidth() == 200)
            params.width = 250;
        else
            params.width = 200;
        viw4.setLayoutParams(params);
    }
}