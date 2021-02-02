package com.mashup.mapper;

import java.util.List;
import com.mashup.entity.ButtonDO;

public interface ButtonMapper extends BaseMapper<ButtonDO> {

    /**
     * get ButtonDO by value
     * 
     * @param buttonValue button value
     * @return
     */
    ButtonDO getByValue(String buttonValue);

    /**
     * list ButtonDO by value
     * 
     * @param buttonValues list button value
     * @return
     */
    List<ButtonDO> listByValue(List<String> buttonValues);
}
