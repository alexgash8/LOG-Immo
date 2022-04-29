package immorm.controller;

import immorm.domain.House;
import immorm.service.CRUDService;
import immorm.service.HouseService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("house")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class HouseController {

    HouseService service;

    @PostMapping
    public void save(@RequestBody House house) {
        service.save(house);
    }

    @PutMapping
    public void update(@RequestBody House house) {
        service.save(house);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

//    @GetMapping("/{id}")
//    public House findById(@PathVariable(name = "id") int id) {
//        return service.findById(id);
//    }

    @GetMapping("/houses")
    public List<House> findAll() {
        return service.findAll();
    }

}
