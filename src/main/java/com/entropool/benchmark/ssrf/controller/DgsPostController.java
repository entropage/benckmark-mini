package com.entropool.benchmark.ssrf.controller;
import com.alibaba.fastjson.JSON;
import com.entropool.benchmark.ssrf.service.PuUpstreamService;
import com.alibaba.fastjson.JSONObject;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
@DgsComponent
public class DgsPostController {
    @Autowired
    PuUpstreamService puUpstreamService;
    @DgsMutation
    public String createKongUpstreamTarget(
            @InputArgument("api_url") String apiUrl,
            @InputArgument("ns_env") String nsEnv,
            @InputArgument("upstream_id") String upstreamId) {
        puUpstreamService.createUpstreamTarget(apiUrl, nsEnv, upstreamId);
         return "success";
    }

}
