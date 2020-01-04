package dungeon;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany
    private List<Category> categories;
}
