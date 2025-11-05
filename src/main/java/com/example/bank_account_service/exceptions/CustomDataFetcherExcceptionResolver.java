package com.example.bank_account_service.exceptions;

import java.util.List;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustomDataFetcherExcceptionResolver extends DataFetcherExceptionResolverAdapter {
 
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return new GraphQLError(){
            @Override
            public String getMessage() {
                return "Custom error message: " + ex.getMessage();
            };

            @Override
            public List<SourceLocation> getLocations() {
                return List.of(env.getField().getSourceLocation());
            }

            @Override
            public ErrorClassification getErrorType() {
                return null;
            }
        };
        }

}
