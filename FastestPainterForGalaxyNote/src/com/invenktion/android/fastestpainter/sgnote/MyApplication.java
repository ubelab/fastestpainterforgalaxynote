package com.invenktion.android.fastestpainter.sgnote;

import android.app.Application;

import com.invenktion.android.fastestpainter.sgnote.utils.Foreground;

public class MyApplication extends Application {
    public void onCreate(){
    	super.onCreate();
        Foreground.init(this);
    }
}
