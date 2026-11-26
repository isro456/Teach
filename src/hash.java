import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class hash {
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i ++)
        {
            int naidennoe = target - nums[i];
            if(map.containsKey(naidennoe))
            {
                return new int[] {map.get(naidennoe), i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }
    public boolean isAnagram(String s, String t) 
    {
        HashMap<Character,Integer> map = new HashMap<>();

        if (s.length() != t.length()) return false;

        for(char c: s.toCharArray())
        {
            
           if(map.containsKey(c)) map.put(c,map.get(c) + 1);
           else map.put(c,1);
        }
        for(char d: t.toCharArray())
        {
            if(map.containsKey(d)) map.put(d,map.get(d) - 1);
        }

        for(int count : map.values())
        {
            if(count != 0) return false;
        }
        return true;
        
    }
    public static int[] intersect(int[] nums1, int[] nums2) 
    {
        Map<Integer,Integer> map = new HashMap<>();

        for(int nums : nums1)
        {
            map.put(nums, map.getOrDefault(nums, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for(int num: nums2)
        {
            if(map.containsKey(num) && map.get(num) > 0)
            {
                list.add(num);
                map.put(num,map.get(num) - 1);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i ++)
        {
            ans[i] = list.get(i);
        }

        return ans;

    }
    public static boolean isIsomorphic(String s, String t) 
{
    if (s.length() != t.length()) return false;

    Map<Character, Character> map1 = new HashMap<>(); // s -> t
    Map<Character, Character> map2 = new HashMap<>(); // t -> s

    for (int i = 0; i < s.length(); i++)
    {
        char sc = s.charAt(i);
        char tc = t.charAt(i);

        if (map1.containsKey(sc))
        {
            if (map1.get(sc) != tc) return false;
        }
        else
        {
            map1.put(sc, tc);
        }

        if (map2.containsKey(tc))
        {
            if (map2.get(tc) != sc) return false;
        }
        else
        {
            map2.put(tc, sc);
        }
    }

    return true;
}
public static boolean wordPattern(String pattern, String s) 
    {
        String[] stroka = s.split(" ");

        if(stroka.length != pattern.length()) return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        for(int i = 0; i < pattern.length(); i ++)
        {
            if(map1.containsKey(pattern.charAt(i)))
            {
                if(!map1.get(pattern.charAt(i)).equals(stroka[i])) return false;
            }
            else
            {
                map1.put(pattern.charAt(i),stroka[i]);
            }
            if(map2.containsKey(stroka[i]))
            {
                if(!map2.get(stroka[i]).equals(pattern.charAt(i)))  return false;
            }
            else map2.put(stroka[i], pattern.charAt(i));

        }
        return true;
        
    }
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if(!map.containsKey(sorted))
            {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public static int longestConsecutive(int[] nums) 
    {
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        for(int num: nums) set.add(num);

        for(int num: set)
        {
            if(!set.contains(num - 1))
            {
                int Current = num;
                int LongStreak = 1;

                while(set.contains(num + 1))
                {
                    Current++;
                    LongStreak++;
                }
                ans = Math.max(LongStreak,ans);
            }
        }
        return ans;
    }
}