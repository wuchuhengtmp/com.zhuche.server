/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/21
 * Listen  MIT
 */

package com.zhuche.server.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "error")
@PropertySource(value = "classpath:config/error-code.properties")
@Component
public class ErrorCodeConfiguration {

    private Map<Integer, String> codeMapMessage = new HashMap<>();

    public Map<Integer, String> getCodeMapMessage() {
        return codeMapMessage;
    }

    public void setCodeMapMessage(Map<Integer, String> codeMapMessage) {
        this.codeMapMessage = codeMapMessage;
    }

    public String getMessage(int code) {
        String message = this.codeMapMessage.get(code);

        return message;
    }
}
