package org.taonaw.studio_reservation.usecase.command.usageFeeSetting.createBasicUsageFeeSetting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.taonaw.studio_reservation.domain.model.practiceTypeSetting.PracticeType;
import org.taonaw.studio_reservation.domain.model.usageFeeSetting.ApplicablePeriod;

@Getter
@Builder
@AllArgsConstructor
public class CreateBasicUsageFeeSettingCommand {
    private PracticeType practiceType;
    private ApplicablePeriod applicablePeriod;
}
