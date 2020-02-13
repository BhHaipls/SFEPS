package ua.haipls.sfeps.repositoriy;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.haipls.sfeps.domain.User;

import java.util.Optional;

@Repository

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByEmail(String username);

    @Modifying
    @Transactional
    @Query("update User set status = 'DELETED' where id = :id")
    int setDeletedStatusById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update User set status = 'ACTIVATED' where id = :id")
    int activateUserById(@Param("id") Long id);
}
