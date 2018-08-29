package com.example;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * api-example1
 * com.example
 * Created by xiaobao.chen on 2018/8/29.
 *
 * @RestController  -- 默认把返回结果转换为json
 *
 */
@RestController
public class RestTestController {

    private static final Logger logger = LoggerFactory.getLogger(RestTestController.class);


    /**
     * 请求方式：application/x-www-form-urlencoded
     * 请求参数：对象
     *
     * **/
    @RequestMapping(value = "/advertiserUrlencoded1", method = RequestMethod.POST)
    public Response createAdvertiserUrlencoded1(HttpServletRequest request,TestParam testParam) {
        logger.info("createAdvertiserUrlencoded1 {} type:{}", JSON.toJSONString(testParam), request.getContentType());
        return new Response().success();
    }


    /***
     * 请求方式：application/json
     * 请求参数：实体对象
     * 使用注解：@RequestBody ：把请求json 转换为 实体对象
     * @param testParam
     * @return
     */
    @RequestMapping(value = "/advertiserJson1", method = RequestMethod.POST)
    public Response createAdvertiserJson1(@RequestBody TestParam testParam) {
        logger.info("advertiserJson1 {}", JSON.toJSONString(testParam));
        return new Response().success();
    }
}
