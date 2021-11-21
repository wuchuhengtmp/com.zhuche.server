/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/22
 * Listen  MIT
 */

package com.zhuche.server.resolver.bank.mutation;

import com.zhuche.server.resolver.bank.dto.BankAccount;
import com.zhuche.server.resolver.bank.dto.Currency;
import com.zhuche.server.resolver.bank.mutation.dto.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class BankMutationResolver implements GraphQLMutationResolver {

    public BankAccount createBankAccount(CreateBankAccountInput input) {
        log.info("Creating bank account for {}", input);

        return BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.USD)
                .build();
    }
}
