package com.application.accessdata.view.customize.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.application.accessdata.R;

/**
 * Created by CuongNV on 3/6/2017.
 */

public class DialogCustomizeSecond {

    private Builder builder;

    private DialogCustomizeSecond(Builder builder) {
        this.builder = builder;
        builder.bBuilder = initSetting(builder);
    }

    public Builder getBuilder() {
        return this.builder;
    }

    public void show() {
        if (builder != null && builder.bBuilder != null) {
            builder.bBuilder.show();
        }
    }

    private AlertDialog.Builder initSetting(Builder builderInput) {
        AlertDialog.Builder builder = new AlertDialog.Builder(builderInput.bContext);
        builder.setCancelable(builderInput.isCancelable);
        builder.setView(initView(builderInput));

        if (builderInput.bLabelButtonPositive != null && builderInput.bLabelButtonPositive.length() != 0
                && builderInput.positiveCallback != null) {
            builder.setPositiveButton(builderInput.bLabelButtonPositive, builderInput.positiveCallback);
        }
        if (builderInput.bLabelButtonNegative != null && builderInput.bLabelButtonNegative.length() != 0
                && builderInput.negativeCallback != null) {
            builder.setNegativeButton(builderInput.bLabelButtonNegative, builderInput.negativeCallback);
        }
        return builder;
    }

    public View initView(Builder builder) {
        LayoutInflater inflater = LayoutInflater.from(builder.bContext);
        View view = inflater.inflate(R.layout.dialog_customize , null);

        TextView titleDialog = (TextView) view.findViewById(R.id.title_dialog);
        TextView descriptionDialog = (TextView) view.findViewById(R.id.description_dialog);
        
        if (builder.bTitle != null && builder.bTitle.length() != 0) {
            titleDialog.setText(builder.bTitle);
        } else {
            titleDialog.setVisibility(View.GONE);
        }

        if (builder.bDescription != null && builder.bDescription.length() != 0) {
            descriptionDialog.setText(builder.bDescription);
        } else {
            descriptionDialog.setVisibility(View.GONE);
        }

        return view;
    }

    public static class Builder implements IBuilder {
        private Context bContext;
        private CharSequence bTitle, bDescription, bLabelButtonPositive, bLabelButtonNegative;
        private DialogInterface.OnClickListener positiveCallback, negativeCallback;
        private boolean isCancelable;
        private AlertDialog.Builder bBuilder;

        public Builder(Context context) {
            this.bContext = context;
            this.isCancelable = true;
        }

        @Override
        public Builder setTitle(CharSequence title) {
            this.bTitle = title;
            return this;
        }

        @Override
        public Builder setDescription(CharSequence description) {
            this.bDescription = description;
            return this;
        }

        @Override
        public Builder onPositive(CharSequence label, DialogInterface.OnClickListener callback) {
            this.bLabelButtonPositive = label;
            this.positiveCallback = callback;
            return this;
        }

        @Override
        public Builder onNegative(CharSequence label, DialogInterface.OnClickListener callback) {
            this.bLabelButtonNegative = label;
            this.negativeCallback = callback;
            return this;
        }

        public DialogCustomizeSecond build() {
            return new DialogCustomizeSecond(this);
        }

        public DialogCustomizeSecond show() {
            DialogCustomizeSecond dialogCustomizeSecond = build();
            dialogCustomizeSecond.show();
            return dialogCustomizeSecond;
        }
    }

}