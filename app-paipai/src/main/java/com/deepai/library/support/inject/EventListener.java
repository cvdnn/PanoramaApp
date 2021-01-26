package com.deepai.library.support.inject;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EventListener implements OnClickListener, OnLongClickListener, OnItemClickListener, OnItemSelectedListener, OnItemLongClickListener {
    private String clickMethod;
    private Object handler;
    private String itemClickMethod;
    private String itemLongClickMehtod;
    private String itemSelectMethod;
    private String longClickMethod;
    private String nothingSelectedMethod;

    public EventListener(Object handler2) {
        this.handler = handler2;
    }

    public EventListener click(String method) {
        this.clickMethod = method;
        return this;
    }

    public EventListener longClick(String method) {
        this.longClickMethod = method;
        return this;
    }

    public EventListener itemLongClick(String method) {
        this.itemLongClickMehtod = method;
        return this;
    }

    public EventListener itemClick(String method) {
        this.itemClickMethod = method;
        return this;
    }

    public EventListener select(String method) {
        this.itemSelectMethod = method;
        return this;
    }

    public EventListener noSelect(String method) {
        this.nothingSelectedMethod = method;
        return this;
    }

    public boolean onLongClick(View v) {
        return invokeLongClickMethod(this.handler, this.longClickMethod, v);
    }

    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        return invokeItemLongClickMethod(this.handler, this.itemLongClickMehtod, arg0, arg1, Integer.valueOf(arg2), Long.valueOf(arg3));
    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        invokeItemSelectMethod(this.handler, this.itemSelectMethod, arg0, arg1, Integer.valueOf(arg2), Long.valueOf(arg3));
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        invokeNoSelectMethod(this.handler, this.nothingSelectedMethod, arg0);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        invokeItemClickMethod(this.handler, this.itemClickMethod, arg0, arg1, Integer.valueOf(arg2), Long.valueOf(arg3));
    }

    public void onClick(View v) {
        invokeClickMethod(this.handler, this.clickMethod, v);
    }

    public static Object invokeClickMethod(Object handler2, String methodName, Object... params) {
        Object obj = null;
        if (handler2 == null) {
            return obj;
        }
        Method method = null;
        for (Class<?> clazz = handler2.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Method[] ms = clazz.getDeclaredMethods();
            boolean breakFlag = false;
            int length = ms.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method m = ms[i];
                if (m.getName().equals(methodName)) {
                    method = m;
                    breakFlag = true;
                    break;
                }
                i++;
            }
            if (breakFlag) {
                break;
            }
        }
        if (method == null) {
            return obj;
        }
        try {
            method.setAccessible(true);
            return method.invoke(handler2, params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return obj;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return obj;
        }
    }

    public static boolean invokeLongClickMethod(Object handler2, String methodName, Object... params) {
        if (handler2 == null) {
            return false;
        }
        try {
            Method method = handler2.getClass().getDeclaredMethod(methodName, new Class[]{View.class});
            method.setAccessible(true);
            if (method != null) {
                Object obj = method.invoke(handler2, params);
                if (obj != null) {
                    return Boolean.valueOf(obj.toString()).booleanValue();
                }
                return false;
            }
            throw new RuntimeException("no such method:" + methodName);
        } catch (Exception e) {
            return false;
        }
    }

    public static Object invokeItemClickMethod(Object handler2, String methodName, Object... params) {
        if (handler2 == null) {
            return null;
        }
        try {
            Method method = handler2.getClass().getDeclaredMethod(methodName, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE});
            if (method != null) {
                return method.invoke(handler2, params);
            }
            throw new RuntimeException("no such method:" + methodName);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean invokeItemLongClickMethod(Object handler2, String methodName, Object... params) {
        if (handler2 == null) {
            throw new RuntimeException("invokeItemLongClickMethod: handler is null :");
        }
        try {
            Method method = handler2.getClass().getDeclaredMethod(methodName, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE});
            if (method != null) {
                Object obj = method.invoke(handler2, params);
                return Boolean.valueOf(obj == null ? false : Boolean.valueOf(obj.toString()).booleanValue()).booleanValue();
            }
            throw new RuntimeException("no such method:" + methodName);
        } catch (Exception e) {
            return false;
        }
    }

    public static Object invokeItemSelectMethod(Object handler2, String methodName, Object... params) {
        if (handler2 == null) {
            return null;
        }
        try {
            Method method = handler2.getClass().getDeclaredMethod(methodName, new Class[]{AdapterView.class, View.class, Integer.TYPE, Long.TYPE});
            if (method != null) {
                return method.invoke(handler2, params);
            }
            throw new RuntimeException("no such method:" + methodName);
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invokeNoSelectMethod(Object handler2, String methodName, Object... params) {
        if (handler2 == null) {
            return null;
        }
        try {
            Method method = handler2.getClass().getDeclaredMethod(methodName, new Class[]{AdapterView.class});
            if (method != null) {
                return method.invoke(handler2, params);
            }
            throw new RuntimeException("no such method:" + methodName);
        } catch (Exception e) {
            return null;
        }
    }
}
