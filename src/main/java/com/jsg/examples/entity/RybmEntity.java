package com.jsg.examples.entity;

import java.io.Serializable;

public class RybmEntity implements Serializable {
    private String RYBM;      //人员编码
    private String RYXM;      //人员姓名
    private String PYDM;      //拼音代码
    private String PASSWORD;  //密码
    private String SJHM;      //手机号码
    private String SFZHM;     //身份证号码
    private String XB;        //性别
    private String QYZT;      //停用标志
    private String ip;         //登录ip地址
    private String BrowserName; //登录浏览器名称
    private String BrowserVersion; //登录浏览器版本
    private String OsName;       //登录操作系统
    private String logintime;    //登录时间
    private String token;        //会话编号
    private String logintoken;   //登录token

    public String getRYBM() {
        return RYBM;
    }

    public void setRYBM(String RYBM) {
        this.RYBM = RYBM;
    }

    public String getRYXM() {
        return RYXM;
    }

    public void setRYXM(String RYXM) {
        this.RYXM = RYXM;
    }

    public String getPYDM() {
        return PYDM;
    }

    public void setPYDM(String PYDM) {
        this.PYDM = PYDM;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getSJHM() {
        return SJHM;
    }

    public void setSJHM(String SJHM) {
        this.SJHM = SJHM;
    }

    public String getSFZHM() {
        return SFZHM;
    }

    public void setSFZHM(String SFZHM) {
        this.SFZHM = SFZHM;
    }

    public String getXB() {
        return XB;
    }

    public void setXB(String XB) {
        this.XB = XB;
    }

    public String getQYZT() {
        return QYZT;
    }

    public void setQYZT(String QYZT) {
        this.QYZT = QYZT;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBrowserName() {
        return BrowserName;
    }

    public void setBrowserName(String browserName) {
        BrowserName = browserName;
    }

    public String getBrowserVersion() {
        return BrowserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        BrowserVersion = browserVersion;
    }

    public String getOsName() {
        return OsName;
    }

    public void setOsName(String osName) {
        OsName = osName;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogintoken() {
        return logintoken;
    }

    public void setLogintoken(String logintoken) {
        this.logintoken = logintoken;
    }

    @Override
    public String toString() {
        return "RybmEntity{" +
                "RYBM='" + RYBM + '\'' +
                ", RYXM='" + RYXM + '\'' +
                ", PYDM='" + PYDM + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", SJHM='" + SJHM + '\'' +
                ", SFZHM='" + SFZHM + '\'' +
                ", XB='" + XB + '\'' +
                ", QYZT='" + QYZT + '\'' +
                ", ip='" + ip + '\'' +
                ", BrowserName='" + BrowserName + '\'' +
                ", BrowserVersion='" + BrowserVersion + '\'' +
                ", OsName='" + OsName + '\'' +
                '}';
    }
}
