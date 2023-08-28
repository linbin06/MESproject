package com.ems.Service.Impl;

import com.ems.DAO.EPMapper;
import com.ems.POJO.EnergyPoint;
import com.ems.POJO.PageBean;
import com.ems.Service.EPService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EPServiceImpl implements EPService {

    @Autowired
    private EPMapper epMapper;


    //增加
    @Override
    public void add(EnergyPoint energyPoint) {
        energyPoint.setApplyTime(LocalDateTime.now());
        epMapper.add(energyPoint);
    }

    //修改
    @Override
    public void update(EnergyPoint energyPoint) {
        energyPoint.setApplyTime(LocalDateTime.now());
        epMapper.update(energyPoint);
    }


    //删除
    @Override
    public void delete(Integer id) {
        epMapper.delete(id);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, String address, String status) {
        PageHelper.startPage(page,pageSize);
        List<EnergyPoint> energyPointList=epMapper.list(name,address,status);
        Page<EnergyPoint> pointPage=(Page<EnergyPoint>) energyPointList;

        PageBean pageBean=new PageBean(pointPage.getTotal(), pointPage.getResult());
        return pageBean;
    }
}
