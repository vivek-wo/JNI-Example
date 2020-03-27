package com.vivek.wo.jni;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    JniExample jniExample = new JniExample();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText("JNI 输出：" + jniExample.onJniExecute()
                + ",Dynamic: " + jniExample.onJniDynamicExecute());

        jniExample.onJniCall("onJniCallArg1", 30, new byte[]{0x01, 0x02},
                new JniExample.OnJNICallback() {
                    @Override
                    public void onCallback(int code, String message) {
                        Log.w("_JNI_CALL_BACK", "onJniCall code: " + code + ",message: " + message);
                    }
                });
        jniExample.onJniDynamicCall("onJniDynamicCall", 30, new byte[]{0x01, 0x02},
                new JniExample.OnJNICallback() {
                    @Override
                    public void onCallback(int code, String message) {
                        Log.w("_JNI_CALL_BACK", "onJniDynamicCall code: " + code + ",message: " + message);
                    }
                });
    }

}
