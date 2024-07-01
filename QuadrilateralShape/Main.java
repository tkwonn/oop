public class Main {

  public static void main(String[] args) {
    // ********************************
    // Test Purpose
    // not a quadrilateral
    // Area: 0.0
    // Such a shape could not be drawn.
    // ********************************

    // Line lineAB = new Line(new Point(1,1), new Point(2,2));
    // Line lineBC = new Line(new Point(2,2), new Point(3,3));
    // Line lineCD = new Line(new Point(3,3), new Point(4,4));
    // Line lineDA = new Line(new Point(4,4), new Point(1,1));
    // Line lineAC = new Line(new Point(1,1), new Point(3,3));
    // Line lineBD = new Line(new Point(2,2), new Point(4,4));
    // QuadrilateralShape shape0 = new QuadrilateralShape(lineAB, lineBC, lineCD,
    // lineDA, lineAC, lineBD);
    // System.out.println("Area: " + shape0.getArea());
    // System.out.println("Type: " + shape0.getShapeType());
    // System.out.println(shape0.draw());

    // square
    // ﹍ ﹍ ﹍ ﹍ ﹍
    // ｜ ｜
    // ｜ ｜
    // ｜ ｜
    // ｜ ｜
    // ｜ ｜
    // ﹉ ﹉ ﹉ ﹉ ﹉

    // ***************************************
    // UNCOMMENT BELOW TO SEE SQUARE SHAPE
    // ***************************************

    // Line lineAB = new Line(new Point(0,0), new Point(5,0));
    // Line lineBC = new Line(new Point(5,0), new Point(5,5));
    // Line lineCD = new Line(new Point(5,5), new Point(0,5));
    // Line lineDA = new Line(new Point(0,5), new Point(0,0));
    // Line lineAC = new Line(new Point(0,0), new Point(5,5));
    // Line lineBD = new Line(new Point(5,0), new Point(0,5));
    // QuadrilateralShape shape1 = new QuadrilateralShape(lineAB, lineBC, lineCD,
    // lineDA, lineAC, lineBD);
    // System.out.println("Perimeter: " + shape1.getPerimeter());
    // System.out.println("angleDAB: " + shape1.getAngle('A'));
    // System.out.println("angleABC: " + shape1.getAngle('B'));
    // System.out.println("angleBCD: " + shape1.getAngle('C'));
    // System.out.println("angleCDA: " + shape1.getAngle('D'));
    // System.out.println("Area: " + shape1.getArea());
    // System.out.println("Type: " + shape1.getShapeType());
    // System.out.println(shape1.draw());

    // rectangle
    // ﹍ ﹍ ﹍ ﹍ ﹍ ﹍ ﹍ ﹍
    // ｜ ｜
    // ｜ ｜
    // ｜ ｜
    // ｜ ｜
    // ｜ ｜
    // ﹉ ﹉ ﹉ ﹉ ﹉ ﹉ ﹉ ﹉

    // ***************************************
    // UNCOMMENT BELOW TO SEE RECTANGLE SHAPE
    // ***************************************

    // Line lineAB = new Line(new Point(0,0), new Point(8,0));
    // Line lineBC = new Line(new Point(8,0), new Point(8,5));
    // Line lineCD = new Line(new Point(8,5), new Point(0,5));
    // Line lineDA = new Line(new Point(0,5), new Point(0,0));
    // Line lineAC = new Line(new Point(0,0), new Point(8,5));
    // Line lineBD = new Line(new Point(8,0), new Point(0,5));
    // QuadrilateralShape shape2 = new QuadrilateralShape(lineAB, lineBC, lineCD,
    // lineDA, lineAC, lineBD);
    // System.out.println("Perimeter: " + shape2.getPerimeter());
    // System.out.println("angleDAB: " + shape2.getAngle('A'));
    // System.out.println("angleABC: " + shape2.getAngle('B'));
    // System.out.println("angleBCD: " + shape2.getAngle('C'));
    // System.out.println("angleCDA: " + shape2.getAngle('D'));
    // System.out.println("Area: " + shape2.getArea());
    // System.out.println("Type: " + shape2.getShapeType());
    // System.out.println(shape2.draw());

    // parallelogram 未完成
    //
    // ／ ｜
    // ／ ｜
    // ｜ ｜
    // ｜ ｜
    // ｜ ／
    // ｜ ／

    // ﹍ ﹍ ﹍ ﹍
    // ／ ／
    // ／ ／
    // ﹉ ﹉ ﹉ ﹉

    // *******************************************
    // UNCOMMENT BELOW TO SEE PARALLELOGRAM SHAPE
    // *******************************************

    // Line lineAB = new Line(new Point(0,0), new Point(2,2));
    // Line lineBC = new Line(new Point(2,2), new Point(2,6));
    // Line lineCD = new Line(new Point(2,6), new Point(0,4));
    // Line lineDA = new Line(new Point(0,4), new Point(0,0));
    // Line lineAC = new Line(new Point(0,0), new Point(2,6));
    // Line lineBD = new Line(new Point(2,2), new Point(0,4));
    // QuadrilateralShape shape3 = new QuadrilateralShape(lineAB, lineBC, lineCD,
    // lineDA, lineAC, lineBD);
    // System.out.println("Perimeter: " + shape3.getPerimeter());
    // System.out.println("Area: " + shape3.getArea());
    // System.out.println("Type: " + shape3.getShapeType());
    // System.out.println(shape3.draw());

    // trapezoid
    // ﹍ ﹍
    // ／ ＼
    // ／ ＼
    // ﹉ ﹉ ﹉ ﹉ ﹉ ﹉

    // ***************************************
    // UNCOMMENT BELOW TO SEE TRAPEZOID SHAPE
    // ***************************************

    Line lineAB = new Line(new Point(0, 0), new Point(6, 0));
    Line lineBC = new Line(new Point(6, 0), new Point(4, 2));
    Line lineCD = new Line(new Point(4, 2), new Point(2, 2));
    Line lineDA = new Line(new Point(2, 2), new Point(0, 0));
    Line lineAC = new Line(new Point(0, 0), new Point(4, 2));
    Line lineBD = new Line(new Point(6, 0), new Point(2, 2));
    QuadrilateralShape shape4 = new QuadrilateralShape(lineAB, lineBC, lineCD, lineDA, lineAC, lineBD);
    System.out.println("Perimeter: " + shape4.getPerimeter());
    System.out.println("angleDAB: " + shape4.getAngle('A'));
    System.out.println("angleABC: " + shape4.getAngle('B'));
    System.out.println("angleBCD: " + shape4.getAngle('C'));
    System.out.println("angleCDA: " + shape4.getAngle('D'));
    System.out.println("Area: " + shape4.getArea());
    System.out.println("Type: " + shape4.getShapeType());
    System.out.println(shape4.draw());

    // kite（凧）未完成
    //
    // ／＼
    // ／ ＼
    // ＼ ／
    // ＼ ／
    // ＼／
    //

    // ***************************************
    // UNCOMMENT BELOW TO SEE KITE SHAPE
    // ***************************************

    // Line lineAB = new Line(new Point(0,0), new Point(5,3));
    // Line lineBC = new Line(new Point(5,3), new Point(0,8));
    // Line lineCD = new Line(new Point(0,8), new Point(-5,3));
    // Line lineDA = new Line(new Point(-5,3), new Point(0,0));
    // Line lineAC = new Line(new Point(0,0), new Point(0,8));
    // Line lineBD = new Line(new Point(5,3), new Point(-5,3));
    // QuadrilateralShape shape4 = new QuadrilateralShape(lineAB, lineBC, lineCD,
    // lineDA, lineAC, lineBD);
    // System.out.println("Perimeter: " + shape4.getPerimeter());
    // System.out.println("angleDAB: " + shape4.getAngle('A'));
    // System.out.println("angleABC: " + shape4.getAngle('B'));
    // System.out.println("angleBCD: " + shape4.getAngle('C'));
    // System.out.println("angleCDA: " + shape4.getAngle('D'));
    // System.out.println("Area: " + shape4.getArea());
    // System.out.println("Type: " + shape4.getShapeType());
    // System.out.println(shape4.draw());
  }

}
