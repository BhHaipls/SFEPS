package ua.haipls.sfeps.service;

import ua.haipls.sfeps.dto.CommentDto;

import java.util.Collection;

public interface CommentService {

    CommentDto create(CommentDto commentDto);

    CommentDto update(CommentDto commentDto);

    Collection<CommentDto> findAll();

    Collection<CommentDto> findAllByEventId(Long id);

    Collection<CommentDto> findAllByAuthorId(Long id);

    CommentDto findById(Long id);


    void deleteById(Long id);
}
