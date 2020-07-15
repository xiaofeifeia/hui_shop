package com.xph.shop.config;

import java.util.List;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.CanalEntry.Column;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.DeleteListenPoint;
import com.xpand.starter.canal.annotation.InsertListenPoint;
import com.xpand.starter.canal.annotation.UpdateListenPoint;

@CanalEventListener
public class CanalListener {
	
	
	@InsertListenPoint
	public void onEvent(CanalEntry.EventType eventType,CanalEntry.RowData rowData){
		List<Column> afterColumnsList = rowData.getAfterColumnsList();
		for(Column c:afterColumnsList){
			System.out.println(c.getName()+"--"+c.getValue());
		}
	}

	@UpdateListenPoint
    public void onEvent1(CanalEntry.RowData rowData) {
		List<Column> afterColumnsList = rowData.getAfterColumnsList();
		for(Column c:afterColumnsList){
			System.out.println(c.getName()+"--"+c.getValue());
		}
    }

    @DeleteListenPoint
    public void onEvent3(CanalEntry.EventType eventType,CanalEntry.RowData rowData) {
    	List<Column> afterColumnsList = rowData.getBeforeColumnsList();
		for(Column c:afterColumnsList){
			System.out.println(c.getName()+"--"+c.getValue());
		}
    }

	/**
	 * @param eventType
	 * @param rowData
	 *//*
	@ListenPoint(destination = "sku info", schema = "changgou_content", table = { "tb_content" }, eventType = {
			CanalEntry.EventType.UPDATE, CanalEntry.EventType.INSERT,
			CanalEntry.EventType.DELETE })
	public void onEventCustomUpdate(CanalEntry.EventType eventType,
			CanalEntry.RowData rowData) {
		// 1.获取到被修改的category_id
		String categoryId = getColumnValue(eventType, rowData);

		// 2.调用feign 获取数据
	}

	private String getColumnValue(CanalEntry.EventType eventType,
			CanalEntry.RowData rowData) {
		// 1.判断更改类型 如果是删除 则需要获取到before的数据
		String categoryId = "";
		if (CanalEntry.EventType.DELETE == eventType) {
			List<CanalEntry.Column> beforeColumnsList = rowData
					.getBeforeColumnsList();
			for (CanalEntry.Column column : beforeColumnsList) {
				// column.getName(列的名称 column.getValue() 列对应的值
				if (column.getName().equals("category_id")) {
					categoryId = column.getValue();
					return categoryId;
				}
			}
		} else {
			// 2判断是 更新 新增 获取after的数据
			List<CanalEntry.Column> beforeColumnsList = rowData
					.getAfterColumnsList();
			for (CanalEntry.Column column : beforeColumnsList) {
				// column.getName(列的名称 column.getValue() 列对应的值
				if (column.getName().equals("category_id")) {
					categoryId = column.getValue();
					return categoryId;
				}
			}
		}
		// 3.返回
		return categoryId;
	}

	// 监听商品数据库的spu的表的数据的变化,变了,调用feign 生成静态页就可以了

	@ListenPoint(destination = "example", schema = "changgou_goods", table = { "tb_spu" }, eventType = {
			CanalEntry.EventType.UPDATE, CanalEntry.EventType.INSERT,
			CanalEntry.EventType.DELETE })
	public void onEventCustomSpu(CanalEntry.EventType eventType,
			CanalEntry.RowData rowData) {

		// 判断操作类型
		if (eventType == CanalEntry.EventType.DELETE) {
			String spuId = "";
			List<CanalEntry.Column> beforeColumnsList = rowData
					.getBeforeColumnsList();
			for (CanalEntry.Column column : beforeColumnsList) {
				if (column.getName().equals("id")) {
					spuId = column.getValue();// spuid
					break;
				}
			}
			// todo 删除静态页

		} else {
			// 新增 或者 更新
			List<CanalEntry.Column> afterColumnsList = rowData
					.getAfterColumnsList();
			String spuId = "";
			for (CanalEntry.Column column : afterColumnsList) {
				if (column.getName().equals("id")) {
					spuId = column.getValue();
					break;
				}
			}
		}
	}*/
}
