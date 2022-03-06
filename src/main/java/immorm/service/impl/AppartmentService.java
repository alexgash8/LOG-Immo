package immorm.service.impl;

import immorm.domain.Appartment;
import immorm.domain.Leaser;
import immorm.repository.AppartmentRepository;
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
public class AppartmentService implements CRUDService<Appartment> {

    AppartmentRepository repository;
    @Override
    public void save(Appartment appartment) {
        repository.save(appartment);
    }

    @Override
    public void update(Appartment appartment) {
        repository.save(appartment);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Appartment findById(int id) {
        return repository.findById(id).get();
    }
}
