package ua.in.dris4ecoder.spring.mvc.controllers.dbControllers;

import org.springframework.transaction.annotation.Transactional;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Dish;
import ua.in.dris4ecoder.spring.mvc.model.businessObjects.DishCategory;
import ua.in.dris4ecoder.spring.mvc.model.dao.DishDao;

import java.util.List;

/**
 * Created by Alex Korneyko on 14.08.2016 17:22.
 */
public class DishController {

    private DishDao dishDao;

    @Transactional
    public void initDishes() {
        createDish("Plov", DishCategory.MAIN, 4F, 300F);
        createDish("Salad", DishCategory.SALAD, 2F, 200F);
        createDish("Potato", DishCategory.SIDE_DISH, 3F, 300F);
        createDish("Borsch", DishCategory.MAIN, 5F, 300F);

    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public void removeAllDishes() {
        this.dishDao.removeAll();
    }

    private void createDish(String name, DishCategory category, float price, float weight) {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setCategory(category);
        dish.setPrice(price);
        dish.setWeight(weight);

        dishDao.save(dish);
    }
}
