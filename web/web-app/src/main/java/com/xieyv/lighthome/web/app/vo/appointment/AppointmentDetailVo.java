package com.xieyv.lighthome.web.app.vo.appointment;

import com.xieyv.lighthome.model.entity.ViewAppointment;
import com.xieyv.lighthome.web.app.vo.community.CommunityItemVo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "APP端预约看房详情")
public class AppointmentDetailVo extends ViewAppointment {

    @Schema(description = "社区基本信息")
    private CommunityItemVo communityItemVo;
}
