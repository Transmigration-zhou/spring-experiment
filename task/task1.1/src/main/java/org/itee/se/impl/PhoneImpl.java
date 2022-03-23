package org.itee.se.impl;

import lombok.Data;
import org.itee.se.Phone;

@Data
public class PhoneImpl implements Phone {
    private String phoneType;

    @Override
    public void call(String to) {
        System.out.println("手机型号：" + phoneType + ",正在接通" + to);
    }

    @Override
    public String getType() {
        return phoneType;
    }
}
