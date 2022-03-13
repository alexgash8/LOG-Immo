package immorm.controller;

import immorm.domain.Appartment;
import immorm.domain.House;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appartment")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AppartmentController {

    CRUDService<Appartment> service;

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
    public Appartment findById(@PathVariable(name = "id") int id) {
        return service.findById(id);
    }

}
