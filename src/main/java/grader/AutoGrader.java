package grader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;

import exercises.Exercises;
import exercises.Exercises.Queue;
import exercises.Exercises.RunningAverageStream;

/**
 * Run this class to verify the correctness of the exercises you have completed. Verification occurs by testing
 * that example inputs produce the desired results. Do not attempt to cheat the verification system by catering
 * the implementation of your functions to the specific examples that are tested - if you do this, you will not
 * get credit even if the autograder says you are passing.
 * 
 * You don't **need** to look at the code of this class in order to do the assignment, nor should you modify 
 * this class.
 * 
 * It may be helpful to look at the code of this class to see which test cases are failing. For example, you may
 * get something similar to the following error:
 *   ~~ Error for fibonacci:
 *     grader.AutoGrader$AssertionException: Expected 0, got 8 <-- Shows what the outputs were and what was expected.
 *         at grader.AutoGrader.assertEquals(AutoGrader.java:129)
 *         at grader.AutoGrader.testFibonacci(AutoGrader.java:181) <-- Check this line to see the inputs that failed.
 *         at grader.AutoGrader.main(AutoGrader.java:33)
 *         
 * NOTE: If you find a test case that is incorrect (I make mistakes sometimes, too), please post about it on Piazza.
 * 
 * @author mschurr
 */
public class AutoGrader {
  private static List<String> correctMethods = new ArrayList<>();
  private static List<String> incorrectMethods = new ArrayList<>();
  private static List<String> unattemptedMethods = new ArrayList<>();
  private static StringBuffer failedTraces = new StringBuffer();
  
  public static void main(String[] args) {
    testFibonacci();
    testFibonacciRec();
    testFactorial();
    testFactorialRec();
    testHistogram();
    testSumUpTo();
    testMin();
    testSum();
    testStringReverse();
    testDivisibleUpTo();
    testConcat();
    testFilterList();
    testFilterListInPlace();
    testQueue();
    testSelectionSort();
    testStringToLengths();
    testReverseArray();
    testRotate();
    testGetDigits();
    testCollatz();
    testWordCount();
    testIsPangram();
    testIsPalindrome();
    testIsPrime();
    testPrimeFactorization();
    testEncodeToPigLatin();
    testDecodeFromPigLatin();
    testEncodeCaesarian();
    testDecodeCaesarian();
    testConcatIterable();
    testFilterIterable();
    testFlattenIterable();
    testRunningAverageStream();

    int attempted = correctMethods.size() + incorrectMethods.size();
    int total = attempted + unattemptedMethods.size();
    
    System.out.format("ATTEMPTED METHODS (%d)\n", attempted);
    System.out.format("  INCORRECT (%d)\n", incorrectMethods.size());

    for (String s : incorrectMethods) {
      System.out.format("    @%s\n", s);
    }
    
    System.out.format("  CORRECT (%d)\n", correctMethods.size());

    for (String s : correctMethods) {
      System.out.format("    @%s\n", s);
    }

    System.out.format("\n");
    System.out.format("UNATTEMPTED METHODS (%d)\n", unattemptedMethods.size());
    
    for (String s : unattemptedMethods) {
      System.out.format("  @%s\n", s);
    }
    
    System.out.format("\n");
    System.out.println("Attempted: " + printStats(attempted, total));
    System.out.println("Un-Attempted: " + printStats(unattemptedMethods.size(), total));
    System.out.println("Correct (of total): " + printStats(correctMethods.size(), total));
    System.out.println("Incorrect (of total): " + printStats(incorrectMethods.size(), total));
    System.out.println("Correct (of attempted): " + printStats(correctMethods.size(), attempted));
    System.out.println("Incorrect (of attempted): " + printStats(incorrectMethods.size(), attempted));

    System.out.format("\n");
    if (correctMethods.size() >= 12) {
      System.out.println("You are currently passing the assignment!");
    } else {
      System.out.format("You must complete %d more problems to pass the assignment.\n", 12 - correctMethods.size());
    }
    
    if (!incorrectMethods.isEmpty()) {
      System.out.format("\n");
      System.out.format("-------------------------------------------------\n");
      System.out.format("Failure Messages for Incorrect Methods:\n");
      System.out.format("-------------------------------------------------\n");
      System.out.format(failedTraces.toString());
    }
  }
  
  private static class AssertionException extends Exception {
    private static final long serialVersionUID = 1L;

    public AssertionException(String msg) {
      super(msg);
    }
  }
  
  private static String printStats(int a, int b) {
    float perc = (b == 0 ? 0 : (((float) a) / b) * 100);
    return String.format("%d / %d (%2f%s)", a, b, perc, "%");
  }
  
  private static <T, R> void assertEquals(T expected, R actual) throws AssertionException {
    if (!expected.equals(actual)) {
      throw new AssertionException(String.format("Expected %s, got %s", expected, actual));
    }
  }
  
  private static <K, V> void assertMapEquals(Map<K, V> expected, Map<K, V> actual) throws AssertionException {
    assertEquals(expected.keySet(), actual.keySet());
    
    for (K key : expected.keySet()) {
      assertEquals(expected.get(key), actual.get(key));
    }
  }
  
  private static <T> List<T> iterableToList(Iterable<T> items) {
    List<T> list = new ArrayList<>();
    
    for (T item : items) {
      list.add(item);
    }
    
    return list;
  }
  
  private static <T> Multiset<T> convert(List<T> list) {
    return HashMultiset.create(list);
  }
  
  @SafeVarargs
  private static <T> Multiset<T> multiset(T ...items) {
    Multiset<T> set = HashMultiset.create();
    
    for (T item : items) {
      set.add(item);
    }
    
    return set;
  }
  
  private static <T> void assertIterableEquals(Iterable<T> expected, Iterable<T> actual) throws AssertionException {
    assertArrayEquals(iterableToList(expected), iterableToList(actual));
  }
  
  private static <T> void assertArrayEquals(List<T> expected, List<T> actual) throws AssertionException {
    if (expected.size() != actual.size()) {
      throw new AssertionException(String.format("Expected %s, got %s.", expected, actual));
    }
    
    for (int i = 0; i < expected.size(); i++) {
      if (!expected.get(i).equals(actual.get(i))) {
        throw new AssertionException(String.format("Expected %s, got %s.", expected, actual));
      }
    }
  }
  
  private static <T> void assertArraySorted(List<T> actual, Comparator<T> cmp) throws AssertionException {
    for (int i = 0; i < actual.size() - 1; i++) {
      T current = actual.get(i);
      T next = actual.get(i + 1);
      
      if (cmp.compare(current, next) > 0) {
        throw new AssertionException(String.format("%s is not sorted according to comparator.", actual));
      }
    }
  }
  
  private static void recordFailure(String method, Exception e) {
    incorrectMethods.add(method);
    failedTraces.append("~~ Error for " + method + ":\n");
    failedTraces.append(ExceptionUtils.getStackTrace(e));
    failedTraces.append("\n\n");
  }
  
  @SafeVarargs
  private static <T> Iterable<T> makeIterable(T... items) {
    return (Iterable<T>) Arrays.asList(items);
  }
  
  private static final Comparator<Integer> INTS_ASC = (a, b) -> a - b;
  
  private static void testFibonacci() {
    try {
      assertEquals(0, Exercises.fibonacci(0));
      assertEquals(1, Exercises.fibonacci(1));
      assertEquals(1, Exercises.fibonacci(2));
      assertEquals(2, Exercises.fibonacci(3));
      assertEquals(3, Exercises.fibonacci(4));
      assertEquals(5, Exercises.fibonacci(5));
      assertEquals(8, Exercises.fibonacci(6));
      assertEquals(13, Exercises.fibonacci(7));
      assertEquals(21, Exercises.fibonacci(8));
      assertEquals(34, Exercises.fibonacci(9));
      correctMethods.add("fibonacci");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("fibonacci");
    } catch (AssertionException e) {
      recordFailure("fibonacci", e);
    }
  }
  
  private static void testFibonacciRec() {
    try {
      assertEquals(0, Exercises.fibonacciRec(0));
      assertEquals(1, Exercises.fibonacciRec(1));
      assertEquals(1, Exercises.fibonacciRec(2));
      assertEquals(2, Exercises.fibonacciRec(3));
      assertEquals(3, Exercises.fibonacciRec(4));
      assertEquals(5, Exercises.fibonacciRec(5));
      correctMethods.add("fibonacciRec");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("fibonacciRec");
    } catch (AssertionException e) {
      recordFailure("fibonacciRec", e);
    }
  }
  
  private static void testFactorial() {
    try {
      assertEquals(1, Exercises.factorial(1));
      assertEquals(2, Exercises.factorial(2));
      assertEquals(120, Exercises.factorial(5));
      assertEquals(5040, Exercises.factorial(7));
      assertEquals(40320, Exercises.factorial(8));
      correctMethods.add("factorial");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("factorial");
    } catch (AssertionException e) {
      recordFailure("factorial", e);
    }
  }
  
  private static void testFactorialRec() {
    try {
      assertEquals(1, Exercises.factorialRec(1));
      assertEquals(2, Exercises.factorialRec(2));
      assertEquals(120, Exercises.factorialRec(5));
      assertEquals(5040, Exercises.factorialRec(7));
      assertEquals(40320, Exercises.factorialRec(8));
      correctMethods.add("factorialRec");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("factorialRec");
    } catch (AssertionException e) {
      recordFailure("factorialRec", e);
    }
  }
  
  private static void testSumUpTo() {
    try {
      assertEquals(0, Exercises.sumUpTo(0));
      assertEquals(1, Exercises.sumUpTo(1));
      assertEquals(21, Exercises.sumUpTo(6));
      assertEquals(55, Exercises.sumUpTo(10));
      assertEquals(703, Exercises.sumUpTo(37));
      correctMethods.add("sumUpTo");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("sumUpTo");
    } catch (AssertionException e) {
      recordFailure("sumUpTo", e);
    }
  }
  
  private static void testHistogram() {
    try {
      assertMapEquals(
        ImmutableMap.of(
          1, 3, 
          3, 1, 
          4, 1,
          7, 1,
          5, 1
        ), Exercises.histogram(ImmutableList.of(
          1, 1, 3, 4, 7, 1, 5
        ))
      );
      
      assertMapEquals(
          ImmutableMap.of(
            -7, 3, 
            8, 2, 
            3, 1,
            4, 1
          ), Exercises.histogram(ImmutableList.of(
            -7, 8, -7, -7, 4, 8, 3
          ))
        );
      correctMethods.add("histogram");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("histogram");
    } catch (AssertionException e) {
      recordFailure("histogram", e);
    }
  }
  
  private static void testMin() {
    try {
      assertEquals(-5, Exercises.min(ImmutableList.of(1,-5,1254,-3,0,20)));
      assertEquals(0, Exercises.min(ImmutableList.of(5,4,3,2,1,0,8,9)));
      assertEquals(1337, Exercises.min(ImmutableList.of(1337, 2048, 5192, 6975, 12233)));
      correctMethods.add("min");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("min");
    } catch (AssertionException e) {
      recordFailure("min", e);
    }
  }
  
  private static void testSum() {
    try {
      assertEquals(0, Exercises.sum(ImmutableList.of(0, 0, 0, 0)));
      assertEquals(10, Exercises.sum(ImmutableList.of(1, 2, 3, 4)));
      assertEquals(0, Exercises.sum(ImmutableList.of(-10, 1, 2, 3, 4)));
      assertEquals(-7, Exercises.sum(ImmutableList.of(-3, -4, 1, -1, 0)));
      correctMethods.add("sum");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("sum");
    } catch (AssertionException e) {
      recordFailure("sum", e);
    }
  }
  
  private static void testStringReverse() {
    try {
      assertEquals("racecar", Exercises.reverse("racecar"));
      assertEquals("anna", Exercises.reverse("anna"));
      assertEquals("Matthew", Exercises.reverse("wehttaM"));
      correctMethods.add("stringReverse");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("stringReverse");
    } catch (AssertionException e) {
      recordFailure("stringReverse", e);
    }
  }
  
  private static void testDivisibleUpTo() {
    try {
      assertArrayEquals(ImmutableList.of(0, 3, 6, 9, 12, 15, 18, 21, 24), Exercises.divisibleUpTo(25, 3));
      assertArrayEquals(ImmutableList.of(0, 7, 14, 21), Exercises.divisibleUpTo(25, 7));
      correctMethods.add("divisibleUpTo");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("divisibleUpTo");
    } catch (AssertionException e) {
      recordFailure("divisibleUpTo", e);
    }
  }

  private static void testConcat() {
    try {
      assertArrayEquals(ImmutableList.of(1, 2, 3, 4, 5, 6), Exercises.concat(
          ImmutableList.of(1, 2, 3), 
          ImmutableList.of(4, 5, 6)
      ));
      assertArrayEquals(ImmutableList.of("a", "b", "c", "d", "e"), Exercises.concat(
          ImmutableList.of("a", "b", "c"), 
          ImmutableList.of("d", "e")
      ));
      correctMethods.add("concat");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("concat");
    } catch (AssertionException e) {
      recordFailure("concat", e);
    }
  }
  
  private static void testFilterList() {
    try {
      assertArrayEquals(ImmutableList.of(2, 3, 5), Exercises.filterList(
          ImmutableList.of(1, 2, 3, -2, 5), 
          x -> x >= 2
      ));
      assertArrayEquals(ImmutableList.of("a", "ab"), Exercises.filterList(
          ImmutableList.of("a", "ab", "c"), 
          s -> s.startsWith("a")
      ));
      correctMethods.add("filterList");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("filterList");
    } catch (AssertionException e) {
      recordFailure("filterList", e);
    }
  }
  
  private static void testFilterListInPlace() {
    try {
      List<Integer> A = Ints.asList(1, 2, 3, -2, 5);
      Exercises.filterListInPlace(A, x -> x >= 2);
      assertArrayEquals(ImmutableList.of(2, 3, 5), A);
      
      List<Integer> B = Ints.asList(1, 2, 3, 4, 5);
      Exercises.filterListInPlace(B, x -> x % 2 == 0);
      assertArrayEquals(ImmutableList.of(2, 4), B);
      
      correctMethods.add("filterListInPlace");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("filterListInPlace");
    } catch (AssertionException e) {
      recordFailure("filterListInPlace", e);
    }
  }
  
  private static void testQueue() {
    try {
      Queue<Integer> A = new Queue<>();
      Queue<String> B = new Queue<>();
      A.push(1);
      A.push(2);
      B.push("Bob");
      assertEquals(2, A.pop());
      assertEquals("Bob", B.pop());
      assertEquals(0, B.size());
      A.push(3);
      B.push("Kate");
      A.push(4);
      B.push("Jill");
      assertEquals(2, B.size());
      assertEquals(4, A.pop());
      assertEquals(2, A.size());
      assertEquals("Jill", B.pop());
      
      correctMethods.add("Queue");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("Queue");
    } catch (AssertionException e) {
      recordFailure("Queue", e);
    }
  }
  
  private static void testSelectionSort() {
    try {
      
      ArrayList<Integer> A = new ArrayList<>(Ints.asList(5, 4, 3, 2, 1));
      Exercises.selectionSort(A);
      assertArraySorted(A, INTS_ASC);
      
      ArrayList<Integer> B = new ArrayList<>(Ints.asList(6, 7, 5, 1, 4, 2, 3));
      Exercises.selectionSort(B);
      assertArraySorted(B, INTS_ASC);
      
      correctMethods.add("selectionSort");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("selectionSort");
    } catch (AssertionException e) {
      recordFailure("selectionSort", e);
    }
  }  
  
  private static void testStringToLengths() {
    try {
      assertArrayEquals(
          ImmutableList.of(1, 3, 2, 4), 
          Exercises.stringToLengths(ImmutableList.of(
              "x",
              "xxx",
              "xx",
              "xxxx"
          ))
      );
      
      correctMethods.add("stringToLengths");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("stringToLengths");
    } catch (AssertionException e) {
      recordFailure("stringToLengths", e);
    }
  }
  
  private static void testReverseArray() {
    try {
      ArrayList<Integer> A = new ArrayList<>(ImmutableList.of(1, 2, 3, 4, 5));
      Exercises.reverseArray(A);
      assertArrayEquals(ImmutableList.of(5, 4, 3, 2, 1), A);
      
      ArrayList<String> B = new ArrayList<>(ImmutableList.of("a", "b", "c", "d"));
      Exercises.reverseArray(B);
      assertArrayEquals(ImmutableList.of("d", "c", "b", "a"), B);
      
      correctMethods.add("reverseArray");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("reverseArray");
    } catch (AssertionException e) {
      recordFailure("reverseArray", e);
    }
  }
   
  private static void testRotate() {
    try {
      ArrayList<Integer> A = new ArrayList<>(ImmutableList.of(1, 2, 3, 4, 5));
      Exercises.rotate(A, 2);
      assertArrayEquals(ImmutableList.of(4, 5, 1, 2, 3), A);
      
      ArrayList<String> B = new ArrayList<>(ImmutableList.of("a", "b", "c", "d"));
      Exercises.rotate(B, -1);
      assertArrayEquals(ImmutableList.of("b", "c", "d", "a"), B);
      
      correctMethods.add("rotate");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("rotate");
    } catch (AssertionException e) {
      recordFailure("rotate", e);
    }
  }

  private static void testGetDigits() {
    try {
      assertArrayEquals(ImmutableList.of(7, 6, 5), Exercises.getDigits(765));
      assertArrayEquals(ImmutableList.of(1, 3, 3, 7), Exercises.getDigits(1337));
      assertArrayEquals(ImmutableList.of(1), Exercises.getDigits(1));
      assertArrayEquals(ImmutableList.of(0), Exercises.getDigits(0));
      
      correctMethods.add("getDigits");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("getDigits");
    } catch (AssertionException e) {
      recordFailure("getDigits", e);
    }
  }

  private static void testCollatz() {
    try {
      assertEquals(111, Exercises.collatz(27));
      correctMethods.add("collatz");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("collatz");
    } catch (AssertionException e) {
      recordFailure("collatz", e);
    }
  }
  
  private static void testWordCount() {
    try {
      assertEquals(2, Exercises.wordCount("Hello World"));
      assertEquals(4, Exercises.wordCount("Hello World, and Bob!"));
      assertEquals(4, Exercises.wordCount("Hello World,   and  Bob!!!"));
      correctMethods.add("wordCount");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("wordCount");
    } catch (AssertionException e) {
      recordFailure("wordCount", e);
    }
  }
  
  private static void testIsPangram() {
    try {
      assertEquals(false, Exercises.isPangram("Hello World"));
      assertEquals(true, Exercises.isPangram("aBcdefgHiJKLmNoPqrStUvWxyz"));
      assertEquals(true, Exercises.isPangram("AbCDEFGhijklmNOpQrStuVWXyZ"));
      correctMethods.add("isPangram");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("isPangram");
    } catch (AssertionException e) {
      recordFailure("isPangram", e);
    }
  }
  
  private static void testIsPalindrome() {
    try {
      assertEquals(false, Exercises.isPalindrome("Hello World"));
      assertEquals(true, Exercises.isPalindrome("racecar"));
      assertEquals(true, Exercises.isPalindrome("madamimadam"));
      assertEquals(true, Exercises.isPalindrome("abba"));
      correctMethods.add("isPalindrome");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("isPalindrome");
    } catch (AssertionException e) {
      recordFailure("isPalindrome", e);
    }
  }
  
  private static void testIsPrime() {
    try {
      assertEquals(true, Exercises.isPrime(7));
      assertEquals(true, Exercises.isPrime(5));
      assertEquals(true, Exercises.isPrime(193));
      assertEquals(true, Exercises.isPrime(179));
      assertEquals(false, Exercises.isPrime(126));
      assertEquals(false, Exercises.isPrime(125));
      assertEquals(false, Exercises.isPrime(24));
      assertEquals(false, Exercises.isPrime(54));
      assertEquals(false, Exercises.isPrime(57));
      correctMethods.add("isPrime");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("isPrime");
    } catch (AssertionException e) {
      recordFailure("isPrime", e);
    }
  }
  
  private static void testPrimeFactorization() {
    try {
      assertEquals(multiset(7), convert(Exercises.primeFactorization(7)));
      assertEquals(multiset(2, 7), convert(Exercises.primeFactorization(14)));
      assertEquals(multiset(2, 7, 7), convert(Exercises.primeFactorization(98)));
      assertEquals(multiset(2, 2, 3, 3, 5), convert(Exercises.primeFactorization(180)));
      correctMethods.add("primeFactorization");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("primeFactorization");
    } catch (AssertionException e) {
      recordFailure("primeFactorization", e);
    }
  }
  
  private static void testEncodeToPigLatin() {
    try {
      assertEquals("Hetay uickqay rownbay oxfay", Exercises.encodeToPigLatin("The quick brown fox"));
      correctMethods.add("encodeToPigLatin");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("encodeToPigLatin");
    } catch (AssertionException e) {
      recordFailure("encodeToPigLatin", e);
    }
  }
  
  private static void testDecodeFromPigLatin() {
    try {
      assertEquals("The quick brown fox", Exercises.decodeFromPigLatin("Hetay uickqay rownbay oxfay"));
      correctMethods.add("decodeFromPigLatin");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("decodeFromPigLatin");
    } catch (AssertionException e) {
      recordFailure("decodeFromPigLatin", e);
    }
  }
  
  private static void testEncodeCaesarian() {
    try {
      assertEquals("Znk waoiq hxuct lud", Exercises.encodeCaesarian("The quick brown fox"));
      correctMethods.add("encodeCaesarian");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("encodeCaesarian");
    } catch (AssertionException e) {
      recordFailure("encodeCaesarian", e);
    }
  }
  
  private static void testDecodeCaesarian() {
    try {
      assertEquals("The quick brown fox", Exercises.decodeCaesarian("Znk waoiq hxuct lud"));
      correctMethods.add("decodeCaesarian");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("decodeCaesarian");
    } catch (AssertionException e) {
      recordFailure("decodeCaesarian", e);
    }
  }
  
  private static void testConcatIterable() {
    try {
      assertIterableEquals(makeIterable(1, 2, 3, 4), 
          Exercises.concatIterable(makeIterable(1, 2), makeIterable(3, 4)));
      assertIterableEquals(makeIterable(5, 6, 7), 
          Exercises.concatIterable(makeIterable(5), makeIterable(6, 7)));
      correctMethods.add("concatIterable");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("concatIterable");
    } catch (AssertionException e) {
      recordFailure("concatIterable", e);
    }
  }
  
  private static void testFilterIterable() {
    try {
      assertIterableEquals(makeIterable(3, 5), 
          Exercises.filterIterable(makeIterable(1, 2, 3, 1, 5), x -> x > 2));
      assertIterableEquals(makeIterable(-1, -2), 
          Exercises.filterIterable(makeIterable(-1, 3, -2, 4), x -> x < 0));
      correctMethods.add("filterIterable");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("filterIterable");
    } catch (AssertionException e) {
      recordFailure("filterIterable", e);
    }
  }
  
  private static void testFlattenIterable() {
    try {
      assertIterableEquals(makeIterable(1, 2, 3, 4, 5, 6, 7, 8), Exercises.flattenIterable(makeIterable(
          makeIterable(1, 2, 3),
          makeIterable(4),
          makeIterable(5, 6, 7, 8)
      )));
      correctMethods.add("flattenIterable");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("flattenIterable");
    } catch (AssertionException e) {
      recordFailure("flattenIterable", e);
    }
  }
  
  private static void testRunningAverageStream() {
    try {
      RunningAverageStream stream = new RunningAverageStream(makeIterable(1.0, 2.0, 3.0, 4.0, 5.0).iterator(), 3);
      assertEquals(true, stream.hasNext());
      assertEquals(1.0, stream.next());
      assertEquals(true, stream.hasNext());
      assertEquals(1.5, stream.next());
      assertEquals(true, stream.hasNext());
      assertEquals(2.0, stream.next());
      assertEquals(true, stream.hasNext());
      assertEquals(3.0, stream.next());
      assertEquals(true, stream.hasNext());
      assertEquals(4.0, stream.next());
      assertEquals(false, stream.hasNext());
      correctMethods.add("RunningAverageStream");
    } catch (NotCompletedException e) {
      unattemptedMethods.add("RunningAverageStream");
    } catch (AssertionException e) {
      recordFailure("RunningAverageStream", e);
    }
  }
}
