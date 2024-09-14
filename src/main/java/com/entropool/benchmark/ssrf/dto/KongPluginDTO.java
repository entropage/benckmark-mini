package com.entropool.benchmark.ssrf.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KongPluginDTO implements Serializable {
    private String id;
    private String name;
    @JSONField(name = "created_at")
    private String createdAt;
    private Map<String, String> route;
    private Map<String, String> service;
    private Map<String, String> consumer;
    private Map<String, Object> config;
    @JSONField(name = "run_on")
    private String runOn;
    private List<String> protocols;
    private Boolean enabled;
    private List<String> tags;
    @JSONField(name = "route_name")
    private String routeName;
    @JSONField(name = "service_name")
    private String serviceName;
    private String scope;
}
