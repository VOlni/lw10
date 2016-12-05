package com.example.oliinyk.lw10;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    Paint p;
    int mywidth=0, myheight=0;
    float x,y;
    int k=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mm=new one(this);
        setContentView(mm);
        mm.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = (int) event.getX(); // текущая координата X пальца
        y = (int) event.getY(); // текущая координата Y пальца
        mm.invalidate();
        return true;
    }


    class one extends View {

        public one(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            mywidth = w;
            myheight = h;
            super.onSizeChanged(w, h, oldw, oldh);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            int y1=100,y2=200;
            int xb1 = 10, xb2 = 110;
            int xw1 = 110,xw2 = 210;
            int num=1;
            while(y1<(myheight-200)) {
                while (xb1 < mywidth-100) {
                    p.setColor(Color.BLUE);
                    canvas.drawRect(xb1, y1, xb2, y2, p);
                    xb1 += 200;
                    xb2 += 200;
                }
                while (xw1 < mywidth-100) {
                    p.setColor(Color.GREEN);
                    canvas.drawRect(xw1, y1, xw2, y2, p);
                    xw1 += 200;
                    xw2 += 200;
                }
                y1 += 100;
                y2 += 100;
                num++;
                if(num%2==1 && num<8){
                    xb1=10;
                    xb2=110;
                    xw1=110;
                    xw2=210;
                }
                if(num%2==0 && num<8) {
                    xb1 = 110;
                    xb2 = 210;
                    xw1 = 10;
                    xw2 = 110;
                }
            }
            p.setTextSize(50);
            p.setTextAlign(Paint.Align.CENTER);
            int mw = myheight-(myheight%100)-300;
            int mh = mywidth-(mywidth%100);
            int sy = myheight - 100;
            int sx = mywidth - (mywidth / 2);
            if(x==0 && y==0) {
                String s = "Screen size " + mw + " " + mh;
                p.setColor(Color.DKGRAY);
                canvas.drawText(s, sx, sy, p);
            }
            if(x>0 && y>0) {
                invalidate(sx,sy,sx,sy);
                p.setColor(Color.BLACK);
                k++;
                String s = x + " " + y + " number of pushes " + k/2;
                canvas.drawText(s, sx, sy, p);
            }
        }
    }


    one mm;
}
