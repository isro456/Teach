import java.util.HashMap;

public class TwoPointers 
{
    public int[] twoSum(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;

        while(left < right)
        {
            int sum = nums[left] + nums[right];

            if(sum == target) return new int[] {left + 1, right + 1};
            if(sum > target) right--;
            if(sum < target) left++;
        }
        return new int[]{-1,-1};
    }
    public int maxArea(int[] height) 
    {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

    while (left < right) {
        int width = right - left;
        int minHeight = Math.min(height[left], height[right]);
        int area = width * minHeight;
        maxArea = Math.max(maxArea, area);

        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return maxArea;
    }
    public boolean isPalindrome(String s) 
    {
        s = s.toLowerCase().replaceAll("[^a-z0-9]","");

        int left = 0;
        int right = s.length() - 1;

        while(left < right)
        {
            if(s.charAt(left) == s.charAt(right))
            {
                left ++;
                right --;
            }
            else
            {
                return false;
            }
        }
        return true;
        
    }
    public static int removeDuplicates(int[] nums) 
    {
        int slow = 0;
        int fast = 0;
        
        while(fast < nums.length)
        {
            if(nums[fast] != nums[slow])
            {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;

        }

        return slow + 1;
    }
    public static int removeElement(int[] nums, int val)
    {
        int slow = 0;
        int fast = 0;

        while(fast < nums.length)
        {
            if(nums[fast] != val)
            {
                nums[slow] = nums[fast];
                slow++;

            }
            fast++;
        }
        return slow;
    }
    public static void moveZeroes(int[] nums) 
    {
        int slow = 0;
        int fast = 0;

        while(fast < nums.length)
        {
            if(nums[fast] != 0)
            {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
    public static void sortColors(int[] nums) {
    int low = 0;
    int mid = 0;
    int high = nums.length - 1;

    while (mid <= high) {
        if (nums[mid] == 0) {
            swap(nums, low, mid);
            low++;
            mid++;
        } else if (nums[mid] == 1) {
            mid++;
        } else { 
            swap(nums, mid, high);
            high--;
        }
    }
}

private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
public static int lengthOfLongestSubstring(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;

        for(int right = 0; right < s.length(); right ++)
        {
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left)
                {
                    map.put(s.charAt(right), right);
                    left = map.get(s.charAt(right)) + 1; 
                }
            else
            {
                map.put(s.charAt(right), right);
            }
            count = Math.max(count,right - left + 1);

        }
        return count;

}
    public boolean isPalindrome(int x) 
    {
        int original = x;
        int reversed = 0;

        while(x > 0)
        {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }
        System.out.println(original);
        System.out.println(reversed);
        return original == reversed;
    
    }
}
