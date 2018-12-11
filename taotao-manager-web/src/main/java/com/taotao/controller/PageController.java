package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: zhihu
 * Description:
 * Date: Create in 19:46 2018/2/5
 */
@Controller
public class PageController {

        /**
         * 打开首页
         */
        @RequestMapping("/")
        public String showIndex() {
                return "index";
        }

        /**
         * 展示其他页面
         */
        @RequestMapping("/{page}")
        public String showpage(@PathVariable String page) {
                return page;
        }
}
