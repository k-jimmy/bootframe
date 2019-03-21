package example.bootframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("example.bootframe.mapper")
public class BootframeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootframeApplication.class, args);
    }

}
