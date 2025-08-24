package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class N08_12 extends AppCompatActivity {
    private View viw1;
    private View viw2;
    private View viw3;
    private View viw4;
    private View firstView = null;
    private View secondView = null;
    private float dpFromPx(final Context context, final float px) {
        float density = context.getResources().getDisplayMetrics().density;
        return px / density;
    }

    private float pxFromDp(final Context context, final float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return dp * density;
    }

    private void findViews() {
        viw1 = findViewById(R.id.viw10812);
        viw2 = findViewById(R.id.viw20812);
        viw3 = findViewById(R.id.viw30812);
        viw4 = findViewById(R.id.viw40812);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0812);
        findViews();
    }

    public void viw_Clicked(View view) {
        if (firstView == null)
            firstView = view;
        else {
            secondView = view;
            int temp = ((ColorDrawable) firstView.getBackground()).getColor();
            firstView.setBackgroundColor(((ColorDrawable) secondView.getBackground()).getColor());
            secondView.setBackgroundColor(temp);
            firstView = null;
            secondView = null;
        }
        /*view.bringToFront();
        ColorDrawable drawable = (ColorDrawable) view.getBackground();
        String colorCode = Integer.toHexString(drawable.getColor());
        Toast.makeText(this, colorCode, Toast.LENGTH_LONG).show();*/
    }

    public void btn1_Clicked(View view) {
        if (viw1.getVisibility()==View.INVISIBLE)
            viw1.setVisibility(View.VISIBLE);
        else
            viw1.setVisibility(View.INVISIBLE);
    }
    public void btn2_Clicked(View view) {
        if (viw2.getVisibility()==View.INVISIBLE)
            viw2.setVisibility(View.VISIBLE);
        else
            viw2.setVisibility(View.INVISIBLE);
    }
    public void btn3_Clicked(View view) {
        if (viw3.getVisibility()==View.INVISIBLE)
            viw3.setVisibility(View.VISIBLE);
        else
            viw3.setVisibility(View.INVISIBLE);
    }
    public void btn4_Clicked(View view) {
        if (viw4.getVisibility()==View.INVISIBLE)
            viw4.setVisibility(View.VISIBLE);
        else
            viw4.setVisibility(View.INVISIBLE);
    }
    public void btn1_1_Clicked(View view) {
        ViewGroup.LayoutParams params = viw1.getLayoutParams();
        if (params.width == pxFromDp(this,200))
            params.width = (int)pxFromDp(this,250);
        else
            params.width = (int)pxFromDp(this,200);;
        viw1.setLayoutParams(params);
    }
    public void btn2_1_Clicked(View view) {
        ViewGroup.LayoutParams params = viw2.getLayoutParams();
        if (params.width == 200)
            params.width = 250;
        else
            params.width = 200;
        viw2.setLayoutParams(params);
    }
    public void btn3_1_Clicked(View view) {
        ViewGroup.LayoutParams params = viw3.getLayoutParams();
        if (params.width == 200)
            params.width = 250;
        else
            params.width = 200;
        viw3.setLayoutParams(params);
    }
    public void btn4_1_Clicked(View view) {
        ViewGroup.LayoutParams params = viw4.getLayoutParams();
        if (params.width == 200)
            params.width = 250;
        else
            params.width = 200;
        viw4.setLayoutParams(params);
    }
}