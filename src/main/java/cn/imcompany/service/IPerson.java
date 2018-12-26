package cn.imcompany.service;

public interface IPerson {

    default String sayHi() {
        return "iperson say hi ";
    }
}
