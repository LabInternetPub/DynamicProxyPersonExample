package cat.tecnocampus;

import java.lang.reflect.Proxy;

public class PersonProxyFactory {
    public static Person getPersonProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new PersonInvocationHandler(person));
    }
}
