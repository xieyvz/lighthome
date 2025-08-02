package com.xieyv.lighthome.web.admin.vo.agreement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "租约查询实体")
public class AgreementQueryVo {

    @Schema(description = "社区所处省份id")
    private Long provinceId;

    @Schema(description = "社区所处城市id")
    private Long cityId;

    @Schema(description = "社区所处区域id")
    private Long districtId;

    @Schema(description = "社区id")
    private Long communityId;

    @Schema(description = "房间号")
    private String roomNumber;

    @Schema(description = "用户姓名")
    private String name;

    @Schema(description = "用户手机号码")
    private String phone;

}
