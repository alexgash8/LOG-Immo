package immorm.service;

import immorm.domain.House;

import java.util.List;

public interface HouseService extends CRUDService<House> {
    List<House> findAll();
}
