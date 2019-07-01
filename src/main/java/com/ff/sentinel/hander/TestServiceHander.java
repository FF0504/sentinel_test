package com.ff.sentinel.hander;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: FF
 * @Date: 2019/7/1 11:50
 * @Version 1.0
 */
@Slf4j
public class TestServiceHander {

    public static void blockHandler(String str, BlockException ex) {
        log.error("blockHandler：" + str, ex);
    }

}
