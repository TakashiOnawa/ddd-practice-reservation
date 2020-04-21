package org.taonaw.identityaccess.domain.model.member;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.taonaw.identityaccess.domain.model.shared.DateOfBirth;
import org.taonaw.identityaccess.domain.model.shared.EmailAddress;
import org.taonaw.identityaccess.domain.model.shared.PersonName;
import org.taonaw.identityaccess.domain.model.shared.PhoneNumber;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class MemberDetail {
    private final PersonName name;
    private final DateOfBirth dateOfBirth;
    private final PhoneNumber phoneNumber;
    private final EmailAddress emailAddress;
}
