package com.pyg.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyg.pojo.TbBrand;
import com.pyg.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Reference
	private BrandService brandService;
	
	/*
	 * 返回全部列表
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}
	/*
	 * 分页
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page,int rows) {
		return brandService.findPage(page, rows);
	}
	/*
	 * 增加
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand tbBrand) {
		try {
			brandService.add(tbBrand);
			return new Result(true, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "新增失败");
		}
	}
	/*
	 * 修改
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand tbBrand) {
		try {
			brandService.update(tbBrand);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}
	/*
	 * 获取实体
	 */
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return brandService.findOne(id);
	}
	/*
	 * 修改
	 */
	@RequestMapping("/delete")
	public Result delete(Long[] ids) {
		try {
			brandService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand,int page,int rows) {
		return brandService.findPage(tbBrand, page, rows);
	}

}
