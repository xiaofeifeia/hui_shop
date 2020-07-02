package com.xph.shop.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:xph
 * @Description:Template构建
 */
@Table(name="tb_template")
public class Template implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//ID

    @Column(name = "name")
	private String name;//模板名称

    @Column(name = "spec_num")
	private Integer specNum;//规格数量

    @Column(name = "para_num")
	private Integer paraNum;//参数数量

    @Column(name = "createdate")
	private Date createdate;//创建时间

    @Column(name = "updatedate")
	private Date updatedate;//更新时间



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}
	//get方法
	public Integer getSpecNum() {
		return specNum;
	}

	//set方法
	public void setSpecNum(Integer specNum) {
		this.specNum = specNum;
	}
	//get方法
	public Integer getParaNum() {
		return paraNum;
	}

	//set方法
	public void setParaNum(Integer paraNum) {
		this.paraNum = paraNum;
	}
	//get方法
	public Date getCreatedate() {
		return createdate;
	}

	//set方法
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	//get方法
	public Date getUpdatedate() {
		return updatedate;
	}

	//set方法
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}


}
