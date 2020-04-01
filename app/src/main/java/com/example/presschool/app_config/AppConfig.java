package com.example.presschool.app_config;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

import androidx.multidex.MultiDex;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.crashlytics.android.Crashlytics;
import com.pixplicity.easyprefs.library.Prefs;

import io.fabric.sdk.android.Fabric;


//This class will be called whenever app is launched
public class AppConfig extends Application {


    private static final String TAG = "BaseActivity";
    private static AppConfig mInstance;
    private RequestQueue mRequestQueue;

    public static synchronized AppConfig getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        mInstance = this;

        // Initialize the Prefs class (Builder)
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();


//        if (true) {
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setApplicationId("1:838405172619:android:140a43c31bd883850c538e")
//                    .setApiKey("AIzaSyBbnMyh233J9wjMiKGluLC2SHMV5nLbvas")
//                    .setDatabaseUrl("https://wasalny-6139e.firebaseio.com")
//                    .build();
//            //https://wasalny-6139e.firebaseio.com/
////            FirebaseApp.initializeApp(BaseActivity.getInstance().getApplicationContext(), options, "Wasalny");
//            FirebaseApp.initializeApp(AppConfig.getInstance().getApplicationContext(), options, "Wasalny");
//        }


    }

    @Override
    public void onTerminate() {
        super.onTerminate();


    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(JsonObjectRequest req, String tag) {
        // set the default tag if tag is empty
//        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
//        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
