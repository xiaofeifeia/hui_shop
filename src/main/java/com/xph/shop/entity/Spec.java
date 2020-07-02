package com.xph.shop.entity;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;

import lombok.Data;
/**
 * @Author:xph
 * @Description:Spec构建
 */
@Table(name="tb_spec")
@Data
public class Spec implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//ID

    @Column(name = "name")
	private String name;//名称

    @Column(name = "options")
	private String options;//规格选项

    @Column(name = "seq")
	private Integer seq;//排序

    @Column(name = "template_id")
	private Integer templateId;//模板ID

    @Column(name = "createdate")
	private Date createdate;//创建时间

    @Column(name = "updatedate")
	private Date updatedate;//更新时间

}
