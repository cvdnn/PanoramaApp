package com.deepai.library.support.inject;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import com.deepai.library.app.BaseApp;
import java.lang.reflect.Field;

public class InjectUtility {
    public static void initInjectedView(Activity sourceActivity) {
        initInjectedView(sourceActivity, sourceActivity.getWindow().getDecorView());
    }

    public static void initInjectedView(Object injectedSource, View sourceView) {
        for (Class<?> clazz = injectedSource.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            if (fields != null && fields.length > 0) {
                int length = fields.length;
                for (int i = 0; i < length; i++) {
                    Field field = fields[i];
                    ViewInject viewInject = (ViewInject) field.getAnnotation(ViewInject.class);
                    if (viewInject != null) {
                        int viewId = viewInject.id();
                        if (viewId == 0) {
                            String idStr = viewInject.idStr();
                            if (!TextUtils.isEmpty(idStr)) {
                                try {
                                    Context context = BaseApp.getInstance();
                                    String packageName = context.getPackageName();
                                    viewId = context.getPackageManager().getResourcesForApplication(packageName).getIdentifier(idStr, "id", packageName);
                                    if (viewId == 0) {
                                        throw new RuntimeException(String.format("%s 的属性%s关联了id=%s，但是这个id是无效的", new Object[]{clazz.getSimpleName(), field.getName(), idStr}));
                                    }
                                } catch (Exception e) {
                                }
                            }
                        }
                        if (viewId != 0) {
                            try {
                                field.setAccessible(true);
                                if (field.get(injectedSource) == null) {
                                    field.set(injectedSource, sourceView.findViewById(viewId));
                                }
                            } catch (Exception e2) {
                            }
                        }
                        String clickMethod = viewInject.click();
                        if (!TextUtils.isEmpty(clickMethod)) {
                            setViewClickListener(injectedSource, field, clickMethod);
                        }
                        String longClickMethod = viewInject.longClick();
                        if (!TextUtils.isEmpty(longClickMethod)) {
                            setViewLongClickListener(injectedSource, field, longClickMethod);
                        }
                        String itemClickMethod = viewInject.itemClick();
                        if (!TextUtils.isEmpty(itemClickMethod)) {
                            setItemClickListener(injectedSource, field, itemClickMethod);
                        }
                        String itemLongClickMethod = viewInject.itemLongClick();
                        if (!TextUtils.isEmpty(itemLongClickMethod)) {
                            setItemLongClickListener(injectedSource, field, itemLongClickMethod);
                        }
                        Select select = viewInject.select();
                        if (!TextUtils.isEmpty(select.selected())) {
                            setViewSelectListener(injectedSource, field, select.selected(), select.noSelected());
                        }
                    }
                }
                continue;
            }
        }
    }

    public static void setViewClickListener(Object injectedSource, Field field, String clickMethod) {
        try {
            Object obj = field.get(injectedSource);
            if (obj instanceof View) {
                ((View) obj).setOnClickListener(new EventListener(injectedSource).click(clickMethod));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setViewLongClickListener(Object injectedSource, Field field, String clickMethod) {
        try {
            Object obj = field.get(injectedSource);
            if (obj instanceof View) {
                ((View) obj).setOnLongClickListener(new EventListener(injectedSource).longClick(clickMethod));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setItemClickListener(Object injectedSource, Field field, String itemClickMethod) {
        try {
            Object obj = field.get(injectedSource);
            if (obj instanceof AbsListView) {
                ((AbsListView) obj).setOnItemClickListener(new EventListener(injectedSource).itemClick(itemClickMethod));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setItemLongClickListener(Object injectedSource, Field field, String itemClickMethod) {
        try {
            Object obj = field.get(injectedSource);
            if (obj instanceof AbsListView) {
                ((AbsListView) obj).setOnItemLongClickListener(new EventListener(injectedSource).itemLongClick(itemClickMethod));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setViewSelectListener(Object injectedSource, Field field, String select, String noSelect) {
        try {
            Object obj = field.get(injectedSource);
            if (obj instanceof View) {
                ((AbsListView) obj).setOnItemSelectedListener(new EventListener(injectedSource).select(select).noSelect(noSelect));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
