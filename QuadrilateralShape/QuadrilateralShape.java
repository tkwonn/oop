public class QuadrilateralShape {
	public Line lineAB;
	public Line lineBC;
	public Line lineCD;
	public Line lineDA;
	public Line lineAC;
	public Line lineBD;
	public double lenAB;
	public double lenBC;
	public double lenCD;
	public double lenDA;
	public double lenAC;
	public double lenBD;
	public double angleABC;
	public double angleBCD;
	public double angleCDA;
	public double angleDAB;

	public QuadrilateralShape(Line lineAB, Line lineBC, Line lineCD, Line lineDA, Line lineAC, Line lineBD) {
		this.lineAB = lineAB;
		this.lineBC = lineBC;
		this.lineCD = lineCD;
		this.lineDA = lineDA;
		this.lineAC = lineAC;
		this.lineBD = lineBD;
		this.lenAB = lineAB.getLength();
		this.lenBC = lineBC.getLength();
		this.lenCD = lineCD.getLength();
		this.lenDA = lineDA.getLength();
		this.lenAC = lineAC.getLength();
		this.lenBD = lineBD.getLength();
		this.angleDAB = getAngle('A');
		this.angleABC = getAngle('B');
		this.angleBCD = getAngle('C');
		this.angleCDA = getAngle('D');
	}

	// find the angle θ between the two vectors AB
	public double getAngle(char c) {
		switch (c) {
		case 'A':
			return calcAngle(this.lineDA, this.lineAB, this.lenDA, this.lenAB);
		case 'B':
			return calcAngle(this.lineAB, this.lineBC, this.lenAB, this.lenBC);
		case 'C':
			return calcAngle(this.lineBC, this.lineCD, this.lenBC, this.lenCD);
		case 'D':
			return calcAngle(this.lineCD, this.lineDA, this.lenCD, this.lenDA);
		}
		return 0.0;
	}

	// find the inner product of vectors
	// line1=(3,5), line2=(-4,1) -> (3)(-4) + (5)(1)
	public double getInnerProduct(Line lineA, Line lineB) {
		double x1 = lineA.endPoint.x - lineA.startPoint.x;
		double y1 = lineA.endPoint.y - lineA.startPoint.y;
		double x2 = lineB.endPoint.x - lineB.startPoint.x;
		double y2 = lineB.endPoint.y - lineB.startPoint.y;

		return x1 * x2 + y1 * y2;
	}

	public double calcAngle(Line lineA, Line lineB, double lengthA, double lengthB) {
		double cos_sita = getInnerProduct(lineA, lineB) / (lengthA * lengthB);

		double sita = Math.acos(cos_sita);
		// return it in degree
		sita = sita * 180.0 / Math.PI;

		return Math.floor(sita);
	}

	public double getPerimeter() {
		double perimeter = Math.round((this.lenAB + this.lenBC + this.lenCD + this.lenDA) * 10);
		return perimeter / 10;
	}

	public double getArea() {
		String shape = this.getShapeType();
		if (shape == "square" || shape == "rectangle" || shape == "parallelogram")
			return this.lenAB * this.lenBC;
		else if (shape == "trapezoid") {
			if (this.lenBC == this.lenDA && this.lenAB != this.lenCD) {
				double area = Math.round(((this.lenAB + this.lenCD) * this.lenBC / 2) * 10);
				return area / 10;
			} else if (this.lenAB == this.lenCD && this.lenBD != this.lenDA) {
				double area = Math.round(((this.lenBD + this.lenDA) * this.lenAB / 2) * 10);
				return area / 10;
			}
		} else if (shape == "kite") {
			double area = Math.round((this.lenBD * this.lenAC / 2) * 10);
			return area / 10;
		}
		return 0.0;
	}

	public String getShapeType() {
		if (angleABC == 0 || angleABC == 180 || angleBCD == 0 || angleBCD == 180 || angleCDA == 0 || angleCDA == 180
				|| angleDAB == 0 || angleDAB == 180)
			return "not a quadrilateral";

		if (this.lenAB == this.lenBC && this.lenBC == this.lenCD && this.lenCD == this.lenDA) {
			if (angleABC == 90 && angleBCD == 90 && angleCDA == 90 && angleDAB == 90)
				return "square";
			else
				return "rhombus";
		} else if (this.lenAB == this.lenCD && this.lenBC == this.lenDA) {
			if (angleABC == 90 && angleBCD == 90 && angleCDA == 90 && angleDAB == 90)
				return "rectangle";
			else
				return "parallelogram";
		} else if (angleABC + angleBCD == 180 && angleCDA + angleDAB == 180
				|| angleDAB + angleABC == 180 && angleBCD + angleCDA == 180) {
			return "trapezoid";
		} else if ((this.lenAB == this.lenBC && this.lenCD == this.lenDA)
				|| (this.lenAB == this.lenDA && this.lenBC == this.lenCD)) {
			return "kite";
		} else {
			return "other";
		}
	}

	public String drawSquare() {
		int lengthX = (int) this.lenAB;
		int lengthY = (int) this.lenBC;
		String square = "";
		String topWidth = "   ";
		String bottomWidth = "   ";
		String widthSpace = "";
		for (int i = 0; i < lengthX; i++) {
			topWidth += "  ﹍  ";
			bottomWidth += "  ﹉  ";
			widthSpace += "      ";
		}
		square += topWidth + "\n";
		for (int j = 0; j < lengthY; j++) {
			square += " |" + widthSpace + "|" + "\n";
		}
		square += bottomWidth;
		return square;
	}

	public String drawTrapezoid() {
		int lenAtoB = (int) this.lenAB;
		int lenBtoC = (int) this.lenBC;
		int lenCtoD = (int) this.lenCD;
		int lenDtoA = (int) this.lenDA;
		int topWidth = 0;
		int bottomWidth = 0;
		int sideWidth = 0;
		int height = 0;
		String trapezoid = "";
		if (lenAtoB != lenCtoD || lenBtoC != lenDtoA) {
			if (lenAtoB != lenCtoD) {
				topWidth = Math.min(lenAtoB, lenCtoD);
				bottomWidth = Math.max(lenAtoB, lenCtoD);
				sideWidth = (int) this.lenDA;
				height = sideWidth;
			} else {
				topWidth = Math.min(lenBtoC, lenDtoA);
				bottomWidth = Math.max(lenBtoC, lenDtoA);
				sideWidth = (int) this.lenBC;
				height = sideWidth;
			}
		}
		// System.out.println(topWidth);
		// System.out.println(bottomWidth);
		// System.out.println(sideWidth);
		// Upper Part
		for (int i = 0; i < sideWidth; i++) {
			trapezoid += "   ";
		}
		for (int i = 0; i < topWidth; i++) {
			trapezoid += "﹍";
		}
		trapezoid += "\n";

		for (int i = 0; i < sideWidth - 1; i++) {
			trapezoid += "   ";
		}

		// Diagonal part
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < sideWidth - 1; j++) {
				trapezoid += " ";
			}
			trapezoid += "/";
			for (int j = 0; j < topWidth; j++) {
				trapezoid += "   ";
			}
			trapezoid += "\\" + "\n";
			topWidth += 2;
		}

		// Lower Part
		for (int i = 0; i < bottomWidth; i++) {
			trapezoid += " ﹉";
		}

		return trapezoid;
	}

	public String draw() {
		String shape = this.getShapeType();
		if (shape == "square" || shape == "rectangle") {
			return this.drawSquare();
		}
		// else if(shape == "parallelogram（平行四辺形）"){
		// return this.drawParallelogram();
		// }
		else if (shape == "trapezoid") {
			return this.drawTrapezoid();
		}
		// else if(shape == "kite"){
		// return this.drawKite();
		// }
		else
			return "Such a shape could not be drawn.";
	}
}
