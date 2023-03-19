package com.example.interviewtask.presentation.security;

public class JwtPrincipal {
    private final String sub;
    private final String role;

    public JwtPrincipal(String sub, String role) {
        this.sub = sub;
        this.role = role;
    }

    public String getSub() {
        return sub;
    }

    public String getRole() {
        return role;
    }
}