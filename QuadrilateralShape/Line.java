public class Line {
  public Point startPoint;
  public Point endPoint;

  public Line(Point startPoint, Point endPoint) {
    this.startPoint = startPoint;
    this.endPoint = endPoint;
  }

  // ２点 𝐴(𝑥𝑎,𝑦𝑎) , 𝐵(𝑥𝑏,𝑦𝑏) 間の距離 𝐴𝐵 は𝐴𝐵=√(𝑥𝑏−𝑥𝑎)^2+(𝑦𝑏−𝑦𝑎)^2
  public double getLength() {
    return Math
        .sqrt(Math.pow(this.endPoint.x - this.startPoint.x, 2) + Math.pow(this.endPoint.y - this.startPoint.y, 2));
  }
}
