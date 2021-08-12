package com.jsg.examples.entity;

import java.io.Serializable;

//分页条件
public class QueryInfoEntity implements Serializable {
    private String query;    //作为搜索条件
    private Integer pagenum;  //当前页数
    private Integer pagesize; //当前每页显示数量

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }
}
