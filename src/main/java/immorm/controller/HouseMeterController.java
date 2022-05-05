package immorm.controller;

import immorm.domain.meter.Meter;
import immorm.domain.payment.Payment;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("meter")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MeterController {

    CRUDService<Meter> service;

    @PostMapping
    public void save(@RequestBody Meter meter) {
        service.save(meter);
    }

    @PutMapping
    public void update(@RequestBody Meter meter) {
        service.save(meter);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

//    @GetMapping("/{id}")
//    public Meter findById(@PathVariable(name = "id") int id) {
//        return service.findById(id);
//    }

}
