package masayuki.jpa.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "departements")
public class Departements {

    @EmbeddedId
    private DepartementsId id;

    private String name;

    public DepartementsId getId() {
        return id;
    }

    public void setId(DepartementsId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
