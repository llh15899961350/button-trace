package com.mashup.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import com.google.common.collect.Maps;
import com.mashup.entity.LowerLetterDO;
import com.mashup.service.IButtonService;
import com.mashup.service.ILowerLetterService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LowerLetterServiceImpl implements ILowerLetterService {

    // private static final char DEFAULT_LETTER = 'a';

    private static final Map<Integer, LowerLetterDO> CACHE_MAP = Maps.newConcurrentMap();

    private IButtonService buttonService = new ButtonServiceImpl();

    @Override
    public LowerLetterDO getByNumber(Integer digit) {

        // checkout args
        validate(digit);

        String temp = String.valueOf(digit);
        List<String> actualList = null;
        LowerLetterDO letter = null;

        int[] arr;
        if (temp.length() < 2) {

            arr = new int[] {digit};

        } else {

            char[] charArray = temp.toCharArray();
            int tensDigit = Integer.parseInt(String.valueOf(charArray[0]));
            int unitDigit = Integer.parseInt(String.valueOf(charArray[1]));
            arr = new int[] {tensDigit, unitDigit};
        }

        actualList = buttonService.output(arr);

        if (actualList.isEmpty() && Objects.isNull(CACHE_MAP.get(digit))) {
            synchronized (this) {
                // CACHE_MAP.put(digit, value);
            }

        } else {
            String letterValue = actualList.stream().collect(Collectors.joining());
            letter = new LowerLetterDO();
            letter.setValue(letterValue);
        }

        return letter;
    }

    /**
     * 
     * @param digit
     */
    private void validate(Integer digit) {
        log.info("checkout digit");
    }

}
