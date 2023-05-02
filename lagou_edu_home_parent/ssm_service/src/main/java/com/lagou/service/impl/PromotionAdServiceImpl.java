package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper adMapper;

    @Override
    public PageInfo findAllPromotionAdByPage(PromotionAdVO adVO) {
        PageHelper.startPage(adVO.getCurrentPage(),adVO.getPageSize());
        List<PromotionAd> allAd = adMapper.findAllPromotionAdByPage();
        return new PageInfo<>(allAd);
    }
}
