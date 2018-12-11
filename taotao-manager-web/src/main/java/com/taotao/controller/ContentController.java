package com.taotao.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理Controller
 * Author: zhihu
 * Description:
 * Date: Create in 0:05 2018/2/8
 */
@Controller
@RequestMapping("/content")
public class ContentController {

        @Autowired
        private ContentService contentService;

        @RequestMapping("/save")
        @ResponseBody
        public TaotaoResult insertContent(TbContent content) {
                TaotaoResult result = contentService.insertContent(content);
                return result;
        }
}

