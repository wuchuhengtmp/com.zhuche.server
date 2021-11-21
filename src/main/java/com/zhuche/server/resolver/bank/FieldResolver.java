/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/21
 * Listen  MIT
 */

package com.zhuche.server.resolver.bank;

import com.zhuche.server.resolver.bank.dto.BankAccount;
import com.zhuche.server.resolver.bank.dto.Client;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FieldResolver implements GraphQLResolver<BankAccount> {

    public DataFetcherResult<Client> client(BankAccount bankAccount) {
        var l = new ArrayList<String>();
        l.add("hello");
        l.add("hello");
        var client = Client.builder()
                .id(bankAccount.getId())
                .firstname("firstname")
                .middlenames(l)
                .lastname("name")
                .build();
        if ( 3 > 0) {
            throw new RuntimeException("hello, I'm run time exception");
        }

        return DataFetcherResult.<Client>newResult()
                .data(client)
                .error(new GenericGraphQLError("hello error")).build();

    }
}
