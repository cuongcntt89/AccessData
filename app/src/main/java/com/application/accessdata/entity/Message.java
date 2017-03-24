package com.application.accessdata.entity;

/**
 * Created by CuongNV on 3/20/2017.
 */

public class Message {
    private String userName;
    private String message;
    private double timePostMessage;
    private boolean isSend;

    public Message(Builder builder) {
        this.userName = builder.bUserName;
        this.message = builder.bMessage;
        this.timePostMessage = builder.bTimePostMessage;
        this.isSend = builder.isSend;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public double getTimePostMessage() {
        return timePostMessage;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimePostMessage(double timePostMessage) {
        this.timePostMessage = timePostMessage;
    }

    public static class Builder {
        private String bUserName;
        private String bMessage;
        private double bTimePostMessage;
        private boolean isSend;

        public Builder setUserName(String userName) {
            bUserName = userName;
            return this;
        }

        public Builder setMessage(String message) {
            bMessage = message;
            return this;
        }

        public Builder setTimePostMessage(double time) {
            bTimePostMessage = time;
            return this;
        }

        public Builder setIsSend(boolean isSendInput) {
            isSend = isSendInput;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}