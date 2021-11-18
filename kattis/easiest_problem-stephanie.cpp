#include <stdio.h>
#include <iostream>

using namespace std;

int main() {
	// for a number N, find m (smallest but >10)
	// such that sum_of_digits(N) = 
	// sumofdigits(N*m)

	int N, N_sum, Nm, Nm_sum, N_orig;
	// sum = sum of digits aiming for
	// p = testing for m values
	// num = N*p

	while (cin >> N && N > 0) {
		N_orig = N;
		N_sum = 0;
		while (N >= 10) {
			N_sum += N % 10;
			N /= 10;
		}
		N_sum += N;

		for (int m = 11; m <= 100; m++) {
			Nm = N_orig * m;
			Nm_sum = 0;
			while (Nm >= 10) {
				Nm_sum += Nm % 10;
				Nm /= 10;
			}
			Nm_sum += Nm;
			if (Nm_sum == N_sum) {
				cout << m << endl;
				break;
			}
		}
	}

	return 0;
}