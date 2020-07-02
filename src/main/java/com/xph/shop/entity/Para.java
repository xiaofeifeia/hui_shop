package com.xph.shop.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:xph
 * @Description:Para构建
 */
@Table(name="tb_para")
public class Para implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//id

    @Column(name = "name")
	private String name;//名称

    @Column(name = "options")
	private String options;//选项

    @Column(name = "seq")
	private Integer seq;//排序

    @Column(name = "template_id")
	private Integer templateId;//模板ID

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
	public String getOptions() {
		return options;
	}

	//set方法
	public void setOptions(String options) {
		this.options = options;
	}
	//get方法
	public Integer getSeq() {
		return seq;
	}

	//set方法
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	//get方法
	public Integer getTemplateId() {
		return templateId;
	}

	//set方法
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
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
