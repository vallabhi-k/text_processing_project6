package project6;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class LCS {
	
	public LCS() {
		
	}
	
	public int[] algB(int m, int n, String strA, String strB) {
		
		int[][] k = new int[2][n+1];
		for( int j=0; j<=n; j++) {
			k[1][j] = 0;
		}
		for(int i=1; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				k[0][j] = k[1][j];
			}
			for(int j=1; j<=n; j++) {
				if(strA.charAt(i-1) == strB.charAt(j-1)) {
					k[1][j] = k[0][j-1] + 1;
				}else{
					k[1][j] = max(k[1][j-1], k[0][j]);
				}
			}
		}
		return k[1];
		
	}
	
	public int max(int x, int y) {
		if(x > y) {
			return x;
		}else{
			return y;
		}
	}
	
	public String algC(int m, int n, String strA, String strB) {
		int i = 0;
		int j = 0;
		String c = "";
		
		// Step 1
		if(n == 0) {
			c = "";
		} else if(m == 1) {
			c = "";
			for(j = 0; j < n; j++) {
				if(strA.charAt(0) == strB.charAt(j)) {
					c = "" + strA.charAt(0);
					break;
				}
			}
		} else {
			i = (int) Math.floor(((double)m) / 2);
			int[] l1 = algB(i, n, strA.substring(0, i), strB);
			int[] l2 = algB(m - i, n, reverseString(strA.substring(i)), reverseString(strB));
			int k = findK(l1, l2, n);
			String c1 = algC(i, k, strA.substring(0, i), strB.substring(0, k));
			String c2 = algC(m - i, n - k, strA.substring(i), strB.substring(k));
			
			c = c1 + c2;
		}
		
		return c; 
	}
	
	
	public String reverseString(String input) {
		String output = "";
		
		for(int i = input.length() - 1; i >= 0; i--) {
			output = output + input.charAt(i);
		}
		
		return output;
	}

	public int findK(int[] l1, int[] l2, int n) {
		int m = 0;
		int k = 0;
		
		for(int j = 0; j <= n; j++) {	
			if(m < (l1[j] + l2[n - j])) {
				m = l1[j] + l2[n - j];
				k = j;
			}
		}
		
		return k;
	}
	
    public String find(String A, String B) {
		LCS alg = new LCS();
		return alg.algC(A.length(), B.length(), A, B);
	}
}

