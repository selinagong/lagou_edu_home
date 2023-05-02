package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;


public interface PromotionAdMapper {

    //分页获取所有的广告列表
    public List<PromotionAd> findAllPromotionAdByPage();

    // 图片上传

    // 新建广告

    // 修改广告

    // 回显广告信息

    // 广告状态上下线
}
