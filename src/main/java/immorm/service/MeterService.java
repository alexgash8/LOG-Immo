package immorm.service;

import immorm.domain.meter.Meter;

import java.util.List;

public interface MeterService extends CRUDService<Meter> {
    List<Meter> findAllByHouseId(int id);
//    List<Meter> findAllByAppartmentId(int id);
}
