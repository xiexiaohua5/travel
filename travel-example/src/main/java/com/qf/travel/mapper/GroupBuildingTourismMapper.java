package com.qf.travel.mapper;

import com.qf.travel.entity.GroupBuildingTourism;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupBuildingTourismMapper {
    int deleteByPrimaryKey(Long groupId);

    int insert(GroupBuildingTourism record);

    int insertSelective(GroupBuildingTourism record);

    GroupBuildingTourism selectByPrimaryKey(Long groupId);

    int updateByPrimaryKeySelective(GroupBuildingTourism record);

    int updateByPrimaryKey(GroupBuildingTourism record);

    /**
     * 通过各种条件进行筛选，有模糊查询
     * @param gbt
     * @return
     */
    List<GroupBuildingTourism> selectByParams(@Param("gbt") GroupBuildingTourism gbt);

    /**
     * 计算出各个状态的数量
     *
     * @return
     */
    List<GroupBuildingTourism> selectTypeNum();
}