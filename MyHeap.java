import java.util.* ;

public class MyHeap {
  public static void main(String[] args) {

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
    if (index < 0 || index > size - 1) throw new IllegalArgumentException("The index given is not valid!") ;
    if (size < 0 || size > array.length - 1) throw new IllegalArgumentException("The size given is not valid!") ;
    while (index * 2 < size - 1) {
			int max = -99 ;
      int leftIndex = index * 2 ;
      leftIndex++ ;
      int rightIndex = index * 2 ;
      rightIndex += 2 ;
			if (rightIndex >= size || array[leftIndex] >= array[rightIndex]) {
				if (array[index] < array[leftIndex]) max = leftIndex ;
        // we have a new max: the first child (which may be an only child) is bigger than current max
			}
			else if (rightIndex < size && array[leftIndex] < array[rightIndex]) {
				if (array[index] < array[rightIndex]) max = rightIndex ;
        // the second child is bigger so it becomes the new max
			}
			if (max == -99) index = size ;
      else {
        int tem = array[index] ;
        array[index] = array[max] ;
        array[max] = tem ;
        index = max ;
      }
		}
  }
  /**
  Purpose/goal:
   convert the array into a valid heap. [ should be O(n) ]
  **/
  public static void heapify(int[] array) {

  }
  /**
  Purpose/goal:
     sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
  **/
  public static void heapsort(int[] array) {

  }
}
