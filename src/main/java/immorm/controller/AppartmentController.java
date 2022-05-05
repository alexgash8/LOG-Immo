package immorm.controller;

import immorm.domain.Appartment;
import immorm.service.AppartmentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appartment")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AppartmentController {

    AppartmentService service;

    @PostMapping
    public void save(@RequestBody Appartment appartment) {
        service.save(appartment);
    }

    @PutMapping
    public void update(@RequestBody Appartment appartment) {
        service.save(appartment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public List<Appartment> findAllById(@PathVariable(name = "id") int houseId) {
        return service.findAllByHouseId(houseId);
    }

}
