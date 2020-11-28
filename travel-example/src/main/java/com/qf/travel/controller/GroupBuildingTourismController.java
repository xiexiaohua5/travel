package com.qf.travel.controller;

import com.github.pagehelper.PageInfo;
import com.qf.travel.commons.po.GroupBuildingTourismPo;
import com.qf.travel.commons.result.BaseResultEntity;
import com.qf.travel.commons.vo.GroupBuildingTourismVo;
import com.qf.travel.service.GroupBuildingTourismService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/travel")
public class GroupBuildingTourismController {
    @Resource
    GroupBuildingTourismService gbtService;

    /**
     * 根据传进来的参数进行查询，出来的结果有每种状态的条数
     * @return
     */
    @PostMapping("/select")
    public BaseResultEntity<PageInfo<GroupBuildingTourismVo>> selectTravel(@RequestBody GroupBuildingTourismPo gbtPo){
        BaseResultEntity<PageInfo<GroupBuildingTourismVo>> entity = gbtService.selectGroup(gbtPo);
        return entity;
    }

    /**
     * 展示每个状态的数量
     * @return
     */
    @GetMapping("/type")
    public BaseResultEntity<List<GroupBuildingTourismVo>> selectTypeNum(){
        BaseResultEntity<List<GroupBuildingTourismVo>> entity = gbtService.selectTypeNum();
        return entity;
    }
}
