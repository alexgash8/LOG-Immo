package immorm.service.impl;

import immorm.domain.House;
import immorm.repository.HouseRepository;
import immorm.service.CRUDService;
import immorm.service.HouseService;
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
public class HouseServiceImpl implements HouseService {

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
    public List<House> findAll() {
        return repository.findAll();
    }

    @Override
    public House getById(Integer id) {
        return repository.getById(id);
    }
}
