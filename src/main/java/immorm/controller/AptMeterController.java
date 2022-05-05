package immorm.controller;

import immorm.domain.meter.HouseMeter;
import immorm.domain.meter.Meter;
import immorm.domain.payment.Payment;
import immorm.service.CRUDService;
import immorm.service.HouseMeterService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("house-meter")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class HouseMeterController {

    HouseMeterService service;

    @PostMapping
    public void save(@RequestBody HouseMeter meter) {
        service.save(meter);
    }

    @PutMapping
    public void update(@RequestBody HouseMeter meter) {
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
