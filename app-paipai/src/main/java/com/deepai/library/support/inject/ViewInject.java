package com.deepai.library.support.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewInject {
    String click() default "";

    int id() default 0;

    String idStr() default "";

    String itemClick() default "";

    String itemLongClick() default "";

    String longClick() default "";

    Select select() default @Select(selected = "");
}
