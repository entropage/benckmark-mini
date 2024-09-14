package com.entropool.benchmark.ssrf.dto;

import com.entropool.benchmark.ssrf.dto.KongPluginDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KongPluginInfoDTO implements Serializable {
    private String next;

    private List<KongPluginDTO> data;

    private String offset;
}
