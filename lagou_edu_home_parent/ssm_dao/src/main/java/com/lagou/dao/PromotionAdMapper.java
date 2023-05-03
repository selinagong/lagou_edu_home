package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;


public interface PromotionAdMapper {

    //分页获取所有的广告列表
    public List<PromotionAd> findAllPromotionAdByPage();

    // 新建广告
    public void savePromotionAd(PromotionAd promotionAd);

    // 修改广告
    public void updatePromotionAd(PromotionAd promotionAd);

    // 回显广告信息

    // 广告状态上下线
}
