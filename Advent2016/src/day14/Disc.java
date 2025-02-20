package day14;

public class Disc {
	int positions;
	int currentPosition;

	public Disc(int positions, int current) {
		this.positions = positions;
		this.currentPosition = current;
	}

	public int moveForward() {
		currentPosition = currentPosition == positions - 1 ? 0
				: currentPosition + 1;
		return currentPosition;
	}

	public int posInSecs(int secs) {
		// int result = currentPosition+secs;
		// if(result > positions-1){
		// result = result - positions;
		// }
		// return result;
		return (currentPosition + secs) % positions;
	}

	public int timeUntilZero() {
		return positions - currentPosition;
	}
}
