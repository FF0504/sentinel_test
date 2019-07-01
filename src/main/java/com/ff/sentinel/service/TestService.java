package com.ff.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ff.sentinel.hander.TestServiceHander;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: FF
 * @Date: 2019/7/1 10:03
 * @Version 1.0
 */
@Slf4j
@Service
public class TestService {

    /**
     *  限流与阻塞处理（配置限流控制，超过次数就直接调用blockHandler代码）
     */
    @SentinelResource(value = "testHello",blockHandler="blockHandler", blockHandlerClass = TestServiceHander.class)
    public void testHello(String str) {
        log.info(str);
    }

    /**
     * 熔断与降级处理(fallback:抛出异常处理逻辑,单超过异常数或者比例直接掉fallback的方法)
     * @param str
     */
    @SentinelResource(value = "testHello2", fallback = "fallbackHandler" )
    public void testHello2(String str) {
        log.info(str);
        int i=10/0;
    }

    public  void fallbackHandler(String str) {
        log.error("fallbackHandler：" + str);
    }
}
