package immorm.repository;

import immorm.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository<T extends Payment> extends JpaRepository<T, Integer> {

}
