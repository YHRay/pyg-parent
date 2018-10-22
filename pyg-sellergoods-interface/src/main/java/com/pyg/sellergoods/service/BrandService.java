package com.pyg.sellergoods.service;

import java.util.List;

import com.pyg.pojo.TbBrand;

/*
 * 品牌服务层的接口
 */
public interface BrandService {
	/*
	 * 返回全部列表
	 */
	public List<TbBrand> findAll();
}
