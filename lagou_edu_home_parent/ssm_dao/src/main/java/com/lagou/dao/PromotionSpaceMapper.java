package com.lagou.dao;

import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceMapper {

    // 查询广告位列表
    public List<PromotionSpace> findAllPromotionSpace();

    // 添加广告位
    public void savePromotionSpace(PromotionSpace promotionSpace);

    // 修改广告位
    public void updatePromotionSpace(PromotionSpace promotionSpace);

    // 回显广告位名称

    // 广告分页查询

    // 图片上传

    // 新建广告

    // 修改广告

    // 回显广告信息

    // 广告状态上下线
}
