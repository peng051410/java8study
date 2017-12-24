package cn.imcompany.domain;

import cn.imcompany.service.IPerson;

public class DaPerson implements IBasePerson, IPerson {

    @Override
    public String sayHi() {
        return IPerson.super.sayHi();
    }
}
