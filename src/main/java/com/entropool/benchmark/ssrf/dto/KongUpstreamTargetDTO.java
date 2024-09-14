package com.entropool.benchmark.ssrf.dto;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

public class KongUpstreamTargetDTO implements Serializable {
    private String id;
    private String target;

    @JSONField(name = "created_at")
    private Long createdAt;
    private KongUpstreamDTO upstream;
    private Integer weight;
    private List<String> tags;

    public static class KongUpstreamTargetDTOBuilder {
        private String id;
        private String target;
        private Long createdAt;
        private KongUpstreamDTO upstream;
        private Integer weight;
        private List<String> tags;

        KongUpstreamTargetDTOBuilder() {
        }

        public KongUpstreamTargetDTOBuilder id(String id) {
            this.id = id;
            return this;
        }

        public KongUpstreamTargetDTOBuilder target(String target) {
            this.target = target;
            return this;
        }

        public KongUpstreamTargetDTOBuilder createdAt(Long createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public KongUpstreamTargetDTOBuilder upstream(KongUpstreamDTO upstream) {
            this.upstream = upstream;
            return this;
        }

        public KongUpstreamTargetDTOBuilder weight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public KongUpstreamTargetDTOBuilder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public KongUpstreamTargetDTO build() {
            return new KongUpstreamTargetDTO(this.id, this.target, this.createdAt, this.upstream, this.weight, this.tags);
        }

        public String toString() {
            return "KongUpstreamTargetDTO.KongUpstreamTargetDTOBuilder(id=" + this.id + ", target=" + this.target + ", createdAt=" + this.createdAt + ", upstream=" + this.upstream + ", weight=" + this.weight + ", tags=" + this.tags + ")";
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpstream(KongUpstreamDTO upstream) {
        this.upstream = upstream;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof KongUpstreamTargetDTO)) {
            return false;
        }
        KongUpstreamTargetDTO other = (KongUpstreamTargetDTO) o;
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
        Object this$weight = getWeight();
        Object other$weight = other.getWeight();
        if (this$weight == null) {
            if (other$weight != null) {
                return false;
            }
        } else if (!this$weight.equals(other$weight)) {
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
        Object this$target = getTarget();
        Object other$target = other.getTarget();
        if (this$target == null) {
            if (other$target != null) {
                return false;
            }
        } else if (!this$target.equals(other$target)) {
            return false;
        }
        Object this$upstream = getUpstream();
        Object other$upstream = other.getUpstream();
        if (this$upstream == null) {
            if (other$upstream != null) {
                return false;
            }
        } else if (!this$upstream.equals(other$upstream)) {
            return false;
        }
        Object this$tags = getTags();
        Object other$tags = other.getTags();
        return this$tags == null ? other$tags == null : this$tags.equals(other$tags);
    }

    protected boolean canEqual(Object other) {
        return other instanceof KongUpstreamTargetDTO;
    }

    public int hashCode() {
        Object $createdAt = getCreatedAt();
        int result = (1 * 59) + ($createdAt == null ? 43 : $createdAt.hashCode());
        Object $weight = getWeight();
        int result2 = (result * 59) + ($weight == null ? 43 : $weight.hashCode());
        Object $id = getId();
        int result3 = (result2 * 59) + ($id == null ? 43 : $id.hashCode());
        Object $target = getTarget();
        int result4 = (result3 * 59) + ($target == null ? 43 : $target.hashCode());
        Object $upstream = getUpstream();
        int result5 = (result4 * 59) + ($upstream == null ? 43 : $upstream.hashCode());
        Object $tags = getTags();
        return (result5 * 59) + ($tags == null ? 43 : $tags.hashCode());
    }

    public String toString() {
        return "KongUpstreamTargetDTO(id=" + getId() + ", target=" + getTarget() + ", createdAt=" + getCreatedAt() + ", upstream=" + getUpstream() + ", weight=" + getWeight() + ", tags=" + getTags() + ")";
    }

    public static KongUpstreamTargetDTOBuilder builder() {
        return new KongUpstreamTargetDTOBuilder();
    }

    public KongUpstreamTargetDTO() {
    }

    public KongUpstreamTargetDTO(String id, String target, Long createdAt, KongUpstreamDTO upstream, Integer weight, List<String> tags) {
        this.id = id;
        this.target = target;
        this.createdAt = createdAt;
        this.upstream = upstream;
        this.weight = weight;
        this.tags = tags;
    }

    public String getId() {
        return this.id;
    }

    public String getTarget() {
        return this.target;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public KongUpstreamDTO getUpstream() {
        return this.upstream;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public List<String> getTags() {
        return this.tags;
    }
}
