package immorm.service.impl;

import immorm.domain.House;
import immorm.domain.history.History;
import immorm.repository.HistoryRepository;
import immorm.repository.HouseRepository;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
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
}
