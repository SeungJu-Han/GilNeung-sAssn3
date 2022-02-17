package org.seungjutown.gilneungsassignment3_1;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ProgressDialog customProgressDialog;
    CountDownTimer countDownTimer;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLoad = findViewById(R.id.button);

        //로딩창 객체 생성
        customProgressDialog = new ProgressDialog(this);
        //로딩창을 투명하게
        customProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        btnLoad.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // 로딩창 보여주기
                customProgressDialog.show();
                timer();
            }
        });

    }
    public void timer() {

        countDownTimer=new CountDownTimer(11000, 1000) { //display a delay of 20 seconds

            public void onTick(long millisUntilFinished) {
                count --;
                if (count == 0 )
                    countDownTimer.onFinish();
            }

            public void onFinish() {
                customProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "저장이 완료되었습니다", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}