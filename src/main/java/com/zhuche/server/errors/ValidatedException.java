/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/23
 * Listen  MIT
 */

package com.zhuche.server.errors;

import lombok.Getter;
import lombok.Setter;

public class ValidatedException extends BaseExceptionImpl implements BaseException{
    @Setter
    @Getter
    Integer errorCode = 50000;
}
