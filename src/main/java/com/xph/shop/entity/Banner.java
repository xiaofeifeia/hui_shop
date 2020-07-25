package com.xph.shop.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * @Author:xph
 * @Description:Banner构建
 */
@Data
@Table(name="tb_banner")
public class Banner implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

    @Column(name = "title")
	private String title;//

    @Column(name = "url")
	private String url;//

    @Column(name = "image")
	private String image;//

    @Column(name = "sort")
	private Integer sort;//
    
    @Column(name = "type")
	private Integer type;//类型  0  轮播图，1 new新品  2 recommend推荐  3 hot热门

}
