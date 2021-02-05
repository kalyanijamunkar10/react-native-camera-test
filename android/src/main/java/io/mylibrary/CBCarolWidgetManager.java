package io.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CBCarolWidgetManager extends ReactContextBaseJavaModule {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Activity activity;
    public CBCarolWidgetManager(ReactApplicationContext reactContext){
        super(reactContext);
    }

    @Override
    public String getName() {
        return "CBCarolWidget";
    }
    @ReactMethod
    public void onClick() {
        ReactApplicationContext context = getReactApplicationContext();
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(cameraIntent.resolveActivity(context.getPackageManager()) !=null) {
            context.startActivity(cameraIntent);
        }
    }
}
