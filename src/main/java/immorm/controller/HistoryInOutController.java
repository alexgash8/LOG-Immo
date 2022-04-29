package immorm.controller;

import immorm.domain.HistoryInOut;
import immorm.domain.payment.Payment;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("history-in-out")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class HistoryInOutController {

    CRUDService<HistoryInOut> service;

    @PostMapping
    public void save(@RequestBody HistoryInOut historyInOut) {
        service.save(historyInOut);
    }

    @PutMapping
    public void update(@RequestBody HistoryInOut historyInOut) {
        service.save(historyInOut);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }
//
//    @GetMapping("/{id}")
//    public HistoryInOut findById(@PathVariable(name = "id") int id) {
//        return service.findById(id);
//    }

}
