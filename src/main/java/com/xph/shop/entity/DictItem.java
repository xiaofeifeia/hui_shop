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
 * @Description:DictItem构建
 */
@Data
@Table(name="tb_dict_item")
public class DictItem implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dict_item_id")
	private Integer dictItemId;//

    @Column(name = "dict_id")
	private Integer dictId;//字典id

    @Column(name = "dict_item_code")
	private String dictItemCode;//

    @Column(name = "dict_item_value")
	private String dictItemValue;//字典值名称

    @Column(name = "sort")
	private Integer sort;//排序字段

    @Column(name = "createdate")
	private Date createdate;//

    @Column(name = "updatedate")
	private Date updatedate;//

}
