package org.example;

import io.grpc.ServerBuilder;

class Server {
  void main() throws InterruptedException {
    final var server = ServerBuilder.forPort(8080).build();
    IO.println("Server running...");
    server.awaitTermination();
  }
}
