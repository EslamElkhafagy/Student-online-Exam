package layout.Register;

/**
 * Created by Enjoy on 24/05/2017.
 */
public class Validation {

    public boolean num(String s){


        return s.matches("[0-9]+");
    }

    public boolean word(String s){


        return s.matches("[a-zA-Z]+");
    }

    public boolean empty(String s){


        return s.equals("");
    }

    public boolean email(String s){


        return s.matches("[a-zA-Z0-9+_.-]+@(.+)");
    }
}
