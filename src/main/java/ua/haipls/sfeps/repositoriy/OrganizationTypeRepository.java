package ua.haipls.sfeps.repositoriy;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.OrganizationType;

@Repository
public interface OrganizationTypeRepository extends PagingAndSortingRepository<OrganizationType, Long> {
}
