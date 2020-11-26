package exc_1.operation;

public class Calculator {
	public static void main(String[] args) {
		calculateAndPrintResultTable(new GgT(), 30, 40, 30, 40);
		System.out.println("\n");
		calculateAndPrintResultTable(new GgT_Recursive(), 30, 40, 30, 40);
		System.out.println("\n");
		calculateAndPrintResultTable(new KgV(), 30, 40, 30, 40);
		System.out.println("\n");
		calculateAndPrintResultTable(new Multiplication(), 30, 40, 30, 40);
		
		//Auffälligkeit:
		//Wenn der ggT 1 ist, entspricht die Multiplikation dem kgV.
		//Darüber hinaus: ggT(a, b) * kgV(a, b) = a * b
	}
	
	public static void calculateAndPrintResultTable(Operation op, int aFrom, int aTo, int bFrom, int bTo) {
		System.out.println("Operation: " + op.getClass().getSimpleName() + "\n");
		
		int[][] resultTable = new int[aTo - aFrom + 1][bTo - bFrom + 1];
		int digits = 0;
		int curDigits;
		int result;
		
		//Execute the operations for the specified range.
		//Store the results into resultTable.
		for(int a = aFrom; a <= aTo; a++) {
			for(int b = bFrom; b <= bTo; b++) {
				result = op.calculate(a, b);
				resultTable[a - aFrom][b - bFrom] = result;
				
				//Determine maximum number of digits of a result
				curDigits = Integer.toString(result).length();
				if(curDigits > digits)
					digits = curDigits;
				
			}
		}
		
		//Increment digits by 2 (used to generate space between the output results)
		digits +=2;
		String output = "";
		
		//Determine maximum number of digits of an 'a' value
		int digitsIndent = Integer.toString(aTo).length();
		
		
		//Print 'b' column values
		output = " ".repeat(digitsIndent + 2);
		for(int b = bFrom; b <= bTo; b++)
			output += String.format("%" + digits + "s", b);
		
		System.out.println(output);
		
		
		//Print title line
		int lengthOfLine = digits * (bTo - bFrom + 1);
		System.out.println(" ".repeat(digitsIndent + 1) + "+" + "-".repeat(lengthOfLine));
			
		
		//Print table
		output = "";
		for(int a = aFrom; a <= aTo; a++) {
			for(int b = bFrom; b <= bTo; b++)
				output += String.format("%" + digits + "s", resultTable[a - aFrom][b - bFrom]);
			
			//Add 'a' row values to output (before printing)
			System.out.println(String.format("%" + digitsIndent + "s", a) + " |" + output);
			output = "";
		}
	}
}


//Implementieren der Operationen:

class GgT implements Operation {
	@Override
	public int calculate(int a, int b) {
		int r;
		do {
			r = a % b;
			a = b;
			b = r;
		} while(r != 0);
		
		return a;
	}
}

class GgT_Recursive implements Operation {
	@Override
	public int calculate(int a, int b) {
		int r = a % b;
		if(r != 0)
			return calculate(b, r);
		
		return b;
	}
}

class KgV implements Operation {
	@Override
	public int calculate(int a, int b) {
		int v = a;
		while(v % b != 0)
			v += a;
		
		return v;
	}
}

class Multiplication implements Operation {
	@Override
	public int calculate(int a, int b) {
		return a * b;
	}
}
