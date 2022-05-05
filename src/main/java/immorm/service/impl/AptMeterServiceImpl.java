package immorm.service.impl;

import immorm.domain.meter.AppartmentMeter;
import immorm.domain.meter.HouseMeter;
import immorm.domain.meter.Meter;
import immorm.repository.meter.MeterRepository;
import immorm.service.HouseMeterService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class HouseMeterServiceImpl implements HouseMeterService {

    MeterRepository<HouseMeter> houseRepository;

    @Override
    public void save(HouseMeter meter) {
        houseRepository.save(meter);
    }

    @Override
    public void update(HouseMeter meter) {
        houseRepository.save(meter);
    }

    @Override
    public void deleteById(int id) {

        houseRepository.deleteById(id);
    }

    @Override
    public List<HouseMeter> findAllByHouseId(int id) {
        return houseRepository.findAll();
    }
}
