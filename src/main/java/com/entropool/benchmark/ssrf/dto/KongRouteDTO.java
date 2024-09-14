package com.entropool.benchmark.ssrf.dto;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class KongRouteDTO implements Serializable {
    private String id;
    private String name;
    private Map<String, String> service;
    private Map<Object, Object> headers;
    private List<String> protocols;
    private List<String> methods;
    private List<String> paths;

    @JSONField(name = "strip_path")
    private Boolean stripPath;

    @JSONField(name = "preserve_host")
    private Boolean preserveHost;

    @JSONField(name = "regex_priority")
    private Integer regexPriority;
    private List<String> hosts;
    private List<String> tags;

    @JSONField(name = "created_at")
    private Long createdAt;

    @JSONField(name = "updated_at")
    private Long updatedAt;

    @JSONField(name = "https_redirect_status_code")
    private Integer httpsRedirectStatusCode;

    @JSONField(name = "path_handling")
    private String pathHandling;
    private List<String> snis;
    private List<String> sources;
    private String serviceName;

    /* loaded from: opm-metadata.jar:BOOT-INF/lib/opm-metadata-facade-0.0.1-SNAPSHOT.jar:com/pupu/opm/metadata/dto/kongmanger/KongRouteDTO$KongRouteDTOBuilder.class */
    public static class KongRouteDTOBuilder {
        private String id;
        private String name;
        private Map<String, String> service;
        private Map<Object, Object> headers;
        private List<String> protocols;
        private List<String> methods;
        private List<String> paths;
        private Boolean stripPath;
        private Boolean preserveHost;
        private Integer regexPriority;
        private List<String> hosts;
        private List<String> tags;
        private Long createdAt;
        private Long updatedAt;
        private Integer httpsRedirectStatusCode;
        private String pathHandling;
        private List<String> snis;
        private List<String> sources;
        private String serviceName;

        KongRouteDTOBuilder() {
        }

        public KongRouteDTOBuilder id(String id) {
            this.id = id;
            return this;
        }

        public KongRouteDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public KongRouteDTOBuilder service(Map<String, String> service) {
            this.service = service;
            return this;
        }

        public KongRouteDTOBuilder headers(Map<Object, Object> headers) {
            this.headers = headers;
            return this;
        }

        public KongRouteDTOBuilder protocols(List<String> protocols) {
            this.protocols = protocols;
            return this;
        }

        public KongRouteDTOBuilder methods(List<String> methods) {
            this.methods = methods;
            return this;
        }

        public KongRouteDTOBuilder paths(List<String> paths) {
            this.paths = paths;
            return this;
        }

        public KongRouteDTOBuilder stripPath(Boolean stripPath) {
            this.stripPath = stripPath;
            return this;
        }

        public KongRouteDTOBuilder preserveHost(Boolean preserveHost) {
            this.preserveHost = preserveHost;
            return this;
        }

        public KongRouteDTOBuilder regexPriority(Integer regexPriority) {
            this.regexPriority = regexPriority;
            return this;
        }

        public KongRouteDTOBuilder hosts(List<String> hosts) {
            this.hosts = hosts;
            return this;
        }

        public KongRouteDTOBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public KongRouteDTOBuilder createdAt(Long createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public KongRouteDTOBuilder updatedAt(Long updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public KongRouteDTOBuilder httpsRedirectStatusCode(Integer httpsRedirectStatusCode) {
            this.httpsRedirectStatusCode = httpsRedirectStatusCode;
            return this;
        }

        public KongRouteDTOBuilder pathHandling(String pathHandling) {
            this.pathHandling = pathHandling;
            return this;
        }

        public KongRouteDTOBuilder snis(List<String> snis) {
            this.snis = snis;
            return this;
        }

        public KongRouteDTOBuilder sources(List<String> sources) {
            this.sources = sources;
            return this;
        }

        public KongRouteDTOBuilder serviceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public KongRouteDTO build() {
            return new KongRouteDTO(this.id, this.name, this.service, this.headers, this.protocols, this.methods, this.paths, this.stripPath, this.preserveHost, this.regexPriority, this.hosts, this.tags, this.createdAt, this.updatedAt, this.httpsRedirectStatusCode, this.pathHandling, this.snis, this.sources, this.serviceName);
        }

        public String toString() {
            return "KongRouteDTO.KongRouteDTOBuilder(id=" + this.id + ", name=" + this.name + ", service=" + this.service + ", headers=" + this.headers + ", protocols=" + this.protocols + ", methods=" + this.methods + ", paths=" + this.paths + ", stripPath=" + this.stripPath + ", preserveHost=" + this.preserveHost + ", regexPriority=" + this.regexPriority + ", hosts=" + this.hosts + ", tags=" + this.tags + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", httpsRedirectStatusCode=" + this.httpsRedirectStatusCode + ", pathHandling=" + this.pathHandling + ", snis=" + this.snis + ", sources=" + this.sources + ", serviceName=" + this.serviceName + ")";
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setService(Map<String, String> service) {
        this.service = service;
    }

    public void setHeaders(Map<Object, Object> headers) {
        this.headers = headers;
    }

    public void setProtocols(List<String> protocols) {
        this.protocols = protocols;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public void setStripPath(Boolean stripPath) {
        this.stripPath = stripPath;
    }

    public void setPreserveHost(Boolean preserveHost) {
        this.preserveHost = preserveHost;
    }

    public void setRegexPriority(Integer regexPriority) {
        this.regexPriority = regexPriority;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setHttpsRedirectStatusCode(Integer httpsRedirectStatusCode) {
        this.httpsRedirectStatusCode = httpsRedirectStatusCode;
    }

    public void setPathHandling(String pathHandling) {
        this.pathHandling = pathHandling;
    }

    public void setSnis(List<String> snis) {
        this.snis = snis;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof KongRouteDTO)) {
            return false;
        }
        KongRouteDTO other = (KongRouteDTO) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$stripPath = getStripPath();
        Object other$stripPath = other.getStripPath();
        if (this$stripPath == null) {
            if (other$stripPath != null) {
                return false;
            }
        } else if (!this$stripPath.equals(other$stripPath)) {
            return false;
        }
        Object this$preserveHost = getPreserveHost();
        Object other$preserveHost = other.getPreserveHost();
        if (this$preserveHost == null) {
            if (other$preserveHost != null) {
                return false;
            }
        } else if (!this$preserveHost.equals(other$preserveHost)) {
            return false;
        }
        Object this$regexPriority = getRegexPriority();
        Object other$regexPriority = other.getRegexPriority();
        if (this$regexPriority == null) {
            if (other$regexPriority != null) {
                return false;
            }
        } else if (!this$regexPriority.equals(other$regexPriority)) {
            return false;
        }
        Object this$createdAt = getCreatedAt();
        Object other$createdAt = other.getCreatedAt();
        if (this$createdAt == null) {
            if (other$createdAt != null) {
                return false;
            }
        } else if (!this$createdAt.equals(other$createdAt)) {
            return false;
        }
        Object this$updatedAt = getUpdatedAt();
        Object other$updatedAt = other.getUpdatedAt();
        if (this$updatedAt == null) {
            if (other$updatedAt != null) {
                return false;
            }
        } else if (!this$updatedAt.equals(other$updatedAt)) {
            return false;
        }
        Object this$httpsRedirectStatusCode = getHttpsRedirectStatusCode();
        Object other$httpsRedirectStatusCode = other.getHttpsRedirectStatusCode();
        if (this$httpsRedirectStatusCode == null) {
            if (other$httpsRedirectStatusCode != null) {
                return false;
            }
        } else if (!this$httpsRedirectStatusCode.equals(other$httpsRedirectStatusCode)) {
            return false;
        }
        Object this$id = getId();
        Object other$id = other.getId();
        if (this$id == null) {
            if (other$id != null) {
                return false;
            }
        } else if (!this$id.equals(other$id)) {
            return false;
        }
        Object this$name = getName();
        Object other$name = other.getName();
        if (this$name == null) {
            if (other$name != null) {
                return false;
            }
        } else if (!this$name.equals(other$name)) {
            return false;
        }
        Object this$service = getService();
        Object other$service = other.getService();
        if (this$service == null) {
            if (other$service != null) {
                return false;
            }
        } else if (!this$service.equals(other$service)) {
            return false;
        }
        Object this$headers = getHeaders();
        Object other$headers = other.getHeaders();
        if (this$headers == null) {
            if (other$headers != null) {
                return false;
            }
        } else if (!this$headers.equals(other$headers)) {
            return false;
        }
        Object this$protocols = getProtocols();
        Object other$protocols = other.getProtocols();
        if (this$protocols == null) {
            if (other$protocols != null) {
                return false;
            }
        } else if (!this$protocols.equals(other$protocols)) {
            return false;
        }
        Object this$methods = getMethods();
        Object other$methods = other.getMethods();
        if (this$methods == null) {
            if (other$methods != null) {
                return false;
            }
        } else if (!this$methods.equals(other$methods)) {
            return false;
        }
        Object this$paths = getPaths();
        Object other$paths = other.getPaths();
        if (this$paths == null) {
            if (other$paths != null) {
                return false;
            }
        } else if (!this$paths.equals(other$paths)) {
            return false;
        }
        Object this$hosts = getHosts();
        Object other$hosts = other.getHosts();
        if (this$hosts == null) {
            if (other$hosts != null) {
                return false;
            }
        } else if (!this$hosts.equals(other$hosts)) {
            return false;
        }
        Object this$tags = getTags();
        Object other$tags = other.getTags();
        if (this$tags == null) {
            if (other$tags != null) {
                return false;
            }
        } else if (!this$tags.equals(other$tags)) {
            return false;
        }
        Object this$pathHandling = getPathHandling();
        Object other$pathHandling = other.getPathHandling();
        if (this$pathHandling == null) {
            if (other$pathHandling != null) {
                return false;
            }
        } else if (!this$pathHandling.equals(other$pathHandling)) {
            return false;
        }
        Object this$snis = getSnis();
        Object other$snis = other.getSnis();
        if (this$snis == null) {
            if (other$snis != null) {
                return false;
            }
        } else if (!this$snis.equals(other$snis)) {
            return false;
        }
        Object this$sources = getSources();
        Object other$sources = other.getSources();
        if (this$sources == null) {
            if (other$sources != null) {
                return false;
            }
        } else if (!this$sources.equals(other$sources)) {
            return false;
        }
        Object this$serviceName = getServiceName();
        Object other$serviceName = other.getServiceName();
        return this$serviceName == null ? other$serviceName == null : this$serviceName.equals(other$serviceName);
    }

    protected boolean canEqual(Object other) {
        return other instanceof KongRouteDTO;
    }

    public int hashCode() {
        Object $stripPath = getStripPath();
        int result = (1 * 59) + ($stripPath == null ? 43 : $stripPath.hashCode());
        Object $preserveHost = getPreserveHost();
        int result2 = (result * 59) + ($preserveHost == null ? 43 : $preserveHost.hashCode());
        Object $regexPriority = getRegexPriority();
        int result3 = (result2 * 59) + ($regexPriority == null ? 43 : $regexPriority.hashCode());
        Object $createdAt = getCreatedAt();
        int result4 = (result3 * 59) + ($createdAt == null ? 43 : $createdAt.hashCode());
        Object $updatedAt = getUpdatedAt();
        int result5 = (result4 * 59) + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        Object $httpsRedirectStatusCode = getHttpsRedirectStatusCode();
        int result6 = (result5 * 59) + ($httpsRedirectStatusCode == null ? 43 : $httpsRedirectStatusCode.hashCode());
        Object $id = getId();
        int result7 = (result6 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $name = getName();
        int result8 = (result7 * 59) + ($name == null ? 43 : $name.hashCode());
        Object $service = getService();
        int result9 = (result8 * 59) + ($service == null ? 43 : $service.hashCode());
        Object $headers = getHeaders();
        int result10 = (result9 * 59) + ($headers == null ? 43 : $headers.hashCode());
        Object $protocols = getProtocols();
        int result11 = (result10 * 59) + ($protocols == null ? 43 : $protocols.hashCode());
        Object $methods = getMethods();
        int result12 = (result11 * 59) + ($methods == null ? 43 : $methods.hashCode());
        Object $paths = getPaths();
        int result13 = (result12 * 59) + ($paths == null ? 43 : $paths.hashCode());
        Object $hosts = getHosts();
        int result14 = (result13 * 59) + ($hosts == null ? 43 : $hosts.hashCode());
        Object $tags = getTags();
        int result15 = (result14 * 59) + ($tags == null ? 43 : $tags.hashCode());
        Object $pathHandling = getPathHandling();
        int result16 = (result15 * 59) + ($pathHandling == null ? 43 : $pathHandling.hashCode());
        Object $snis = getSnis();
        int result17 = (result16 * 59) + ($snis == null ? 43 : $snis.hashCode());
        Object $sources = getSources();
        int result18 = (result17 * 59) + ($sources == null ? 43 : $sources.hashCode());
        Object $serviceName = getServiceName();
        return (result18 * 59) + ($serviceName == null ? 43 : $serviceName.hashCode());
    }

    public String toString() {
        return "KongRouteDTO(id=" + getId() + ", name=" + getName() + ", service=" + getService() + ", headers=" + getHeaders() + ", protocols=" + getProtocols() + ", methods=" + getMethods() + ", paths=" + getPaths() + ", stripPath=" + getStripPath() + ", preserveHost=" + getPreserveHost() + ", regexPriority=" + getRegexPriority() + ", hosts=" + getHosts() + ", tags=" + getTags() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", httpsRedirectStatusCode=" + getHttpsRedirectStatusCode() + ", pathHandling=" + getPathHandling() + ", snis=" + getSnis() + ", sources=" + getSources() + ", serviceName=" + getServiceName() + ")";
    }

    public static KongRouteDTOBuilder builder() {
        return new KongRouteDTOBuilder();
    }

    public KongRouteDTO() {
    }

    public KongRouteDTO(String id, String name, Map<String, String> service, Map<Object, Object> headers, List<String> protocols, List<String> methods, List<String> paths, Boolean stripPath, Boolean preserveHost, Integer regexPriority, List<String> hosts, List<String> tags, Long createdAt, Long updatedAt, Integer httpsRedirectStatusCode, String pathHandling, List<String> snis, List<String> sources, String serviceName) {
        this.id = id;
        this.name = name;
        this.service = service;
        this.headers = headers;
        this.protocols = protocols;
        this.methods = methods;
        this.paths = paths;
        this.stripPath = stripPath;
        this.preserveHost = preserveHost;
        this.regexPriority = regexPriority;
        this.hosts = hosts;
        this.tags = tags;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.httpsRedirectStatusCode = httpsRedirectStatusCode;
        this.pathHandling = pathHandling;
        this.snis = snis;
        this.sources = sources;
        this.serviceName = serviceName;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, String> getService() {
        return this.service;
    }

    public Map<Object, Object> getHeaders() {
        return this.headers;
    }

    public List<String> getProtocols() {
        return this.protocols;
    }

    public List<String> getMethods() {
        return this.methods;
    }

    public List<String> getPaths() {
        return this.paths;
    }

    public Boolean getStripPath() {
        return this.stripPath;
    }

    public Boolean getPreserveHost() {
        return this.preserveHost;
    }

    public Integer getRegexPriority() {
        return this.regexPriority;
    }

    public List<String> getHosts() {
        return this.hosts;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public Long getUpdatedAt() {
        return this.updatedAt;
    }

    public Integer getHttpsRedirectStatusCode() {
        return this.httpsRedirectStatusCode;
    }

    public String getPathHandling() {
        return this.pathHandling;
    }

    public List<String> getSnis() {
        return this.snis;
    }

    public List<String> getSources() {
        return this.sources;
    }

    public String getServiceName() {
        return this.serviceName;
    }
}
