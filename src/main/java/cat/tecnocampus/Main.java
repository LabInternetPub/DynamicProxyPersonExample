package cat.tecnocampus;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("**************************************************");
        System.out.println("Going to set to a plain person. No Proxy involved");

        Person plainPerson = new PersonImplementation();

        plainPerson.setName("Jack");
        plainPerson.setGender("Man");
        plainPerson.setInterests("Dancing");
        plainPerson.setHotOrNotRating(5);

        System.out.println();
        System.out.println("Going to get from a plain person. No Proxy involved");
        plainPerson.getName();
        plainPerson.getGender();
        plainPerson.getInterests();
        plainPerson.getHotOrNotRating();

        System.out.println();
        System.out.println();
        System.out.println("**************************************************");

        Person anotherPerson = new PersonImplementation();
        Person proxyPerson = PersonProxyFactory.getPersonProxy(anotherPerson);

        System.out.println("Going to set to a proxy of person.");
        proxyPerson.setName("Jack");
        proxyPerson.setGender("Man");
        proxyPerson.setInterests("Dancing");
        proxyPerson.setHotOrNotRating(5);

        System.out.println();
        System.out.println("Going to get from a proxy of person.");
        proxyPerson.getName();
        proxyPerson.getGender();
        proxyPerson.getInterests();
        proxyPerson.getHotOrNotRating();
        
        
    }
}