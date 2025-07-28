package com.xieyv.lighthome.model.entity;

import com.xieyv.lighthome.model.enums.AppointmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.util.Date;

@Schema(description = "预约看房信息表")
@TableName(value = "view_appointment")
@Data
public class ViewAppointment extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    @TableField(value = "user_id")
    private Long userId;

    @Schema(description = "用户姓名")
    @TableField(value = "name")
    private String name;

    @Schema(description = "用户手机号码")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "社区id")
    @TableField(value = "community_id")
    private Long communityId;

    @Schema(description = "预约时间")
    @TableField(value = "appointment_time")
    private Date appointmentTime;

    @Schema(description = "备注信息")
    @TableField(value = "additional_info")
    private String additionalInfo;

    @Schema(description = "预约状态")
    @TableField(value = "appointment_status")
    private AppointmentStatus appointmentStatus;
}