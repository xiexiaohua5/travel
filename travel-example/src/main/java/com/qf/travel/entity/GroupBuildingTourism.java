package com.qf.travel.entity;

import java.util.Date;
import lombok.Data;

/**
    * 旅游团建表
    */
@Data
public class GroupBuildingTourism {
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
    * 过期时间
    */
    private Date expiryTime;

    /**
    * 价格
    */
    private Double price;

    /**
    * 预览
    */
    private String preview;

    /**
    * 更新人
    */
    private String updatePeople;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 排序标签
    */
    private String sortLabel;

    /**
    * 分数
    */
    private Double grade;

    /**
    * 点击
    */
    private Long click;

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
}