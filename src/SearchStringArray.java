import java.util.*;
public class SearchStringArray {
	// compare function :-> compares two strings
	// same as sortStringArray.java
	private int compare(String s1,String s2) {
		int s1Len = s1.length();
		int s2Len = s2.length();
		// s1 comes before s2 => 1
		// s1 comes after s2 => -1
		// s1 is equal to s2 => 0
		int i;
		for(i=0;i<s1Len && i<s2Len;i++)
		{
			if(s1.charAt(i) < s2.charAt(i))
			{
				return 1;
			}
			else
				if(s1.charAt(i) > s2.charAt(i))
				{
					return -1;
				}
		}
		if(s2Len == s1Len)
		{
			return 0;
		}
		if(s1Len < s2Len)
		{
			return 1;
		}
		else
		return -1;
	}
	public int searchWord(List<String>dict,int low,int high,String target) {
		if(low > high)
		{
			// word not present
			return -1;
		}
		while(low <= high) {
			int mid = (low + high)/2;
			int cmp_ = compare(dict.get(mid),target);
			if(cmp_ == 0) {
				return mid;
			}
			else
			{
				if(cmp_ == 1) {
					// dict[mid] comes before target
					// low = mid + 1
					low = mid + 1;
				}
				else
				{
					// cmp_ = -1
					// dict[mid] comes after target
					// high = mid -1
					high = mid -1;
				}
			}
		}
		return -1;
	}
	// Main Function to test
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Implement binary search
		String []dict= {"a","aa","aaa","b","bb","bbb","xyz"}; // sorted order
		String []target= {"aa","bbb","xyz"}; // sorted order by question
		int dictLen = dict.length;
		int targetLen = target.length;
		SearchStringArray e = new SearchStringArray();
		for(int i = 0;i < targetLen ; i++)
		{
			int find = e.searchWord(dict,0,dictLen-1,target[i]);
			if( find == -1)
			{
				System.out.println(target[i] + " :Not Found");
			}
			else
			{
				System.out.println(target[i] + " : " + find);
			}
		}
		
	}
	*/

}
