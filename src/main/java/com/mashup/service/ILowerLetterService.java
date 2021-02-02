package com.mashup.service;

import com.mashup.entity.LowerLetterDO;

public interface ILowerLetterService extends IService<LowerLetterDO> {

    LowerLetterDO getByNumber(Integer digit);

}
