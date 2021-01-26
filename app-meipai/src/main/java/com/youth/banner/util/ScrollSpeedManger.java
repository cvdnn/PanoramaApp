package com.youth.banner.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.viewpager2.widget.ViewPager2;
import com.youth.banner.Banner;
import d.r.d.o;
import java.lang.reflect.Field;

public class ScrollSpeedManger extends LinearLayoutManager {
    public Banner banner;

    public ScrollSpeedManger(Banner banner2, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        super(banner2.getContext(), linearLayoutManager.getOrientation(), false);
        this.banner = banner2;
    }

    public static void reflectLayoutManager(Banner banner2) {
        if (banner2.getScrollTime() >= 100) {
            try {
                ViewPager2 viewPager2 = banner2.getViewPager2();
                RecyclerView recyclerView = (RecyclerView) viewPager2.getChildAt(0);
                recyclerView.setOverScrollMode(2);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                ScrollSpeedManger scrollSpeedManger = new ScrollSpeedManger(banner2, recyclerView, linearLayoutManager);
                recyclerView.setLayoutManager(scrollSpeedManger);
                Field declaredField = LayoutManager.class.getDeclaredField("mRecyclerView");
                declaredField.setAccessible(true);
                declaredField.set(linearLayoutManager, recyclerView);
                Field declaredField2 = ViewPager2.class.getDeclaredField("mLayoutManager");
                declaredField2.setAccessible(true);
                declaredField2.set(viewPager2, scrollSpeedManger);
                Field declaredField3 = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
                declaredField3.setAccessible(true);
                Object obj = declaredField3.get(viewPager2);
                String str = "mLayoutManager";
                if (obj != null) {
                    Field declaredField4 = obj.getClass().getDeclaredField(str);
                    declaredField4.setAccessible(true);
                    declaredField4.set(obj, scrollSpeedManger);
                }
                Field declaredField5 = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
                declaredField5.setAccessible(true);
                Object obj2 = declaredField5.get(viewPager2);
                if (obj2 != null) {
                    Field declaredField6 = obj2.getClass().getDeclaredField(str);
                    declaredField6.setAccessible(true);
                    declaredField6.set(obj2, scrollSpeedManger);
                }
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, a0 a0Var, int i2) {
        AnonymousClass1 r2 = new o(recyclerView.getContext()) {
            public int calculateTimeForDeceleration(int i2) {
                return ScrollSpeedManger.this.banner.getScrollTime();
            }
        };
        r2.setTargetPosition(i2);
        startSmoothScroll(r2);
    }
}
