package immorm.controller;

import immorm.domain.Comment;
import immorm.domain.Leaser;
import immorm.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CommentController {

    CRUDService<Comment> service;

    @PostMapping
    public void save(@RequestBody Comment comment) {
        service.save(comment);
    }

    @PutMapping
    public void update(@RequestBody Comment comment) {
        service.save(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable(name = "id") int id) {
        return service.findById(id);
    }

}
