package org.example;

import com.noahjutz.proto.LidarWarningServiceGrpc;
import com.noahjutz.proto.PointCloud;
import com.noahjutz.proto.Warning;
import io.grpc.stub.StreamObserver;
import java.util.Comparator;

public class LidarWarningService extends LidarWarningServiceGrpc.LidarWarningServiceImplBase {
  @Override
  public StreamObserver<PointCloud> measureDistance(StreamObserver<Warning> responseObserver) {
    return new StreamObserver<>() {
      @Override
      public void onNext(PointCloud pointCloud) {
        final var distance =
            pointCloud.getPointsList().stream()
                .map(p -> distance(p.getX(), p.getY(), p.getZ()))
                .min(Comparator.naturalOrder());
        if (distance.isPresent() && distance.get() <= 10) {
          responseObserver.onNext(Warning.newBuilder().setDistance(distance.get()).build());
        }
        IO.println(distance);
      }

      @Override
      public void onError(Throwable throwable) {}

      @Override
      public void onCompleted() {}
    };
  }

  private double distance(double x, double y, double z) {
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
  }
}
