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
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FieldResolver implements GraphQLResolver<BankAccount> {

    public Client client(BankAccount bankAccount) {
        var l = new ArrayList<String>();
        l.add("hello");
        l.add("hello");

        return Client.builder()
                .id(bankAccount.getId())
                .firstname("firstname")
                .middlenames(l)
                .lastname("name")
                .build();
    }
}
