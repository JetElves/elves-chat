package cn.elves;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {
        "cn.elves.chat.infrastructure"})
public class ChatApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ChatApplication.class, args);
    }
}
