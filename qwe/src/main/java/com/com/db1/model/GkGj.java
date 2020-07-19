package com.com.db1.model;

import java.io.Serializable;
import java.util.Date;

public class GkGj implements Serializable {
    private String id;

    private String gjmc;

    private String gjnr;

    private String gjjb;

    private String sfcl;

    private String rwbm;

    private String rwid;

    private String jsid;

    private String gjlx;

    private Date gjsj;

    private String cljd;

    private String cbcs;

    private String cbjl;

    private Date clsj;

    private String clr;

    private String clyy;

    private String gkcs;

    private String gjyy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGjmc() {
        return gjmc;
    }

    public void setGjmc(String gjmc) {
        this.gjmc = gjmc == null ? null : gjmc.trim();
    }

    public String getGjnr() {
        return gjnr;
    }

    public void setGjnr(String gjnr) {
        this.gjnr = gjnr == null ? null : gjnr.trim();
    }

    public String getGjjb() {
        return gjjb;
    }

    public void setGjjb(String gjjb) {
        this.gjjb = gjjb == null ? null : gjjb.trim();
    }

    public String getSfcl() {
        return sfcl;
    }

    public void setSfcl(String sfcl) {
        this.sfcl = sfcl == null ? null : sfcl.trim();
    }

    public String getRwbm() {
        return rwbm;
    }

    public void setRwbm(String rwbm) {
        this.rwbm = rwbm == null ? null : rwbm.trim();
    }

    public String getRwid() {
        return rwid;
    }

    public void setRwid(String rwid) {
        this.rwid = rwid == null ? null : rwid.trim();
    }

    public String getJsid() {
        return jsid;
    }

    public void setJsid(String jsid) {
        this.jsid = jsid == null ? null : jsid.trim();
    }

    public String getGjlx() {
        return gjlx;
    }

    public void setGjlx(String gjlx) {
        this.gjlx = gjlx == null ? null : gjlx.trim();
    }

    public Date getGjsj() {
        return gjsj;
    }

    public void setGjsj(Date gjsj) {
        this.gjsj = gjsj;
    }

    public String getCljd() {
        return cljd;
    }

    public void setCljd(String cljd) {
        this.cljd = cljd == null ? null : cljd.trim();
    }

    public String getCbcs() {
        return cbcs;
    }

    public void setCbcs(String cbcs) {
        this.cbcs = cbcs == null ? null : cbcs.trim();
    }

    public String getCbjl() {
        return cbjl;
    }

    public void setCbjl(String cbjl) {
        this.cbjl = cbjl == null ? null : cbjl.trim();
    }

    public Date getClsj() {
        return clsj;
    }

    public void setClsj(Date clsj) {
        this.clsj = clsj;
    }

    public String getClr() {
        return clr;
    }

    public void setClr(String clr) {
        this.clr = clr == null ? null : clr.trim();
    }

    public String getClyy() {
        return clyy;
    }

    public void setClyy(String clyy) {
        this.clyy = clyy == null ? null : clyy.trim();
    }

    public String getGkcs() {
        return gkcs;
    }

    public void setGkcs(String gkcs) {
        this.gkcs = gkcs == null ? null : gkcs.trim();
    }

    public String getGjyy() {
        return gjyy;
    }

    public void setGjyy(String gjyy) {
        this.gjyy = gjyy == null ? null : gjyy.trim();
    }
}