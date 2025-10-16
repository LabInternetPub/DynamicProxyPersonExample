package cat.tecnocampus;

import java.lang.reflect.Proxy;

public class PersonProxyFactory {
    public static Person getPersonProxy(Person realSubject) {
        return (Person) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                new PersonInvocationHandler(realSubject));
    }
}
