package com.xieyv.lighthome.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;

@Schema(description = "社区&杂费关联表")
@TableName(value = "community_fee_value")
@Data
@Builder
public class CommunityFeeValue extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "社区id")
    @TableField(value = "community_id")
    private Long communityId;

    @Schema(description = "收费项value_id")
    @TableField(value = "fee_value_id")
    private Long feeValueId;

}