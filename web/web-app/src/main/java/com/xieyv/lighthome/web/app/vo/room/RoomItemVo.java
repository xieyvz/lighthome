package com.xieyv.lighthome.web.app.vo.room;

import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.model.entity.LabelInfo;
import com.xieyv.lighthome.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "APP房间列表实体")
@Data
public class RoomItemVo {

    @Schema(description = "房间id")
    private Long id;

    @Schema(description = "房间号")
    private String roomNumber;

    @Schema(description = "租金（元/月）")
    private BigDecimal rent;

    @Schema(description = "房间图片列表")
    private List<GraphVo> graphVoList;

    @Schema(description = "房间标签列表")
    private List<LabelInfo> labelInfoList;

    @Schema(description = "房间所属社区信息")
    private CommunityInfo communityInfo;

}
