package dev.priyanshuvishnoi.springsecurityjwt.auth;

import dev.priyanshuvishnoi.springsecurityjwt.auth.dtos.AuthRes;
import dev.priyanshuvishnoi.springsecurityjwt.auth.dtos.RegisterUserReq;
import dev.priyanshuvishnoi.springsecurityjwt.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthRes register(RegisterUserReq req) {
        Optional<UserInfo> userInfo = userRepository.findByUsername(req.getUsername().trim());

        if (userInfo.isPresent()) {
            throw new RuntimeException("Username is already in use");
        }

        Optional<UserRole> role = userRoleRepository.findById((short) 1);
        if (role.isEmpty()) {
            throw new RuntimeException("Role not found");
        }

        UserInfo user = new UserInfo();
        user.setUsername(req.getUsername().trim());
        user.setPassword(req.getPassword().trim());
        user.getRoles().add(role.get());

        UserInfo savedUser = userRepository.save(user);

        return new AuthRes(jwtService.generateToken(new CustomUserDetails(savedUser)));
    }

    public AuthRes login(RegisterUserReq req) {
        Optional<UserInfo> userInfo = userRepository.findByUsername(req.getUsername().trim());
        String errorMessage = "Username or password is incorrect";

        if (userInfo.isEmpty()) {
            throw new RuntimeException(errorMessage);
        }

        if (!passwordEncoder.matches(req.getPassword().trim(), userInfo.get().getPassword())) {
            throw new RuntimeException(errorMessage);
        }

        return new AuthRes(jwtService.generateToken(new CustomUserDetails(userInfo.get())));
    }
}
