package immorm.service.impl;

import immorm.domain.meter.AppartmentMeter;
import immorm.domain.meter.HouseMeter;
import immorm.repository.AppartmentRepository;
import immorm.repository.meter.AptMeterRepository;
import immorm.repository.meter.MeterRepository;
import immorm.service.AppartmentService;
import immorm.service.AptMeterService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AptMeterServiceImpl implements AptMeterService {

    AptMeterRepository aptRepository;

    @Override
    public void save(AppartmentMeter meter) {
        aptRepository.save(meter);
    }

    @Override
    public void update(AppartmentMeter meter) {
        aptRepository.save(meter);
    }

    @Override
    public void deleteById(int id) {

        aptRepository.deleteById(id);
    }

    @Override
    public List<AppartmentMeter> findAllByAppartmentId(int id) {
        return aptRepository.findAllByAppartmentId(id);
    }
}
