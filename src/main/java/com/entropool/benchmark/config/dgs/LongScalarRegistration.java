package com.entropool.benchmark.config.dgs;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsRuntimeWiring;
import graphql.schema.idl.RuntimeWiring;

import static graphql.scalars.java.JavaPrimitives.GraphQLLong;

@DgsComponent
public class LongScalarRegistration {
    @DgsRuntimeWiring
    public RuntimeWiring.Builder addScalar(RuntimeWiring.Builder builder) {
        return builder.scalar(GraphQLLong);
    }
}
