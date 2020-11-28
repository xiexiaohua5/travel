package com.qf.travel.commons.po;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class GroupBuildingTourismPo {
    /**
     * 0表示团建旅游，1表示拓展团建，2表示常规旅游，3表示奖励旅游
     */
    private String type;

    /**
     * 展示的数量
     */
    private int num;
}
