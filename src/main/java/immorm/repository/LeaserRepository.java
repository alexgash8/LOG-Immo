package immorm.repository;

import immorm.domain.Leaser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaserRepository extends JpaRepository<Leaser, Integer> {

}
