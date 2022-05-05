package immorm.controller;

import immorm.domain.meter.AppartmentMeter;
import immorm.domain.meter.HouseMeter;
import immorm.service.AptMeterService;
import immorm.service.HouseMeterService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apt-meter")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AptMeterController {

    AptMeterService service;

    @PostMapping
    public void save(@RequestBody AppartmentMeter meter) {
        service.save(meter);
    }

    @PutMapping
    public void update(@RequestBody AppartmentMeter meter) {
        service.save(meter);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public List<AppartmentMeter> findAllById(@PathVariable(name = "id") int aptId) {
        return service.findAllByAppartmentId(aptId);
    }

}
