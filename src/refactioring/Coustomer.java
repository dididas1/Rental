package refactioring;
import java.util.ArrayList;
import java.util.List;

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
		
		for(Rental each:rentals){
			double thisAmount = 0;
			
			switch(each.getMovie().getPriceCode()){
			case Movie.REGULAR:
				thisAmount += 2;
				if(each.getDaysRented()>2)
					thisAmount += (each.getDaysRented() -2) * 1.5;
				break;

			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;	
			
			case Movie.CHILDRENS:
				thisAmount += 1.5;
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
