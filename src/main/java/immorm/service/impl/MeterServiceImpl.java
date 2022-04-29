package immorm.service.impl;

import immorm.domain.House;
import immorm.domain.meter.AppartmentMeter;
import immorm.domain.meter.Meter;
import immorm.repository.MeterRepository;
import immorm.service.CRUDService;
import immorm.service.MeterService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MeterServiceImpl implements MeterService {

    MeterRepository<Meter> repository;

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

        repository.deleteById(id);
    }

    @Override
    public List<Meter> findAllByHouseId(int id) {
        return repository.findAll();
    }
}
