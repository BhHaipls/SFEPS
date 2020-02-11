package ua.haipls.sfeps.repositoriy;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.ImportantEvent;

@Repository
public interface ImportantEventRepository extends PagingAndSortingRepository<ImportantEvent, Long> {
}
