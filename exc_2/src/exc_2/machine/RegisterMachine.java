package exc_2.machine;

public class RegisterMachine {
	public void executeProgram(Program program) {
		boolean debug = false;
		while(!program.done) {
			Instruction inst = program.getInstructionList().get(program.ip);
			inst.execute();
			
			if(debug)
				System.out.println(inst.toString() + ": [line: " + program.ip + ", exec: " + program.storage[0] + ", i: " + program.storage[1] + ", result: " + program.storage[2] + ", n: " + program.storage[3] + ", c1: " + program.storage[4] + "]");
			
			program.ip++;
		}
	}
	
	public static void main(String[] args) {
		RegisterMachine machine = new RegisterMachine();
		Program prg = Program.load("/Prog.regm");
		machine.executeProgram(prg);
	}
}
