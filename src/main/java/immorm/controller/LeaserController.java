package immorm.controller;

import immorm.domain.Leaser;
import immorm.dto.LeaserDTO;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("leaser")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class LeaserController {

    CRUDService<Leaser> service;

    @PostMapping
    public void save(@RequestBody Leaser leaser) {
        service.save(leaser);
    }

    @PutMapping
    public void update(@RequestBody Leaser leaser) {
        service.save(leaser);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

//    @GetMapping("/{id}")
//    public Leaser findById(@PathVariable(name = "id") int id) {
//        return service.findById(id);
//    }
//
//    @GetMapping("short/{id}")
//    public LeaserDTO findShortById(@PathVariable(name = "id") int id) {
//        Leaser leaser = service.findById(id);
//
//        return new LeaserDTO(leaser);
//    }

}
