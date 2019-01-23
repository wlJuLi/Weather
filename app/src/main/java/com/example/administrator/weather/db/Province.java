package com.example.administrator.weather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2019/1/23.
 */

public class Province extends DataSupport {
    private int id;
    private String provinceNane;
    private int privinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceNane() {
        return provinceNane;
    }

    public void setProvinceNane(String provinceNane) {
        this.provinceNane = provinceNane;
    }

    public int getPrivinceCode() {
        return privinceCode;
    }

    public void setPrivinceCode(int privinceCode) {
        this.privinceCode = privinceCode;
    }
}
