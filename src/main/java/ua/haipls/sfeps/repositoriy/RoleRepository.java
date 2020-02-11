package ua.haipls.sfeps.repositoriy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
