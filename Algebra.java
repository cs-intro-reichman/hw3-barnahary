// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3)); // 2 + 3
		System.out.println(plus(-2,-3));   // -5
		System.out.println(plus(-2,3)); // 1
	    System.out.println(minus(7,2));  // 5
		System.out.println(minus(-5,-3));  // -8
   		System.out.println(minus(2,7));  // -5
		   System.out.println(minus(-2,-9));  // -11
 		System.out.println(times(3,4)); // 12
		 System.out.println(times(1,-2)); // -2
		 System.out.println(times(-3,-2));  // 6
		 System.out.println(times(-3,2));  // -6
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
		   System.out.println(pow(-2,3)); //-8
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3      // 5 
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x1 < 0) {
			for (int j = 0; j < -x1; j++) {
			x2--;
		}
	 } else if (x1 >= 0) {
		for (int i = 0; i < x1; i++) {
			x2++;
		}
	}
		return x2;
}



	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x1 < 0 && x2 < 0) {
			for (int j = 0; j > x2; j--) {
				x1++;
			}
		}
		for (int i = 0; i < x2; i++) {
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int outcome = 0;
		if (x2 < 0 && x1 < 0) {
			for (int j = 0; j > x2; j--) {
				outcome = plus(outcome, x1);
			} 
		} if (x1 > 0 && x2 < 0) {
			for ( int k = 0; k > x2; k--) {
				outcome -= 1;
			}
		}
			for (int i = 0; i < x2; i++) {
		outcome = plus(outcome, x1);
		
	} 
	if (x1 < 0 && x2 < 0) {
		outcome = -outcome;
	}
	return outcome;
}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		boolean negative = false;
		if (x < 0) {
			negative = (mod(n, 2)!= 0);
			x = -x;
		}
		for (int i = 0; i < n; i++) {
			result = times(result, x);
		}
		if (negative) {
			result = -result;
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
	     boolean negativeResult = (x1 < 0) != (x2 < 0);

		 if (x1 < 0) x1 = minus(0, x1);
		 if (x2 < 0) x2 = minus(0, x2);

		 int times = 0;
		 while (x1 >= x2) {
         x1 = minus(x1, x2);
		 times++;
		 }

		 if (negativeResult) {
			times = minus(0, times);
		 }
		
        return times;
    }
   
		


	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int firstStep = div(x1, x2);
		int secondStep = times(firstStep, x2);
		int thirdStep = minus(x1, secondStep );
		return thirdStep;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x == 0) {
			return 0;
		} if (x == 1)
		return 1;
		int finel = div(x, 2);
		int prev = 0;
		
		while (finel != prev) {
			prev = finel;


			int firstStep = div(x, finel);
			int secondStep = plus(finel, firstStep);
			finel = div(secondStep, 2); 
		}
		
		return finel;	 	
		
	}
}
