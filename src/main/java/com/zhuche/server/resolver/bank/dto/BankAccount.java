/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/20
 * Listen  MIT
 */

package com.zhuche.server.resolver.bank.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Value
@Builder
public class BankAccount {
    UUID id;
    Currency currency;
    Client client;
    ZonedDateTime createdAt;
    LocalDate createdOn;
}
