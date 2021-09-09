package cn.joyloft.dbword;

import cn.joyloft.dbword.service.GenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;

@SpringBootTest
class DbWordApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    GenService genService;

    @Value("${filePath}")
    private String filePath;

    @Test
    void genWord(){
        genService.gen(filePath);
    }
}
