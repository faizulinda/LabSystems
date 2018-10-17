package dom;

import javax.persistence.*;

@Entity
@Table(name = "rule", schema = "labsystems")
public class RuleEntity {
    private int id;
    private BinEntity binByBinId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RuleEntity that = (RuleEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "bin_id", referencedColumnName = "id", nullable = false)
    public BinEntity getBinByBinId() {
        return binByBinId;
    }

    public void setBinByBinId(BinEntity binByBinId) {
        this.binByBinId = binByBinId;
    }
}
