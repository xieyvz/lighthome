package com.xieyv.lighthome.web.admin.vo.community;

import com.xieyv.lighthome.model.entity.CommunityInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "后台管理系统社区列表实体")
public class CommunityItemVo extends CommunityInfo {

    @Schema(description = "房间总数")
    private Long totalRoomCount;

    @Schema(description = "空闲房间数")
    private Long freeRoomCount;

}
