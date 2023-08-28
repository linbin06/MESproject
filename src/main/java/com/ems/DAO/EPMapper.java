package com.ems.DAO;

import com.ems.POJO.EnergyPoint;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EPMapper {

    //增加
    void add(EnergyPoint energyPoint);


    //修改
    void update(EnergyPoint energyPoint);

    void delete(Integer id);

    List<EnergyPoint> list(@Param("name") String name,
                           @Param("address") String address,
                           @Param("state") String status);
}
