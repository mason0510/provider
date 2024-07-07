package com.example.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.TimeUnit;

/**
 * mock 的作用是：当远程调用失败时，返回 DubboHelloServiceMock 中该方法hello 的 默认值
 */
@DubboService()
public class HelloServiceImpl implements DubboHelloService {

  @Override
  public String hello(String name) {
    return null;
  }
}
