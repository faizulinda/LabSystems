package dom;

import javax.persistence.*;

@Entity
@Table(name = "rule", schema = "labsystems")
public class RuleEntity {
    @GeneratedValue
    private int id;
    private int workflowId;
    private int binId;
    private String testId;

    public RuleEntity() {
    }

    public RuleEntity(int workflowId, int binId, String testId) {
        this.workflowId = workflowId;
        this.binId = binId;
        this.testId = testId;
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
    @Column(name = "workflow_id", nullable = false)
    public int getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(int workflowId) {
        this.workflowId = workflowId;
    }

    @Basic
    @Column(name = "bin_id", nullable = false)
    public int getBinId() {
        return binId;
    }

    public void setBinId(int binId) {
        this.binId = binId;
    }

    @Basic
    @Column(name = "test_id", nullable = false, length = 20)
    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RuleEntity that = (RuleEntity) o;

        if (id != that.id) return false;
        if (workflowId != that.workflowId) return false;
        if (binId != that.binId) return false;
        if (testId != null ? !testId.equals(that.testId) : that.testId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + workflowId;
        result = 31 * result + binId;
        result = 31 * result + (testId != null ? testId.hashCode() : 0);
        return result;
    }
}
