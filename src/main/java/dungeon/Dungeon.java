package dungeon;

import javax.persistence.*;

@Entity
public class Dungeon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void rename(String newName) {
        name = newName;
    }

}
