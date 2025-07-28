package com.xieyv.lighthome.web.admin.vo.appointment;

import com.xieyv.lighthome.model.entity.CommunityInfo;
import com.xieyv.lighthome.model.entity.ViewAppointment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "预约看房信息")
public class AppointmentVo extends ViewAppointment {

    @Schema(description = "预约社区信息")
    private CommunityInfo apartmentInfo;

}
