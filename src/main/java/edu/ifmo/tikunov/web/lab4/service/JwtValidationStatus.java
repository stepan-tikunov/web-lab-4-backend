package edu.ifmo.tikunov.web.lab4.service;

public enum JwtValidationStatus {
    SUCCESSFUL,
    TOKEN_EXPIRED,
    TOKEN_INVALID,
    UNKNOWN_ERROR
}
