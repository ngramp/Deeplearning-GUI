package model.datasources;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by gram on 26/03/16.
 */
@Entity
public class Dr7Gz {
    private long objid;
    private Double ra;
    private Double decl;
    private Float size;

    @Id
    @Column(name = "objid", nullable = false)
    public long getObjid() {
        return objid;
    }

    public void setObjid(long objid) {
        this.objid = objid;
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
    @Column(name = "decl", nullable = true, precision = 0)
    public Double getDecl() {
        return decl;
    }

    public void setDecl(Double decl) {
        this.decl = decl;
    }

    @Basic
    @Column(name = "size", nullable = true, precision = 0)
    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dr7Gz dr7Gz = (Dr7Gz) o;

        if (objid != dr7Gz.objid) return false;
        if (ra != null ? !ra.equals(dr7Gz.ra) : dr7Gz.ra != null) return false;
        if (decl != null ? !decl.equals(dr7Gz.decl) : dr7Gz.decl != null) return false;
        return size != null ? size.equals(dr7Gz.size) : dr7Gz.size == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (objid ^ (objid >>> 32));
        result = 31 * result + (ra != null ? ra.hashCode() : 0);
        result = 31 * result + (decl != null ? decl.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        return result;
    }
}
