package immorm.service;

import immorm.domain.meter.HouseMeter;
import immorm.domain.meter.Meter;

import java.util.List;

public interface HouseMeterService extends CRUDService<HouseMeter> {
    List<HouseMeter> findAllByHouseId(int id);
}
