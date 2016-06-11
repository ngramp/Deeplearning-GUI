package model.datasources;

import javax.persistence.*;

/**
 * Created by gram on 24/03/16.
 */
@Entity
@Table(name = "GZ", schema = "PUBLIC", catalog = "PUBLIC")
public class GzData {
    private long objid;
    private Double ra;
    private Double decl;
    private Short nvoteTot;
    private Byte nvoteStd;
    private Byte nvoteMr1;
    private Short nvoteMr2;
    private Byte nvoteMon;
    private Double pEl;
    private Double pCw;
    private Double pAcw;
    private Double pEdge;
    private Double pDk;
    private Double pMg;
    private Double pCs;

    @Id
    @Column(name = "OBJID", nullable = false)
    public long getObjid() {
        return objid;
    }

    public void setObjid(long objid) {
        this.objid = objid;
    }

    @Basic
    @Column(name = "RA", nullable = true, precision = 0)
    public Double getRa() {
        return ra;
    }

    public void setRa(Double ra) {
        this.ra = ra;
    }

    @Basic
    @Column(name = "DECL", nullable = true, precision = 0)
    public Double getDecl() {
        return decl;
    }

    public void setDecl(Double decl) {
        this.decl = decl;
    }

    @Basic
    @Column(name = "NVOTE_TOT", nullable = true)
    public Short getNvoteTot() {
        return nvoteTot;
    }

    public void setNvoteTot(Short nvoteTot) {
        this.nvoteTot = nvoteTot;
    }

    @Basic
    @Column(name = "NVOTE_STD", nullable = true)
    public Byte getNvoteStd() {
        return nvoteStd;
    }

    public void setNvoteStd(Byte nvoteStd) {
        this.nvoteStd = nvoteStd;
    }

    @Basic
    @Column(name = "NVOTE_MR1", nullable = true)
    public Byte getNvoteMr1() {
        return nvoteMr1;
    }

    public void setNvoteMr1(Byte nvoteMr1) {
        this.nvoteMr1 = nvoteMr1;
    }

    @Basic
    @Column(name = "NVOTE_MR2", nullable = true)
    public Short getNvoteMr2() {
        return nvoteMr2;
    }

    public void setNvoteMr2(Short nvoteMr2) {
        this.nvoteMr2 = nvoteMr2;
    }

    @Basic
    @Column(name = "NVOTE_MON", nullable = true)
    public Byte getNvoteMon() {
        return nvoteMon;
    }

    public void setNvoteMon(Byte nvoteMon) {
        this.nvoteMon = nvoteMon;
    }

    @Basic
    @Column(name = "P_EL", nullable = true, precision = 0)
    public Double getpEl() {
        return pEl;
    }

    public void setpEl(Double pEl) {
        this.pEl = pEl;
    }

    @Basic
    @Column(name = "P_CW", nullable = true, precision = 0)
    public Double getpCw() {
        return pCw;
    }

    public void setpCw(Double pCw) {
        this.pCw = pCw;
    }

    @Basic
    @Column(name = "P_ACW", nullable = true, precision = 0)
    public Double getpAcw() {
        return pAcw;
    }

    public void setpAcw(Double pAcw) {
        this.pAcw = pAcw;
    }

    @Basic
    @Column(name = "P_EDGE", nullable = true, precision = 0)
    public Double getpEdge() {
        return pEdge;
    }

    public void setpEdge(Double pEdge) {
        this.pEdge = pEdge;
    }

    @Basic
    @Column(name = "P_DK", nullable = true, precision = 0)
    public Double getpDk() {
        return pDk;
    }

    public void setpDk(Double pDk) {
        this.pDk = pDk;
    }

    @Basic
    @Column(name = "P_MG", nullable = true, precision = 0)
    public Double getpMg() {
        return pMg;
    }

    public void setpMg(Double pMg) {
        this.pMg = pMg;
    }

    @Basic
    @Column(name = "P_CS", nullable = true, precision = 0)
    public Double getpCs() {
        return pCs;
    }

    public void setpCs(Double pCs) {
        this.pCs = pCs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GzData gzData = (GzData) o;

        if (objid != gzData.objid) return false;
        if (ra != null ? !ra.equals(gzData.ra) : gzData.ra != null) return false;
        if (decl != null ? !decl.equals(gzData.decl) : gzData.decl != null) return false;
        if (nvoteTot != null ? !nvoteTot.equals(gzData.nvoteTot) : gzData.nvoteTot != null) return false;
        if (nvoteStd != null ? !nvoteStd.equals(gzData.nvoteStd) : gzData.nvoteStd != null) return false;
        if (nvoteMr1 != null ? !nvoteMr1.equals(gzData.nvoteMr1) : gzData.nvoteMr1 != null) return false;
        if (nvoteMr2 != null ? !nvoteMr2.equals(gzData.nvoteMr2) : gzData.nvoteMr2 != null) return false;
        if (nvoteMon != null ? !nvoteMon.equals(gzData.nvoteMon) : gzData.nvoteMon != null) return false;
        if (pEl != null ? !pEl.equals(gzData.pEl) : gzData.pEl != null) return false;
        if (pCw != null ? !pCw.equals(gzData.pCw) : gzData.pCw != null) return false;
        if (pAcw != null ? !pAcw.equals(gzData.pAcw) : gzData.pAcw != null) return false;
        if (pEdge != null ? !pEdge.equals(gzData.pEdge) : gzData.pEdge != null) return false;
        if (pDk != null ? !pDk.equals(gzData.pDk) : gzData.pDk != null) return false;
        if (pMg != null ? !pMg.equals(gzData.pMg) : gzData.pMg != null) return false;
        return pCs != null ? pCs.equals(gzData.pCs) : gzData.pCs == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (objid ^ (objid >>> 32));
        result = 31 * result + (ra != null ? ra.hashCode() : 0);
        result = 31 * result + (decl != null ? decl.hashCode() : 0);
        result = 31 * result + (nvoteTot != null ? nvoteTot.hashCode() : 0);
        result = 31 * result + (nvoteStd != null ? nvoteStd.hashCode() : 0);
        result = 31 * result + (nvoteMr1 != null ? nvoteMr1.hashCode() : 0);
        result = 31 * result + (nvoteMr2 != null ? nvoteMr2.hashCode() : 0);
        result = 31 * result + (nvoteMon != null ? nvoteMon.hashCode() : 0);
        result = 31 * result + (pEl != null ? pEl.hashCode() : 0);
        result = 31 * result + (pCw != null ? pCw.hashCode() : 0);
        result = 31 * result + (pAcw != null ? pAcw.hashCode() : 0);
        result = 31 * result + (pEdge != null ? pEdge.hashCode() : 0);
        result = 31 * result + (pDk != null ? pDk.hashCode() : 0);
        result = 31 * result + (pMg != null ? pMg.hashCode() : 0);
        result = 31 * result + (pCs != null ? pCs.hashCode() : 0);
        return result;
    }
}
