package com.mashup.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.Data;

/**
 * button
 * 
 * @author linluhao
 *
 */
@Data
public class ButtonDO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String value;

    private List<CapitalLetterDO> capitalLetters = Collections.emptyList();
}
