/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/21
 * Listen  MIT
 */

package com.zhuche.server.resolver.bank.query.fieldResolver;

import com.zhuche.server.resolver.bank.dto.BankAccount;
import com.zhuche.server.resolver.bank.dto.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
    private final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );


    public CompletableFuture<Client> client(BankAccount bankAccount) {
        var l = new ArrayList<String>();
        l.add("hello");
        l.add("hello");
        var client = Client.builder()
                .id(bankAccount.getId())
                .firstname("firstname")
                .middlenames(l)
                .lastname("name")
                .build();

        return CompletableFuture.supplyAsync(() ->
                Client.builder()
                        .id(UUID.randomUUID())
                        .firstname("firstname")
                        .lastname("lastname")
                        .build()
        );

//        return DataFetcherResult.<Client>newResult()
//                .data(client)
//                .error(new GenericGraphQLError("hello error")).build();

    }
}
