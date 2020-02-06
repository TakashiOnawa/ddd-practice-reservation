package org.taonaw.identityaccess.infrastructure.query;

import org.springframework.stereotype.Repository;
import org.taonaw.identityaccess.query.IAccountQuery;
import org.taonaw.identityaccess.query.dto.AccountQueryDto;

import java.util.Optional;

@Repository
public class AccountQuery implements IAccountQuery {

    public Optional<AccountQueryDto> accountByName(String accountName) {

        var dto = AccountQueryDto.builder()
                .accountId("1")
                .accountName(accountName)
                .password("$2a$10$vZzdISmDQqPYGHwYrrqvB.ijiOPhyy/ZhLAEUJdXnZ86jJIvNZsgS")
                .build();
        return Optional.of(dto);
    }
}
