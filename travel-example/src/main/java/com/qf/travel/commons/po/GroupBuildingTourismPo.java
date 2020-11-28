package com.qf.travel.commons.po;

import lombok.Data;

@Data
public class GroupBuildingTourismPo {
    private Long groupId;

    /**
     * 0表示上架中，1表示待下架，2表示仓库中，3表示草稿箱，4表示回收站
     */
    private Integer state;

    /**
     * 0表示团建旅游，1表示拓展团建，2表示常规旅游，3表示奖励旅游
     */
    private String type;

    /**
     * 主要景点
     */
    private String attractions;

    /**
     * 路线名称
     */
    private String route;

    /**
     * 价格
     */
    private Double price;

    /**
     * 更新人
     */
    private String updatePeople;

    /**
     * 排序标签
     */
    private String sortLabel;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 出发地
     */
    private String departurePlace;

    /**
     * 主题
     */
    private String theme;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 当前页展示条数
     */
    private Integer size;
}
