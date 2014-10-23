package euler

object ProjectEuler {
  /*
   * Even Fibonacci numbers
   *
   * Each new term in the Fibonacci sequence is generated by adding the previous
   * two terms. By starting with 1 and 2, the first 10 terms will be:
   *
   * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
   *
   * By considering the terms in the Fibonacci sequence whose values do not
   * exceed four million, find the sum of the even-valued terms.
   */
  def problem2(): Int ={
    def fib(x: Int, y: Int) : Stream[Int] = {
      x #:: fib(y, x + y)
    }
    fib (1,2).takeWhile(n => n <= 4000000).filter (n => n % 2 == 0).sum
  }

  /*
   * Largest palindrome product
   *
   * A palindromic number reads the same both ways. The largest palindrome made
   * from the product of two 2-digit numbers is 9009 = 91 × 99.
   *
   * Find the largest palindrome made from the product of two 3-digit numbers.
   *
   */
  def problem4(): Int =  { ((for (x <- 100 until 1000; y <- x until 1000) yield x * y) filter (x => x.toString == x.toString.reverse)).max
  }
  

  /*
   * Special Pythagorean triplet
   *
   * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
   * which, a^2 + b^2 = c^2
   *
   * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
   *
   * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
   * Find the product abc.
   */
   
  def problem9(): Int ={
      (for{
        a <- (1 until 1000)
        b <- (a until 1000)
        c <- (b until 1000)
        if (a*a + b*b == c*c && a+b+c == 1000 && a<b && b<c)
      }yield a*b*c).head
    }


  /*
   * Maximum path sum I
   *
   * By starting at the top of the triangle below and moving to adjacent numbers
   * on the row below, the maximum total from top to bottom is 23.
   *
   *      3
   *     7 4
   *    2 4 6
   *   8 5 9 3
   *
   * That is, 3 + 7 + 4 + 9 = 23.
   *
   * Find the maximum total from top to bottom of the given triangle with 15
   * rows:
   */
  def problem18(triangle: List[List[Int]]): Int = { 
      val triangle = 
         List(List(75),
         List(95, 64),
         List(17, 47, 82),
         List(18, 35, 87, 10),
         List(20, 4, 82, 47, 65),
         List(19, 1, 23, 75, 3, 34),
         List(88, 2, 77, 73, 7, 63, 67),
         List(99, 65, 4, 28, 6, 16, 70, 92),
         List(41, 41, 26, 56, 83, 40, 80, 70, 33),
         List(41, 48, 72, 33, 47, 32, 37, 16, 94, 29),
         List(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14),
         List(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57),
         List(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48),
         List(63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31),
         List(4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60, 4, 23)) 
          
    def meld(bl: List[Int], sl: List[Int]): List[Int] = ((bl, sl): @unchecked) match {
    case (bf :: bs :: brest, sf :: srest) =>
      sf + Math.max(bf, bs) :: meld(bs :: brest, srest)
    case (bf :: brest, s) if (brest.size == 1 && s.size == 1) =>
      List(s.head + Math.max(bf, brest.head))
      
    case (b, Nil) =>
      Nil
  }
  def reduce(trng: List[List[Int]]): List[List[Int]] = (trng: @unchecked) match {
    case f :: s :: tail =>
      reduce(meld(f, s) :: tail)
    case f :: Nil => List(f)
  }
  return reduce(triangle.reverse).head.head
  }

  /*
   * Maximum path sum II
   *
   * By starting at the top of the triangle below and moving to adjacent numbers
   * on the row below, the maximum total from top to bottom is 23.
   *
   *    3
   *   7 4
   *  2 4 6
   * 8 5 9 3
   *
   * That is, 3 + 7 + 4 + 9 = 23.
   *
   * Find the maximum total from top to bottom in the given triangle with
   * one-hundred rows.
   *
   * NOTE: This is a much more difficult version of Problem 18. It is not
   * possible to try every route to solve this problem, as there are 2^99
   * altogether! If you could check one trillion (10^12) routes every second it
   * would take over twenty billion years to check them all. There is an
   * efficient algorithm to solve it. ;o)
   */
  def problem67(triangle: List[List[Int]]): Int = ???
}


