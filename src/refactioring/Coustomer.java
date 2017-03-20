package refactioring;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Coustomer {
	private String name;
	private List<Rental> rentals;
	
	public Coustomer(String name) {
		this.name = name;
		this.rentals = new ArrayList<>();
	}
	
	public void addRental(Rental aRental){
		this.rentals.add(aRental);
	}

	public String getName() {
		return name;
	}
	
	public String statement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		StringBuilder result = new StringBuilder(getName() + "고객님의 대여 기록\n");
		//1, 일반물 (2일) 2000원 일일초과 1500 적립1==>(2일, 3000원) 일일초과 2000 ,적립0.5		
		//2, 아동 (3일) 1500원 일일초과 1500 적립1==>(2일, 2000원) 일일초과 2000 ,적립1
		//3, 최신 (1일) 3000원 일일초과 3000 적립1==>(2일, 4000원) 일일초과 4000 ,적립1+1
		//HTML 출력원함
		for(Rental each:rentals){
			double thisAmount = 0;
			
			switch(each.getMovie().getPriceCode()){
			case Movie.REGULAR:
				thisAmount += 3000;
				if(each.getDaysRented()>2)
					thisAmount += (each.getDaysRented() -2) * 1.5;
				break;

			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3000;
				break;	
			
			case Movie.CHILDRENS:
				thisAmount += 1500;
				if(each.getDaysRented()>3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}
			
			frequentRenterPoints ++;
			
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints ++;
			
			result.append("\t"+each.getMovie().getTitle());
			result.append("\t"+String.valueOf(thisAmount)+"\n");
			
			totalAmount += thisAmount;
		}
		
		result.append("누적 대여료: " + String.valueOf(totalAmount) + "\n");
		result.append("적립 포인트: " + String.valueOf(frequentRenterPoints) + "\n");
		
		return result.toString();
	}
	
	
	public String htmlStatement(){
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuilder result = new StringBuilder(getName() + "고객님의 대여 기록\n");
		//1, 일반물 (2일) 2000원 일일초과 1500 적립1==>(2일, 3000원) 일일초과 2000 ,적립0.5		
		//2, 아동 (3일) 1500원 일일초과 1500 적립1==>(2일, 2000원) 일일초과 2000 ,적립1
		//3, 최신 (1일) 3000원 일일초과 3000 적립1==>(2일, 4000원) 일일초과 4000 ,적립1+1
		//HTML 출력원함
		for(Rental each:rentals){
			double thisAmount = 0;
			
			switch(each.getMovie().getPriceCode()){
			case Movie.REGULAR:
				thisAmount += 3000;
				if(each.getDaysRented()>2)
					thisAmount += (each.getDaysRented() -2) * 1.5;
				break;

			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3000;
				break;	
			
			case Movie.CHILDRENS:
				thisAmount += 1500;
				if(each.getDaysRented()>3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}
			
			frequentRenterPoints ++;
			
			if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints ++;
			
			result.append("\t"+each.getMovie().getTitle());
			result.append("\t"+String.valueOf(thisAmount)+"\n");
			
			totalAmount += thisAmount;
		}
		
		result.append("누적 대여료: " + String.valueOf(totalAmount) + "\n");
		result.append("적립 포인트: " + String.valueOf(frequentRenterPoints) + "\n");
		
		return result.toString();
	}
}
