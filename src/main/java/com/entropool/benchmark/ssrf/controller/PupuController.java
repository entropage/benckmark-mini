package com.entropool.benchmark.ssrf.controller;
import com.entropool.benchmark.ssrf.dto.KongOperatePluginDTO;
import com.entropool.benchmark.ssrf.dto.KongPluginDTO;
import com.entropool.benchmark.ssrf.dto.KongPluginInfoDTO;
import com.entropool.benchmark.ssrf.service.PuUpstreamService;
import okhttp3.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@RequestMapping("/cmp/api/kong")
@RestController
public class PupuController {
    @Autowired
    PuUpstreamService puUpstreamService;
    @PostMapping("/get_plugin_by_service_plugin")
    public KongPluginDTO getKongPluginByServiceAndPlugin(@RequestBody() KongOperatePluginDTO kongOperatePlugin) {
       if(kongOperatePlugin.getApiUrl() == null || kongOperatePlugin.getNsEnv() == null || kongOperatePlugin.getServiceName() == null || kongOperatePlugin.getPluginName() == null)
       {
              throw new RuntimeException("参数不能为空");
       }
        String apiUrl = kongOperatePlugin.getApiUrl();
        KongPluginDTO pluginDTO = puUpstreamService.getKongPluginByServiceIdAndPlugin(kongOperatePlugin.getApiUrl(), kongOperatePlugin.getNsEnv(), kongOperatePlugin.getServiceName(), kongOperatePlugin.getPluginName());

        return pluginDTO;
    }

}
