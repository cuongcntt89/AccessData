package com.application.accessdata.entity;

/**
 * Created by CuongNV on 2/24/2017.
 */

public class User {
    private String fullName;
    private int age;
    private String phone;
    private String address;

    private User(UserBuilder builder) {
        this.fullName = builder.fullName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String toString() {
        return "User for fullName => " + this.fullName + ", age: " + this.age + ", phone: " + this.phone + ", address: " + this.address;
    }

    public static class UserBuilder {
        private String fullName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String fullName, int age) {
            this.fullName = fullName;
            this.age = age;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            validate();
            return new User(this);
        }

        private void validate() {
            if (this.phone.length() > 11) {
                this.phone = "Not regist number phone";
            }
        }
    }
}