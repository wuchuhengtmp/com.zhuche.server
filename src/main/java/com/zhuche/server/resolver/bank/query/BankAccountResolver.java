/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/25
 * Listen  MIT
 */

package com.zhuche.server.resolver.bank.query;

import com.zhuche.server.context.dataloader.DataLoaderRegistryFactory;
import com.zhuche.server.resolver.bank.dto.BankAccount;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class BankAccountResolver implements GraphQLResolver<BankAccount> {

    public CompletableFuture<BigDecimal>  balance(BankAccount bankAccount, DataFetchingEnvironment environment) {
        log.info("Getting balance for {}", bankAccount);
        DataLoader<UUID, BigDecimal> dataLoader = environment.getDataLoader(DataLoaderRegistryFactory.BALANCE_DATA_LOADER);

        return dataLoader.load(bankAccount.getId());
    }
}
