package com.mashup.service.impl;

import java.math.BigDecimal;
import com.mashup.entity.DigitDO;
import com.mashup.service.IDigitService;

public class DigitServiceImpl implements IDigitService {

    // private ILowerLetterService lowerLetterService = new LowerLetterServiceImpl();

    @Override
    public DigitDO getByNumber(BigDecimal number) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(1 % 26);
    }

}
