package refactioring;
public class TestMain {
   public static void main(String[] args) {
      Movie mc1 = new Movie("니이모를 찾아서", Movie.CHILDRENS);
      Movie mc2 = new Movie("말레피센트", Movie.CHILDRENS);
      Movie mr1 = new Movie("명량", Movie.REGULAR);
      Movie mr2 = new Movie("변호사", Movie.REGULAR);
      Movie mn1 = new Movie("곡성", Movie.NEW_RELEASE);
      Movie mn2 = new Movie("인디펜던스데이", Movie.NEW_RELEASE);
      
      Rental r1 = new Rental(3, mc1);
      Rental r2 = new Rental(4, mc2);
      Rental r3 = new Rental(2, mr1);
      Rental r4 = new Rental(3, mr2);
      Rental r5 = new Rental(2, mn1);
      Rental r6 = new Rental(3, mn2);
      
      Coustomer c = new Coustomer("김주하");
      c.addRental(r1);
      c.addRental(r3);
      c.addRental(r5);
      
      Coustomer c1 = new Coustomer("김희영");
      c1.addRental(r2);
      c1.addRental(r4);
      c1.addRental(r6);
      
      System.out.println(c.statement());
      System.out.println();
      System.out.println(c1.statement());
   }
}