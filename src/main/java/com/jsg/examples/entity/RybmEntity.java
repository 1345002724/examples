package com.jsg.examples.entity;

import java.io.Serializable;

public class RybmEntity implements Serializable {
    private String rybm;
    private String ryxm;

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm;
    }

    public String getRyxm() {
        return ryxm;
    }

    public void setRyxm(String ryxm) {
        this.ryxm = ryxm;
    }
}
