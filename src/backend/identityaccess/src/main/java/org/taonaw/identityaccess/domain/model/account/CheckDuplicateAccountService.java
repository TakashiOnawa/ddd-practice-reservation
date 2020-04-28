package org.taonaw.identityaccess.domain.model.account;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.taonaw.identityaccess.domain.exception.AccountDuplicatedException;

@AllArgsConstructor
public class CheckDuplicateAccountService {
    @NonNull
    private final IAccountRepository accountRepository;

    public boolean isDuplicated(@NonNull Account account) {
        return accountRepository.findBy(account.getLoginId()).isPresent();
    }

    public void validate(@NonNull Account account) {
        if (isDuplicated(account)) {
            throw new AccountDuplicatedException(account.getLoginId());
        }
    }
}
