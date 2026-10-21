
package com.devops.task_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.devops.task_manager.controller.HelloController;

class HelloControllerTest {

    @Test
    void shouldReturnHelloMessage() {

        HelloController controller = new HelloController();

        String result = controller.hello();

        assertEquals("Hello from Spring Boot DevOps!", result);
    }
}
