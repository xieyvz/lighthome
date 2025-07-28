package com.xieyv.lighthome.model.entity;

import com.xieyv.lighthome.model.enums.ReleaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.math.BigDecimal;

@Schema(description = "房间信息表")
@TableName(value = "room_info")
@Data
public class RoomInfo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "房间号")
    @TableField(value = "room_number")
    private String roomNumber;

    @Schema(description = "租金（元/月）")
    @TableField(value = "rent")
    private BigDecimal rent;

    @Schema(description = "所属社区id")
    @TableField(value = "community_id")
    private Long communityId;

    @Schema(description = "是否发布")
    @TableField(value = "is_release")
    private ReleaseStatus isRelease;

}