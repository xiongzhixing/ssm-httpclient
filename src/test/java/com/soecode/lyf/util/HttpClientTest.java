package com.soecode.lyf.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-httpclient.xml"})
public class HttpClientTest {

    @Autowired
    HttpClientOperate httpClientOperate;

    @Test
    public void test1() throws IOException, URISyntaxException {
        //无参get请求
        String result = httpClientOperate.doGet("http://www.baidu.com");
        System.out.println(result);
        //有参get请求
        Map<String,String> map = new HashMap<String,String>();
        map.put("waybillNo", "12341223");
        String result2 = httpClientOperate.doGet("http://www.baidu.com", map);
        System.out.println(result2);
        //post请求
        HttpResult entity = httpClientOperate.doPost("http://10.230.21.133:8180/esb2/rs/ESB_FOSS2ESB_FOSS_THE_RECEIVING_VERIFY");
        System.out.println(entity);
        //有参post请求
        HttpResult entity2 = httpClientOperate.doPost("http://10.230.21.133:8180/esb2/rs/ESB_FOSS2ESB_FOSS_THE_RECEIVING_VERIFY", map);
        System.out.println(entity2);
        //有参post请求rest服务 JSON
        String json = "{\"waybillNo\":\"12341223\"}";
        HttpResult entity3 = httpClientOperate.doPostJson("http://10.230.21.133:8180/esb2/rs/ESB_FOSS2ESB_FOSS_THE_RECEIVING_VERIFY",json);
        System.out.println(entity3);
    }
}
