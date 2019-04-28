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
    */
    int[] a = {14, 52, 11, 772, 115, 7, 1, 9, 26, 72} ;
    heapsort(a) ;
    System.out.println(Arrays.toString(a)) ;
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
