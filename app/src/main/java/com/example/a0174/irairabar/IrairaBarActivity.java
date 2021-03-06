package com.example.a0174.irairabar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class IrairaBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//フルスクリーンに設定
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(new GameSurfaceView(this));
        AcSensor.Inst().onCreate(this); // センサー初期化
    }

    @Override
    protected void onResume() { // アクティビティが動き始める時呼ばれる
        super.onResume();
        AcSensor.Inst().onResume();// 開始時にセンサーを動かし始める
    }

    @Override
    protected void onPause() { // アクティビティの動きが止まる時呼ばれる
        super.onPause();
        AcSensor.Inst().onPause();// 中断時にセンサーを止める
    }
}
