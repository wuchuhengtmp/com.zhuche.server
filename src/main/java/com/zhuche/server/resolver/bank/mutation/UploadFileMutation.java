/**
 * Desc    The controllers is part of server
 * Author  wuchuheng <root@wuchuheng.com>
 * Blog    https://wuchuheng.com
 * DATE    2021/11/22
 * Listen  MIT
 */

package com.zhuche.server.resolver.bank.mutation;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class UploadFileMutation implements GraphQLMutationResolver {

    public UUID updateFile(DataFetchingEnvironment environment) {
        log.info("Upload file: {}", environment);
        DefaultGraphQLServletContext context = environment.getContext();
        context.getFileParts().forEach(part ->
                log.info("uploading: {}, size {}", part.getSubmittedFileName(), part.getSize())
        );

        return UUID.randomUUID();
    }
}
