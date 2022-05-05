package immorm.repository.meter;

import immorm.domain.meter.Meter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MeterRepository<T extends Meter> extends JpaRepository<T, Integer> {

}
