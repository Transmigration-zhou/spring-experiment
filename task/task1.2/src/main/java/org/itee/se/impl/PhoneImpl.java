package org.itee.se.impl;

import lombok.Data;
import org.itee.se.Phone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class PhoneImpl implements Phone {
    @Value("${phone.type}")
    private String phoneType;

    @Override
    public void call(String to) {
        System.out.println("手机型号：" + phoneType + ",正在接通" + to);
    }

    @Override
    public String getType() {
        return phoneType;
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
