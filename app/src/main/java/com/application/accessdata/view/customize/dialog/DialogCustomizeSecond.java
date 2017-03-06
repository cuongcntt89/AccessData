package com.application.accessdata.view.customize.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.application.accessdata.R;

/**
 * Created by CuongNV on 3/6/2017.
 */

public class DialogCustomizeSecond extends Dialog implements View.OnClickListener {
    private TextView titleDialog, descriptionDialog, labelButtonOKDialog, labelButtonCancelDialog;

    private DialogCustomizeSecond.OnOkClickListener onOkClickListener = null;
    private DialogCustomizeSecond.OnCancelClickListener onCancelClickListener = null;

    public DialogCustomizeSecond(Context context, Builder builder) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogCustomizeView = inflater.inflate(R.layout.dialog_customize, null);

        titleDialog = (TextView) dialogCustomizeView.findViewById(R.id.title_dialog);
        descriptionDialog = (TextView) dialogCustomizeView.findViewById(R.id.description_dialog);
        labelButtonOKDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_ok_dialog);
        labelButtonCancelDialog = (TextView) dialogCustomizeView.findViewById(R.id.bt_cancel_dialog);
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

    public static class Builder {
        private TextView titleDialog, descriptionDialog, labelButtonOKDialog, labelButtonCancelDialog;

        public Builder setTitleDialog(String title) {
            this.titleDialog.setText(title);
            return this;
        }

        public Builder setDescriptionDialog(String description) {
            this.descriptionDialog.setText(description);
            return this;
        }

        public Builder labelPositiveButtonDialog(String label) {
            this.labelButtonOKDialog.setText(label);
            return this;
        }

        public Builder labelNegativeButtonDialog(String label) {
            this.labelButtonCancelDialog.setText(label);
            return this;
        }

        public DialogCustomizeSecond build() {
            return new DialogCustomizeSecond(null ,this);
        }
    }

    public interface OnOkClickListener {
        void onOkClick();
    }

    public interface OnCancelClickListener {
        void onCancelClick();
    }

}