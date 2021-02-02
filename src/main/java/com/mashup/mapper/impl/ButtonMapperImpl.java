package com.mashup.mapper.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Lists;
import com.mashup.entity.ButtonDO;
import com.mashup.entity.CapitalLetterDO;
import com.mashup.mapper.ButtonMapper;

public class ButtonMapperImpl implements ButtonMapper {

    {

        // init size
        memory = new HashMap<>(10);
        memory.put("*", new ButtonDO());
        memory.put("#", new ButtonDO());
        memory.put("0", new ButtonDO());
        memory.put("1", new ButtonDO());
        memory.put("2", simulatedData('A', 3));
        memory.put("3", simulatedData('D', 3));
        memory.put("4", simulatedData('G', 3));
        memory.put("5", simulatedData('J', 3));
        memory.put("6", simulatedData('M', 3));
        memory.put("7", simulatedData('P', 4));
        memory.put("8", simulatedData('T', 3));
        memory.put("9", simulatedData('W', 4));

    }

    /**
     * simulated data
     * 
     * @param letter first letter eg:A
     * @param size
     * @return
     */
    private static ButtonDO simulatedData(int firstLetter, int size) {

        // decare variables
        ButtonDO button = new ButtonDO();
        List<CapitalLetterDO> list = Lists.newArrayList();

        // assgined variables
        for (int i = 0; i < size; i++) {
            CapitalLetterDO capitalLetter = new CapitalLetterDO();
            capitalLetter.setValue(String.valueOf((char) (firstLetter + i)));
            list.add(capitalLetter);
        }
        button.setCapitalLetters(list);
        return button;
    }

    /***
     * simulate query a table
     */
    private static Map<String, ButtonDO> memory = null;

    @Override
    public ButtonDO getByValue(String buttonValue) {
        return memory.get(buttonValue);
    }

    @Override
    public List<ButtonDO> listByValue(List<String> buttonValues) {

        List<ButtonDO> newArrayList = Lists.newArrayList();

        buttonValues.forEach(value -> {
            newArrayList.add(getByValue(value));
        });

        return newArrayList;
    }

}
