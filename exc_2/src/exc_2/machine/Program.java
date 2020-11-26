package exc_2.machine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Program {
	private List<Instruction> program;
	public int ip;
	public int[] storage;
	public boolean done;
	
	private Program() {
		program = new ArrayList<Instruction>();
		ip = 0;
		storage = new int[256];
	}
	
	public List<Instruction> getInstructionList() {
		return program;
	}
	
	public static Program load(String path) {
		Program p = new Program();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(Program.class.getResourceAsStream(path)));
			
			String line;
			while((line = br.readLine()) != null) {
				if(line.startsWith("'") || line.equals(""))
					continue;
				
				String[] strInst= line.split(" ");
				Instruction inst = new Instruction(p, strInst[0], Integer.parseInt(strInst[1]));
				p.program.add(inst);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return p;
	}
}
