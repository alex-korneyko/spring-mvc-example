package ua.in.dris4ecoder.spring.mvc.model.dao;

import ua.in.dris4ecoder.spring.mvc.model.businessObjects.Dish;

import java.util.List;

/**
 * Created by Alex Korneyko on 14.08.2016 17:16.
 */
public interface DishDao {

    void save(Dish dish);

    List findAll();

    Dish findByName(String name);

    void removeAll();
}
