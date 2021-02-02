package com.mashup.service;

import java.util.List;
import com.mashup.entity.ButtonDO;

public interface IButtonService extends IService<ButtonDO> {

    /**
     * output
     * 
     * @param arr [1,9]
     * @return
     */
    List<String> output(int[] arr);

}
