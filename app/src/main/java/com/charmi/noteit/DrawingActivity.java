package com.charmi.noteit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class DrawingActivity extends AppCompatActivity {

    View mView;
    private Paint mPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        LinearLayout layout= (LinearLayout) findViewById(R.id.myDrawing);
        mView= new DrawingView(this);

        layout.addView(mView, new ActionBar.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        init();
    }

    private  void init()
    {
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setColor(0xFFFFFF00);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(6);

    }


    class DrawingView extends View{

        private Path path;
        private Bitmap mBitmap;
        private Canvas mCanvas;

        public DrawingView(Context context) {
            super(context);

            path= new Path();
            mBitmap= Bitmap.createBitmap(820,480,Bitmap.Config.ARGB_8888);
            mCanvas= new Canvas(mBitmap);
            this.setBackgroundColor(Color.BLACK);

        }

        private ArrayList<PathWithPaint>_graphics1= new ArrayList<PathWithPaint>();

        @Override
        public  boolean onTouchEvent(MotionEvent event)
        {

            PathWithPaint pp= new PathWithPaint();
            mCanvas.drawPath(path, mPaint);

            if(event.getAction()==MotionEvent.ACTION_DOWN)
            {
                path.moveTo(event.getX(),event.getY());
                path.lineTo(event.getX(), event.getY());
            }

            else
            if (event.getAction()==MotionEvent.ACTION_MOVE)
            {
                path.lineTo(event.getX(), event.getY());
                pp.setPath(path);
                pp.setmPaint(mPaint);
                _graphics1.add(pp);

            }

            invalidate();
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            if(_graphics1.size()>0)
            {
                canvas.drawPath(
                        _graphics1.get(_graphics1.size()-1).getPath(),
                        _graphics1.get(_graphics1.size()-1).getmPaint());
            }
        }
    }
}
