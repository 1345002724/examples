package com.jsg.examples.entity;

import java.io.Serializable;

/**
 * menulist
 * @author 
 */
public class Menulist implements Serializable {
    private String mkbm1;

    private String mkmc1;

    private String icon;

    private String mkbm2;

    private String mkmc2;

    private String types;

    /**
     * 路由对应地址
     */
    private String path;

    private static final long serialVersionUID = 1L;

    public String getMkbm1() {
        return mkbm1;
    }

    public void setMkbm1(String mkbm1) {
        this.mkbm1 = mkbm1;
    }

    public String getMkmc1() {
        return mkmc1;
    }

    public void setMkmc1(String mkmc1) {
        this.mkmc1 = mkmc1;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMkbm2() {
        return mkbm2;
    }

    public void setMkbm2(String mkbm2) {
        this.mkbm2 = mkbm2;
    }

    public String getMkmc2() {
        return mkmc2;
    }

    public void setMkmc2(String mkmc2) {
        this.mkmc2 = mkmc2;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}