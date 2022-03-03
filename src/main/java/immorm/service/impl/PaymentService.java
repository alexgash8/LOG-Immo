package immorm.service.impl;

import immorm.domain.House;
import immorm.domain.payment.Payment;
import immorm.repository.HouseRepository;
import immorm.repository.PaymentRepository;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class PaymentService implements CRUDService<Payment> {

    PaymentRepository repository;

    @Override
    public void save(Payment payment) {
        repository.save(payment);
    }

    @Override
    public void update(Payment payment) {
        repository.save(payment);
    }

    @Override
    public void deleteById(int id) {
        deleteById(id);
    }
}
