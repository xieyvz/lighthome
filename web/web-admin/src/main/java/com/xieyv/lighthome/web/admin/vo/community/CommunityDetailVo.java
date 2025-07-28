package com.xieyv.lighthome.web.admin.vo.community;


import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.model.entity.FacilityInfo;
import com.xieyv.lighthome.model.entity.LabelInfo;
import com.xieyv.lighthome.web.admin.vo.fee.FeeValueVo;
import com.xieyv.lighthome.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "社区信息")
@Data
public class CommunityDetailVo extends CommunityInfo {

    @Schema(description = "图片列表")
    private List<GraphVo> graphVoList;

    @Schema(description = "标签列表")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "配套列表")
    private List<FacilityInfo> facilityInfoList;

    @Schema(description = "杂费列表")
    private List<FeeValueVo> feeValueVoList;

}
