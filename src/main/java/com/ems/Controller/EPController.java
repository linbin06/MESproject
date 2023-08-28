package com.ems.Controller;

import com.ems.POJO.EnergyPoint;
import com.ems.POJO.PageBean;
import com.ems.POJO.Result;
import com.ems.Service.EPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class EPController {

    @Autowired
    private EPService epService;

    //添加信息
    @PostMapping("/epc")
    public Result add(@RequestBody EnergyPoint energyPoint) {
        log.info("添加信息,energyPoint:{}", energyPoint);
        epService.add(energyPoint);
        return Result.success();
    }

    //修改信息
    @PutMapping("/epc")
    public Result update(@RequestBody EnergyPoint energyPoint) {
        log.info("修改员工信息：{}", energyPoint);
        epService.update(energyPoint);
        return Result.success();
    }

    //根据ID删除
    @DeleteMapping("/epc/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除信息：{}",id);
        epService.delete(id);
        return Result.success("删除成功");
    }

//    查找
    @RequestMapping("/epc")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,String address,String status){
        log.info("分页查询：参数：{},{},{},{},{}",page,pageSize,name,address,status);
        PageBean pageBean=epService.page(page,pageSize,name,address,status);
        return Result.success(pageBean);

    }
}
