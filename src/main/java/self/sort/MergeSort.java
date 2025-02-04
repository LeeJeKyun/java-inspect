package self.sort;

public class MergeSort {

    public void sort(int[] arr, int left, int right) {
        //최소단위로 분할될 경우 종료
        if(left == right) return;

        int mid = (left + right) / 2;

        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        mergeSort(arr, left, mid, right);
    }

    public void mergeSort(int[] arr, int left, int mid, int right) {
        int leftLen = mid - left + 1;
        int rightLen = right - mid;

        int[] leftTemp = new int[leftLen];
        int[] rightTemp = new int[rightLen];

        for(int i=0; i<leftLen; i++) {
            leftTemp[i] = arr[left + i];
        }
        for(int i=0; i<rightLen; i++) {
            rightTemp[i] = arr[mid + 1 + i];
        }

        int i=0, j=0;
        int k = left;

        while ( i < leftLen && j < rightLen) {
            if(leftTemp[i] <= rightTemp[j]) {
                arr[k] = leftTemp[i];
                i++;
            } else {
                arr[k] = rightTemp[j];
                j++;
            }
            k++;
        }
    }

}
