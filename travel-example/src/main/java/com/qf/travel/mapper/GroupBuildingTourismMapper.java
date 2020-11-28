package com.qf.travel.mapper;

import com.qf.travel.commons.po.GroupBuildingTourismPo;
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
    int selectTypeNum(@Param("type") String type);

    /**
     * 根据id修改状态
     * @param id
     * @return
     */
    int updateTypeById(@Param("id") Long id, @Param("type") String type);

    /**
     * 通过id找到记录
     * @param id
     * @return
     */
    GroupBuildingTourism selectById(@Param("id") Long id);
}