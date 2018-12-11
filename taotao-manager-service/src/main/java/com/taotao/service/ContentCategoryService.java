package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * Author: zhihu
 * Description:
 * Date: Create in 19:50 2018/2/6
 */
public interface ContentCategoryService {
        List<EUTreeNode> getCategoryList(long parentId);

        TaotaoResult insertContentCategory(long parentId, String name);

        TaotaoResult deleteContentCategory(long id);

        TaotaoResult updateContentCategory(long id, String name);
}
