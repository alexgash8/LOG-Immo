package immorm.service.impl;

import immorm.domain.Comment;
import immorm.domain.history.History;
import immorm.repository.CommentRepository;
import immorm.repository.HistoryRepository;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class HistoryService implements CRUDService<History> {

    HistoryRepository repository;

    @Override
    public void save(History history) {
        repository.save(history);
    }

    @Override
    public void update(History history) {
        repository.save(history);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
