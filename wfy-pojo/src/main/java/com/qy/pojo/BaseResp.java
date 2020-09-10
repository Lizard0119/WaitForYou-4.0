package com.qy.pojo;

import lombok.Data;

import java.util.List;

/**
 * wwh
 * 2020/9/9
 */
@Data
public class BaseResp<T> {

    private List<T> list;

    private Long total;

    private String message;

    private Integer code;

}
