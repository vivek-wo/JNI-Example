package com.vivek.wo.jni;

public class JniExample {

    static {
        System.loadLibrary("jni-example");
    }

    public interface OnJNICallback {
        void onCallback(int code, String message);
    }

    public native void onJniCall(String arg1, int arg2, byte[] arg3, OnJNICallback callback);

    public native String onJniExecute();

    public native void onJniDynamicCall(String arg1, int arg2, byte[] arg3, OnJNICallback callback);

    public native int onJniDynamicExecute();
}
