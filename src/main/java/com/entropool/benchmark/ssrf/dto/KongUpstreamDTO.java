package com.entropool.benchmark.ssrf.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class KongUpstreamDTO implements Serializable {
    private String id;
    private String name;

    @JSONField(name = "created_at")
    private Long createdAt;
    private Integer slots;
    private String algorithm;

    @JSONField(name = "hash_on")
    private String hashOn;

    @JSONField(name = "hash_fallback")
    private String hashFallback;

    @JSONField(name = "hash_on_cookie_path")
    private String hashOnCookiePath;

    @JSONField(name = "hash_on_header")
    private String hashOnHeader;

    @JSONField(name = "hash_fallback_header")
    private String hashFallbackHeader;

    @JSONField(name = "hash_on_cookie")
    private String hashOnCookie;
    private Map<String, Object> healthchecks;
    private List<String> tags;

    @JSONField(name = "host_header")
    private String hostHeader;

    public static class KongUpstreamDTOBuilder {
        private String id;
        private String name;
        private Long createdAt;
        private Integer slots;
        private String algorithm;
        private String hashOn;
        private String hashFallback;
        private String hashOnCookiePath;
        private String hashOnHeader;
        private String hashFallbackHeader;
        private String hashOnCookie;
        private Map<String, Object> healthchecks;
        private List<String> tags;
        private String hostHeader;

        KongUpstreamDTOBuilder() {
        }

        public KongUpstreamDTOBuilder id(String id) {
            this.id = id;
            return this;
        }

        public KongUpstreamDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public KongUpstreamDTOBuilder createdAt(Long createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public KongUpstreamDTOBuilder slots(Integer slots) {
            this.slots = slots;
            return this;
        }

        public KongUpstreamDTOBuilder algorithm(String algorithm) {
            this.algorithm = algorithm;
            return this;
        }

        public KongUpstreamDTOBuilder hashOn(String hashOn) {
            this.hashOn = hashOn;
            return this;
        }

        public KongUpstreamDTOBuilder hashFallback(String hashFallback) {
            this.hashFallback = hashFallback;
            return this;
        }

        public KongUpstreamDTOBuilder hashOnCookiePath(String hashOnCookiePath) {
            this.hashOnCookiePath = hashOnCookiePath;
            return this;
        }

        public KongUpstreamDTOBuilder hashOnHeader(String hashOnHeader) {
            this.hashOnHeader = hashOnHeader;
            return this;
        }

        public KongUpstreamDTOBuilder hashFallbackHeader(String hashFallbackHeader) {
            this.hashFallbackHeader = hashFallbackHeader;
            return this;
        }

        public KongUpstreamDTOBuilder hashOnCookie(String hashOnCookie) {
            this.hashOnCookie = hashOnCookie;
            return this;
        }

        public KongUpstreamDTOBuilder healthchecks(Map<String, Object> healthchecks) {
            this.healthchecks = healthchecks;
            return this;
        }

        public KongUpstreamDTOBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public KongUpstreamDTOBuilder hostHeader(String hostHeader) {
            this.hostHeader = hostHeader;
            return this;
        }

        public KongUpstreamDTO build() {
            return new KongUpstreamDTO(this.id, this.name, this.createdAt, this.slots, this.algorithm, this.hashOn, this.hashFallback, this.hashOnCookiePath, this.hashOnHeader, this.hashFallbackHeader, this.hashOnCookie, this.healthchecks, this.tags, this.hostHeader);
        }

        public String toString() {
            return "KongUpstreamDTO.KongUpstreamDTOBuilder(id=" + this.id + ", name=" + this.name + ", createdAt=" + this.createdAt + ", slots=" + this.slots + ", algorithm=" + this.algorithm + ", hashOn=" + this.hashOn + ", hashFallback=" + this.hashFallback + ", hashOnCookiePath=" + this.hashOnCookiePath + ", hashOnHeader=" + this.hashOnHeader + ", hashFallbackHeader=" + this.hashFallbackHeader + ", hashOnCookie=" + this.hashOnCookie + ", healthchecks=" + this.healthchecks + ", tags=" + this.tags + ", hostHeader=" + this.hostHeader + ")";
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void setHashOn(String hashOn) {
        this.hashOn = hashOn;
    }

    public void setHashFallback(String hashFallback) {
        this.hashFallback = hashFallback;
    }

    public void setHashOnCookiePath(String hashOnCookiePath) {
        this.hashOnCookiePath = hashOnCookiePath;
    }

    public void setHashOnHeader(String hashOnHeader) {
        this.hashOnHeader = hashOnHeader;
    }

    public void setHashFallbackHeader(String hashFallbackHeader) {
        this.hashFallbackHeader = hashFallbackHeader;
    }

    public void setHashOnCookie(String hashOnCookie) {
        this.hashOnCookie = hashOnCookie;
    }

    public void setHealthchecks(Map<String, Object> healthchecks) {
        this.healthchecks = healthchecks;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setHostHeader(String hostHeader) {
        this.hostHeader = hostHeader;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof KongUpstreamDTO)) {
            return false;
        }
        KongUpstreamDTO other = (KongUpstreamDTO) o;
        if (!other.canEqual(this)) {
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
        Object this$slots = getSlots();
        Object other$slots = other.getSlots();
        if (this$slots == null) {
            if (other$slots != null) {
                return false;
            }
        } else if (!this$slots.equals(other$slots)) {
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
        Object this$algorithm = getAlgorithm();
        Object other$algorithm = other.getAlgorithm();
        if (this$algorithm == null) {
            if (other$algorithm != null) {
                return false;
            }
        } else if (!this$algorithm.equals(other$algorithm)) {
            return false;
        }
        Object this$hashOn = getHashOn();
        Object other$hashOn = other.getHashOn();
        if (this$hashOn == null) {
            if (other$hashOn != null) {
                return false;
            }
        } else if (!this$hashOn.equals(other$hashOn)) {
            return false;
        }
        Object this$hashFallback = getHashFallback();
        Object other$hashFallback = other.getHashFallback();
        if (this$hashFallback == null) {
            if (other$hashFallback != null) {
                return false;
            }
        } else if (!this$hashFallback.equals(other$hashFallback)) {
            return false;
        }
        Object this$hashOnCookiePath = getHashOnCookiePath();
        Object other$hashOnCookiePath = other.getHashOnCookiePath();
        if (this$hashOnCookiePath == null) {
            if (other$hashOnCookiePath != null) {
                return false;
            }
        } else if (!this$hashOnCookiePath.equals(other$hashOnCookiePath)) {
            return false;
        }
        Object this$hashOnHeader = getHashOnHeader();
        Object other$hashOnHeader = other.getHashOnHeader();
        if (this$hashOnHeader == null) {
            if (other$hashOnHeader != null) {
                return false;
            }
        } else if (!this$hashOnHeader.equals(other$hashOnHeader)) {
            return false;
        }
        Object this$hashFallbackHeader = getHashFallbackHeader();
        Object other$hashFallbackHeader = other.getHashFallbackHeader();
        if (this$hashFallbackHeader == null) {
            if (other$hashFallbackHeader != null) {
                return false;
            }
        } else if (!this$hashFallbackHeader.equals(other$hashFallbackHeader)) {
            return false;
        }
        Object this$hashOnCookie = getHashOnCookie();
        Object other$hashOnCookie = other.getHashOnCookie();
        if (this$hashOnCookie == null) {
            if (other$hashOnCookie != null) {
                return false;
            }
        } else if (!this$hashOnCookie.equals(other$hashOnCookie)) {
            return false;
        }
        Object this$healthchecks = getHealthchecks();
        Object other$healthchecks = other.getHealthchecks();
        if (this$healthchecks == null) {
            if (other$healthchecks != null) {
                return false;
            }
        } else if (!this$healthchecks.equals(other$healthchecks)) {
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
        Object this$hostHeader = getHostHeader();
        Object other$hostHeader = other.getHostHeader();
        return this$hostHeader == null ? other$hostHeader == null : this$hostHeader.equals(other$hostHeader);
    }

    protected boolean canEqual(Object other) {
        return other instanceof KongUpstreamDTO;
    }

    public int hashCode() {
        Object $createdAt = getCreatedAt();
        int result = (1 * 59) + ($createdAt == null ? 43 : $createdAt.hashCode());
        Object $slots = getSlots();
        int result2 = (result * 59) + ($slots == null ? 43 : $slots.hashCode());
        Object $id = getId();
        int result3 = (result2 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $name = getName();
        int result4 = (result3 * 59) + ($name == null ? 43 : $name.hashCode());
        Object $algorithm = getAlgorithm();
        int result5 = (result4 * 59) + ($algorithm == null ? 43 : $algorithm.hashCode());
        Object $hashOn = getHashOn();
        int result6 = (result5 * 59) + ($hashOn == null ? 43 : $hashOn.hashCode());
        Object $hashFallback = getHashFallback();
        int result7 = (result6 * 59) + ($hashFallback == null ? 43 : $hashFallback.hashCode());
        Object $hashOnCookiePath = getHashOnCookiePath();
        int result8 = (result7 * 59) + ($hashOnCookiePath == null ? 43 : $hashOnCookiePath.hashCode());
        Object $hashOnHeader = getHashOnHeader();
        int result9 = (result8 * 59) + ($hashOnHeader == null ? 43 : $hashOnHeader.hashCode());
        Object $hashFallbackHeader = getHashFallbackHeader();
        int result10 = (result9 * 59) + ($hashFallbackHeader == null ? 43 : $hashFallbackHeader.hashCode());
        Object $hashOnCookie = getHashOnCookie();
        int result11 = (result10 * 59) + ($hashOnCookie == null ? 43 : $hashOnCookie.hashCode());
        Object $healthchecks = getHealthchecks();
        int result12 = (result11 * 59) + ($healthchecks == null ? 43 : $healthchecks.hashCode());
        Object $tags = getTags();
        int result13 = (result12 * 59) + ($tags == null ? 43 : $tags.hashCode());
        Object $hostHeader = getHostHeader();
        return (result13 * 59) + ($hostHeader == null ? 43 : $hostHeader.hashCode());
    }

    public String toString() {
        return "KongUpstreamDTO(id=" + getId() + ", name=" + getName() + ", createdAt=" + getCreatedAt() + ", slots=" + getSlots() + ", algorithm=" + getAlgorithm() + ", hashOn=" + getHashOn() + ", hashFallback=" + getHashFallback() + ", hashOnCookiePath=" + getHashOnCookiePath() + ", hashOnHeader=" + getHashOnHeader() + ", hashFallbackHeader=" + getHashFallbackHeader() + ", hashOnCookie=" + getHashOnCookie() + ", healthchecks=" + getHealthchecks() + ", tags=" + getTags() + ", hostHeader=" + getHostHeader() + ")";
    }

    public static KongUpstreamDTOBuilder builder() {
        return new KongUpstreamDTOBuilder();
    }

    public KongUpstreamDTO() {
    }

    public KongUpstreamDTO(String id, String name, Long createdAt, Integer slots, String algorithm, String hashOn, String hashFallback, String hashOnCookiePath, String hashOnHeader, String hashFallbackHeader, String hashOnCookie, Map<String, Object> healthchecks, List<String> tags, String hostHeader) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.slots = slots;
        this.algorithm = algorithm;
        this.hashOn = hashOn;
        this.hashFallback = hashFallback;
        this.hashOnCookiePath = hashOnCookiePath;
        this.hashOnHeader = hashOnHeader;
        this.hashFallbackHeader = hashFallbackHeader;
        this.hashOnCookie = hashOnCookie;
        this.healthchecks = healthchecks;
        this.tags = tags;
        this.hostHeader = hostHeader;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public Integer getSlots() {
        return this.slots;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getHashOn() {
        return this.hashOn;
    }

    public String getHashFallback() {
        return this.hashFallback;
    }

    public String getHashOnCookiePath() {
        return this.hashOnCookiePath;
    }

    public String getHashOnHeader() {
        return this.hashOnHeader;
    }

    public String getHashFallbackHeader() {
        return this.hashFallbackHeader;
    }

    public String getHashOnCookie() {
        return this.hashOnCookie;
    }

    public Map<String, Object> getHealthchecks() {
        return this.healthchecks;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getHostHeader() {
        return this.hostHeader;
    }
}
