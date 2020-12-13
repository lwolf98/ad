package exc_9.hashing;

import exc_9.hashing.HashTable.ExtendedHashFunction;
import exc_9.hashing.HashTable.HashFunction;

public class TestHash {
	public static void main(String[] args) {
		int m = 11;
		
		HashFunction h_ = s -> s;
		ExtendedHashFunction h_lin = (s, i) -> (h_.exec(s) + i) % m;
		ExtendedHashFunction h_square = (s, i) -> (h_.exec(s) + i + 3*i*i) % m;
		
		HashFunction h_1 = h_;
		HashFunction h_2 = s -> 1 + (s % (m - 1));
		ExtendedHashFunction h_double = (s, i) -> (h_1.exec(s) + i * h_2.exec(s)) % m; 
		
		HashTable tab_lin = new HashTable(h_lin, m);
		tab_lin.insert(10, 22, 31, 4, 15, 28, 17, 88, 59);
		tab_lin.print();
		
		HashTable tab_square = new HashTable(h_square, m);
		tab_square.insert(10, 22, 31, 4, 15, 28, 17, 88, 59);
		tab_square.print();
		
		HashTable tab_double = new HashTable(h_double, m);
		tab_double.insert(10, 22, 31, 4, 15, 28, 17, 88, 59);
		tab_double.print();
	}
}
