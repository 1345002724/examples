package com.jsg.examples.controller;
import com.jsg.examples.entity.CommonResult;
import com.jsg.examples.utils.domain.Server;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 服务器监控
 *
 *
 */
@RestController
@RequestMapping("/xtjk")
public class serverController
{

    @RequestMapping("/server")
    public CommonResult getInfo() throws Exception
    {
        Server server = new Server();
        server.copyTo();
        return new CommonResult(200,"成功",server);
    }
}
