package com.rinfon.view;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by rinfon on 15/6/17.
 */
public class InjectToolUtils {
    public static void autoInjectAllField(Activity activity) throws IllegalAccessException, IllegalArgumentException {
        //得到Activity对应的Class
        Class clazz = activity.getClass();
        //得到该Activity的所有字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //判断字段是否标注InjectView
            Log.i("id","id:"+fields.toString());
            if (field.isAnnotationPresent(InjectView.class)) {
                //如果标注了，就获得它的id
                InjectView inject = field.getAnnotation(InjectView.class);
                int id = inject.id();
                if (id > 0) {
                    //反射访问私有成员，必须加上这句
                    field.setAccessible(true);
                    //然后对这个属性复制
                    field.set(activity, activity.findViewById(id));
                }
            }
        }
    }
}
