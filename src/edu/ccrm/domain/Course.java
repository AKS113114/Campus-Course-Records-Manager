package edu.ccrm.domain;

public class Course {
    private int id;
    private String code;
    private String title;
    private int credits;

    private Course(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.title = builder.title;
        this.credits = builder.credits;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - %s (%d credits)", id, code, title, credits);
    }

    // Builder class
    public static class Builder {
        private int id;
        private String code;
        private String title;
        private int credits;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder credits(int credits) {
            this.credits = credits;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}
