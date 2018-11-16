package com.pyg.pojogroup;

import java.io.Serializable;
import java.util.List;

import com.pyg.pojo.TbGoods;
import com.pyg.pojo.TbGoodsDesc;
import com.pyg.pojo.TbItem;

/**
 * 商品组合实体类
 * @author ray
 *
 */
public class Goods implements Serializable{

	private TbGoods goods;//商品SPU
	private TbGoodsDesc goodsDesc;//商品扩展
	private List<TbItem> itemList;//商品SKU列表
	public TbGoods getGoods() {
		return goods;
	}
	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}
	public TbGoodsDesc getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(TbGoodsDesc goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public List<TbItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<TbItem> itemList) {
		this.itemList = itemList;
	}
	
}
