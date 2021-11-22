/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/22
 * Listen  MIT
 */

package com.zhuche.server.resolver.bank.mutation.dto;

import lombok.Data;

@Data
public class CreateBankAccountInput {
    String firstname;
    int age;
}
