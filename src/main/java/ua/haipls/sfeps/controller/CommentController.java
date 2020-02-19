package ua.haipls.sfeps.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.haipls.sfeps.dto.CommentDto;
import ua.haipls.sfeps.dto.transfer.OnCreate;
import ua.haipls.sfeps.dto.transfer.OnUpdate;
import ua.haipls.sfeps.service.CommentService;

import java.util.Collection;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto create(@Validated(OnCreate.class) @RequestBody CommentDto commentDto) {
        return commentService.create(commentDto);
    }

    @PutMapping("/{id}")
    public CommentDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody CommentDto commentDto) {
        commentDto.setId(id);
        return commentService.update(commentDto);
    }

    @GetMapping
    public Collection<CommentDto> findAll() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDto findById(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @GetMapping("/author/{id}")
    public Collection<CommentDto> findByAuthorId(@PathVariable Long id) {
        return commentService.findAllByAuthorId(id);
    }

    @GetMapping("/event/{id}")
    public Collection<CommentDto> findAllByEventId(@PathVariable Long id) {
        return commentService.findAllByEventId(id);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        commentService.deleteById(id);
    }
}
