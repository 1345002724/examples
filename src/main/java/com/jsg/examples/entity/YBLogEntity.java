package com.jsg.examples.entity;

import java.io.Serializable;

public class YBLogEntity implements Serializable {
    public String qqrq;
    public String jylx;
    public String ybjgid;
    public String instr;
    public String outstr;
    public String starttime;
    public String endtime;
    public String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getQqrq() {
        return qqrq;
    }

    public void setQqrq(String qqrq) {
        this.qqrq = qqrq;
    }

    public String getJylx() {
        return jylx;
    }

    public void setJylx(String jylx) {
        this.jylx = jylx;
    }

    public String getYbjgid() {
        return ybjgid;
    }

    public void setYbjgid(String ybjgid) {
        this.ybjgid = ybjgid;
    }

    public String getInstr() {
        return instr;
    }

    public void setInstr(String instr) {
        this.instr = instr;
    }

    public String getOutstr() {
        return outstr;
    }

    public void setOutstr(String outstr) {
        this.outstr = outstr;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "YBLogEntity{" +
                "qqrq='" + qqrq + '\'' +
                ", jylx='" + jylx + '\'' +
                ", ybjgid='" + ybjgid + '\'' +
                ", instr='" + instr + '\'' +
                ", outstr='" + outstr + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                '}';
    }
}
