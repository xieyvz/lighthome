package com.xieyv.lighthome.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonIgnore //不在返回给前端的json中出现
    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)     //用mp设置插入时添加创建时间
    private Date createTime;

    @JsonIgnore
    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    @JsonIgnore
    @TableLogic //逻辑删除，默认0留 1删
    @Schema(description = "逻辑删除")
    @TableField("is_deleted")
    private Byte isDeleted;

}