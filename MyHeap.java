import java.util.* ;

public class MyHeap {
  public static void main(String[] args) {
    /*int[] a = {1,31,5,7,9,10} ;
    pushDown(a,5,0) ;
    System.out.println(Arrays.toString(a)) ; // should bring 31 up
    System.out.println("We are now testing with size of 3!") ;
    int[] e = {1,31,5,7,9,10} ;
    pushDown(e,3,0) ;
    System.out.println(Arrays.toString(e)) ; // should bring 31 up
    int[] aa = {14, 52, 11, 772, 115, 7, 1, 9, 26, 72} ;
    heapsort(aa) ;
    System.out.println(Arrays.toString(aa)) ;*/
    /* Mr. K's Driver
    System.out.println("Size\t\tMax Value\theap/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long htime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++) {
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          MyHeap.heapsort(data2);
          t2 = System.currentTimeMillis();
          htime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*htime/btime);
      }
      System.out.println();
    }*/
    /*Here are the results after running
    Size		  Max Value	     heap/builtin ratio
    31250		 1000000000	     0.5652173913043478
    62500		 1000000000	     0.5454545454545454
    125000	 1000000000	     1.8444444444444446
    250000	 1000000000	     1.467741935483871
    500000	 1000000000	     1.7130434782608697
    1000000	 1000000000	     1.973856209150327
    2000000	 1000000000	     2.4154013015184383

    31250		    500	         0.6111111111111112
    62500		    500	         1.3636363636363635
    125000		  500	         2.8518518518518516
    250000		  500	         3.24
    500000		  500	         3.267326732673267
    1000000		  500          3.497560975609756
    2000000		  500	         4.178921568627451

    31250		     10	            4.0
    62500		     10	            5.0
    125000	     10 	          9.0
    250000		   10	            6.0
    500000		   10	        6.3428571428571425
    1000000		   10	            6.16
    2000000		   10	        6.523809523809524
    */
  }
  /**
  precondition index is between 0 and size-1 inclusive
  precondition: size is between 0 and array.length-1 inclusive.
  @param size is the number of elements in the array.
  Purpose/goal:
    push the element at index i downward into the correct position.
    This will swap with the larger of the child nodes provided that child is larger.
    This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
  **/
  private static void pushDown(int[] array, int size, int index) {
    // Checking whether arguments given are valid
    /*if (index < 0 || index > size - 1) throw new IllegalArgumentException("The index given is not valid!") ;
    if (size < 0 || size > array.length - 1) throw new IllegalArgumentException("The size given is not valid!") ;*/
    while (index * 2 < size - 1) {
			int max = -99 ;
      boolean found = false ;
      int leftIndex = index * 2 ;
      leftIndex++ ;
      int rightIndex = index * 2 ;
      rightIndex += 2 ;
			if (rightIndex >= size || array[leftIndex] >= array[rightIndex]) {
				if (array[index] < array[leftIndex]) {
          max = leftIndex ;
          found = true ;
          // we have a new max: the first child (which may be an only child) is bigger than current max
        }
			}
			else if (rightIndex < size && array[leftIndex] < array[rightIndex]) {
				if (array[index] < array[rightIndex]) {
          max = rightIndex ;
          found = true ;
          // the second child is bigger so it becomes the new max
        }
			}
			if (found) {
        swap(array, index, max) ;
        index = max ;
      }
      else {
        index = size ;
      }
		}
  }
  private static void swap(int[] array, int a, int b) {
		int tem = array[a];
		array[a] = array[b] ;
		array[b] = tem ;
	}
    // parent is (index - 1) / 2
  /**
  Purpose/goal:
   convert the array into a valid heap. [ should be O(n) ]
  **/
  public static void heapify(int[] array) {
    for (int i = array.length - 1 ; i >= 0 ; i--) {
      // go backwards and start from end of array
			pushDown(array, array.length, i) ;
		}
  }
  /**
  Purpose/goal:
     sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
  **/
  public static void heapsort(int[] array) {
    heapify(array) ; // first step!
		int s = array.length - 1 ;
		while (s > 0) {
      int tem = array[0] ;
      array[0] = array[s] ;
      array[s] = tem ;
			pushDown(array, s, 0) ;
			s-- ;
		}
  }
}
