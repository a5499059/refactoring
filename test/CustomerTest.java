import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Movie movieRegular;
    private Rental rentalRegularTwoDays;
    private Rental rentalRegularThreeDays;

    private Movie movieNEWRELEASE;
    private Rental rentalNEWRELEASE;

    private Movie movieCHILDREN;
    private Rental rentalCHILDRENThreeDays;
    private Rental rentalCHILDRENFourDays;

    private Customer customer;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //REGULAR(priceCode=0)
        movieRegular = new Movie("doraemon0",0);
        rentalRegularTwoDays = new Rental(movieRegular,2);
        rentalRegularThreeDays = new Rental(movieRegular,3);

        //NEWRELEASE(priceCode=1)
        movieNEWRELEASE= new Movie("doraemon1",1);
        rentalNEWRELEASE = new Rental(movieNEWRELEASE,2);


        //CHILDREN(priceCode=2)
        movieCHILDREN = new Movie("doraemon2",2);
        rentalCHILDRENThreeDays = new Rental(movieCHILDREN,3);
        rentalCHILDRENFourDays = new Rental(movieCHILDREN,4);

        customer = new Customer("hoge");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testGetName() {
        assertEquals("hoge",customer.getName());
    }
    @org.junit.jupiter.api.Test
    void testSingleRentalRegularTwoDays() {
        customer.addRentals(rentalRegularTwoDays);
        String statement = customer.statement();
        String result = "Rental Record for " + "hoge" + "\n";
        result += "\t" + "doraemon0" + "\t" + "2.0" + "\n";
        result += "Amount owed is " + "2.0" + "\n";
        result += "You earned " + "1" + " frequent renter points";
        assertEquals(result, statement);
    }
        @org.junit.jupiter.api.Test
        void testSingleRentalRegularThreeDays() {
        customer.addRentals(rentalRegularThreeDays);
        String statement = customer.statement();
        String result = "Rental Record for " + "hoge" + "\n";
        result += "\t" + "doraemon0" + "\t" + "3.5" + "\n" ;
        result += "Amount owed is " + "3.5" + "\n";
        result += "You earned " + "1" + " frequent renter points";
        assertEquals(result,statement);

    }
    @org.junit.jupiter.api.Test
    void testSingleRentalNEWRELEASE() {
        customer.addRentals(rentalNEWRELEASE);
        String statement = customer.statement();
        String result = "Rental Record for " + "hoge" + "\n";
        result += "\t" + "doraemon1" + "\t" + "6.0" + "\n" ;
        result += "Amount owed is " + "6.0" + "\n";
        result += "You earned " + "2" + " frequent renter points";
        assertEquals(result,statement);

    }
    @org.junit.jupiter.api.Test
    void testSingleRentalCHILDRENThreeDays() {
        customer.addRentals(rentalCHILDRENThreeDays);
        String statement = customer.statement();
        String result = "Rental Record for " + "hoge" + "\n";
        result += "\t" + "doraemon2" + "\t" + "1.5" + "\n" ;
        result += "Amount owed is " + "1.5" + "\n";
        result += "You earned " + "1" + " frequent renter points";
        assertEquals(result,statement);
    }
    @org.junit.jupiter.api.Test
    void testSingleRentalCHILDRENFourDays() {
        customer.addRentals(rentalCHILDRENFourDays);
        String statement = customer.statement();
        String result = "Rental Record for " + "hoge" + "\n";
        result += "\t" + "doraemon2" + "\t" + "3.0" + "\n" ;
        result += "Amount owed is " + "3.0" + "\n";
        result += "You earned " + "1" + " frequent renter points";
        assertEquals(result,statement);
    }
    @org.junit.jupiter.api.Test
    void testMultiRentalRegular() {
        customer.addRentals(rentalRegularTwoDays);
        customer.addRentals(rentalRegularThreeDays);
        String statement = customer.statement();
        String result = "Rental Record for " + "hoge" + "\n";
        result += "\t" + "doraemon0" + "\t" + "2.0" + "\n";
        result += "\t" + "doraemon0" + "\t" + "3.5" + "\n";
        result += "Amount owed is " + "5.5" + "\n";
        result += "You earned " + "2" + " frequent renter points";
        assertEquals(result, statement);
    }

    @org.junit.jupiter.api.Test
    void testMultiRentalNEWRELEASE() {
        customer.addRentals(rentalNEWRELEASE);
        customer.addRentals(rentalNEWRELEASE);
        String statement = customer.statement();
        String result = "Rental Record for " + "hoge" + "\n";
        result += "\t" + "doraemon1" + "\t" + "6.0" + "\n" ;
        result += "\t" + "doraemon1" + "\t" + "6.0" + "\n" ;
        result += "Amount owed is " + "12.0" + "\n";
        result += "You earned " + "4" + " frequent renter points";
        assertEquals(result,statement);

    }
    @org.junit.jupiter.api.Test
    void testMultiRentalCHILDREN() {
        customer.addRentals(rentalCHILDRENThreeDays);
        customer.addRentals(rentalCHILDRENFourDays);
        String statement = customer.statement();
        String result = "Rental Record for " + "hoge" + "\n";
        result += "\t" + "doraemon2" + "\t" + "1.5" + "\n" ;
        result += "\t" + "doraemon2" + "\t" + "3.0" + "\n" ;
        result += "Amount owed is " + "4.5" + "\n";
        result += "You earned " + "2" + " frequent renter points";
        assertEquals(result,statement);
    }
}