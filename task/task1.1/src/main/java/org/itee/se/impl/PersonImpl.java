package org.itee.se.impl;

import lombok.Data;
import org.itee.se.Person;
import org.itee.se.Phone;

@Data
public class PersonImpl implements Person {
    private Phone phone;
    private String name;
    private String type;

    @Override
    public void dial(String to) {
        System.out.println(name + "开始拨号...");
        phone.call(to);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Phone getPhone() {
        return phone;
    }
}
