package com.application.accessdata.view.customize.dialog;

import android.content.DialogInterface;

/**
 * Created by CuongNV on 3/28/2017.
 */

public interface IBuilder {

    DialogCustomizeSecond.Builder setTitle(CharSequence title);

    DialogCustomizeSecond.Builder setDescription(CharSequence description);

    DialogCustomizeSecond.Builder onPositive(CharSequence label, DialogInterface.OnClickListener callback);

    DialogCustomizeSecond.Builder onNegative(CharSequence label, DialogInterface.OnClickListener callback);

}