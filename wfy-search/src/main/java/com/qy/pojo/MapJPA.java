package com.qy.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_map")
public class MapJPA {
    @Id
    @Column(name = "companyid")
    private Integer companyId;
    private String lng;
    private String lat;
}
