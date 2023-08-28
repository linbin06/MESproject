package com.ems.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnergyPoint {
    private Integer id; //编号
    private String name; // 检测点名称
    private String address; // 检测点地址
    private Integer realTimePower; // 实时功率
    private Integer realTimeVoltage; // 实时电压
    private String status; // 状态
    private String remark; // 备注
    private LocalDateTime applyTime; //上报时间
}