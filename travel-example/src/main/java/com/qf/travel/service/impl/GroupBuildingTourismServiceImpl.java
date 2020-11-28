package com.qf.travel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.travel.commons.exception.ServiceException;
import com.qf.travel.commons.dto.GroupBuildingTourismDto;
import com.qf.travel.commons.po.GroupBuildingTourismPo;
import com.qf.travel.commons.result.BaseResultEntity;
import com.qf.travel.commons.result.ResultCodeEnum;
import com.qf.travel.commons.utils.ColaBeanUtils;
import com.qf.travel.commons.vo.GroupBuildingTourismVo;
import com.qf.travel.entity.GroupBuildingTourism;
import com.qf.travel.mapper.GroupBuildingTourismMapper;
import com.qf.travel.service.GroupBuildingTourismService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroupBuildingTourismServiceImpl implements GroupBuildingTourismService {
    @Resource
    GroupBuildingTourismMapper gbtMapper;

    @Override
    public BaseResultEntity<PageInfo<GroupBuildingTourismVo>> selectGroup(GroupBuildingTourismDto gbtDto) {
        List<GroupBuildingTourism> groups = null;
        BaseResultEntity<PageInfo<GroupBuildingTourismVo>> success = null;
        try {
            GroupBuildingTourism tourism = new GroupBuildingTourism();
            //把传入对象的值赋给实体类
            BeanUtils.copyProperties(gbtDto,tourism);
            // 开启分页插件,放在查询语句上面,帮助生成分页语句
            PageHelper.startPage(gbtDto.getCurrentPage(), gbtDto.getSize());
            //根据条件从数据库查找数据
            groups = gbtMapper.selectByParams(tourism);
            if (groups != null){
                //两个list之间进行交换
                List<GroupBuildingTourismVo> voList = ColaBeanUtils.copyListProperties(groups, GroupBuildingTourismVo::new);
                // 封装分页之后的数据,返回给客户端展示,PageInfo做了一些封装,作为一个类
                PageInfo<GroupBuildingTourismVo> pageInfo = new PageInfo<>(voList);
                //返回统一的结果集
                success = BaseResultEntity.success(pageInfo);
            }else {
                throw new ServiceException(ResultCodeEnum.SYSTEM_INNER_ERROR);
            }
        }catch (Exception e){
            throw new ServiceException(ResultCodeEnum.ERROR);
        }
        return success;
    }

    public BaseResultEntity<List<GroupBuildingTourismVo>> selectTypeNum(){
        BaseResultEntity<List<GroupBuildingTourismVo>> success = null;
        try {
            //从库中查到该有的数量
            int i0 = gbtMapper.selectTypeNum("0");
            int i1 = gbtMapper.selectTypeNum("1");
            int i2 = gbtMapper.selectTypeNum("2");
            int i3 = gbtMapper.selectTypeNum("3");
            ArrayList<GroupBuildingTourismPo> list = new ArrayList<>();
            list.add(new GroupBuildingTourismPo("0",i0));
            list.add(new GroupBuildingTourismPo("1",i1));
            list.add(new GroupBuildingTourismPo("2",i2));
            list.add(new GroupBuildingTourismPo("3",i3));
            //把值赋给vo
            List<GroupBuildingTourismVo> voList = ColaBeanUtils.copyListProperties(list, GroupBuildingTourismVo::new);
            //返回统一的结果集
            success = BaseResultEntity.success(voList);
        }catch (Exception e){
            throw new ServiceException(ResultCodeEnum.ERROR);
        }
        return success;
    }

    public BaseResultEntity<Integer> updateType(long id, String type){
        GroupBuildingTourism selectById = null;
        BaseResultEntity<Integer> success = null;
        try {
            //先判断商品是否存在，不存在则提示错误信息
            selectById = gbtMapper.selectById(id);
            if (selectById != null){
                //修改商品的状态
                int i = gbtMapper.updateTypeById(id, type);
                //修改成功则返回统一的结果集
                if (i > 0){
                    success = BaseResultEntity.success(i);
                }else {
                    throw new ServiceException(ResultCodeEnum.SYSTEM_INNER_ERROR);
                }
            }else {
                throw new ServiceException(ResultCodeEnum.SYSTEM_INNER_ERROR);
            }
        } catch (Exception e) {
            throw new ServiceException(ResultCodeEnum.ERROR);
        }
        return success;
    }

}
