package org.itee.se.impl;

import lombok.Data;
import org.itee.se.Person;
import org.itee.se.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component("person")
public class PersonImpl implements Person {
    @Autowired
    private Phone phone;
    @Value("${person.name}")
    private String name;
    @Value("${person.type}")
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

    @Override
    public void init() {
        System.out.println("进行init");
    }

    @Override
    public void destroy() {
        System.out.println("进行destroy");
    }
}
