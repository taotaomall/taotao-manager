package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Author: zhihu
 * Description:
 * Date: Create in 18:37 2018/2/5
 */
public interface ItemService {
        TbItem getItemById(long itemId);
        EUDataGridResult getItemList(int page, int rows);
        TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
