package pl.csanecki.AITSI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.csanecki.AITSI.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
