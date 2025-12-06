# Aufgabe gRPC: LIDAR Scanner

Erstelle einen Service, der eine Punktwolke (x, y, z) als Stream empfängt, und den Abstand des nähesten Punktes zurück gibt.

Teste deine Implementierung mit grpcurl:

```shell
grpcurl -plaintext -d @ localhost:8080 com.noahjutz.proto.LidarWarningService/measureDistance
{"points": [{"x": 9.42, "y": 1.78, "z": 0.0}]} # stdin input
{
  "distance": 9.586699119092035
} # response
```