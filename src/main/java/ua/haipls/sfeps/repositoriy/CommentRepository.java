package ua.haipls.sfeps.repositoriy;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ua.haipls.sfeps.domain.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {
    List<Comment> findAllByEventId(Long id);
    List<Comment> findAllByAuthorId(Long id);
}
