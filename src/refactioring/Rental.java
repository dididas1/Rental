package refactioring;
public class Rental {
	private int daysRented;
	private Movie movie;
	
	public Rental(int daysRented, Movie movie) {
		this.daysRented = daysRented;
		this.movie = movie;
	}
	public int getDaysRented() {
		return daysRented;
	}
	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
