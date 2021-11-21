/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/21
 * Listen  MIT
 */

package com.zhuche.server.errors;

public class NotFoundException extends BaseException {

    public NotFoundException(int errorCode) {
        super(errorCode);
    }
}
