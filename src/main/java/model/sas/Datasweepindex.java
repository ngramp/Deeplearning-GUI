package model.sas;

import javax.persistence.*;

/**
 * Created by Graham Perry on 16/06/16.
 *
 * @author Graham Perry
 */
@Entity
@IdClass(DatasweepindexPK.class)
public class Datasweepindex {
    private Integer run;
    private String rerun;
    private Integer camcol;
    private Integer field;
    private Double ra;
    private Double dec;
    private Integer istart;
    private Integer iend;
    private Integer nprimary;

    @Id
    @Column(name = "run", nullable = false)
    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    @Id
    @Column(name = "rerun", nullable = false, length = -1)
    public String getRerun() {
        return rerun;
    }

    public void setRerun(String rerun) {
        this.rerun = rerun;
    }

    @Id
    @Column(name = "camcol", nullable = false)
    public Integer getCamcol() {
        return camcol;
    }

    public void setCamcol(Integer camcol) {
        this.camcol = camcol;
    }

    @Id
    @Column(name = "field", nullable = false)
    public Integer getField() {
        return field;
    }

    public void setField(Integer field) {
        this.field = field;
    }

    @Basic
    @Column(name = "ra", nullable = true, precision = 0)
    public Double getRa() {
        return ra;
    }

    public void setRa(Double ra) {
        this.ra = ra;
    }

    @Basic
    @Column(name = "dec", nullable = true, precision = 0)
    public Double getDec() {
        return dec;
    }

    public void setDec(Double dec) {
        this.dec = dec;
    }

    @Basic
    @Column(name = "istart", nullable = true)
    public Integer getIstart() {
        return istart;
    }

    public void setIstart(Integer istart) {
        this.istart = istart;
    }

    @Basic
    @Column(name = "iend", nullable = true)
    public Integer getIend() {
        return iend;
    }

    public void setIend(Integer iend) {
        this.iend = iend;
    }

    @Basic
    @Column(name = "nprimary", nullable = true)
    public Integer getNprimary() {
        return nprimary;
    }

    public void setNprimary(Integer nprimary) {
        this.nprimary = nprimary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Datasweepindex that = (Datasweepindex) o;

        if (run != null ? !run.equals(that.run) : that.run != null) return false;
        if (rerun != null ? !rerun.equals(that.rerun) : that.rerun != null) return false;
        if (camcol != null ? !camcol.equals(that.camcol) : that.camcol != null) return false;
        if (field != null ? !field.equals(that.field) : that.field != null) return false;
        if (ra != null ? !ra.equals(that.ra) : that.ra != null) return false;
        if (dec != null ? !dec.equals(that.dec) : that.dec != null) return false;
        if (istart != null ? !istart.equals(that.istart) : that.istart != null) return false;
        if (iend != null ? !iend.equals(that.iend) : that.iend != null) return false;
        if (nprimary != null ? !nprimary.equals(that.nprimary) : that.nprimary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = run != null ? run.hashCode() : 0;
        result = 31 * result + (rerun != null ? rerun.hashCode() : 0);
        result = 31 * result + (camcol != null ? camcol.hashCode() : 0);
        result = 31 * result + (field != null ? field.hashCode() : 0);
        result = 31 * result + (ra != null ? ra.hashCode() : 0);
        result = 31 * result + (dec != null ? dec.hashCode() : 0);
        result = 31 * result + (istart != null ? istart.hashCode() : 0);
        result = 31 * result + (iend != null ? iend.hashCode() : 0);
        result = 31 * result + (nprimary != null ? nprimary.hashCode() : 0);
        return result;
    }
}
