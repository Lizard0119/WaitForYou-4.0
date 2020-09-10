package com.qy.service.impl;

import com.qy.pojo.*;
import com.qy.service.SearchCompanyService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SearchCompanyServiceImpl implements SearchCompanyService {

    @Autowired
    RestHighLevelClient client;

    //根据公司名进行查询
    @Override
    public BaseResp searchByCompanyName(String index) throws IOException {
        SearchRequest searchRequest = new SearchRequest("wfy-province2city2company");
        searchRequest.types("doc");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(index, "companyname", "companyshortname").field("companyshortname", 5));

        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest);

        SearchHits hits = search.getHits();

        SearchHit[] hits1 = hits.getHits();

        List list = new ArrayList();
        for (SearchHit his : hits1
        ) {
            Company company = new Company();
            Business business = new Business();
            Province province = new Province();
            City city = new City();
            Map<String, Object> sourceAsMap = his.getSourceAsMap();

            company.setCompanyName((String) sourceAsMap.get("companyname"));
            company.setCompanyShortName((String) sourceAsMap.get("companyshortname"));
            //公司规模（默认0）0不限/1（0-20）/2（20-99）/3（100-499）/4（500-999）/5（1000-9999）/6（10000+）
            company.setCompanyScale((Integer) sourceAsMap.get("companyscale"));
            //融资阶段（默认0）0不限/1未融资/2天使轮/3A轮/4B轮/5C轮/6D轮及以上/7已上市/8不需要融资
            company.setCompanyFinancing((Integer) sourceAsMap.get("companyfinancing"));

            province.setProvinceName((String) sourceAsMap.get("province"));

            city.setCityName((String) sourceAsMap.get("city"));

            business.setBusinessName((String) sourceAsMap.get("businessname"));

            list.add(company);
            list.add(business);
            list.add(province);
            list.add(city);

        }

        BaseResp baseResp = new BaseResp();

        baseResp.setList(list);
        baseResp.setTotal(hits.getTotalHits());
        baseResp.setMessage("查询成功");
        baseResp.setCode(200);

        return baseResp;
    }

    //根据省份进行查询
    @Override
    public BaseResp searchCompanByProvince(String index) throws IOException {
        SearchRequest searchRequest = new SearchRequest("wfy-province2city2company");
        searchRequest.types("doc");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(index, "province"));

        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest);

        SearchHits hits = search.getHits();

        SearchHit[] hits1 = hits.getHits();

        List list = new ArrayList();
        for (SearchHit his : hits1
        ) {
            Company company = new Company();
            Business business = new Business();
            Province province = new Province();
            City city = new City();
            Map<String, Object> sourceAsMap = his.getSourceAsMap();

            company.setCompanyName((String) sourceAsMap.get("companyname"));
            company.setCompanyShortName((String) sourceAsMap.get("companyshortname"));
            //公司规模（默认0）0不限/1（0-20）/2（20-99）/3（100-499）/4（500-999）/5（1000-9999）/6（10000+）
            company.setCompanyScale((Integer) sourceAsMap.get("companyscale"));
            //融资阶段（默认0）0不限/1未融资/2天使轮/3A轮/4B轮/5C轮/6D轮及以上/7已上市/8不需要融资
            company.setCompanyFinancing((Integer) sourceAsMap.get("companyfinancing"));

            province.setProvinceName((String) sourceAsMap.get("province"));

            city.setCityName((String) sourceAsMap.get("city"));

            business.setBusinessName((String) sourceAsMap.get("businessname"));

            list.add(company);
            list.add(business);
            list.add(province);
            list.add(city);

        }

        BaseResp baseResp = new BaseResp();

        baseResp.setList(list);
        baseResp.setTotal(hits.getTotalHits());
        baseResp.setMessage("查询成功");
        baseResp.setCode(200);

        return baseResp;
    }

    //根据市进行查询
    @Override
    public BaseResp searchCompanByCity(String index) throws IOException {
        SearchRequest searchRequest = new SearchRequest("wfy-province2city2company");
        searchRequest.types("doc");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(index, "city"));

        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest);

        SearchHits hits = search.getHits();

        SearchHit[] hits1 = hits.getHits();

        List list = new ArrayList();
        for (SearchHit his : hits1
        ) {
            Company company = new Company();
            Business business = new Business();
            Province province = new Province();
            City city = new City();
            Map<String, Object> sourceAsMap = his.getSourceAsMap();

            company.setCompanyName((String) sourceAsMap.get("companyname"));
            company.setCompanyShortName((String) sourceAsMap.get("companyshortname"));
            //公司规模（默认0）0不限/1（0-20）/2（20-99）/3（100-499）/4（500-999）/5（1000-9999）/6（10000+）
            company.setCompanyScale((Integer) sourceAsMap.get("companyscale"));
            //融资阶段（默认0）0不限/1未融资/2天使轮/3A轮/4B轮/5C轮/6D轮及以上/7已上市/8不需要融资
            company.setCompanyFinancing((Integer) sourceAsMap.get("companyfinancing"));

            province.setProvinceName((String) sourceAsMap.get("province"));

            city.setCityName((String) sourceAsMap.get("city"));

            business.setBusinessName((String) sourceAsMap.get("businessname"));

            list.add(company);
            list.add(business);
            list.add(province);
            list.add(city);

        }

        BaseResp baseResp = new BaseResp();

        baseResp.setList(list);
        baseResp.setTotal(hits.getTotalHits());
        baseResp.setMessage("查询成功");
        baseResp.setCode(200);

        return baseResp;
    }
}
