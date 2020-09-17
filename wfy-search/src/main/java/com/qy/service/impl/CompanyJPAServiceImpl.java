package com.qy.service.impl;

import com.netflix.discovery.converters.Auto;
import com.qy.pojo.CompanyJPA;
import com.qy.pojo.MapJPA;
import com.qy.pojo.search.BaseResp;
import com.qy.pojo.search.JobSecond;
import com.qy.repository.CompanyRepository;
import com.qy.repository.MapJPARepository;
import com.qy.service.CompanyJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyJPAServiceImpl implements CompanyJPAService {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    MapJPARepository mapJPARepository;

    @Override
    public MapJPA findMapByCompanyId(Integer id) {
        Optional<MapJPA> byId = mapJPARepository.findById(id);
        if (byId.isPresent()) {
            MapJPA mapJPA = byId.get();
            return mapJPA;
        }
        return null;
    }

    @Override
    public CompanyJPA findAllById(Integer id) {
        Optional<CompanyJPA> byId = companyRepository.findById(id);
        if (byId.isPresent()) {
            CompanyJPA companyJPA = byId.get();
            return companyJPA;
        }
        return null;
    }

    @Override
    public BaseResp findAllCompany(Integer page, Integer size) {
        Boolean companyList = redisTemplate.hasKey("CompanyList");
        List companyList1 = new ArrayList();
        BaseResp baseResp = new BaseResp();
        Integer start = (page - 1) * size;
        Long total;
        if (companyList) {
            System.out.println("从redis中进行获取");
            companyList1 = redisTemplate.opsForList().range("CompanyList", start, start + size);
            total = redisTemplate.opsForList().size("CompanyList");

            baseResp.setList(companyList1);
            baseResp.setTotal(total);
            return baseResp;
        } else {
            System.out.println("从数据库查询数据");

            List<CompanyJPA> all = companyRepository.findAll();
            for (CompanyJPA c : all
            ) {
                redisTemplate.opsForList().rightPush("CompanyList", c);
            }
            companyList1 = redisTemplate.opsForList().range("CompanyList", start, start + size);
            total = redisTemplate.opsForList().size("CompanyList");
            //设置过期时间为30min
//            redisTemplate.expire("secondList",30, TimeUnit.MINUTES);
            baseResp.setList(companyList1);
            baseResp.setTotal(total);
            return baseResp;
        }
    }


}
