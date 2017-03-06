package com.application.accessdata.utils;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ItemTypeDescriptor {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({MODE_MUSSIC, MODE_VIDEO, MODE_OTHER})
    public @interface ItemTypeDef { }
    public int itemType;
    public static final int MODE_MUSSIC = 0;
    public static final int MODE_VIDEO = 1;
    public static final int MODE_OTHER = 2;

    public ItemTypeDescriptor(@ItemTypeDef int itemType) {
        this.itemType = itemType;
    }

}