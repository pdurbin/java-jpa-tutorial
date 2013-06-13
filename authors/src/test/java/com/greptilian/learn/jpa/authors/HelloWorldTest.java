package com.greptilian.learn.jpa.authors;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;

// http://www.adam-bien.com/roller/abien/entry/embedding_ejb_3_1_container
public class HelloWorldTest {

    @Test
    public void hello() throws NamingException {

        EJBContainer ejbC = EJBContainer.createEJBContainer();

        Context ctx = ejbC.getContext();

        HelloWorld helloWorld = (HelloWorld) ctx.lookup("java:global/classes/HelloWorld");

        assertNotNull(helloWorld);

        String expected = "duke";

        String hello = helloWorld.hello(expected);

        assertNotNull(hello);

        assertTrue(hello.endsWith(expected));

        ejbC.close();

    }
}
