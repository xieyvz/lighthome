package com.xieyv.lighthome.web.app.vo.community;

import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.model.entity.LabelInfo;
import com.xieyv.lighthome.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(description = "App端社区信息")
public class CommunityItemVo extends CommunityInfo {

    private List<LabelInfo> labelInfoList;

    private List<GraphVo> graphVoList;

    private BigDecimal minRent;
}
