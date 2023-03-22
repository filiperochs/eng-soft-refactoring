import java.util.Enumeration;
import java.util.Vector;

public class Customer {
  private String _name;
  private Vector _rentals = new Vector();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    String result = "Rental Record for " + getName() + "\n";
    Enumeration rentals = _rentals.elements();
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();

      // show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(each.getCharge()) + "\n";

    }
    // add footer lines
    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
        " frequent renter points";
    return result;
  }

  public String htmlStatement() {
    Enumeration rentals = _rentals.elements();

    String result = "<h1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      // show figures for each rental
      result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
    }

    // add footer lines
    result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
    result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints())
        + "</EM> frequent renter points<P>";

    return result;

  }

  private double getTotalCharge() {
    double total = 0;

    Enumeration rentals = _rentals.elements();

    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      total += each.getCharge();
    }

    return total;
  }

  private int getTotalFrequentRenterPoints() {
    int total = 0;

    Enumeration rentals = _rentals.elements();

    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      total += each.getFrequentRenterPoints();
    }

    return total;
  }
}