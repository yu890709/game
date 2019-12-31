package com.yu.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
    findViewById(R.id.arrow_down).setOnClickListener(this);
    findViewById(R.id.arrow_left).setOnClickListener(this);
    findViewById(R.id.arrow_right).setOnClickListener(this);
    findViewById(R.id.arrow_up).setOnClickListener(this);
    gameView = findViewById(R.id.game);
}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.arrow_up:
                gameView.moveUp();
                Log.d(TAG, "onClick: up");
                break;
            case R.id.arrow_down:
                gameView.moveDown();
                Log.d(TAG, "onClick: down");
                break;
            case R.id.arrow_left:
                gameView.moveLeft();
                Log.d(TAG, "onClick: left");
                break;
            case R.id.arrow_right:
                gameView.moveRight();
                Log.d(TAG, "onClick: rigth");
                break;
        }
    }
}
