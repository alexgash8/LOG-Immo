package immorm.repository;

import immorm.domain.meter.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterRepository extends JpaRepository<Meter, Integer> {

}
