package com.zhuche.server.errors;

import graphql.GraphQLError;

import java.util.EnumMap;
import java.util.Map;

public interface BaseException extends GraphQLError {
    public Integer getErrorCode();

    public void setErrorCode(Integer errorCode);

    public void setErrorMessage(String errorMessage);

    public String getErrorMessage();

    @Override
    Map<String, Object> getExtensions();
}
