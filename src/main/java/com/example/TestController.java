package com.example;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * api-example1
 * com.example
 * Created by xiaobao.chen on 2018/8/28.
 */
@Controller
@RequestMapping
public class TestController {


    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /******************************application/x-www-form-urlencoded*********************begin*********************************************************************/

    /**
     * 请求方式：application/x-www-form-urlencoded
     * 请求参数：对象
     *
     * **/
    @RequestMapping(value = "/advertiserUrlencoded1", method = RequestMethod.POST)
    @ResponseBody
    public Response createAdvertiserUrlencoded1(HttpServletRequest request,TestParam testParam) {
        logger.info("createAdvertiserUrlencoded1 {} type:{}", JSON.toJSONString(testParam), request.getContentType());
        return new Response().success();
    }


    /**
     * 请求方式：application/x-www-form-urlencoded
     * 请求参数：单个参数
     * 参数修饰：@RequestParam  默认请求参数必须传递。可以设置。（required 属性）
     *
     * **/
    @RequestMapping(value = "/advertiserUrlencoded2", method = RequestMethod.POST)
    @ResponseBody
    public Response createAdvertiserUrlencoded2(HttpServletRequest request,
                                                @RequestParam(value = "name") String name,
                                                @RequestParam(value = "message") String message) {
        logger.info("createAdvertiserUrlencoded2 {} {} type:{}", JSON.toJSONString(name), JSON.toJSONString(message), request.getContentType());
        return new Response().success();
    }

    /**
     * 请求方式：application/x-www-form-urlencoded
     * 请求参数：单个参数
     * 参数修饰：无   参数可以缺省
     *
     * **/
    @RequestMapping(value = "/advertiserUrlencoded3", method = RequestMethod.POST)
    @ResponseBody
    public Response createAdvertiserUrlencoded3(HttpServletRequest request, String name, String message) {
        logger.info("createAdvertiserUrlencoded2 {} {} type:{}", JSON.toJSONString(name), JSON.toJSONString(message), request.getContentType());
        return new Response().success();
    }


    /***
     * 总结：
     * 1.application/x-www-form-urlencoded 可以接收 单个参数 ， 也可以接收对象参数
     * 2.@RequestParam 只能修饰普通类型参数，不能修饰实体对象
     * 3.@RequestParam 修饰的参数默认要求比传
     * 4.由于spring的RequestParam注解接收的参数是来自于requestHeader中，即请求头，也就是在url中，格式为xxx?username=123&password=456，而RequestBody注解接收的参数则是来自于requestBody中，即请求体中。
     */

    /*********************************application/x-www-form-urlencoded********************* end ******************************************************************/


    /***************************************************application/json********** begin*********************************************************/

    /***
     * 请求方式：application/json
     * 请求参数：实体对象
     * 使用注解：@RequestBody ：把请求json 转换为 实体对象
     * @param testParam
     * @return
     */
    @RequestMapping(value = "/advertiserJson1", method = RequestMethod.POST)
    @ResponseBody
    public Response createAdvertiserJson1(@RequestBody TestParam testParam) {
        logger.info("advertiserJson1 {}", JSON.toJSONString(testParam));
        return new Response().success();
    }

    /***
     * 请求方式：application/json
     * 请求参数：实体对象
     * 使用注解：@RequestBody ：把请求json 转换为 实体对象 ，配合其他注解使用@RequestParam  @PathVariable
     * @param testParam
     * @return
     */
    @RequestMapping(value = "/advertiserJson2/{flag}", method = RequestMethod.POST)
    @ResponseBody
    public Response createAdvertiserJson2(@RequestBody TestParam testParam,@RequestParam(value = "name") String name,@PathVariable String flag) {
        logger.info("advertiserJson2 {}-{}-{}", JSON.toJSONString(testParam),name,flag);
        return new Response().success();
    }

    /***
     * 请求方式：application/json
     * 使用 consumes 设置请求类型  (指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;)
     * @param testParam
     * @param name
     * @param flag
     * @return
     */
    @RequestMapping(value = "/advertiserJson3/{flag}", method = RequestMethod.POST,consumes = {"application/json"})
    @ResponseBody
    public Response createAdvertiserJson3(String testParam,@RequestParam(value = "name") String name,@PathVariable String flag) {
        logger.info("advertiserJson3 {}-{}-{}", testParam,name,flag);
        return new Response().success();
    }

    /***************************************************application/json********** end *********************************************************/
}
