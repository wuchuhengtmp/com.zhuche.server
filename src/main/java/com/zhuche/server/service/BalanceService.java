/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/26
 * Listen  MIT
 */

package com.zhuche.server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service
@Slf4j
public class BalanceService {
    public Map<UUID, BigDecimal> getBalanceFor(Set<UUID> bankAccountIds, String userId) {
        log.info("Requesting bank account ids: {} for user Id: {}", bankAccountIds, userId);

        return Map.of(
                UUID.fromString("c6aa269a-812b-49d5-b178-a739a1ed74cc"), BigDecimal.ONE,
                UUID.fromString("410f5919-e50b-4790-aae3-65d2d4b21c77"), new BigDecimal("11")
        );
    }
}
