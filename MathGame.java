       /*
        * Decompiled with CFR.
        */
       package springbootarthas.arthastest.demo;
       
       import java.util.ArrayList;
       import java.util.List;
       import java.util.Random;
       import java.util.concurrent.TimeUnit;
       
       public class MathGame {
           private static Random random = new Random();
           private int illegalArgumentCount = 0;
       
           public List<Integer> primeFactors(int number) {
/*52*/         if (number < 2) {
/*53*/             ++this.illegalArgumentCount;
                   throw new IllegalArgumentException("number is: " + number + ", need >= 2");
               }
               ArrayList<Integer> result = new ArrayList<Integer>();
/*57*/         int i = 2;
/*58*/         while (i <= number) {
/*59*/             if (number % i == 0) {
/*60*/                 result.add(i);
/*61*/                 number /= i;
/*62*/                 i = 2;
/*63*/                 continue;
                   }
/*65*/             ++i;
               }
/*67*/         return result;
           }
       
           public static void main(String[] args) throws InterruptedException {
               MathGame game = new MathGame();
               while (true) {
/*25*/             game.run();
/*26*/             TimeUnit.SECONDS.sleep(1L);
               }
           }
       
           public void run() throws InterruptedException {
               try {
/*32*/             int number = random.nextInt() / 10000;
/*33*/             List<Integer> primeFactors = this.primeFactors(number);
/*34*/             MathGame.print(number, primeFactors);
               }
               catch (Exception e) {
/*36*/             System.out.println(String.format("illegalArgumentCount:%3d, ", this.illegalArgumentCount) + e.getMessage());
               }
           }
       
           public static void print(int number, List<Integer> primeFactors) {
               StringBuffer sb = new StringBuffer(number + "=");
/*42*/         for (int factor : primeFactors) {
/*43*/             sb.append(factor).append('*');
               }
/*45*/         if (sb.charAt(sb.length() - 1) == '*') {
/*46*/             sb.deleteCharAt(sb.length() - 1);
               }
/*48*/         System.out.println(sb);
           }
       }

