package com.xieyv.lighthome.web.app.vo.community;

import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.model.entity.FacilityInfo;
import com.xieyv.lighthome.model.entity.LabelInfo;
import com.xieyv.lighthome.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
@Schema(description = "APP端社区信息详情")
public class CommunityDetailVo extends CommunityInfo {

    @Schema(description = "图片列表")
    private List<GraphVo> graphVoList;

    @Schema(description = "标签列表")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "配套列表")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "租金最小值")
    private BigDecimal minRent;
}
