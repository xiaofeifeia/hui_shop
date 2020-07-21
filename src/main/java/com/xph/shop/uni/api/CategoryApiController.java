package com.xph.shop.uni.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xph.shop.service.CategoryService;
import com.xph.shop.vo.CategoryTree;
import com.xph.shop.vo.Result;

@CrossOrigin
@RestController
@RequestMapping("api/category")
public class CategoryApiController {
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("getCategoryTree")
	public Result list(){
		List<CategoryTree> tree=categoryService.getCategoryTree();
		return Result.build(tree);
	}
}
