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
import org.springframework.transaction.annotation.Transactional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Transactional
public class PaymentService implements CRUDService<Payment> {

    PaymentRepository<Payment> repository;

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
        repository.deleteById(id);
    }

//    @Override
//    public Payment findById(int id) {
//        return repository.findById(id).get();
//    }
}
