package com.pyg.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pyg.mapper.TbBrandMapper;
import com.pyg.pojo.TbBrand;
import com.pyg.pojo.TbBrandExample;
import com.pyg.pojo.TbBrandExample.Criteria;
import com.pyg.sellergoods.service.BrandService;

import entity.PageResult;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	@Override
	public List<TbBrand> findAll() {
		
		return brandMapper.selectByExample(null);
	}

	@Override
	/**
	 * 分页
	 */
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}
	//新增
	@Override
	public void add(TbBrand tbBrand) {
		String firstChar = tbBrand.getFirstChar().toUpperCase();;
		tbBrand.setFirstChar(firstChar);
		brandMapper.insert(tbBrand);
	}
	//修改
	@Override
	public void update(TbBrand tbBrand) {
		String firstChar = tbBrand.getFirstChar().toUpperCase();;
		tbBrand.setFirstChar(firstChar);
		brandMapper.updateByPrimaryKey(tbBrand);
	}
	//根据ID查找
	@Override
	public TbBrand findOne(Long id) {
		
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id:ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
	}
	/**
	 * 搜索
	 */
	@Override
	public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbBrandExample example = new TbBrandExample();
		if(tbBrand != null) {
			Criteria criteria = example.createCriteria();
			if(tbBrand.getName()!=null&&tbBrand.getName().length()>0) {
				criteria.andNameLike("%"+tbBrand.getName()+"%");
			}
			if(tbBrand.getFirstChar()!=null&&tbBrand.getFirstChar().length()>0) {
				criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
			}
		}
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> selectOptionList() {
		
		return brandMapper.selectOptionList();
	}

}
