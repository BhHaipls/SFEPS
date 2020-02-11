package ua.haipls.sfeps.repositoriy;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.Service;

import java.util.List;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service,Long> {
    List<Service> findAllByAuthorId(Long id);
    List<Service> findAllByServiceTypeId(Long id);
}
