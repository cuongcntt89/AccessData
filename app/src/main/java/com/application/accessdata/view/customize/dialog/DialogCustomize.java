package com.application.accessdata.view.customize.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.accessdata.R;

/**
 * Created by CuongNV on 2/24/2017.
 * Info : Class customize Dialog
 */

public class DialogCustomize extends Dialog implements View.OnClickListener {
    private TextView titleDialog, descriptionDialog, labelButtonOKDialog, labelButtonCancelDialog;

    private OnOkClickListener onOkClickListener = null;
    private OnCancelClickListener onCancelClickListener = null;

    public DialogCustomize(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogCustomizeView = inflater.inflate(R.layout.dialog_customize, null);

        titleDialog = (TextView) dialogCustomizeView.findViewById(R.id.title_dialog);
        descriptionDialog = (TextView) dialogCustomizeView.findViewById(R.id.description_dialog);
        labelButtonOKDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_ok_dialog);
        labelButtonCancelDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_cancel_dialog);

        labelButtonOKDialog.setOnClickListener(this);
        labelButtonCancelDialog.setOnClickListener(this);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            View divider = new View(context);
            divider.setBackgroundColor(context.getColor(
                    android.R.color.transparent));
        }

        setContentView(dialogCustomizeView);
    }

    public void setTitleDialog(String title) {
        this.titleDialog.setText(title);
    }

    public void setDescriptionDialog(String description) {
        this.descriptionDialog.setText(description);
    }

    public void setPositiveButtonCustomize(String labelPositive, OnOkClickListener onOkClickListener) {
        this.labelButtonOKDialog.setText(labelPositive);
        this.onOkClickListener = onOkClickListener;
    }

    public void setNegativeButtonCustomize(String labelNegative, OnCancelClickListener onCancelClickListener) {
        this.labelButtonCancelDialog.setText(labelNegative);
        this.onCancelClickListener = onCancelClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ok_dialog:
                onOkClickListener.onOkClick();
                dismiss();
                break;

            case R.id.bt_cancel_dialog:
                onCancelClickListener.onCancelClick();
                dismiss();
                break;

            default:
                break;
        }
    }

    public interface OnOkClickListener {
        void onOkClick();
    }

    public interface OnCancelClickListener {
        void onCancelClick();
    }

}