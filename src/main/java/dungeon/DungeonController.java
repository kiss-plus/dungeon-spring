package dungeon;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DungeonController {

    private DungeonRepository repository;

    public DungeonController(DungeonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/dungeons")
    public Iterable<Dungeon> dungeons() {

        return repository.findAll();
    }

    @PostMapping("/dungeons")
    public void createNewDungeon(@RequestBody Dungeon dungeon) {
        repository.save(dungeon);
    }

    @DeleteMapping("/dungeons/{id}")
    public ResponseEntity<Void> removeDungeon(@PathVariable Integer id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/dungeons/{id}")
    public ResponseEntity<Dungeon> justATest(@PathVariable Integer id) {
        return repository.findById(id)
                .map((Dungeon dungeon) -> new ResponseEntity<>(dungeon, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
