package dom;

import javax.persistence.*;

@Entity
@Table(name = "bin", schema = "labsystems")
public class BinEntity {
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String name;

    public BinEntity() {
    }

    public BinEntity(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 5)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinEntity binEntity = (BinEntity) o;

        if (id != binEntity.id) return false;
        if (name != null ? !name.equals(binEntity.name) : binEntity.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
