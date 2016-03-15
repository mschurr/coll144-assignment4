package exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.google.common.collect.ImmutableList;

import grader.NotCompletedException;

/**
 * Many of these challenges correspond to problems we discussed in-class.
 * You must complete 12 of these challenges successfully to pass the assignment.
 * You are strongly encouraged to complete more challenges to improve your programming abilities.
 * You may run the AutoGrader to check how many of the problems you have solved correctly.
 * 
 * NOTE: Challenges start easy near the top of this file and get progressively harder. You
 * are not expected to be able to solve all of these (many are probably too hard for new
 * programmers), but I have provided a great number of challenges so that you can get all
 * of the practice you need if you so desire.
 * 
 * Ask any questions you have on Piazza! Feel free to discuss these problems with your
 * classmates and the instructor both on Piazza and in-person. You should consult the
 * official Java language documentation as needed. 
 * 
 * If you are truly stuck or don't know where to start, you can search the Internet for 
 * help BUT remember that you don't learn much if you don't solve the problems yourself. 
 * Try asking on Piazza first.
 */
public class Exercises {
  /**
   * Returns the n-th fibonacci number iteratively (without recursion).
   * @param n A number.
   * @return The n-th fibonacci number.
   * HINT: What restrictions are placed on the value of n?
   * HINT: Convert the code in the lecture slides to Java.
   */
  public static int fibonacci(int n) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns the n-th fibonacci number recursively.   
   * @param n A number.
   * @return The n-th fibonacci number.
   * HINT: What restrictions are placed on the value of n?
   * HINT: Convert the code in the lecture slides to Java.
   */
  public static int fibonacciRec(int n) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns n! (factorial) iteratively (without recursion).
   * @param n A number.
   * @return n!
   * HINT: What restrictions are placed on the value of n?
   * HINT: Try using a FOR loop.
   */
  public static int factorial(int n) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns n! (factorial) recursively.
   * @param n A number.
   * @return n!
   * HINT: What restrictions are placed on the value of n?
   * HINT: What is the base case (exit condition)?
   */
  public static int factorialRec(int n) {
    throw new NotCompletedException();
  }
  
  /**
   * @param n A number.
   * @return The sum of all integers 0 to n inclusive.
   * HINT: Try using a FOR loop.
   */
  public static int sumUpTo(int n) {
    throw new NotCompletedException();
  }
  
  /**
   * Produces a histogram from list of integer values.
   * @param data A list of integers.
   * @return A map of integers to the number of times that integer occurs in data.
   * HINT: Try using java.util.HashMap and a FOR loop.
   */
  public static Map<Integer, Integer> histogram(List<Integer> data) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns the minimum element of a list of integers.
   * @param data A non-empty list of integers.
   * @return The minimum element in data.
   * HINT: Try using a FOR loop and keeping track of the minimum at all times.
   */
  public static int min(List<Integer> data) {
    if (data.isEmpty()) {
      throw new IllegalArgumentException("The given list must not be empty.");
    }
    
    throw new NotCompletedException();
  }
  
  /**
   * Returns the sum of a list of integers. The sum of an empty list is 0.
   * @param data A list of integers.
   * @return The sum of all elements in data.
   * HINT: Try using a FOR loop and maintaining a running sum.
   */
  public static int sum(List<Integer> data) {
    throw new NotCompletedException();
  }
  
  /**
   * Reverses a string (for example "abc" becomes "cba").
   * @param original An input string.
   * @return The reverse of the input string.
   * REQUIREMENT: Do not use the built-in original.reverse() method.
   * HINT: Try iterating over original backwards by index using a FOR loop.
   */
  public static String reverse(String original) {
    throw new NotCompletedException();
  }
  
  /**
   * @param k A positive number greater than 0.
   * @param d A positive number greater than 0.
   * @return A list of all integers between 0 and k that are evenly divisible by d in ascending order.
   * HINT: Try allocating an ArrayList and building it up incrementally using a FOR loop.
   * HINT: Try utilizing the remainder (modulo) operator (%).
   */
  public static List<Integer> divisibleUpTo(int k, int d) {
    throw new NotCompletedException();
  }
  
  /**
   * Concatenates two lists together, returning a new list that contains
   * the items in a followed by the items in b.
   * @param a A list of items of type T.
   * @param b A list of items of type T.
   * @return A list of items of type T created by concatenating b to a.
   * HINT: Try allocating a java.util.ArrayList and adding all of the items
   *       from a and then all of the items from b using FOR loops.
   */
  public static <T> List<T> concat(List<T> a, List<T> b) {
    throw new NotCompletedException();
  }
  
  /**
   * Defines a filter for the next exercise.
   * @param <T> The type of item.
   */
  @FunctionalInterface
  public static interface Filter<T> {
    /**
     * @param item An item.
     * @return True iff item matches the filter and should be kept in the output.
     */
    public boolean shouldKeep(T item);
  }
  
  /**
   * @param items A list of items of type T.
   * @param filter A filter for items of type T.
   * @return A new list containing only elements in items which match the filter.
   * REQUIREMENT: The output must maintain relative ordering. That is, if both a
   *              and b match the filter and a appears before b in items then a
   *              must appear before b in the output.
   * HINT: An item should be in the output if filter.shouldKeep(item) is true.
   * HINT: Try allocating a new list and adding only items which match the filter.
   */
  public static <T> List<T> filterList(List<T> items, Filter<T> filter) {
    throw new NotCompletedException();
  }
  
  /**
   * Filters a list in-place, removing all items from the list which do not
   * match the filter.
   * @param items A list of items of type T.
   * @param filter A filter for items of type T.
   * NOTE: You cannot modify a List while iterating over it (if you do, you will
   *       probably see a ConcurrentModificationException). Try keeping track of
   *       the items to be removed in a separate list and then removing them at
   *       the end.
   * HINT: An item should be in the output if filter.shouldKeep(item) is true.
   */
  public static <T> void filterListInPlace(List<T> items, Filter<T> filter) {
    throw new NotCompletedException();
  }
  
  /**
   * Implement a first-in first-out queue (the earliest item to be
   * placed in the queue is removed first). Think about standing in
   * line for coffee - the person who got in line first is served
   * first.
   * HINT: You need to have another data structure stored as a class
   *       member backing this Queue. Try the strategy we discussed
   *       in class using QueueNode.
   * @param <T> The type of item stored in the queue.
   */
  public static class Queue<T> {
    protected static class QueueNode<T> {
      public T data;
      public QueueNode<T> next;
    }
    
    protected int size;
    protected QueueNode<T> head;
    protected QueueNode<T> tail;
    
    /**
     * A constructor (automatically called when a queue is created).
     */
    public Queue() {
      throw new NotCompletedException();
    }
    
    /**
     * Pushes an item onto the end of the queue.
     * @param item To add.
     */
    public void push(T item) {
      throw new NotCompletedException();
    }
    
    /**
     * Removes the item at the front of the queue and returns it.
     * @return The popped item.
     */
    public T pop() {
      throw new NotCompletedException();
    }
    
    /**
     * @return The number of items in the queue.
     */
    public int size() {
      throw new NotCompletedException();
    }
  }
  
  /**
   * Sorts the provided list in-place into ascending order.
   * @param list A list to sort in-place.
   * REQUIREMENT: You must utilize the selection sort algorithm
   *              provided in the lecture slides.
   */
  public static void selectionSort(ArrayList<Integer> list) {
    throw new NotCompletedException();
  }
  
  /**
   * @param strings An ordered list of strings.
   * @return An ordered list of integers where the i-th integer in
   *         the list is the length of the i-th string in strings.
   * NOTE: The "length" of a string is the number of characters in it.
   * HINT: You'll need to allocate a new list and build it piece by 
   *       piece as you iterate over strings.
   */
  public static List<Integer> stringToLengths(List<String> strings) {
    throw new NotCompletedException();
  }
  
  /**
   * Reverses a list of items of arbitrary type T in-place.
   * @param list The list to reverse in-place.
   * HINT: You'll need to iterate through the list by index
   *       up to the mid point and perform swapping. Be wary
   *       of lists of odd length.
   */
  public static <T> void reverseArray(ArrayList<T> list) {
    throw new NotCompletedException();
  }
  
  /**
   * Rotates the items in a list by k places in-place.
   * If k == 0, the list is unchanged.
   * If k > 0, the items are rotated right k places.
   * If k < 0, the items are rotated left |k| places.
   * @param list List to rotate in-place.
   * @param k Number of places to rotate.
   * EXAMPLE: rotate([0, 1, 2, 3], 2) --> [2, 3, 0, 1]
   * EXAMPLE: rotate([0, 1, 2, 3], -1) --> [1, 2, 3, 0]
   * HINT: Try using the remainder (modulo) operator (%).
   */
  public static <T> void rotate(ArrayList<T> list, int k) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns a list of the digits in a positive integer.
   * @param integer A non-negative integer.
   * @return A list of the integers in the digit.
   * EXAMPLE: getDigits(765) -> [7, 6, 5]
   * NOTE: Each integer in the resulting list should be between 0 and 0.
   * HINT: Try converting to a string and converting each character back
   *       to an integer individually (Integer.toString and Integer.parseInt).
   */
  public static List<Integer> getDigits(int integer) {
    throw new NotCompletedException();
  }
  
  /**
   * Write a function collatz(n) that tests the collatz conjecture.
   * The function takes a single positive number as input and then 
   * repeats the following process on that number until the n is 1:
   *    - if n is even, divide it by 2
   *    - if n is odd, triple it and add 1
   * The collatz conjecture asserts that this process will always reach
   * 1 no matter what positive integer you start with.
   * @param n A positive number.
   * @return The number of steps it takes to arrive at 1.
   * EXAMPLE: collatz(27) -> 111
   */
  public static int collatz(int n) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns the number of words in a string.
   * @param s A string.
   * @return The number of words in s.
   * EXAMPLE: wordCount("hello world") -> 2
   * EXAMPLE: wordCount("I    am   awesome!") -> 3
   * HINT: Try counting the number of space characters,
   *       but be careful not to count consecutive spaces.
   */
  public static int wordCount(String s) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns whether or not the given string is a pangram. 
   * A pangram is a string that contains all of the letters of the
   * English alphabet (a-z A-Z) at least once. Note that it need not
   * contain both the uppercase AND lowercase of each letter, but it
   * must contain either the uppercase version or the lowercase version.
   * @param s A string.
   * @return Whether or not s is a pangram.
   * HINT: You'll need to visit each character in the string once and
   *       keep track of which characters you have seen and, at the
   *       end, need to determine whether you have seen them all.
   */
  public static boolean isPangram(String s) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns whether or not the given string is a palindrome.
   * A string is a palindrome iff s.reverse().equals(s).
   * @param s A string.
   * @return Whether or not s is a palindrome.
   * REQUIREMENT: Do not use the trivial implementation s.reverse().equals(s).
   * HINT: Try iterating over the string from 0 to its midpoint and checking that
   *       the i-th character from the start is the same as the i-th from the end,
   *       but be wary of odd-length strings.
   */
  public static boolean isPalindrome(String s) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns whether or not n is prime.
   * A prime number is an integer greater than 1 that has no
   * perfect divisors (no remainder) other than 1 and itself.
   * @param n A number.
   * @return Whether or not n is prime.
   * HINT: If n is not prime, then it must be evenly divisible
   *       by some integer 1 < i <= SQRT(n).
   */
  public static boolean isPrime(int n) {
    throw new NotCompletedException();
  }
  
  /**
   * Returns the prime factorization of n.
   * A prime factorization is a collection of prime numbers whose product is n.
   * @param n A number >= 2.
   * @return A prime factorization of n.
   * NOTE: Do not include 1's in the output of your factorization.
   * HINT: This problem is what computer scientists call NP-hard. This means there
   *       is no known solution running in faster than exponential time. If you
   *       feel your solution is too inefficient, it's supposed to be!
   */
  public static List<Integer> primeFactorization(int n) {
    throw new NotCompletedException();
  }
  
  /**
   * Encodes an English string into Pig Latin.
   * 
   * English is translated to Pig Latin by taking the first letter of every word, moving it 
   * to the end of that word, and adding 'ay' to the end of the word.
   * 
   * EXAMPLE: "The quick brown fox" -> "Hetay uickqay rownbay oxfay"
   * @param s An English string.
   * @return A pig-latin equivalent of s.
   * HINT: You'll need to break the string into words and encode each word individually.
   */
  public static String encodeToPigLatin(String s) {
    throw new NotCompletedException();
  }
  
  /**
   * Decodes a string from Pig Latin into English.
   * @param s A Pig Latin string.
   * @return An English equivalent of s.
   * NOTE: See the hints in encodeToPigLatin.
   */
  public static String decodeFromPigLatin(String s) {
    throw new NotCompletedException();
  }
  
  /**
   * Encodes a string using a Caesarian Cipher of size 6.
   * 
   * A Caesarian Cipher is a form of encryption used during the Roman Empire
   * to exchange messages between Caesar and his soldiers. The cipher involves
   * replacing each character in the original text with the letter in the alphabet
   * 6 characters to the right.
   * 
   * For example:
   *  ORIGINAL: A B C D E F G H I J K L M N O P Q R S T U V W X Y Z  (original alphabet)
   * ENCRYPTED: U V W X Y Z A B C D E F G H I J K L M N O P Q R S T  (shifted 6 right)
   * 
   * Thus, in the encrypted text A becomes U, B becomes V, and so forth. Decryption is
   * simply the reversal of this process. Lowercase characters are encrypted in the same
   * way.
   * 
   * @param s A plaintext string (only alphabet characters).
   * @return A caesarian-6 encoded version of s.
   */
  public static String encodeCaesarian(String s) {
    throw new NotCompletedException();
  }
  
  /**
   * Decodes a string encrypted with a Caesarian Cipher of size 6.
   * @param s A caesarian-6 encoded string.
   * @return A plaintext version of s (only alphabet characters).
   * NOTE: See the hints for encodeCaesarian.
   */
  public static String decodeCaesarian(String s) {
    throw new NotCompletedException();
  }
  
  // ---------------------------------------------------
  // CHALLENGE PROBLEMS BELOW HERE
  // You are not expected to do the challenge problems,
  // but take a look at them if you want to learn more.
  // ---------------------------------------------------
  
  
  /**
   * In Java, a functional interface (declared using the @FunctionalInterface annotation)
   * is an interface with a single method. Let's define an interface for a Map function.
   * 
   * A map function takes some input of type IN and maps it to an output of type OUT.
   * Map functions are constructs that are commonly used in practical computer science.
   * Example: The stringToLengths challenge in this homework assignment could be created
   *          by applying the following map function to every item in the list:
   *          (String s) -> s.length()
   */
  @FunctionalInterface
  static interface MapFunction<IN, OUT> {
    public OUT apply(IN item);
  }
  
  /**
   * In Java, an instance of a class which implements the Iterable<T> interface can be
   * iterated over using the for(T item : iterable) loop syntax.
   * 
   * The Iterable<T> interface defines one method which returns an Iterator<T>.
   *   Iterator<T> iterator(): Returns an iterator on the object.
   * 
   * The interesting work happens in Iterator<T>, which defines two methods:
   *   boolean hasNext(): Returns whether or not there is a next item in the iterator.
   *   T next(): Returns the next item and advances the iterator by one place. If there
   *             is not a next item, throws a NoSuchElementException.
   */
  
  /**
   * This class implements an Iterator on the built-in ArrayList class and should
   * give you an idea of how Iterators work.
   * 
   * To use it: 
   *   for(T item : new ArrayListIterator<T>(someArrayList))
   *   
   * If ArrayList implemented the Iterable<T> interface to return a new ArrayListIterator<T>(list), 
   * then we could simply say:
   *   for (T item : list)
   * 
   * @param <T> The type of item contained in the list.
   */
  public static final class ArrayListIterator<T> implements Iterator<T> {
    private int currentIdx;
    private final ArrayList<T> list;
    
    public ArrayListIterator(ArrayList<T> list) {
      // Retain a reference to the list.
      this.list = list;
      
      // Remember the current position of the iterator within the list.
      // Start at position 0 (the first item in the list).
      this.currentIdx = 0;
    }

    @Override
    public boolean hasNext() {
      // Until our current position has passed the last valid index in the list,
      // there exists a next item.
      return currentIdx < list.size(); 
    }

    @Override
    public T next() {
      // To comply with the Iterator interface, if there exists no next item, 
      // we must throw a NoSuchElementException.
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      
      // Fetch the item at the current position and remember it.
      T item = list.get(currentIdx);
      
      // Advance the current position within the list by 1 slot.
      currentIdx += 1;
      
      // Return the item that we fetched.
      return item;
    }
  }
  
  
  /**
   * Defines a method that is parametric on two types: IN and OUT.
   * @param input An Iterable of items of type IN.
   * @param mapFn A function that maps (converts) items of type IN to type OUT by applying 
   *              some transformation.
   * @return An Iterable of items of type OUT produced by applying mapFn to each item in the 
   *         input Iterable in turn.
   * NOTE: Observe that executing this function requires constant time. This makes sense because,
   *       as you will see, the work done by the map function does not actually occur until the
   *       returned Iterable is iterated over.
   */
  public static <IN, OUT> Iterable<OUT> map(final Iterable<IN> input, final MapFunction<IN, OUT> mapFn) {
    // This interface is simple, so we will just define it in-line as an anonymous class:
    return new Iterable<OUT>() {
      @Override
      public Iterator<OUT> iterator() {
        // The anonymous class closes over the values input and mapFn, so they are available here.
        // MapIterator implementation is below.
        return new MapIterator<>(mapFn, input.iterator());
      }
    };
  }
  
  /**
   * Implements the MapIterator returned by the previous function.
   * @param <IN> The type of the original items.
   * @param <OUT> The type of item produced after applying the map function.
   */
  private static class MapIterator<IN, OUT> implements Iterator<OUT> {
    private final MapFunction<IN, OUT> mapFn;
    private final Iterator<IN> source;
    
    /**
     * @param mapFunction A function that maps items of type IN to type OUT.
     * @param source An iterator of type IN to wrap.
     */
    public MapIterator(MapFunction<IN, OUT> mapFunction, Iterator<IN> source) {
      // Remember the mapping function and the source iterator.
      this.mapFn = mapFunction;
      this.source = source;
    }
    
    @Override
    public boolean hasNext() {
      // Delegate to the original iterator as we are simply wrapping it.
      return source.hasNext();
    }

    @Override
    public OUT next() {
      // Delegate to the original iterator to get the next item and return the
      // result of applying the map function to that item.
      return mapFn.apply(source.next());
    }
  }
  
  public static void demoMapIterator() {
    // Let's consider the problem we had before: we have a list of strings and we want
    // to iterate over the lengths of those strings.
    List<String> strings = ImmutableList.of("apple", "donut", "cat");
    
    // First, we need to define a map function that takes a string and produces a length.
    // We can define this in-line very simply by using Java's lambda notation.
    MapFunction<String, Integer> strToLen = x -> x.length();
    
    // Now, we can iterate over the length of strings as follows:
    for (int length : map(strings, strToLen)) {
      System.out.println(length); // Do something with the length.
    }
  }
  
  /**
   * A reduction function folds a value into an accumulator.
   * @param <T> The type of items that will be incorporated into the accumulated value.
   * @param <S> The type of the accumulated value.
   */
  @FunctionalInterface
  public static interface Reducer<T, S> {
    public S reduce(S accumulator, T item);
  }
  
  /**
   * A reduce() operation applies a reduction function to an iterable, folding each
   * value in the given collection into the accumulated value using the reduction
   * function.
   * @param collection An Iterable.
   * @param initialValue An initial value for the accumulator.
   * @param reducer A reduction function.
   * @return The final accumulated (reduced) value.
   */
  public static <T, S> S reduce(Iterable<T> collection, S initialValue, Reducer<T,S> reducer) {
    S value = initialValue;
    
    for (T item : collection) {
      value = reducer.reduce(value, item);
    }
    
    return value;
  }
  
  @SuppressWarnings("unused")
  public static void demoReduce() {
    // Reduction functions are very powerful. For example, to find the sum of a list:
    List<Integer> items = ImmutableList.of(1, 2, 3, 4, 5);
    int sum = reduce(items, 0, (a, i) -> a + i);
    
    // Map and Reduce functions are often applied together in a pattern commonly referred
    // to as MapReduce. MapReduce is an **incredibly** powerful and popular pattern in
    // practice because it is concise, highly parallelizable and many important computations
    // can be expressed as MapReduces. In fact, MapReduce powers a significant portion of
    // the infrastructure of large companies such as Google.
    
    // For example: To find the total combined length of all strings in a list:
    List<String> strings = ImmutableList.of("apple", "donut", "cat");
    int length = reduce(map(strings, s -> s.length()), 0, (a, i) -> a + i);
    
    // For example: To find the product of items in a non-empty list:
    List<Integer> nums = ImmutableList.of(1, 2, 3, 4, 5);
    int product = reduce(nums, 1, (a, i) -> a * i);
  }
  
  /**
   * Returns a new Iterable which returns an iterator over all of the
   * items in a immediately followed by all of the items in b.
   * @param a An iterable.
   * @param b An iterable.
   * @return An iterable over a followed by b.
   * EXAMPLE: Iterating over concat([1,2,3], [4,5,6]) should yield [1,2,3,4,5,6].
   */
  public static <T> Iterable<T> concatIterable(Iterable<T> a, Iterable<T> b) {
    throw new NotCompletedException();
  }
  
  /**
   * @param items An Iterable over items of type T.
   * @param filter A function that returns true iff some item of type T should
   *               be included in the output Iterable.
   * @return An Iterable over only the items in the orignal Iterable which match
   *         the filter. The relative ordering of items in the original iterable
   *         is preserved.
   * NOTE: This function provides functionality equivalent to the filterList method
   *       you have already implemented. However, this implementation may be faster
   *       in practice since you are not allocating a new copy of the list.
   * EXAMPLE: Iterating over filter([1, 2, 3], x -> x > 2) should yield only [3].
   */
  public static <T> Iterable<T> filterIterable(Iterable<T> items, Filter<T> filter) {
    throw new NotCompletedException();
  }
  
  /**
   * @param items An iterable of iterables of type T.
   * @return An iterable which yields the items of the inner iterables in the order they appear.
   *         Essentially, you are un-nesting the inner iterables to produce one single iterable.
   * EXAMPLE: flattenIterable([[1,2,3],[4,5],[6,7]]) -> [1,2,3,4,5,6,7]
   */
  public static <T> Iterable<T> flattenIterable(Iterable<Iterable<T>> items) {
    throw new NotCompletedException();
  }
  
  /**
   * A stream is a collection of items coming in one at a time where the
   * total number of items is not known (that is, it is not known when
   * the stream will end). To represent a stream for this exercise, we 
   * will use an Iterator.
   * 
   * The running average of a stream of doubles of size k is defined as
   * the average of the last k doubles returned by the stream. If k items
   * have not yet been observed, then simply return the average of the
   * items you have observed.
   * 
   * Your task is to implement a stream that wraps another stream. When next()
   * is called on your stream, you pull another item from the wrapped stream,
   * incorporate it into your running average of the last k items, and then
   * return that new running average.
   * 
   * CHALLENGE: 
   *   The challenge here is not simply implementing this interface (if you
   *   think about it, doing so is trivial - just remember the last k values
   *   in a List at all times). Rather, you should try to implement this 
   *   as efficiently as possible.
   * REQUIREMENT: The amount of data you store in RunningAverageStream must
   *              be proportional to the value of k.
   * REQUIREMENT: Your implementation of next() should be constant-time (you
   *              shouldn't need to iterate over anything).
   * HINT: Think about the mathematical definition of average and how you
   *       can account for the addition of a new value into an existing
   *       average.
   * EXAMPLE:
   *   For input stream of items [1.0, 2.0, 3.0, 4.0, 5.0]
   *   Your stream should yield [1.0, 1.5, 2.0, 3.0, 4.0]
   */
  public static class RunningAverageStream implements Iterator<Double> {
    public final Iterator<Double> input;
    public final int k;
    
    public RunningAverageStream(Iterator<Double> input, int k) {
      this.input = input;
      this.k = k;
    }

    @Override
    public boolean hasNext() {
      return input.hasNext(); // COMPLETE: Delegate to the wrapped stream.
    }

    @Override
    public Double next() {
      // Pull the next item from the wrapped stream.
      @SuppressWarnings("unused")
      Double nextItem = input.next();
      
      // TODO: Incorporate the pulled item into the running average while removing
      // the k+1th furthest item from the average.
      // You'll need to maintain some instance state to do this. 
      // Remember: If you have only seen j < k items so far, then just return the running 
      // average of those j items.
      throw new NotCompletedException();
    }
  }
  
  // -----------------------------------------------------------------
  // Still not challenged enough?
  // Email the instructor to get some additional challenge problems on
  // inheritance, composition, and polymorphism.
  // -----------------------------------------------------------------
}
