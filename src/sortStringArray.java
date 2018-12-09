import java.util.*;
public class sortStringArray {
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
	public void bubbleSort(List<String> list,int size) {
		int len = size;
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len ;j++) {
				int flag = compare(list.get(i), list.get(j));
				if(flag == -1)
				{
					// string[j] should be before string[i]
					// swap
					String auxString=list.get(i);
					list.set(i,list.get(j));
					list.set(j, auxString);
				}
			}
		}
		return;
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String []arr= {"hello","anurag","has","hai","cse"};
//		sortStringArray s = new sortStringArray();
//		// bubble sort
//		s.bubbleSort(arr);
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(arr[i]);
//		}
//		
//	}

}
