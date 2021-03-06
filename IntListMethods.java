package intlistmethods;

public class IntListMethods {
    static int[] node;
    public static String getAuthorName(){ return ("Cheung, Austin"); }
    
    public static String getRyersonID() { return ("500810580");}
    
    public static int removeIfDivisible(int n, int k)
    {
         if (n == 0) {return 0;}
        
         while(IntList.getKey(n) % k ==0)
         {
             int key = IntList.getKey(n);
        if(((key)%k) == 0)
                {
                    n = IntList.removeFirst(n, IntList.getKey(n));
                }
         }

        int first=n;
        int prev=n;
        n=IntList.getNext(n);
        
        while(n!=0)
        {
        if(IntList.getKey(IntList.getNext(prev))%k == 0)
        { 
                    int  temp = IntList.getNext(n);
                    int prevnext = IntList.getNext(prev);
                    IntList.setNext(prevnext, 0);
                    IntList.release(prevnext);
                    IntList.setNext(prev, temp);            
        }
            else
            {
                prev=n;
            }
             n=IntList.getNext(prev);
        }
        return first;
    }
    
   
   public static int sort(int n)  
    { 
        int[] key = new int[IntList.getAllocatedNodeCount()];
        node = new int[IntList.getAllocatedNodeCount()];
        for(int i = 0; i < key.length; i++) {
            key[i] = IntList.getKey(n);
            node[i] = n;
            n = IntList.getNext(n);
        }
       
       quickSort(key, 0, key.length-1);
       int count = 0;
       for(int i = 0; i<key.length-1; i++)
       {
           IntList.setNext(node[i], node[i+1]);
           count++;
       }
       IntList.setNext(node[count], 0);
       return node[0];   
    }

public static void quickSort(int key[], int left, int right) {
    
     int i = left;
      int j = right;
      int tmp, tmp2;
      int pivot = key[(left + right) / 2];
      while (i <= j) {
            while (key[i] < pivot)
                  i++;
            while (key[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp2 = node[i];
                  node[i] = node[j];
                  node[j] = tmp2;
                  tmp = key[i];
                  key[i] = key[j];
                  key[j] = tmp;
                  i++;
                  j--;
            }
      }
    int count = i;
      if (left < count - 1)
            quickSort(key, left, count - 1);
      if (count < right)
            quickSort(key, count, right);
    }
}
  
 