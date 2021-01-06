package tacos.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @Author WuRui
 * @ClassName Ingredient
 * @Date 2021/1/6 15:08
 * @Version 1.0
 * @Description //TODO taco配料模型
 **/
@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;

    private final String name;

    private final Type type;

}
