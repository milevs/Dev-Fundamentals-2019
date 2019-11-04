class MinMaxExample { 
    // Method for retuen the maximum value
    public static int getMax(int[] inputArray){ 
        int maxValue = inputArray[0]; 
        for(int i=1;i < inputArray.length;i++){ 
          if(inputArray[i] > maxValue){ 
             maxValue = inputArray[i]; 
          } 
        } 
        return maxValue; 
      }
     
      // Method for return the minimum value
      public static int getMin(int[] inputArray){ 
        int minValue = inputArray[0]; 
        for(int i=1;i<inputArray.length;i++){ 
          if(inputArray[i] < minValue){ 
            minValue = inputArray[i]; 
          } 
        } 
        return minValue; 
      } 

      // Method that return average of an array. 
    static double average(int a[], int n) 
    {          
        // Find sum of array element 
        int sum = 0; 
          
        for (int i = 0; i < n; i++) {
            sum += a[i];
        } 
             return sum / n; 
    } 

 
    public static void main(String args[]){
      int array[] = new int[]{10, 11, 88, 2, 12, 120};
   
      // Calling getMax() 
      int max = getMax(array);
      System.out.println("Maximum Value is: "+max);
   
      // Calling getMin()
      int min = getMin(array);
      System.out.println("Minimum Value is: "+min);


      // Calling Average()
        int n = array.length; 
      System.out.println("Average is: "+ average(array, n)); 
    }
   
    
  }