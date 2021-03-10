import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Represents an oject DateVerifier.
 */
public class DateVerifier {
    public static final String DATE_FORMAT ="DD/MM/YYYY";
    public static final String DELIMETER ="/";
    public static final int[] DAYS_IN_MONTH ={31, 29, 31 ,30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Constructs the object DateVerifier.
     */
    public DateVerifier(){

    }

    /**
     * Takes timeString and split it and if anything is wrong it throws DateTimeException
     * and if everything is good it @return date in correct order in form of LocalDate.
     * @param s1
     * @param timeString
     */
    public static LocalDate verify( String s1,String timeString ){
        if(timeString.length()>DATE_FORMAT.length() || timeString.length()<5){
            throw new DateTimeException(s1+" not the right number of Characters\nPlease use the following format:\n"+DATE_FORMAT);
        }

        final String[] split = timeString.split("/");

        if(split.length !=3){
            throw new DateTimeException(s1+" missing or too many fields\n the correct formay is "+DATE_FORMAT);
        }

        int day,month,year;
        try {
            day = Integer.parseInt(split[0]);
            month =Integer.parseInt(split[1]);
            year = Integer.parseInt(split[2]);
        }catch(NumberFormatException ex){
            throw new DateTimeException(s1+" only digits are allowed\n D M Y are digits in "+DATE_FORMAT);
        }

        if(!validDay(day,month)){
            throw new DateTimeException(s1+" incorrect\"day digits\" of "+day);
        }
        if(!validMonth(month)){
            throw new DateTimeException(s1+" incorrect\"month digits\" of "+day);
        }
        if(!validYear(year)){
            throw new DateTimeException(s1+" incorrect\"year digits\" of "+day);
        }
        //System.out.println(day+"/"+month+"/"+day);
        return LocalDate.of(year,month,day);
    }

    /**
     * 
     * @param day
     * @param month
     * @return true if Day is valid else return false.
     */
    private static boolean validDay(int day,int month){
        if(day >= 1 && day <= DAYS_IN_MONTH[month-1]){
            return true;
        }
        return false;
    }

    /**
     * 
     * @param month
     * @return true if Month is valid else return false.
     */
    private static boolean validMonth(int month){
        if(month >= 0 && month <= 12){
            return true;
        }
        return false;
    }

    /**
     * 
     * @param year
     * @return true if Year is valid else return false.
     */
    private static boolean validYear(int year){
        if(year >= 1000 && year <= 3000){
            return true;
        }
        return false;
    }


}