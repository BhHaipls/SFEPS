package ua.haipls.sfeps.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.haipls.sfeps.domain.Comment;
import ua.haipls.sfeps.dto.CommentDto;
import ua.haipls.sfeps.dto.mapper.CommentMapper;
import ua.haipls.sfeps.repositoriy.CommentRepository;
import ua.haipls.sfeps.service.CommentService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;


    @Override
    public CommentDto create(CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);

        Comment result = commentRepository.save(comment);

        CommentDto resultDto = commentMapper.toDto(result);
        log.info("IN create - comment: {} successfully created", resultDto);
        return resultDto;
    }

    @Override
    public CommentDto update(CommentDto commentDto) {
        findById(commentDto.getId());

        Comment comment = commentMapper.toEntity(commentDto);
        Comment result = commentRepository.save(comment);
        CommentDto resultDto = commentMapper.toDto(result);
        log.info("IN update - comment: {} successfully updated", resultDto);

        return resultDto;
    }

    @Override
    public Collection<CommentDto> findAll() {
        Collection<CommentDto> result = ((Collection<Comment>) commentRepository.findAll())
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} comment found", result.size());
        return result;
    }

    @Override
    public Collection<CommentDto> findAllByEventId(Long id) {
        Collection<CommentDto> result = commentRepository.findAllByEventId(id)
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAllByEventId - id:{}; {} comment found", id, result.size());
        return result;
    }

    @Override
    public Collection<CommentDto> findAllByAuthorId(Long id) {
        Collection<CommentDto> result = commentRepository.findAllByAuthorId(id)
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAllByAuthorId - id:{}; {} comment found", id, result.size());
        return result;
    }

    @Override
    public CommentDto findById(Long id) {
        CommentDto result = commentMapper.toDto(commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found by id: " + id)));
        log.info("IN findById - comment: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        commentRepository.deleteById(id);
        log.info("IN deleteById - comment with id: {} successfully deleted", id);
    }
}
