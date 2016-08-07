package leetcode;

/* Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int i = m + n - 1;
        int j = m - 1;
        int k = n - 1;
        if (m == 0)
            while (k >= 0) {
                A[k] = B[k];
                k--;
            }
        while (j >= 0 && k >= 0) {
            if (A[j] > B[k])
                A[i--] = A[j--];
            else
                A[i--] = B[k--];
        }
        while (k >= 0) {
            A[i--] = B[k--];
        }
    }

    public void mergeArray(int fistArray[], int fistArrayNum, int secArray[], int secArrayNum) {
        int fistIndex = fistArrayNum - 1;
        int secIndex = secArrayNum - 1;
        int pos = fistArrayNum + secArrayNum - 1;
        while (fistIndex>=0 && secIndex>=0) {
            if (fistArray[fistIndex] > secArray[secIndex])
                fistArray[pos--] = fistArray[fistIndex--];
            else
                fistArray[pos--] = secArray[secIndex--];
        }
        if(fistIndex>0){
            fistArray[pos--] = fistArray[fistIndex--];
        }
        if(secIndex>0){
            fistArray[pos--] = secArray[secIndex--];
        }
    }


    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();
        int array1[] = new int[10];
        for (int i = 0; i < 5; i++) {
            array1[i] = 2 * i + 1;
        }
        int array2[] = {2, 4, 6, 8, 10};
        test.mergeArray(array1, 5, array2, 5);
        for (int i : array1) {
            System.out.println(i);
        }
    }
}
