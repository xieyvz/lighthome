package com.xieyv.lighthome.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;

@Schema(description = "社区标签关联表")
@TableName(value = "community_label")
@Data
@Builder
public class CommunityLabel extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "社区id")
    @TableField(value = "community_id")
    private Long communityId;

    @Schema(description = "社区id")
    @TableField(value = "label_id")
    private Long labelId;

}