package immorm.repository.meter;

import immorm.domain.meter.AppartmentMeter;

import java.util.List;

public interface AptMeterRepository extends MeterRepository<AppartmentMeter> {
    List<AppartmentMeter> findAllByAppartmentId(int id);
}
