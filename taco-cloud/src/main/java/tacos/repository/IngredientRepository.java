package tacos.repository;

import tacos.domain.Ingredient;

/**
 * @Author WuRui
 * @ClassName IngredientRepository
 * @Date 2021/1/7 14:24
 * @Version 1.0
 * @Description //TODO
 **/
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
