import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Recursie {


   // Oefening 1: n-de Fibonacci-getal

   public static int fibonacci(int getal) {
      if (getal == 1) {
         return 1;
      } else if (getal == 2) {
         return 1;
      } else if (getal <= 0) {
         throw new IllegalArgumentException("Getal moet strikt positief zijn");
      }
      return fibonacci(getal - 1) + fibonacci(getal - 2);
   }

   // Oefening 2 : som van cijfers

   public static int somVanCijfers(int getal) {
      getal = Math.abs(getal);
      if (getal < 10) {
         return getal;
      } else {
         return getal % 10 + somVanCijfers(getal / 10);
      }
   }

   // Oefening 3: keer een string om
   public static String keerOm(String s) {
      if (s == null){
         throw new IllegalArgumentException("");
      }
      if (s.isEmpty()) {
         return s;
      }
      return keerOm(s.substring(1)) + s.charAt(0);

   }

   //oefening 4: countX

   public static int countX(String s) {
      if(s == null){
         throw new IllegalArgumentException("String mag niet leeg zijn");
      }
      if(s.isEmpty()){
         return 0;
      }
      if(s.charAt(0)=='x'){
         return 1 + countX(s.substring(1));
      } else {
         return countX(s.substring(1));
      }
   }

   //oefening 5 : countHi
   public static int countHi(String s) {
      if (s == null){
         throw new IllegalArgumentException("");
      } else if (s.length()<2){
         return 0;
      } else if(s.charAt(0)=='h'){
         if(s.charAt(1)=='i'){
            return 1 + countHi(s.substring(2));
         }
      }
      return countHi(s.substring(1));
   }

   // oefening 6
   public static String changeXY(String s) {
      if(s == null){
         throw new IllegalArgumentException("");
      }
      if(s.equals("")){
         return s;
      }
      if(s.charAt(0)=='x'){
         return ("y"+changeXY(s.substring(1)));
      } else {
         return s.charAt(0) + changeXY(s.substring(1));
      }
   }

   // oefening 7

   public static String changePi(String s) {

      //s.replaceAll("pi","3.14")

      if(s == null){
         throw new IllegalArgumentException("");
      }
      if(s.equals("")){
         return s;
      }
      if(s.charAt(0)=='p'){
         if(s.charAt(1)=='i'){

         }
      }
         return s.charAt(0) + changePi(s.substring(1));
   }

   // oefening 8:
   public static int tweelog(int getal) {
      if(getal <= 0){
         throw new IllegalArgumentException("");
      }
      if(getal == 1){
         return 0;
      } else {
         return 1 + tweelog(getal/2);
      }
   }

   // oefening 9;
   public static double findMaximum(List<Double> lijst) {
      throw new UnsupportedOperationException("Not yet implemented");
   }

   // oefening 10;
   public static ArrayList<String> findSubstrings(String string) {
      throw new UnsupportedOperationException("Not yet implemented");
   }

}