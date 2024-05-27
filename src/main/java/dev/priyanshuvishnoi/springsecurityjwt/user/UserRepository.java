package dev.priyanshuvishnoi.springsecurityjwt.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Long> {
    Optional<UserInfo> findByUsername(String username);
}
