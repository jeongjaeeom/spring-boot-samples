package io.jjeom.hello;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)    // 실제 내장톰캣이 실행되지 않고 Mocking한다.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)    // 실제 내장톰캣이 실행된다.
@AutoConfigureMockMvc
@Slf4j
public class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    HelloService helloService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void test() {
        System.out.println(new Date().getTime() / 1000);
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(LocalDateTime.now().getSecond());
        System.out.println(passwordEncoder.encode("1234"));
    }

    @Test
    public void hello() throws Exception {
        when(helloService.getName()).thenReturn("jeongjae");
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello jeongjae"))
                .andDo(print());
    }

    @Test
    public void helloForRestTemplate() throws Exception {
        when(helloService.getName()).thenReturn("jeongjae");
        String result = testRestTemplate.getForObject("/hello", String.class);
        assertThat(result).isEqualTo("Hello jeongjae");
    }

    @Test
    public void helloForWebTestClient() {
//        when(helloService.getName()).thenReturn("jeongjae");
//        webTestClient.get().uri("/hello").exchange().expectStatus().isOk()
//                .expectBody(String.class).isEqualTo("Hello jeongjae");

    }

}