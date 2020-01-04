package dungeon;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne(targetEntity = Category.class)
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> children;

    @ManyToMany(mappedBy = "categories")
    private List<Item> items;

    public String name() {
        return name;
    }

    public Category parent() {
        return parent;
    }

    public List<Category> children() {
        return children;
    }
}
