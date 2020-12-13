package exc_9.hashing;

import java.util.Arrays;

public class HashTable {
	private ExtendedHashFunction f;
	private int m;
	private int[] table;
	
	public HashTable(ExtendedHashFunction f, int m) {
		this.f = f;
		this.m = m;
		table = new int[m];
	}
	
	public void insert(int... keys) {
		for(int key : keys)
			insert(key);
	}
	
	public void insert(int key) {
		if(key <= 0)
			return;
		
		int pos = -1;
		int i = 0;
		while(pos == -1) {
			int tryPos = f.exec(key, i);
			if(table[tryPos] == 0)
				pos = tryPos;
			else {
				System.out.println("Collission at: " + tryPos + " for key: " + key);
			}
			
			if(i >= m) {
				System.out.println("issues...");
			}
			
			i++;
		}
		
		table[pos] = key;
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return Arrays.toString(table);
	}
	
	public interface HashFunction {
		int exec(int s);
	}
	
	public interface ExtendedHashFunction {
		int exec(int s, int i);
	}
}
