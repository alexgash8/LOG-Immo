package immorm.repository;

import immorm.domain.Appartment;
import immorm.domain.Leaser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppartmentRepository extends JpaRepository<Appartment, Integer> {

}