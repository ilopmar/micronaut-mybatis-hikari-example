package issue271.mybatis;

import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Factory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

@Factory
public class MybatisFactory {

    @Context
    SqlSessionFactory sessionFactory() throws IOException {
        try {
            Reader reader = Resources.getResourceAsReader("database-config.xml");
            return new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
