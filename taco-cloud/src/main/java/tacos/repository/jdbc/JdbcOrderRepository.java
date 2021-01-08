package tacos.repository.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import tacos.domain.Order;
import tacos.domain.Taco;
import tacos.repository.OrderRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author WuRui
 * @ClassName JdbcOrderRepository
 * @Date 2021/1/8 14:58
 * @Version 1.0
 * @Description //TODO
 **/
@Repository
public class JdbcOrderRepository implements OrderRepository {

    private SimpleJdbcInsert orderInserter;

    private SimpleJdbcInsert orderTacoInserter;

    private ObjectMapper objectMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc) {
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");
        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("Taco_Order_Tacos");
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        for (Taco taco : order.getTacos()) {
            saveTacoToOrder(taco,orderId);
        }
        return order;
    }

    private long saveOrderDetails(Order order){
        @SuppressWarnings("unchecked")
        Map<String,Object> values = objectMapper.convertValue(order, Map.class);
        values.put("placedAt",order.getPlacedAt());
        return orderInserter.executeAndReturnKey(values).longValue();
    }

    private void saveTacoToOrder(Taco taco,long orderId){
        Map<String,Object> values = new HashMap<String, Object>();
        values.put("tacoOrder",orderId);
        values.put("taco",taco.getId());
        orderTacoInserter.execute(values);
    }
}
