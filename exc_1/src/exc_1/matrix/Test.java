package exc_1.matrix;

import exc_1.timer.Timer.OutputType;

public class Test {
	public static void main(String[] args) {
		
		testMatrixMultTimeEvaluation(2000, 10);
		testMatrixMultTimeEvaluation(2500, 5);
		testMatrixMultTimeEvaluation(3300, 2);
		testMatrixMultTimeEvaluation(4200, 1);

		
		testMatrixAdd(18720);
		
		/*
		 * Ergebnisse:
		 * Multiplikation:
		 * 
		 * Info:
		 * Die Berechnungsdauer in Abh�ngigkeit von der Gr��e schwankt teilweise start, selbst bei konstanter Gr��e.
		 * Beispiel: Dauer Gr��e 2000: 48s - 80s
		 * 
		 * Die ben�tigte Dauer um eine Operation durchzuf�hren scheint bei wachsender Matrix-Gr��e zu steigen.
		 * Sie bleibt nicht konstant!
		 * 
		 * Durchsnittliche Dauer f�r eine Operation:
		 * (Berechnung: Dauer gesamt / Operationen gesamt)
		 * 
		 * Gr��e 500:	1,5ns
		 * Gr��e 1000:	1,65ns
		 * Gr��e 1500:	4ns
		 * Gr��e 2000:	8ns (6ns - 10ns)
		 * 
		 * Erste Annahme: Bei Gr��en �ber 500 verdoppelt sich die Dauer einer Operation bei jedem "Gr��ensprung" um 500:
		 * Approximationsfunktion (Gr��e 500 bis 2000): t1(x) = 2^((x-500)/500) ns * x�
		 * 
		 * Ab etwa Gr��e 2000 scheint sich die ansteigende Operationsdauer zu relativieren.
		 * Ab dieser Gr��e liegt die durchsnittliche Dauer einer Operation bei 8ns.
		 * Approximationsfunktion (Gr��e 2000 bis ?): t2(x) = 8ns * x� 
		 * 
		 * 
		 * Approximation der Gr��e mit t2:
		 * (tats�chliches Ergebnis in Klammern)
		 * 1 min: Gr��e ~2000 (48s - 80s)
		 * 2 min: Gr��e ~2500 (100s - 120s)
		 * 5 min: Gr��e ~3300 (306s)
		 * 10 min: Gr��e ~4200 (703s)
		 * 
		 * 
		 * 
		 * Addition:
		 * nicht gen�gend Speicher ab Gr��e ~20.000.
		 * Eine Addition bei dieser Gr��e ist bereits nach etwa einer Sekunde abgeschlossen.
		 * 
		 */
	}
	
	private static void testMatrixMultTimeEvaluation(int size, int loops) {
		//testMatrixInit();
		//testMatrixInput();
		
		System.out.println("Size: " + size);
		
		Matrix.showLog = true;
		Matrix.typeOut = OutputType.Millisecond;
		
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		long sumDuration = 0;
		
		for(int i = 0; i < loops; i++) {
			System.out.println("Calculation: " + (i + 1));
			testMatrixMult(size);
			sumDuration += Matrix.getDurationOfLastOperation();
		}
		
		System.out.println("Average duration (" + Matrix.typeOut + "): " + (sumDuration / loops) + "\n");
		
		System.out.println("-".repeat(100));
	}
	
	private static void testMatrixInit() {
		Matrix m = new Matrix(3, 4);
		m.print();
		m.init();
		m.print();
	}
	
	private static void testMatrixInput() {
		Matrix m = new Matrix(2, 3);
		m.input();
		m.print();
	}
	
	private static void testMatrixAdd(int size) {
		Matrix m1 = new Matrix(size, size);
		Matrix m2 = new Matrix(size, size);
		
		m1.randomFill();
		//m1.print();
		m2.randomFill();
		//m2.print();

		Matrix mResult = Matrix.add(m1, m2);
		
		//mResult.print();
		System.out.println();
	}
	
	private static void testMatrixMult(int size) {
		Matrix m1 = new Matrix(size, size);
		Matrix m2 = new Matrix(size, size);
		
		m1.randomFill();
		//m1.print();
		m2.randomFill();
		//m2.print();

		Matrix mResult = Matrix.mult(m1, m2);
		
		//mResult.print();
		System.out.println();
	}
}
