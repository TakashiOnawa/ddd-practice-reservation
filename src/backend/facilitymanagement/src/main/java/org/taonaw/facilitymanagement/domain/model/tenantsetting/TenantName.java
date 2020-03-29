package org.taonaw.facilitymanagement.domain.model.tenantsetting;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import org.taonaw.facilitymanagement.domain.shared.Assertion;

@Getter
@EqualsAndHashCode
public class TenantName {
    private final String value;

    public TenantName(@NonNull String value) {
        Assertion.argumentRange(value, 1, 50);
        this.value = value;
    }
}
