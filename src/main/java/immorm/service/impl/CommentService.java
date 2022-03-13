package immorm.service.impl;

import immorm.domain.Comment;
import immorm.repository.CommentRepository;
import immorm.repository.LeaserRepository;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Transactional
public class CommentService implements CRUDService<Comment> {

    CommentRepository repository;
    @Override
    public void save(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void update(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Comment findById(int id) {
        return repository.findById(id).get();
    }
}
