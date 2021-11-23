/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/21
 * Listen  MIT
 */

package com.zhuche.server.errors;

import lombok.Getter;
import lombok.Setter;

public class InternalException extends BaseExceptionImpl implements BaseException {
    @Setter
    @Getter
    Integer errorCode = 40000;
}
