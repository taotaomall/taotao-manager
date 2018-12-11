package com.taotao.controller;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类管理
 * Author: zhihu
 * Description:
 * Date: Create in 0:06 2018/2/8
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

        @Autowired
        private ContentCategoryService contentCategoryService;

        @RequestMapping("/list")
        @ResponseBody
        public List<EUTreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
                List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
                return list;
        }

        @RequestMapping("/create")
        @ResponseBody
        public TaotaoResult createContentCategory(Long parentId, String name) {
                TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
                return result;
        }

        @RequestMapping("/delete")
        @ResponseBody
        public TaotaoResult deleteContentCategory(Long parentId, Long id) {
                TaotaoResult result = contentCategoryService.deleteContentCategory(id);
                return result;
        }

        @RequestMapping("/update")
        @ResponseBody
        public TaotaoResult updateContentCategory(Long id, String name) {
                TaotaoResult result = contentCategoryService.updateContentCategory(id, name);
                return result;
        }
}

