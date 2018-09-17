import java.util.Scanner;

public class LenskartChallenge {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int b = scanner.nextInt();
		int r = scanner.nextInt();
		int y = scanner.nextInt();
		int g = scanner.nextInt();

		CandidateCode code = new CandidateCode();
		int maxLength = code.findMaxLength(b, r, y, g);
		System.out.println(maxLength);

		scanner.close();

	}

	private char getNextRuby(char currentRuby, int b, int r, int y, int g) {
		char nextRuby = 'r';
		if (currentRuby == 0) {
			if (r == 0) {
				if (b == 0) {
					if (y > 0) {
						nextRuby = 'y';
					} else {
						nextRuby = 'g';
					}
				} else {
					nextRuby = 'b';
				}
			}
		}

		else {
			if (currentRuby == 'r') {
				if (b > 0) {
					nextRuby = 'b';
				} else {
					nextRuby = 'y';
				}
			} else if (currentRuby == 'b') {
				if (b > 0) {
					nextRuby = 'b';
				} else {
					nextRuby = 'y';
				}
			} else if (currentRuby == 'y') {
				if (g > 0) {
					nextRuby = 'g';
				} else {
					nextRuby = 'r';
				}
			} else {
				if (g > 0) {
					nextRuby = 'g';
				} else {
					nextRuby = 'r';
				}
			}
		}

		return nextRuby;
	}

	private int findMaxLength(int b, int r, int y, int g) {
		int maxLength = 0;
		char currentRuby = 0;
		char nextRuby = 0;
		boolean toCalc = true;
		while (toCalc == true) {

			switch (nextRuby) {

			case 'b':
				maxLength++;
				b--;

				if ((b <= 0) && (y <= 0)) {
					toCalc = false;
				}
				break;
			case 'r':
				maxLength++;
				r--;

				if ((b == 0) && (y == 0)) {
					toCalc = false;
				}
				break;
			case 'y':
				maxLength++;
				y--;

				if ((g <= 0) && (r <= 0)) {
					toCalc = false;
				}

				break;
			case 'g':
				maxLength++;
				g--;

				if ((r <= 0) && (g <= 0)) {
					toCalc = false;
				}

				break;
			default:
				// nextRuby = getNextRuby(currentRuby, b, r, y, g);
				break;
			}
			currentRuby = nextRuby;
			nextRuby = getNextRuby(currentRuby, b, r, y, g);
		}
		return maxLength;
	}
}
