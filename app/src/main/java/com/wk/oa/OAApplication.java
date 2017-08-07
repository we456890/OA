package com.wk.oa;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 78560 on 2017/8/7.
 */

public class OAApplication extends Application {
    public static Context applicationContext;
    private static OAApplication instance;

    public static Context getContext() {
        return applicationContext;
    }

    public static OAApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
        instance = this;
    }

    //用于存放我们所有activity的数组
    public static List<Activity> activities;

    //向集合中添加一个activity
    public static void addActivity(Activity activity) {
        if (activities == null) {
            //如果集合为空  则初始化
            activities = new ArrayList<>();
        }
        //将activity加入到集合中
        activities.add(activity);
    }

    //结束掉所有的Activity
    public static void finishAll() {
        //循环集合,  将所有的activity finish
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public static void removeActivity(Activity activity) {
        //移除已经销毁的Activity
        activities.remove(activity);
    }
}
