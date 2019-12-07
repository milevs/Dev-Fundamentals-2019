//Find first repeated number in array
import java.util.*; 

class Main 
{ 

	// This function prints the first repeated numbe in array
	static void (int arr[]) 
	{ 
		// Initialize index of first repeating element 
		int min = -1; 

		// Creates an empty hashset foundFirstRepeating
		HashSet<Integer> set = new HashSet<>(); 

		// Cross the array from right to left 
		for (int i=arr.length-1; i>=0; i--) 
		{ 
			// If element is already in hash set update min 
			if (set.contains(arr[i])) 
				min = i; 

			else // Else add element to hash set 
				set.add(arr[i]); 
		} 

		// Print the results in console
		if (min != -1) 
		System.out.println("The first repeated number is " + arr[min]); 
		else
		System.out.println("There are no Repeated numbers"); 
	} 

	// Main method 
	public static void main (String[] args) throws java.lang.Exception 
	{ 
		int arr[] = {2, 1, 3, 5, 3, 2}; 
		foundFirstRepeating(arr); 
	} 
} 

