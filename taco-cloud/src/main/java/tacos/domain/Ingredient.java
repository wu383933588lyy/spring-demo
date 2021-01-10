package tacos.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author WuRui
 * @ClassName Ingredient
 * @Date 2021/1/6 15:08
 * @Version 1.0
 * @Description //TODO taco配料模型
 **/
@Data
@Entity // 声明为 JPA 实体
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public class Ingredient {

    @Id
    private final String id;

    private final String name;

    private final Type type;

}
