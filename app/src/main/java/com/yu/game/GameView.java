package com.yu.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.io.FileInputStream;

public class GameView extends View {
    Fish fish;
    private Bitmap bitmap;
    private Bitmap bitmapNG;
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    Paint paint=new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(fish==null){
            fish=new Fish(this);
            bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.fish);
            bitmapNG=BitmapFactory.decodeResource(getResources(),R.drawable.fish_cake);
        }
        if(fish.getDirection()==Fish.DIRECTION_NG)
            bitmap=bitmapNG;
        canvas.drawBitmap(bitmap,fish.getX(),fish.getY(),paint);
    }

    void moveUp(){
        fish.setDirection(Fish.DIRECTION_UP);
    }
    void moveDown(){
        fish.setDirection(Fish.DIRECTION_DOWN);
    }
    void moveLeft(){
        fish.setDirection(Fish.DIRECTION_LEFT);
    }
    void moveRight(){
        fish.setDirection(Fish.DIRECTION_RIGHT);
    }

}
