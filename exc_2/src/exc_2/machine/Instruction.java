package exc_2.machine;

import java.util.Scanner;

enum Operation {
	ADD, SUB, MUL, DIV,
	LDA, LDK,
	STA, INP, OUT,
	HLT,
	JMP, JEZ, JNE, JLZ, JLE, JGZ, JGE
}

public class Instruction {
	private Program context;
	private Operation op;
	private int value;
	
	private Scanner scan;
	
	public Instruction(Program context, String strOP, int value) {
		this.op = Operation.valueOf(strOP.toUpperCase());
		this.value = value;
		this.context = context;
		
		scan = new Scanner(System.in);
	}
	
	public void execute() {
		switch(op) {
			case ADD:
				context.storage[0] += context.storage[value];
				break;
			case SUB:
				context.storage[0] -= context.storage[value];
				break;
			case MUL:
				context.storage[0] *= context.storage[value];
				break;
			case DIV:
				context.storage[0] /= context.storage[value];
				break;
			case LDA:
				context.storage[0] = context.storage[value];
				break;
			case LDK:
				context.storage[0] = value;
				break;
			case STA:
				context.storage[value] = context.storage[0];
				break;
			case INP:
				context.storage[value] = scan.nextInt();
				break;
			case OUT:
				System.out.println(context.storage[value]);
				break;
			case HLT:
				if(value == 99)
					context.done = true;
				
				break;
			case JMP:
				context.ip = value - 1;
				break;
			case JEZ:
				if(context.storage[0] == 0)
					context.ip = value - 1;
				
				break;
			case JNE:
				if(context.storage[0] != 0)
					context.ip = value - 1;
				
				break;
			case JLZ:
				if(context.storage[0] < 0)
					context.ip = value - 1;
				
				break;
			case JLE:
				if(context.storage[0] <= 0)
					context.ip = value - 1;
				
				break;
			case JGZ:
				if(context.storage[0] > 0)
					context.ip = value - 1;
				
				break;
			case JGE:
				if(context.storage[0] >= 0)
					context.ip = value - 1;
				
				break;
				
		}
	}
	
	@Override
	public String toString() {
		return op + " " + value;
	}
}