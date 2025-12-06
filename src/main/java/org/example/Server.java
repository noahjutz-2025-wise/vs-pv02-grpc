package org.example;

import io.grpc.ServerBuilder;

class Server {
  void main() throws InterruptedException {
    final var server = ServerBuilder.forPort(8080).addService(new LidarWarningService()).build();
    IO.println("Server running...");
    server.awaitTermination();
  }
}
