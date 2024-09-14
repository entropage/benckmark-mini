package com.entropool.benchmark.ssrf.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KongOperatePluginDTO implements Serializable {
    /**
     * api接口
     */
    @JSONField(name = "api_url")
    private String apiUrl;
    /**
     * 环境
     */
    @JSONField(name = "ns_env")
    private String nsEnv;
    /**
     * 路由名
     */
    @JSONField(name = "route_name")
    private String routeName;
    /**
     * service名
     */
    @JSONField(name = "service_name")
    private String serviceName;
    /**
     * 开启(true)或关闭(false)
     */
    private Boolean enabled;
    /**
     * 插件名称
     */
    @JSONField(name = "plugin_name")
    private String pluginName;
}
