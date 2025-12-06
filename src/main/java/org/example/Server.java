package org.example;

import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

class Server {
  void main() throws InterruptedException, IOException {
    final var server =
        ServerBuilder.forPort(8080)
            .addService(ProtoReflectionService.newInstance())
            .addService(new LidarWarningService())
            .build();
    server.start();
    IO.println("Server running...");
    server.awaitTermination();
  }
}
