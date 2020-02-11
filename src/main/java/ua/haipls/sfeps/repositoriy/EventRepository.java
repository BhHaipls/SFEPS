package ua.haipls.sfeps.repositoriy;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.Event;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event,Long> {
    List<Event> findAllByAuthorId(Long id);
    List<Event> findAllByImportantId(Long id);
    List<Event> findAllByStatus(String status);
    List<Event> findAllByDateBetween(LocalDateTime start,LocalDateTime end);
}
