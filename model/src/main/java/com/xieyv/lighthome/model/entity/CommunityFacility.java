package com.xieyv.lighthome.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;

@Schema(description = "社区&配套关系")
@TableName(value = "community_facility")
@Data
@Builder
public class CommunityFacility extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "社区id")
    @TableField(value = "community_id")
    private Long community;

    @Schema(description = "设施id")
    @TableField(value = "facility_id")
    private Long facilityId;


}