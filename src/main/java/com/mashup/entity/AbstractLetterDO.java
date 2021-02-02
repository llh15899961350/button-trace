package com.mashup.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * letter
 * 
 * @author linluhao
 *
 */
@SuppressWarnings("serial")
@Data
public abstract class AbstractLetterDO implements Serializable {

    protected Long id;

    protected String value;

}
