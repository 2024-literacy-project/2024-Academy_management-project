package com.lastdance.project.sessionsecurity.common;

public enum UserRole {

    STUDENT("STUDENT"),

    ADMIN("ADMIN"),

    EMPLOYEE("EMPLOYEE");


    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}
