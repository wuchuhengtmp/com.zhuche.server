/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/21
 * Listen  MIT
 */

package com.zhuche.server.errors;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class BaseExceptionImpl extends RuntimeException implements GraphQLError{
    @Getter
    @Setter
    Integer errorCode;

    @Getter
    @Setter
    String errorMessage;

    @Override
    public String getMessage() {
        return this.errorMessage;
    }

    @Getter
    List<SourceLocation> locations = null;

    @Getter
    List<Object> path = null;

    @Getter
    ErrorClassification errorType = null;

    public Map<String, Object> getExtensions() {
        var extensions = new HashMap<String, Object>();
        extensions.put("errorCode", this.getErrorCode());

        return extensions;
    }
}
