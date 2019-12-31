package com.yu.game;

public class Fish extends Thread {
    public static final int DIRECTION_UP=0;
    public static final int DIRECTION_DOWN=1;
    public static final int DIRECTION_LEFT=2;
    public static final int DIRECTION_RIGHT=3;
    public static final int DIRECTION_NONE=-1;
    public static final int DIRECTION_NG=9;
    GameView gameView;
    private int x=400;
    private int y=400;
    private int direction=DIRECTION_NONE;
    public int getDirection() {
        return direction;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    Fish(GameView gameView){
        this.gameView=gameView;
    }
    @Override
    public void run() {
        while (direction!=DIRECTION_NONE&&direction!=DIRECTION_NG) {
            switch (direction) {
                case DIRECTION_UP:
                    if (y > 0)
                        y -= 50;
                    else
                        y=gameView.getHeight()-200;
                    break;
                case DIRECTION_DOWN:
                    if (y < gameView.getHeight() - 200)
                        y += 50;
                    else
                        y=0;
                    break;
                case DIRECTION_RIGHT:
                    if (x < gameView.getWidth()-200)
                        x += 50;
                    else
                        direction=DIRECTION_NG;
                    break;
                case DIRECTION_LEFT:
                    if (x > 0)
                        x -= 50;
                    else
                        direction=DIRECTION_NG;
                    break;
            }
            gameView.invalidate();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setDirection(int direction) {
        if(this.direction==DIRECTION_NONE) {
            start();
        }
        this.direction=direction;
    }
}
