package cn.imcompany.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {

    private String name;
    private int baseSalary;
    private int bonus;
    private long totalSalary;
}
