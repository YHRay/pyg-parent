package com.pyg.sellergoods.service;

import java.util.List;

import com.pyg.pojo.TbBrand;

import entity.PageResult;

/*
 * 品牌服务层的接口
 */
public interface BrandService {
	/*
	 * 返回全部列表
	 */
	public List<TbBrand> findAll();
	/**
	 * 品牌分页
	 * @param pageNum 总记录数
	 * @param pageSize 当前页数据
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize) ;
	
	/*
	 * 增加品牌
	 */
	public void add(TbBrand tbBrand);
	/*
	 * 修改品牌
	 */
	public void update(TbBrand tbBrand);
	/*
	 * 通过id查找
	 */
	public TbBrand findOne(Long id);
	/*
	 * 批量删除品牌
	 */
	public void delete(Long[] ids);
	/**
	 * 搜索查询
	 * @param tbBrand
	 * @param pageNum 当前页
	 * @param pageSize 每页数量
	 * @return
	 */
	public PageResult findPage(TbBrand tbBrand,int pageNum,int pageSize);
	
}
