package com.application.accessdata.view.customize.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.application.accessdata.R;

/**
 * Created by CuongNV on 2/24/2017.
 */

public class DialogCustomize extends Dialog implements View.OnClickListener {
    private OnOkClickListener onOkClickListener;
    private OnCancelClickListener onCancelClickListener;
    private OnDenyClickListener onDenyClickListener;

    public String titleDialog;
    public String descriptionDialog;
    public String labelButtonOK;
    private String labelButtonCancel;
    private String labelButtonDeny;

    public DialogCustomize(Context context, String title, String description, String labelButtonOK) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogCustomizeView = inflater.inflate(R.layout.dialog_customize, null);

        TextView titleDialog = (TextView) dialogCustomizeView.findViewById(R.id.title_dialog);
        TextView descriptionDialog = (TextView) dialogCustomizeView.findViewById(R.id.description_dialog);
        TextView labelButtonOKDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_ok_dialog);
        TextView labelButtonDenyDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_deny_dialog);
        TextView labelButtonCancelDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_cancel_dialog);

        labelButtonDenyDialog.setVisibility(View.GONE);
        labelButtonCancelDialog.setVisibility(View.GONE);
        titleDialog.setText(title);
        descriptionDialog.setText(description);
        labelButtonOKDialog.setText(labelButtonOK);
        labelButtonOKDialog.setOnClickListener(this);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            View divider = new View(context);
            divider.setBackgroundColor(context.getColor(
                    android.R.color.transparent));
        }

        setContentView(dialogCustomizeView);
    }

    public DialogCustomize(Context context, String title, String description, String labelButtonOK, String labelButtonCancel) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogCustomizeView = inflater.inflate(R.layout.dialog_customize, null);

        TextView titleDialog = (TextView) dialogCustomizeView.findViewById(R.id.title_dialog);
        TextView descriptionDialog = (TextView) dialogCustomizeView.findViewById(R.id.description_dialog);
        TextView labelButtonOKDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_ok_dialog);
        TextView labelButtonDenyDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_deny_dialog);
        TextView labelButtonCancelDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_cancel_dialog);

        labelButtonDenyDialog.setVisibility(View.GONE);
        titleDialog.setText(title);
        descriptionDialog.setText(description);
        labelButtonOKDialog.setText(labelButtonOK);
        labelButtonCancelDialog.setText(labelButtonCancel);
        labelButtonOKDialog.setOnClickListener(this);
        labelButtonCancelDialog.setOnClickListener(this);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            View divider = new View(context);
            divider.setBackgroundColor(context.getColor(
                    android.R.color.transparent));
        }

        setContentView(dialogCustomizeView);
    }

    public void setTitleDialog(String titleDialog) {
        this.titleDialog = titleDialog;
    }

    public void setDescriptionDialog(String descriptionDialog) {
        this.descriptionDialog = descriptionDialog;
    }

    public void setLabelButtonOK(String labelButtonOK) {
        this.labelButtonOK = labelButtonOK;
    }

    public void setLabelButtonCancel(String labelButtonCancel) {
        this.labelButtonCancel = labelButtonCancel;
    }

    public void setLabelButtonDeny(String labelButtonDeny) {
        this.labelButtonDeny = labelButtonDeny;
    }

    public void setOnOkClickListener(OnOkClickListener onOkClickListener) {
        this.onOkClickListener = onOkClickListener;
    }

    public void setOnCancelClickListener(OnCancelClickListener onCancelClickListener) {
        this.onCancelClickListener = onCancelClickListener;
    }

    public void setOnDenyClickListener(OnDenyClickListener onDenyClickListener) {
        this.onDenyClickListener = onDenyClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ok_dialog:     // If clicked button OK
                onOkClickListener.onOkClick();
                dismiss();
                break;

            case R.id.bt_cancel_dialog: // If clicked button CANCEL
                onCancelClickListener.onCancelClick();
                dismiss();
                break;

            case R.id.bt_deny_dialog:   // If clicked button DENY
                onDenyClickListener.onDenyClick();
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

    public interface OnDenyClickListener {
        void onDenyClick();
    }

}