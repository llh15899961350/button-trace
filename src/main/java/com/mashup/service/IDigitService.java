package com.mashup.service;

import java.math.BigDecimal;
import com.mashup.entity.DigitDO;

public interface IDigitService extends IService<DigitDO> {

    DigitDO getByNumber(BigDecimal number);

}
