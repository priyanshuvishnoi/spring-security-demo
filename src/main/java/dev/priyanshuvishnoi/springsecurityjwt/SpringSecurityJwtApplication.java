package dev.priyanshuvishnoi.springsecurityjwt;

import dev.priyanshuvishnoi.springsecurityjwt.user.UserRole;
import dev.priyanshuvishnoi.springsecurityjwt.user.UserRoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(SpringSecurityJwtApplication.class, args);

        UserRoleRepository repo = ctx.getBean(UserRoleRepository.class);
        Optional<UserRole> role = repo.findById((short) 1);
        if (role.isEmpty()) {
            UserRole newRole = new UserRole();
            newRole.setRoleName("ROLE_USER");
            repo.save(newRole);
        }
    }

}
