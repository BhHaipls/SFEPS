package ua.haipls.sfeps.dto.mapper;


import org.mapstruct.Mapper;
import ua.haipls.sfeps.domain.Comment;
import ua.haipls.sfeps.dto.CommentDto;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toEntity(CommentDto dto);

    CommentDto toDto(Comment entity);
}
