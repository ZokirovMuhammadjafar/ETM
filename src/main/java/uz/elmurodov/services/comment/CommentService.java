package uz.elmurodov.services.comment;

import uz.elmurodov.dtos.commetn.CommentCreateDto;
import uz.elmurodov.dtos.commetn.CommentDto;
import uz.elmurodov.repository.comment.CommentRepositoryImpl;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.services.BaseService;

/**
 * @author Saydali Murodullayev, Thu 1:54 AM. 1/20/2022
 */
public class CommentService extends BaseService<CommentRepositoryImpl, CommentCreateDto, CommentDto, Long> {
    public CommentService(CommentRepositoryImpl commentRepository) {
        super(commentRepository);
    }

    @Override
    public ResponseEntity<Data<?>> create(CommentCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<CommentDto> get(Long id) {
        return null;
    }
}
