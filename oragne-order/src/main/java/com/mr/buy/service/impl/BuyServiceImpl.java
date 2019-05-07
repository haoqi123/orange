package com.mr.buy.service.impl;

import com.mr.buy.mapper.BuyMapper;
import com.mr.buy.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by FHJ on 2019/5/7.
 *
 */
@Service
public class BuyServiceImpl implements BuyService{
    @Autowired
    private BuyMapper buyMapper;
}
