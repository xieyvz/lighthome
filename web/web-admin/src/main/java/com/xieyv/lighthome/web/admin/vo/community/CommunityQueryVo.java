package com.xieyv.lighthome.web.admin.vo.community;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "社区查询实体")
public class CommunityQueryVo {

    @Schema(description = "省份id")
    private Long provinceId;

    @Schema(description = "城市id")
    private Long cityId;

    @Schema(description = "区域id")
    private Long districtId;
}
