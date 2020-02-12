package ua.haipls.sfeps.repositoriy;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.Organization;

import java.util.List;

@Repository
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Long> {
    List<Organization> findAllByAuthorId(Long id);

    List<Organization> findAllByServiceTypeId(Long id);
}
