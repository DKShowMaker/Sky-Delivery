package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类相关接口")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */

    @PostMapping
    @ApiOperation("新增分类")
    public Result addCategory(CategoryDTO categoryDTO){

        log.info("新增分类：{}",categoryDTO);
        categoryService.addCategory(categoryDTO);
        return Result.success();
    }

    /**
     * 分类分页查询
     * @return
     */
    @ApiOperation("分类分页查询")
    @GetMapping("/page")
    public Result<PageResult> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分类分页查询参数：{}",categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @ApiOperation("删除分类")
    @DeleteMapping
    public Result deleteCategory(String id) {
        log.info("删除分类id：{}", id);
        categoryService.deleteCategory(id);
        return Result.success();
    }
}
