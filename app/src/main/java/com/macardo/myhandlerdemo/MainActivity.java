package com.macardo.myhandlerdemo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //创建主线程Handler
    Handler handler = new Handler();

    /*{//创建消息
        //创建消息对象
        Message message = Message.obtain();
        //拷贝消息对象
        Message message1 = Message.obtain(message);
        //为消息对象设置可执行代码
        Message message2 = Message.obtain(handler, new Runnable() {
            @Override
            public void run() {
                //do something
            }
        });
        //创建一个与handler对象绑定的消息对象
        handler.obtainMessage();
    }
    {//发送消息
        Message message = Message.obtain();
        handler.sendMessage(message);
        //基于android.os.SystemClock#uptimeMillis
        handler.sendMessageAtTime(message,1000);
        handler.sendMessageDelayed(message,1000);
        //发送消息到消息队列最前端
        handler.sendMessageAtFrontOfQueue(message);
        //sendMessage系列方法的简约版本
        handler.sendEmptyMessage(1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //do something
            }
        };
        Object token = new Object();
        //sendMessage系列方法的简约版本
        handler.post(runnable);
        //基于android.os.SystemClock#uptimeMillis
        handler.postAtTime(runnable,token,1000);

        //判断消息队列中是否有指定的消息对象
        handler.hasMessages(1);
        handler.hasMessages(1,token);

        //移除what值为指定值的消息对象
        handler.removeMessages(1);
        //如果token为null，移除所有what值为指定值的消息对象
        handler.removeMessages(1,token);

        //移除callback值为指定值的消息对象
        handler.removeCallbacks(runnable);
        //如果token为null，移除callback值为指定值的消息对象
        handler.removeCallbacks(runnable,token);

        //移除所有Object值为指定值的消息对象，如果token为null，移除消息队列中所有消息对象
        handler.removeCallbacksAndMessages(token);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button demoBtn = findViewById(R.id.demoBtn);
        demoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DemoActivity.class);
                startActivity(intent);

            }
        });
    }
}
