//Program to count repeated words
public class CountRepatWords 
{

	public static void main(String[] args)
	{
		String input="This is is a new text text that have repeating repeating repeating words"; 		//String	
		String[] words=input.split(" ");	//Split the word from String
		int RepeatedCount=1;							//Variable for have Repeated word count
		
		for(int i=0;i<words.length;i++)		//Outer loop for Comparison		
		{
			for(int j=i+1;j<words.length;j++)	//Cycle to compare
			{
				
			if(words[i].equals(words[j]))	//to see if both strings are equal
				{
					RepeatedCount=RepeatedCount+1;				//if equal increment the count
					words[j]="0";			//Replace repeated words by zero
				}
			}
			if(words[i]!="0")
			System.out.println(words[i]+" -- is repeated "+RepeatedCount+" times");	//to print number of words according the counter 
			RepeatedCount=1;
	     }  
			
	}

}