package com.mashup.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * 
 * @author linluhao
 *
 */
@Data
@Accessors(chain = true)
public class DigitDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer number;

    private LowerLetterDO lowerLetter;

}
