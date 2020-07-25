package com.xph.shop.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * @Author:xph
 * @Description:Dict构建
 */
@Data
@Table(name="tb_dict")
public class Dict implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

    @Column(name = "dict_code")
	private String dictCode;//

    @Column(name = "dict_value")
	private String dictValue;//

    @Column(name = "createdate")
	private Date createdate;//

    @Column(name = "updatedate")
	private Date updatedate;//

}
