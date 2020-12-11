package com.jsg.examples.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenulistEntity implements Serializable {

    private String mkbm1;   //一级模块编码
    private String mkmc1;   //一级模块名称
    private String icon;    //一级模块图标
    private String mkbm2;   //二级模块编码
    private String mkmc2;   //二级级模块名称
    private String types;   //所属几级模块(1代表所属级别为一级模块，2代表所属级别为2级模块)
    private String path;    //二级模块所对应的路由地址
    private List<Object> children=new ArrayList<>();

    public List<Object> getChildren() {
        return children;
    }

    public void setChildren(List<Object> children) {
        this.children = children;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

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
}
