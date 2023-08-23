package Tests;

public class StaticContext {
    static String firstName;

    public static String getFirstName(){
        return firstName;
    }

    public static void setFirstName(String firstName){
        StaticContext.firstName = firstName;}


}


