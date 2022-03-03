package immorm.service.impl;

import immorm.domain.Leaser;
import immorm.repository.LeaserRepository;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class LeaserService implements CRUDService<Leaser> {

    LeaserRepository repository;

    @Override
    public void save(Leaser leaser) {
        repository.save(leaser);
    }

    @Override
    public void update(Leaser leaser) {
        repository.save(leaser);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
