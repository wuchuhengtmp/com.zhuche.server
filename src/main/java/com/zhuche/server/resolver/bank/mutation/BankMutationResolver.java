/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/22
 * Listen  MIT
 */

package com.zhuche.server.resolver.bank.mutation;

import com.zhuche.server.connection.CursorUtil;
import com.zhuche.server.repository.BankAccountRepository;
import com.zhuche.server.resolver.bank.dto.BankAccount;
import com.zhuche.server.resolver.bank.dto.Currency;
import com.zhuche.server.resolver.bank.mutation.dto.CreateBankAccountInput;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.relay.*;
import io.micrometer.core.lang.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.Clock;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
@Validated
public class BankMutationResolver implements GraphQLMutationResolver {
    private final BankAccountRepository bankAccountRepository;
    private final CursorUtil cursorUtil;
    private final Clock clock;

    public BankAccount createBankAccount(@Valid CreateBankAccountInput input) {
        log.info("Creating bank account for {}", input);

        return BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.USD)
                .createdAt(ZonedDateTime.now(clock))
                .createdOn(LocalDate.now(clock))
                .build();
    }

    public Connection<BankAccount> bankAccounts(int first, @Nullable String cursor) {
        List<Edge<BankAccount>> edges = getBankAccounts(cursor)
                .stream()
                .map(bankAccount -> new DefaultEdge<>(bankAccount,
                        cursorUtil.createCursorWith(bankAccount.getId())))
                .limit(first)
                .collect(Collectors.toUnmodifiableList());

        var pageInfo = new DefaultPageInfo(
                cursorUtil.getFirstCursorFrom(edges),
                cursorUtil.getLastCursorFrom(edges),
                cursor != null,
                edges.size() >= first);

        return new DefaultConnection<>(edges, pageInfo);
    }

    public List<BankAccount> getBankAccounts(String cursor) {
        if (cursor == null) {
            return bankAccountRepository.getBankAccounts();
        }
        return bankAccountRepository.getBankAccountsAfter(cursorUtil.decode(cursor));
    }

}
