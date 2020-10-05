package com.lycsoftware.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcServerApplication
{
    public static void main(final String[] args)
    {
        SpringApplication.run(GrpcServerApplication.class, args);
    }

}
