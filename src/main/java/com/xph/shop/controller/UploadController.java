package com.xph.shop.controller;

import java.io.File;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.xph.shop.utils.Constants;
import com.xph.shop.vo.Result;
import com.xph.shop.vo.StatusCode;

@RestController
@Slf4j
@CrossOrigin
public class UploadController {

	@Value("${upload.file.path}")
	private String filePath;
	
	private static String path="/images";

	@PostMapping("/upload")
	public Result upload(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			log.error(StatusCode.UPLOAD_FILE_EMPTY.getMessage());
			return Result.error(StatusCode.UPLOAD_FILE_EMPTY);
		}

		String fileName = file.getOriginalFilename();
		String basePath = filePath + "/" + Constants.uuid + "/";
		String showPath = path + "/" + Constants.uuid + "/";
		if (!new File(basePath).exists()) {
			new File(basePath).mkdirs();
		}
		File dest = new File(basePath + fileName);
		try {
			file.transferTo(dest);
			log.info("上传成功");
			JSONObject data = new JSONObject();
			data.put("name", fileName);
			data.put("url", showPath + fileName);
			return Result.build(data);
		} catch (IOException e) {
			log.error(StatusCode.UPLOAD_FAIL.getMessage(), e);
		}
		return Result.error(StatusCode.UPLOAD_FAIL);
	}
}
