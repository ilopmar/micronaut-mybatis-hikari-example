package issue271.service;

import issue271.domain.Category;

public interface CategoryMapper {
    Category selectCategoryById(int id);
}
