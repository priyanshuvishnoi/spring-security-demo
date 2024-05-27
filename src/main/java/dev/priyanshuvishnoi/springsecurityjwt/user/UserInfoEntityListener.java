package dev.priyanshuvishnoi.springsecurityjwt.user;

import jakarta.persistence.PrePersist;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class UserInfoEntityListener {
    private final PasswordEncoder passwordEncoder;

    @PrePersist
    public void onSaveOrUpdate(UserInfo userInfo) {
        final String password = userInfo.getPassword();
        final String encodedPassword = passwordEncoder.encode(password);
        userInfo.setPassword(encodedPassword);
    }
}
