package com.xieyv.lighthome.web.admin.schedule;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.xieyv.lighthome.model.entity.LeaseAgreement;
import com.xieyv.lighthome.model.enums.LeaseStatus;
import com.xieyv.lighthome.web.admin.service.LeaseAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleTasks {
    @Autowired
    private LeaseAgreementService leaseAgreementService;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkLeasesStatus() {
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.le(LeaseAgreement::getLeaseEndDate, new Date())   //结束日期小于当前日期
                .in(LeaseAgreement::getStatus, LeaseStatus.SIGNED, LeaseStatus.WITHDRAWING)
                .set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED);
        leaseAgreementService.update(updateWrapper);
    }
}
