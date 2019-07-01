package com.ff.sentinel.controller;

import com.ff.sentinel.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: FF
 * @Date: 2019/7/1 10:02
 * @Version 1.0
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/testHello")
    public String testHello() {
        testService.testHello("testHello " + new Date());
        return "testHello";
    }

    @GetMapping("/testHello2")
    public String testHello2() {
        testService.testHello2("testHello2 " + new Date());
        return "testHello2";
    }
}
