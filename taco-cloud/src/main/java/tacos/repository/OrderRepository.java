package tacos.repository;

import tacos.domain.Order;

/**
 * @Author WuRui
 * @ClassName OrderRepository
 * @Date 2021/1/8 14:06
 * @Version 1.0
 * @Description //TODO
 **/
public interface OrderRepository {

    Order save(Order order);
}
