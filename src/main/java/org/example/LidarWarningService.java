package org.example;

import com.noahjutz.proto.LidarWarningServiceGrpc;
import com.noahjutz.proto.PointCloud;
import com.noahjutz.proto.Warning;
import io.grpc.stub.StreamObserver;

public class LidarWarningService extends LidarWarningServiceGrpc.LidarWarningServiceImplBase {
  @Override
  public StreamObserver<PointCloud> measureDistance(StreamObserver<Warning> responseObserver) {
    return new StreamObserver<>() {
      @Override
      public void onNext(PointCloud pointCloud) {}

      @Override
      public void onError(Throwable throwable) {}

      @Override
      public void onCompleted() {}
    };
  }
}
