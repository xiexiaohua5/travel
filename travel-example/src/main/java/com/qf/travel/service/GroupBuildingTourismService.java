package com.qf.travel.service;

import com.github.pagehelper.PageInfo;
import com.qf.travel.commons.po.GroupBuildingTourismPo;
import com.qf.travel.commons.result.BaseResultEntity;
import com.qf.travel.commons.vo.GroupBuildingTourismVo;

import java.util.List;

public interface GroupBuildingTourismService {
    BaseResultEntity<PageInfo<GroupBuildingTourismVo>> selectGroup(GroupBuildingTourismPo gbtp);

    BaseResultEntity<List<GroupBuildingTourismVo>> selectTypeNum();

    public BaseResultEntity<Integer> updateType(long id, String type);
}
