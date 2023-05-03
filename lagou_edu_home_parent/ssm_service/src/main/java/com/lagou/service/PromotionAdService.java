package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;


public interface PromotionAdService {

    //分页获取所有的广告列表
    public PageInfo findAllPromotionAdByPage(PromotionAdVO adVO);

    // 新建广告
    public void savePromotionAd(PromotionAd promotionAd);

    // 修改广告
    public void updatePromotionAd(PromotionAd promotionAd);
}
