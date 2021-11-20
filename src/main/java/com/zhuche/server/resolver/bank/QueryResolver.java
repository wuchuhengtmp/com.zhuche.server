/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/20
 * Listen  MIT
 */

package com.zhuche.server.resolver.bank;

import com.zhuche.server.resolver.bank.dto.BankAccount;
import com.zhuche.server.resolver.bank.dto.Client;
import com.zhuche.server.resolver.bank.dto.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class QueryResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id) {
        log.info("Retrieving id: %d {}", id);
        var l = new ArrayList<String>();
        l.add("hello");
        l.add("hello");
        var clientA = Client.builder()
                .id(UUID.randomUUID())
                .lastname("lastnameA")
                .firstname("firstnameA")
                .middlenames(l)
                .build();

        var clientB = Client.builder()
                .id(UUID.randomUUID())
                .lastname("lastnameB")
                .firstname("firstnameB")
                .middlenames(l)
                .build();
        clientA.setClient(clientB);
        clientB.setClient(clientA);

        return BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.USD)
                .client(clientA)
                .build();
    }
}
