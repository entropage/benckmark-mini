package com.entropool.benchmark.ssrf.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entropool.benchmark.ssrf.dto.KongPluginDTO;
import com.entropool.benchmark.ssrf.dto.KongPluginInfoDTO;
import com.entropool.benchmark.ssrf.dto.KongRouteDTO;
import okhttp3.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class PuUpstreamService {
    public void deleteUpstream(String apiUrl, String nsEnv, String upstreamId) {
        String url = apiUrl + "/upstreams/" + upstreamId;
        kongDelete(nsEnv, url);
    }

    private void kongDelete(String nsEnv, String url) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(1L, TimeUnit.SECONDS)
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .delete()
                    .headers(getHeaders(nsEnv))
                    .build();
            Response execute = okHttpClient.newCall(request).execute();
            String result = execute.body().string();
        } catch (IOException e) {
            throw new RuntimeException("Error deleting upstream: " + e.getMessage());
        }
    }

    private String kongGet(String nsEnv, String url) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.SECONDS).build();
            Request request = new Request.Builder().url(url)
                    .get()
                    .build();
            Response execute = okHttpClient.newCall(request).execute();
            String result = execute.body().string();
            return result;
        } catch (IOException e) {
            return null;
        }
    }

    private String kongPatch(String nsEnv, String url, String params) {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, params);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1L, TimeUnit.SECONDS).build();
            Request request = new Request.Builder().url(url).patch(body).headers(getHeaders(nsEnv)).build();
            Response execute = okHttpClient.newCall(request).execute();
            String result = execute.body().string();
            return result;
        } catch (IOException e) {
            System.out.println("e.getMessage() :" + e.getMessage());
            return null;
        }
    }
    private String kongPost(String nsEnv, String url, String params) {
        try {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, params);
            OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1L, TimeUnit.SECONDS).build();
            Request request = new Request.Builder().url(url).post(body).headers(getHeaders(nsEnv)).build();
            Response execute = okHttpClient.newCall(request).execute();
            String result = execute.body().string();
            return result;
        }  catch (IOException e) {
            return null;
        }
    }
    private Headers getHeaders(String nsEnv) {
        return Headers.of(
                "Host", "kong." + nsEnv + ".entropool.com",
                "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"
        );
    }
    public KongPluginDTO getKongPluginByServiceIdAndPlugin(String apiUrl, String nsEnv, String service, String plugin) {
        List<KongPluginDTO> kongPlugins = getKongPluginByServiceId(apiUrl, nsEnv, service);
        Optional<KongPluginDTO> kongPlugin = kongPlugins.stream().filter(x -> x.getName().equals(plugin)).findFirst();
        KongPluginDTO kongPluginDTO = kongPlugin.orElse(null);
        return kongPluginDTO;
    }
    public List<KongPluginDTO> getKongPluginByServiceId(String apiUrl, String nsEnv, String serviceId) {
        return getAllPlugins(apiUrl, nsEnv, serviceId, null, null);
    }
    public List<KongPluginDTO> getAllPlugins(String apiUrl, String nsEnv, String service, String route, String tags) {
        KongPluginInfoDTO ret = getPlugins(apiUrl, nsEnv, null, service, route, tags);
        List<KongPluginDTO> kongPlugins = ret.getData();
        while (Objects.nonNull(ret.getNext())) {
            String offset = ret.getOffset();
            ret = getPlugins(apiUrl, nsEnv, offset, service, route, tags);
            kongPlugins.addAll(ret.getData());
        }
        return kongPlugins;
    }

    public KongPluginInfoDTO getPlugins(String apiUrl, String nsEnv, String offset, String service, String route, String tags) {
        String url = "";
        if (Objects.nonNull(service)) {
            url += "/services/" + service + "/plugins?";
        } else if (Objects.nonNull(route)) {
            url += "/routes/" + route + "/plugins?";
        } else {
            url += "/plugins?";
        }
        url += "size=" + 1000;
        if (Objects.nonNull(tags)) {
            url += "&tags=" + tags;
        }
        if (Objects.nonNull(offset)) {
            url += "&offset=" + offset;
        }
        String result = kongGet(nsEnv,apiUrl + url);
        KongPluginInfoDTO kongPluginInfoDto = JSON.parseObject(result, KongPluginInfoDTO.class);
        return kongPluginInfoDto;
    }

    public KongRouteDTO updateRoute(String apiUrl, String nsEnv, String route) {
        return JSON.parseObject(kongPatch(nsEnv, apiUrl + "/routes/",route), KongRouteDTO.class);
    }

    public JSONObject createUpstreamTarget(String apiUrl, String nsEnv, String upstreamId) {
        return JSON.parseObject(kongPost(nsEnv, apiUrl + "/upstreams/" + upstreamId + "/targets",upstreamId));
    }
    private String getApiKey(String nsEnv) {
        String ns = nsEnv;
        return ns;
    }

}