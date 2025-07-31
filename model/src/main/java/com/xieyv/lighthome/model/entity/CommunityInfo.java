package com.xieyv.lighthome.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xieyv.lighthome.model.enums.ReleaseStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;

@Schema(description = "社区信息表")
@TableName(value = "community_info")
@Data
public class CommunityInfo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "社区名称")
    @TableField(value = "name")
    private String name;

    @Schema(description = "社区介绍")
    @TableField(value = "introduction")
    private String introduction;

    @Schema(description = "所处区域id")
    @TableField(value = "district_id")
    private Long districtId;

    @Schema(description = "所处区域名称")
    @TableField(value = "district_name")
    private String districtName;

    @Schema(description = "所处城市id")
    @TableField(value = "city_id")
    private Long cityId;

    @Schema(description = "所处城市名称")
    @TableField(value = "city_name")
    private String cityName;

    @Schema(description = "所处省份id")
    @TableField(value = "province_id")
    private Long provinceId;

    @Schema(description = "所处区域名称")
    @TableField(value = "province_name")
    private String provinceName;

    @Schema(description = "详细地址")
    @TableField(value = "address_detail")
    private String addressDetail;

    @Schema(description = "经度")
    @TableField(value = "latitude")
    private String latitude;

    @Schema(description = "纬度")
    @TableField(value = "longitude")
    private String longitude;

    @Schema(description = "社区前台电话")
    @TableField(value = "phone")
    private String phone;

    @Schema(description = "是否发布")
    @TableField(value = "is_release")
    private ReleaseStatus isRelease;

}