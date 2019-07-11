package com.example.mongodb.common.mongo;

import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Map;

public class CriteriaUitl {

    /**
     *  拼装过滤条件
     * @param parameter
     * @return
     */
    public static Criteria buildCriteria(Map<String, Object> parameter){
        Criteria criteria = null;
        for (Map.Entry<String, Object> entry : parameter.entrySet()){
            if (criteria == null){
                criteria = Criteria.where(entry.getKey()).is(entry.getValue());
            }else {
                criteria.and(entry.getKey()).is(entry.getValue());
            }
        }
        return criteria;
    }
}
