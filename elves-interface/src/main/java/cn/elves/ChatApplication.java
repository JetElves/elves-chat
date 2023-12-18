package cn.elves;


import cn.elves.domain.session.repository.ChatModelAdaptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"cn.elves"})
public class ChatApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ChatApplication.class, args);
        ChatModelAdaptor baseChatModelAdaptor = applicationContext.getBean(ChatModelAdaptor.class);
        System.out.println(baseChatModelAdaptor.hashCode());
    }
}
