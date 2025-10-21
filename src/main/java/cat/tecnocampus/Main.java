package cat.tecnocampus;

import com.sun.security.jgss.GSSUtil;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("**************************************************");
        System.out.println("*** Going to set to a plain person. No Proxy involved ***");

        Person plainPerson = new PersonImplementation();

        plainPerson.setName("Jack");
        plainPerson.setGender("Man");
        plainPerson.setInterests("Dancing");
        plainPerson.setHotOrNotRating(5);

        System.out.println();
        System.out.println("*** Going to get from a plain person. No Proxy involved ***");

        System.out.println("Main: name = " + plainPerson.getName());
        System.out.println("Main: gender = " + plainPerson.getGender());
        System.out.println("Main: interests = " + plainPerson.getInterests());
        System.out.println("Main: hotOrNotRating = " + plainPerson.getHotOrNotRating());

        System.out.println();
        System.out.println();
        System.out.println("**************************************************");

        Person anotherPerson = new PersonImplementation();
        Person proxyPerson = PersonProxyFactory.getPersonProxy(plainPerson);

        System.out.println("*** Going to set to a proxy of person.***");
        proxyPerson.setName("Maria");
        proxyPerson.setGender("Woman");
        proxyPerson.setInterests("Rugby");
        proxyPerson.setHotOrNotRating(50);

        System.out.println();
        System.out.println("*** Going to get from a proxy of person.***");
        System.out.println("Main Proxy: name = " + proxyPerson.getName());
        System.out.println();
        System.out.println("Main Proxy: gender = " + proxyPerson.getGender());
        System.out.println();
        System.out.println("Main Proxy: interests = " + proxyPerson.getInterests());
        System.out.println();
        System.out.println("Main Proxy: hotOrNotRating = " + proxyPerson.getHotOrNotRating());

        System.out.println();
        System.out.println("*** Going to get from a plain person. No Proxy involved ***");

        System.out.println("Main plain: name = " + plainPerson.getName());
        System.out.println("Main plain: gender = " + plainPerson.getGender());
        System.out.println("Main plain: interests = " + plainPerson.getInterests());
        System.out.println("Main plain: hotOrNotRating = " + plainPerson.getHotOrNotRating());

    }
}