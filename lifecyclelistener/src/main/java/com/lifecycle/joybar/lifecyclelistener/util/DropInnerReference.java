package com.lifecycle.joybar.lifecyclelistener.util;

import java.lang.reflect.Field;

/**
 * @author Jose.Han
 * DATE 2019/4/28 0028
 *
 * 场景条件1：解决匿名内部类内存泄漏的问题，匿名内部类是纯接口，无法用静态内部类+弱引用的方式解决。
 * 场景条件2：在没有遵循MVP模式的地方
 * 使用条件：drop 和 isnull 需要成对出现，防止抛出NullPointException
 */
public class DropInnerReference {

    /**
     * 断开内部类和外部类的引用，以变回收对象
     * @param obj  生成的独立类的对象
     * @param type 外部类的类型
     */
    public static void dropReference(Object obj,String type) {
        Field[] field = obj.getClass().getDeclaredFields();
        for(int i = 0;i<field.length;i++) {
            Field field2 = field[i];
            if(field2.getType().getName().equals(type)) {
                try {
                    field2.setAccessible(true);
                    field2.set(obj, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 断开之后，在内部类要访问外部类的时候，需要判空
     * @param obj 生成的独立类的对象
     * @param type 外部类的类型
     * @return
     */
    public static boolean isNull(Object obj,String type) {
        Field[] field = obj.getClass().getDeclaredFields();
        for(int i = 0;i<field.length;i++) {
            Field field2 = field[i];
            if(field2.getType().toString().equals(type)) {
                try {
                    return field2.get(obj) == null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}
