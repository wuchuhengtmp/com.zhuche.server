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

@Setter
@Getter
public class InternalException extends BaseException {

    public InternalException(int errorCode) {
        super(errorCode);
    }
}
