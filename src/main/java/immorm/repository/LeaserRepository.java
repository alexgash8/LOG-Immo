package immorm.repository;

import immorm.domain.Appartment;
import immorm.domain.Leaser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaserRepository extends JpaRepository<Leaser, Integer> {

    @EntityGraph(attributePaths = {"phones"})
    Leaser findById(int id);
}
