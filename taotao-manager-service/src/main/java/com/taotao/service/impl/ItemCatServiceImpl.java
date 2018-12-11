package com.taotao.service.impl;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理
 * Author: zhihu
 * Description:
 * Date: Create in 22:29 2018/2/5
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
        @Autowired
        private TbItemCatMapper itemCatMapper;

        @Override
        public List<EUTreeNode> getCatList(long parentId) {
                // 创建查询条件
                TbItemCatExample example = new TbItemCatExample();
                TbItemCatExample.Criteria criteria = example.createCriteria();
                criteria.andParentIdEqualTo(parentId);
                // 根据条件查询
                List<TbItemCat> list = itemCatMapper.selectByExample(example);
                List<EUTreeNode> resultList = new ArrayList<>();
                // 把列表转换成treeNodeList
                for (TbItemCat tbItemCat : list) {
                        EUTreeNode node = new EUTreeNode();
                        node.setId(tbItemCat.getId());
                        node.setText(tbItemCat.getName());
                        node.setState(tbItemCat.getIsParent() ? "closed" : "open");
                        resultList.add(node);
                }
                //返回结果
                return resultList;
        }
}
