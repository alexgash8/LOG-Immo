package immorm.service.impl;

import immorm.domain.HistoryInOut;
import immorm.repository.HistoryInOutRepository;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class HistoryInOutService implements CRUDService<HistoryInOut> {

    HistoryInOutRepository repository;

    @Override
    public void save(HistoryInOut history) {
        repository.save(history);
    }

    @Override
    public void update(HistoryInOut history) {
        repository.save(history);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public HistoryInOut findById(int id) {
        return repository.findById(id).get();
    }
}
