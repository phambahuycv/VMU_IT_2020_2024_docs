package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class N01_12 extends AppCompatActivity {
    private View viw1;
    private View viw2;
    private View viw3;
    private View viw4;
    private View firstView = null;
    private View secondView = null;
    private void findViews() {
        viw1 = findViewById(R.id.viw1_0112);
        viw2 = findViewById(R.id.viw2_0112);
        viw3 = findViewById(R.id.viw3_0112);
        viw4 = findViewById(R.id.viw4_0112);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0112);
        findViews();
    }

    private int convertDpToPx(float dp) {
        float density = this.getResources().getDisplayMetrics().density;
        return (int)(dp * density);
    }
    public void btni_1_Clicked(View view) {
        String text = ((Button)view).getText().toString().toLowerCase();
        View viw;
        if (text.equals("btn 1 1"))
            viw = viw1;
        else if (text.equals("btn 2 1"))
            viw = viw2;
        else if (text.equals("btn 3 1"))
            viw = viw3;
        else
            viw = viw4;
        ViewGroup.LayoutParams params = viw.getLayoutParams();
        if (params.width == convertDpToPx(200))
            params.width = convertDpToPx(250);
        else
            params.width = convertDpToPx(200);
        viw.setLayoutParams(params);
    }

    public void btn1_Clicked(View view) {
        if (viw1.getVisibility() == View.INVISIBLE)
            viw1.setVisibility(View.VISIBLE);
        else
            viw1.setVisibility(View.INVISIBLE);
    }

    public void btn2_Clicked(View view) {
        if (viw2.getVisibility() == View.INVISIBLE)
            viw2.setVisibility(View.VISIBLE);
        else
            viw2.setVisibility(View.INVISIBLE);
    }

    public void btn3_Clicked(View view) {
        if (viw3.getVisibility() == View.INVISIBLE)
            viw3.setVisibility(View.VISIBLE);
        else
            viw3.setVisibility(View.INVISIBLE);
    }

    public void btn4_Clicked(View view) {
        if (viw4.getVisibility() == View.INVISIBLE)
            viw4.setVisibility(View.VISIBLE);
        else
            viw4.setVisibility(View.INVISIBLE);
    }

    public void viw_Clicked(View view) {
        /*ColorDrawable drawable = (ColorDrawable) view.getBackground();
        int colorCode = drawable.getColor();
        Toast.makeText(this,Integer.toHexString(colorCode),Toast.LENGTH_LONG).show();*/
        //view.bringToFront();
        /*if (firstView == null)
            firstView = view;
        else {
            secondView = view;
            int color1 = ((ColorDrawable)firstView.getBackground()).getColor();
            int color2 = ((ColorDrawable)secondView.getBackground()).getColor();
            firstView.setBackgroundColor(color2);
            secondView.setBackgroundColor(color1);
            firstView = null;
            secondView = null;
        }*/
        //Bam vao view nao thi an view do di
        view.setVisibility(View.INVISIBLE);
        //Neu tat ca cac view deu an thi hien lai
        if (viw1.getVisibility()==View.INVISIBLE && viw2.getVisibility() == View.INVISIBLE && viw3.getVisibility()==View.INVISIBLE && viw4.getVisibility()==View.INVISIBLE) {
            viw1.setVisibility(View.VISIBLE);
            viw2.setVisibility(View.VISIBLE);
            viw3.setVisibility(View.VISIBLE);
            viw4.setVisibility(View.VISIBLE);
        }
    }
}