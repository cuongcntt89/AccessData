package com.application.accessdata.entity;

/**
 * Created by CuongNV on 2/24/2017.
 */

public class BuilderPatternDataTest {
    private Builder builder;

    public BuilderPatternDataTest(Builder builder) {
        this.builder = builder;
    }

    public static class Builder {
        private int id;
        private String title;
        private String description;
        private int numberView;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setNumber(int numberView) {
            this.numberView = numberView;
            return this;
        }

        public int getId() {
            return this.id;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }

        public int getNumberView() {
            return this.numberView;
        }

        public BuilderPatternDataTest build() {
            validate();
            return new BuilderPatternDataTest(this);
        }

        private void validate() {
            if (this.numberView > 100) {
                this.numberView = 100;
            }
        }
    }
}