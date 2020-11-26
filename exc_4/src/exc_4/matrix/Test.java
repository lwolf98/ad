package exc_4.matrix;

import exc_4.timer.Timer.OutputType;

public class Test {
	public static void main(String[] args) {
		int size = 1024;
		Matrix.showLog = true;
		Matrix.typeOut = OutputType.Millisecond;
		Matrix m = new Matrix(size, size);
		m.randomFill();
		
		Matrix n = new Matrix(size, size);
		n.randomFill();
		
		/*m.table = new int[][] {
				{6, 0, 6, 5},
				{8, 3, 0, 0},
				{5, 4, 3, 3},
				{6, 9, 0, 8}
			};
			
		n.table = new int[][] {
				{8, 7, 0, 4},
				{4, 1, 6, 8},
				{4, 9, 9, 7},
				{3, 0, 4, 8}
			};*/
		
		/*m.print();
		n.print();
		System.out.println("---------\n");*/
		
		Matrix.mult(m, n);
		Matrix.mult_var2(m, n);
		
		/*
		 * Ergebnis:
		 * Am schnellsten funktioniert die Implementierung wohl, wenn
		 * für Matrizen bis Größe 128x128 die Standard-Methode verwendet wird.
		 * Bei größeren Matrizen ist die Variante 2 effizienter.
		 * Matrix.mult_var2() stellt die Hybridlösung dar.
		 */
	}
}
