package immorm.service.impl;

import immorm.domain.history.History;
import immorm.domain.meter.Meter;
import immorm.repository.HistoryRepository;
import immorm.repository.MeterRepository;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MeterService implements CRUDService<Meter> {

    MeterRepository repository;

    @Override
    public void save(Meter meter) {
        repository.save(meter);
    }

    @Override
    public void update(Meter meter) {
        repository.save(meter);
    }

    @Override
    public void deleteById(int id) {
        deleteById(id);
    }
}
