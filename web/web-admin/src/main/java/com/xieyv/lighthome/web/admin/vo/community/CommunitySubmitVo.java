package com.xieyv.lighthome.web.admin.vo.community;

import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.web.admin.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Schema(description = "社区信息")
@Data
public class CommunitySubmitVo extends CommunityInfo {

    @Schema(description="社区配套id")
    private List<Long> facilityInfoIds;

    @Schema(description="社区标签id")
    private List<Long> labelIds;

    @Schema(description="社区杂费值id")
    private List<Long> feeValueIds;

    @Schema(description="社区图片id")
    private List<GraphVo> graphVoList;

}
