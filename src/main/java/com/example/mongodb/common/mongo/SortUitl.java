package com.example.mongodb.common.mongo;

import org.springframework.data.domain.Sort;

public class SortUitl {

    /**
     * 根据某个字段升序排序
     *
     * @param property
     * @return
     */
    public static Sort asc(String property) {
        return Sort.by(Sort.Direction.ASC, property);
    }

    /**
     * 根据指定的字段升序排序
     *
     * @param propertys
     * @return
     */
    public static Sort asc(String... propertys) {
        return Sort.by(Sort.Direction.ASC, propertys);
    }

    /**
     * 根据某个字段降序排序
     *
     * @param property
     * @return
     */
    public static Sort desc(String property) {
        return Sort.by(Sort.Direction.DESC, property);
    }

    /**
     * 根据指定的字段降序排序
     *
     * @param propertys
     * @return
     */
    public static Sort desc(String... propertys) {
        return Sort.by(Sort.Direction.DESC, propertys);
    }
}
