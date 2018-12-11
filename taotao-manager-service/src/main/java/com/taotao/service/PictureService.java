package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Author: zhihu
 * Description:
 * Date: Create in 19:15 2018/2/6
 */
public interface PictureService {
        Map uploadPicture(MultipartFile uploadFile);
}
