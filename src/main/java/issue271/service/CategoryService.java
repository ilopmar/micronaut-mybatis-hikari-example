package issue271.service;

import issue271.domain.Category;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.inject.Singleton;

@Singleton
public class CategoryService implements CategoryMapper {

    final SqlSessionFactory sqlSessionFactory;

    public CategoryService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Category selectCategoryById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
            return categoryMapper.selectCategoryById(id);
        } finally {
            sqlSession.close();
        }
    }
}
