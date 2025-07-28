package com.xieyv.lighthome.web.app.vo.agreement;

import com.xieyv.lighthome.model.entity.LeaseAgreement;
import com.xieyv.lighthome.web.app.vo.graph.GraphVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "租约详细信息")
public class AgreementDetailVo extends LeaseAgreement {

    @Schema(description = "社区名称")
    private String communityName;

    @Schema(description = "社区图片列表")
    private List<GraphVo> communityGraphVoList;

    @Schema(description = "房间号")
    private String roomNumber;

    @Schema(description = "房间图片列表")
    private List<GraphVo> roomGraphVoList;

    @Schema(description = "支付方式")
    private String paymentTypeName;

    @Schema(description = "租期月数")
    private Integer leaseTermMonthCount;

    @Schema(description = "租期单位")
    private String leaseTermUnit;

}