package immorm.service;

import immorm.domain.meter.AppartmentMeter;
import immorm.domain.meter.HouseMeter;

import java.util.List;

public interface AptMeterService extends CRUDService<AppartmentMeter> {
    List<AppartmentMeter> findAllByAppartmentId(int id);
}
