package tacos.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.domain.Ingredient;
import tacos.domain.Type;
import tacos.repository.IngredientRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author WuRui
 * @ClassName JdbcIngredientRepository
 * @Date 2021/1/7 14:27
 * @Version 1.0
 * @Description //TODO
 **/
@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id,name,type from Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Ingredient findOne(String id) {
        return jdbcTemplate.queryForObject("select id,name,type from Ingredient where id =?", this::mapRowToIngredient, id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredient (id,name type) values (?,?,?)",
                ingredient.getId(),ingredient.getName(),ingredient.getType().toString());
        return ingredient;
    }

    /**
     * @Author WuRui
     * @Date 14:35 2021/1/7
     * @Param [rs, rowNum]
     * @Return tacos.domain.Ingredient
     * @Description //TODO 将结果集中的每行数据映射成一个对象
     */
    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(rs.getString("id"), rs.getString("name"), Type.valueOf(rs.getString("type")));
    }
}
