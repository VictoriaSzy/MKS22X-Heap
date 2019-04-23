import java.util.* ;

public class MyHeap {
  public static void main(String[] args) {

  }
  /**
  precondition index is between 0 and size-1 inclusive
  precondition: size is between 0 and data.length-1 inclusive.
  @param size is the number of elements in the data array.
  Purpose/goal:
    push the element at index i downward into the correct position.
    This will swap with the larger of the child nodes provided that child is larger.
    This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
  **/
  private static void pushDown(int[] array, int size, int index) {
    // Checking whether arguments given are valid
    if (index < 0 || index > size - 1) throw new IllegalArgumentException("The index given is not valid!") ;
    if (size < 0 || size > array.length - 1) throw new IllegalArgumentException("The size given is not valid!") ;
    //

   }
}
