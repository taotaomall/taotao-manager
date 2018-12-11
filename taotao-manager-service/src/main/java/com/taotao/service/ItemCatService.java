package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;

import java.util.List;

/**
 * Author: zhihu
 * Description:
 * Date: Create in 22:27 2018/2/5
 */
public interface ItemCatService {
        List<EUTreeNode> getCatList(long parentId);
}
