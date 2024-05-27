package dev.priyanshuvishnoi.springsecurityjwt.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class GlobalApiResponse<T extends Object> {
    private final boolean error;
    private final T data;
    private final String message;

    public GlobalApiResponse(boolean error, T data) {
        this.error = error;
        this.data = data;
        this.message = null;
    }

    public GlobalApiResponse(boolean error, String message) {
        this.error = error;
        this.data = null;
        this.message = message;
    }
}
