package com.qf.travel.service;

import com.github.pagehelper.PageInfo;
import com.qf.travel.commons.dto.GroupBuildingTourismDto;
import com.qf.travel.commons.result.BaseResultEntity;
import com.qf.travel.commons.vo.GroupBuildingTourismVo;

import java.util.List;

public interface GroupBuildingTourismService {
    BaseResultEntity<PageInfo<GroupBuildingTourismVo>> selectGroup(GroupBuildingTourismDto gbtDto);

    BaseResultEntity<List<GroupBuildingTourismVo>> selectTypeNum();

    BaseResultEntity<Integer> updateType(long id, String type);
}
