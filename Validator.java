public class Validator {
    public boolean checkAge(int age) {//there we check age of customer
        if (age >= 16) {
            return true;
        } else //people who are less than 16 can't buy a ticket
            return false;
    }

    public boolean checkNum(String tel) {//there we check phone number of customer
        if(tel.length()!=12)//number can't be less than 12 digits
            return false;
        else {
            if(tel.charAt(0) == '+' && tel.charAt(1) == '7')//number must start from '+7'
                return true;
            int e=0;
            for (int i = 0; i < tel.length(); i++) {
                if (Character.isDigit(tel.charAt(i))) {//number must contain only digits after symbol +
                    e++;
                }
            }
            return e == 11;
        }
    }


    public boolean checkPassword(String password) {
        if (password.length() < 8) { //password must contain more than 8 symbols
            return false;
        } else {
            int e = 0;
            for (int p = 0; p < password.length(); p++) {
                if (Character.isUpperCase(password.charAt(p))) { //it must contain at least 1 uppercase letter
                    e++;
                    break;
                }
            }
            for (int q = 0; q < password.length(); q++) { //it must contain at least 1 lowercase letter
                if (Character.isLowerCase(password.charAt(q))) {
                    e++;
                    break;
                }
            }
            for (int r = 0; r < password.length(); r++) { //it must contain at least  1 digit letter
                if (Character.isDigit(password.charAt(r))) {
                    e++;
                    break;
                }
            }
            for (int r = 0; r < password.length(); r++) { //it must contain at least 1 special symbol letter
                if ((password.contains("@") || password.contains("#")
                        || password.contains("!") || password.contains("~")
                        || password.contains("$") || password.contains("%")
                        || password.contains("^") || password.contains("&")
                        || password.contains("*") || password.contains("(")
                        || password.contains(")") || password.contains("-")
                        || password.contains("+") || password.contains("/")
                        || password.contains(":") || password.contains(".")
                        || password.contains(", ") || password.contains("<")
                        || password.contains(">") || password.contains("?")
                        || password.contains("|"))) {
                    e++;
                    break;
                }
            }
            if (e == 4)
                return true;
            else
                return false;
        }
    }
}

