public class sorts {
    public static void InsertionSort(int[] nums)
    {
        for(int i = 1; i < nums.length; i ++)
        {
            int current = nums[i];
            int j = i;
            while(j > 0 && nums[j - 1] > current)
            {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = current;
        }
    }
    public static void QuickSort(int[] array, int from, int to)
    {
        if(from < to)
        {
            int divideIndex = partition(array, from, to);
            QuickSort(array, from, divideIndex - 1);
            QuickSort(array, divideIndex, to);
        }
    }

    private static int partition(int[] arr, int from, int to)
    {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from];
        while(leftIndex <= rightIndex)
        {
            while(arr[leftIndex] < pivot)
            {
                leftIndex++;
            }
            while(arr[rightIndex] > pivot)
            {
                rightIndex--;
            }
            if(leftIndex <= rightIndex)
            {
                swap(arr,leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }

        }
        return leftIndex;
    }
    private static void swap(int[] nums, int index1, int index2)
    {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
