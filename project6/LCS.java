package project6;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class LCS {
 
  public String find(String A, String B) {
    int m=A.length();
    int n=B.length();
    
    int[][] L = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (A.charAt(i - 1) == B.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j],L[i][j - 1]);
            }
        }

        int index = L[m][n];
        int temp = index;
        char[] lcs = new char[index + 1];
        lcs[index] = '\u0000';
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                lcs[index - 1] = A.charAt(i - 1);
                i--;
                j--;
                index--;
            }
            else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;
        }
        String ans="";
           for (int k = 0; k <= temp; k++)
            ans += lcs[k];
        return ans;
  }

}
