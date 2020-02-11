package ua.haipls.sfeps.repositoriy;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.ServiceType;

@Repository
public interface ServiceTypeRepository extends PagingAndSortingRepository<ServiceType, Long> {
}
