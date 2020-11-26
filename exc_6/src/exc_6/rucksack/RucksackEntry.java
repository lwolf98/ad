package exc_6.rucksack;

public class RucksackEntry implements Comparable<RucksackEntry> {
	public int value;
	public int weight;
	public double percentage;
	
	public RucksackEntry() {
		percentage = 1;
	}
	
	public RucksackEntry(int value, int weight) {
		this();
		
		this.value = value;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(RucksackEntry e) {
		if(e == null)
			return -1;
		
		return Double.compare(valueRatio(), e.valueRatio());
	}

	public double valueRatio() {
		return (double)value / weight;
	}
	
	@Override
	public String toString() {
		return String.format("[V: %d, W: %d, R: %.2f, P: %.2f]", value, weight, valueRatio(), percentage);
	}
}
