package immorm.service;

import immorm.domain.Appartment;
import immorm.domain.meter.Meter;

import java.util.List;

public interface AppartmentService extends CRUDService<Appartment> {
    List<Appartment> findAllByHouseId(int id);
}
