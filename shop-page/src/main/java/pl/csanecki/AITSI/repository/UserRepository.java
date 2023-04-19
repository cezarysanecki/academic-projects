package pl.csanecki.AITSI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.csanecki.AITSI.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
