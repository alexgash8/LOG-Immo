package immorm.service.impl;

import immorm.domain.Appartment;
import immorm.domain.Leaser;
import immorm.repository.AppartmentRepository;
import immorm.repository.LeaserRepository;
import immorm.service.AppartmentService;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Transactional
public class AppartmentServiceImpl implements AppartmentService {

    AppartmentRepository repository;

    @Override
    public void save(Appartment appartment) {

        appartment.getComments().forEach(com -> com.setAppartment(appartment));

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
    public List<Appartment> findAllByHouseId(int id) {
        return repository.findAllByHouseId(id);
    }
}
