package model.sas;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Graham Perry on 16/06/16.
 *
 * @author Graham Perry
 */
public class DatasweepindexPK implements Serializable {
    private Integer run;
    private String rerun;
    private Integer camcol;
    private Integer field;

    @Column(name = "run", nullable = false)
    @Id
    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    @Column(name = "rerun", nullable = false, length = -1)
    @Id
    public String getRerun() {
        return rerun;
    }

    public void setRerun(String rerun) {
        this.rerun = rerun;
    }

    @Column(name = "camcol", nullable = false)
    @Id
    public Integer getCamcol() {
        return camcol;
    }

    public void setCamcol(Integer camcol) {
        this.camcol = camcol;
    }

    @Column(name = "field", nullable = false)
    @Id
    public Integer getField() {
        return field;
    }

    public void setField(Integer field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatasweepindexPK that = (DatasweepindexPK) o;

        if (run != null ? !run.equals(that.run) : that.run != null) return false;
        if (rerun != null ? !rerun.equals(that.rerun) : that.rerun != null) return false;
        if (camcol != null ? !camcol.equals(that.camcol) : that.camcol != null) return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = run != null ? run.hashCode() : 0;
        result = 31 * result + (rerun != null ? rerun.hashCode() : 0);
        result = 31 * result + (camcol != null ? camcol.hashCode() : 0);
        result = 31 * result + (field != null ? field.hashCode() : 0);
        return result;
    }
}
