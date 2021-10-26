package testdemo.greeter;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static testdemo.greeter.Greeting.greet;

public class GreetingTest {


    @Test
    void givenNameBobGreetShouldReturnHelloBob() {
        String answer = greet("Bob");

        assertThat(answer).isEqualTo("Hello Bob");
    }

    @Test
    void givenNullAsNameGreetShouldReturnHellomyFriend() {
       assertThat(greet(null)).isEqualTo("Hello, my friend.");
    }

    @Test
    void givenNameMartinGreetShouldReturnHelloMartin() {
        assertThat(greet("Martin")).isEqualTo("Hello Martin");
    }

    @Test
    void givenNameJERRYShouldReturnHELLOJERRY() {
        assertThat(greet("JERRY")).isEqualTo("HELLO JERRY");
    }

    @Test
    void givenNameANNAShouldReturnHELLOANNA() {
        assertThat(greet("ANNA")).isEqualTo("HELLO ANNA");
    }

    @Test
    void givenTwoNamesShouldReturnHelloName1AndName2() {
        assertThat(greet("Jill,Jane")).isEqualTo("Hello Jill and Jane");
    }

    @Test
    void givenAnotherPairOfNamesShouldReturnHelloName1AndName2() {
        assertThat(greet("Joakim,Frida")).isEqualTo("Hello Joakim and Frida");
    }


    


}
