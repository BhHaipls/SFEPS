package ua.haipls.sfeps.service.impl;

import org.springframework.stereotype.Service;
import ua.haipls.sfeps.dto.CommentDto;
import ua.haipls.sfeps.service.CommentService;

import java.util.Collection;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public CommentDto create(CommentDto commentDto) {
        return null;
    }

    @Override
    public CommentDto update(CommentDto commentDto) {
        return null;
    }

    @Override
    public Collection<CommentDto> findAll() {
        return null;
    }

    @Override
    public Collection<CommentDto> findAllByEventId(Long id) {
        return null;
    }

    @Override
    public Collection<CommentDto> findAllByAuthorId(Long id) {
        return null;
    }

    @Override
    public CommentDto findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
