package com.ems.Service;

import com.ems.POJO.EnergyPoint;
import com.ems.POJO.PageBean;

public interface EPService {

    //增加
    void add(EnergyPoint energyPoint);

    //修改
    void update(EnergyPoint energyPoint);

    //删除
    void delete(Integer id);

    PageBean page(Integer page, Integer pageSize, String name, String address, String status);
}
