package cn.imcompany.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Salary {

    private String name;
    private int baseSalary;
    private int bonus;
}
