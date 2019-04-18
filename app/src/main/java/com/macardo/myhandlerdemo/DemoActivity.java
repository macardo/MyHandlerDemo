package com.macardo.myhandlerdemo;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class DemoActivity extends AppCompatActivity {

    /*//创建主线程handler
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1){
                Toast.makeText(DemoActivity.this,"First handle",Toast.LENGTH_SHORT).show();
            }
            return false;//false 需要消息进一步处理
        }
    }){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                Toast.makeText(DemoActivity.this,"what is 1",Toast.LENGTH_SHORT).show();
            }
        }
    };*/

    String msgText = "MsgText";
    /*Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                Toast.makeText(DemoActivity.this,msgText,Toast.LENGTH_SHORT).show();
            }
        }
    };*/
    Handler handler = new MyHandler(this);

    static  class MyHandler extends Handler{
        WeakReference<Activity> wf;
        MyHandler(Activity activity){
            wf = new WeakReference<Activity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1){
                if (wf.get() != null) {
                    Toast.makeText(wf.get(), ((DemoActivity) wf.get()).msgText, Toast.LENGTH_SHORT).show();
                }else {
                    System.out.println("Exit");
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

/*        handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(DemoActivity.this,"Run",Toast.LENGTH_SHORT).show();
                }
        });

        //发送消息
        handler.sendEmptyMessage(1);*/

        handler.sendEmptyMessageDelayed(1,10000);
    }
}
