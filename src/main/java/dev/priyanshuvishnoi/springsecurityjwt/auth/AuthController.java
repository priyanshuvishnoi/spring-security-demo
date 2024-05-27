package dev.priyanshuvishnoi.springsecurityjwt.auth;

import dev.priyanshuvishnoi.springsecurityjwt.auth.dtos.AuthRes;
import dev.priyanshuvishnoi.springsecurityjwt.auth.dtos.RegisterUserReq;
import dev.priyanshuvishnoi.springsecurityjwt.utils.GlobalApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<GlobalApiResponse<AuthRes>> register(@Valid @RequestBody RegisterUserReq user) {
        GlobalApiResponse<AuthRes> responseBody = new GlobalApiResponse<>(
                false,
                authService.register(user)
        );

        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/login")
    public ResponseEntity<GlobalApiResponse<AuthRes>> login(@Valid @RequestBody RegisterUserReq user) {
        GlobalApiResponse<AuthRes> responseBody = new GlobalApiResponse<>(
                false,
                authService.login(user)
        );

        return ResponseEntity.ok(responseBody);
    }
}
