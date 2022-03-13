package immorm.controller;

import immorm.domain.payment.Payment;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class PaymentController {

    CRUDService<Payment> service;

    @PostMapping
    public void save(@RequestBody Payment payment) {
        service.save(payment);
    }

    @PutMapping
    public void update(@RequestBody Payment payment) {
        service.save(payment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Payment findById(@PathVariable(name = "id") int id) {
        return service.findById(id);
    }

}
