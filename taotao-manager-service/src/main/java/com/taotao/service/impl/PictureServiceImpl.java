package com.taotao.service.impl;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传服务
 * Author: zhihu
 * Description:
 * Date: Create in 19:16 2018/2/6
 */
@Service
public class PictureServiceImpl implements PictureService {

        // FTP服务器地址
        @Value("${FTP_ADDRESS}")
        private String FTP_ADDRESS;
        // FTP服务器端口
        @Value("${FTP_PORT}")
        private Integer FTP_PORT;
        // FTP服务器登录账号
        @Value("${FTP_USERNAME}")
        private String FTP_USERNAME;
        // FTP服务器登录密码
        @Value("${FTP_PASSWORD}")
        private String FTP_PASSWORD;
        // FTP服务器的基本访问目录路径
        @Value("${FTP_BASE_PATH}")
        private String FTP_BASE_PATH;
        // 图片服务器的基本http服务器的基本路径（这里采用nginx服务器）
        @Value("${IMAGE_BASE_URL}")
        private String IMAGE_BASE_URL;

        @Override
        public Map uploadPicture(MultipartFile uploadFile) {
                Map resultMap = new HashMap<>();
                try {
                        //生成一个新的文件名
                        //取原始文件名
                        String oldName = uploadFile.getOriginalFilename();
                        //生成新文件名
                        //UUID.randomUUID();
                        String newName = IDUtils.genImageName();
                        // 新文件名+原文件扩展名
                        newName = newName + oldName.substring(oldName.lastIndexOf("."));
                        //图片上传路径(以年月日生成图片存放路径:/年/月/日)
                        String imagePath = new DateTime().toString("/yyyy/MM/dd");
                        boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
                                FTP_BASE_PATH, imagePath, newName, uploadFile.getInputStream());
                        //返回结果
                        if(!result) {
                                resultMap.put("error", 1);
                                resultMap.put("message", "文件上传失败");
                                return resultMap;
                        }
                        resultMap.put("error", 0);
                        resultMap.put("url", IMAGE_BASE_URL + imagePath + "/" + newName);
                        return resultMap;

                } catch (Exception e) {
                        resultMap.put("error", 1);
                        resultMap.put("message", "文件上传发生异常");
                        return resultMap;
                }
        }
}
