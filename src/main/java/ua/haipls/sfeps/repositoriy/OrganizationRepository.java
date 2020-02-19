package ua.haipls.sfeps.repositoriy;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.Organization;

import java.util.Collection;

@Repository
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Long> {
    Collection<Organization> findAllByAuthorId(Long id);

    Collection<Organization> findAllByOrganizationTypeId(Long id);
}
