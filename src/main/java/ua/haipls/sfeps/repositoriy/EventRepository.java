package ua.haipls.sfeps.repositoriy;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.Event;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
    Collection<Event> findAllByAuthorId(Long id);

    Collection<Event> findAllByImportantId(Long id);

    Collection<Event> findAllByStatus(String status);

    Collection<Event> findAllByDateBetween(LocalDateTime start, LocalDateTime end);
}
