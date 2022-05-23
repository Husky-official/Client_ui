/**
 * @author UWENAYO Alain Pacifique
 * @description This class is used to validate the user input
 */
package src.utils.registration;

import java.util.Date;

/** The type Validations. */
public class Validations {
  /**
   * In range string.
   *
   * @param number the number
   * @param min the min
   * @param max the max
   * @return the string
   */
  public static String inRange(int number, int min, int max) {
        if(number < min || number > max) return "Number is not in range[" + min + "," + max + "]";
        return "OK";
    }
  /**
   * Is email valid string.
   *
   * @param email the email
   * @return the string
   */
  public static String isEmailValid(String email) {
        if(!email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) return "Email is not valid, must be in format: example.domain.extension";
        return "OK";
    }
<<<<<<< HEAD
=======

    public static String isPhoneNumberValid(String phoneNumber) {
      if(!phoneNumber.matches("^07\\d{8}$")) return "Phone number is not valid, must be in format: 0782345678";
    return "OK";
    }
>>>>>>> main
  /**
   * Is password valid string.
   *
   * @param password the password
   * @return the string
   */
  public static String isPasswordValid(String password) {
<<<<<<< HEAD
      if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) return "Password is not valid, must be at least 8 characters long, contain at least one upper case letter, one lower case letter, one number and one special character";
=======
      // password must be at least 6 characters long
      if(password.length() < 6) return "Password is not valid, must be at least 6 characters long";
>>>>>>> main
        return "OK";
    }

  /**
   * Is date of birth valid string.
   *
   * @param dateOfBirth the date of birth
   * @return the string
   */
  public static String isDateOfBirthValid(Date dateOfBirth) {
        Date eighteenYearsAgo = new Date(new Date().getTime() - (16L * 365 * 24 * 60 * 60 * 1000));
        if(dateOfBirth.after(eighteenYearsAgo)) return "Date of birth is not valid, must be at least 16 years old";
        return "OK";
    }

  /**
   * Is date valid string.
   *
   * @param date the date
   * @return the string
   */
  public static String isDateValid(String date) {
        if(!date.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) return "Date is not valid, must be in format dd/mm/yyyy";
        return "OK";
    }
  /**
   * Is name valid string.
   *
   * @param name the name
   * @return the string
   */
  public static String isNameValid(String name) {
        if(!name.matches("^[a-zA-Z ]+$")) return "Name is not valid, must be in format: Uwenayo Alain Pacifique";
        return "OK";
    }
  /**
   * Not null boolean.
   *
   * @param value the value
   * @return the boolean
   */
  public static boolean NotNull(String value) {
        return !(value == null || value.isEmpty());
    }
}
