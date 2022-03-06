package immorm.repository;

import immorm.domain.HistoryInOut;
import immorm.domain.history.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryInOutRepository extends JpaRepository<HistoryInOut, Integer> {

}
