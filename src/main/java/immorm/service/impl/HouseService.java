package immorm.service.impl;

import immorm.domain.House;
import immorm.repository.HouseRepository;
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
public class HouseService implements CRUDService<House> {

    HouseRepository repository;

    @Override
    public void save(House house) {
        repository.save(house);
    }

    @Override
    public void update(House house) {
        repository.save(house);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public House findById(int id) {
        return repository.findById(id).get();
    }
}
