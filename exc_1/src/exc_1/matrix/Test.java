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
		 * Die Berechnungsdauer in Abhängigkeit von der Größe schwankt teilweise start, selbst bei konstanter Größe.
		 * Beispiel: Dauer Größe 2000: 48s - 80s
		 * 
		 * Die benötigte Dauer um eine Operation durchzuführen scheint bei wachsender Matrix-Größe zu steigen.
		 * Sie bleibt nicht konstant!
		 * 
		 * Durchsnittliche Dauer für eine Operation:
		 * (Berechnung: Dauer gesamt / Operationen gesamt)
		 * 
		 * Größe 500:	1,5ns
		 * Größe 1000:	1,65ns
		 * Größe 1500:	4ns
		 * Größe 2000:	8ns (6ns - 10ns)
		 * 
		 * Erste Annahme: Bei Größen über 500 verdoppelt sich die Dauer einer Operation bei jedem "Größensprung" um 500:
		 * Approximationsfunktion (Größe 500 bis 2000): t1(x) = 2^((x-500)/500) ns * x³
		 * 
		 * Ab etwa Größe 2000 scheint sich die ansteigende Operationsdauer zu relativieren.
		 * Ab dieser Größe liegt die durchsnittliche Dauer einer Operation bei 8ns.
		 * Approximationsfunktion (Größe 2000 bis ?): t2(x) = 8ns * x³ 
		 * 
		 * 
		 * Approximation der Größe mit t2:
		 * (tatsächliches Ergebnis in Klammern)
		 * 1 min: Größe ~2000 (48s - 80s)
		 * 2 min: Größe ~2500 (100s - 120s)
		 * 5 min: Größe ~3300 (306s)
		 * 10 min: Größe ~4200 (703s)
		 * 
		 * 
		 * 
		 * Addition:
		 * nicht genügend Speicher ab Größe ~20.000.
		 * Eine Addition bei dieser Größe ist bereits nach etwa einer Sekunde abgeschlossen.
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
