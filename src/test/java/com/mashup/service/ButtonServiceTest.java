package com.mashup.service;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mashup.service.impl.ButtonServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ButtonServiceTest {

    private IButtonService buttonService = new ButtonServiceImpl();

    /**
     * Question 1
     * 
     * @throws Exception
     */
    @Test
    void testDoRecursionButton() throws Exception {

        // ***--- Start

        // --- Button 9
        int[] arr = {9};

        List<String> actualLines = buttonService.output(arr);

        List<String> expectedLines = Lists.newArrayList("w", "x", "y", "z");

        assertLinesMatch(expectedLines, actualLines);

        // --- Button [2,3]
        arr = new int[] {2, 3};

        actualLines = buttonService.output(arr);

        expectedLines = Lists.newArrayList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        assertLinesMatch(expectedLines, actualLines);

        // --- Button 0
        arr = new int[] {0};

        actualLines = buttonService.output(arr);

        expectedLines = Collections.emptyList();

        assertLinesMatch(expectedLines, actualLines);

        // ***--- end

    }

    @Test
    void testDoQueryWith() throws Exception {
        List<String> actualLines = null;
        List<String> numbers = Lists.newArrayList();
        Set<String> values = Sets.newHashSet();
        char letter = 'a';
        for (int i = 0; i < 100; i++) {
            String temp = String.valueOf(i);
            int[] arr;
            if (temp.length() > 1) {
                char[] charArray = temp.toCharArray();
                int tensDigit = Integer.valueOf(String.valueOf(charArray[0]));
                int unitDigit = Integer.valueOf(String.valueOf(charArray[1]));
                arr = new int[] {tensDigit, unitDigit};



            } else {
                arr = new int[] {i};

            }
            actualLines = buttonService.output(arr);

            if (actualLines.isEmpty()) {

                numbers.add(temp);
                values.add(String.valueOf((char) (letter + i)));
            } else {
                values.add(Joiner.on("").join(actualLines));
            }
        }

        log.info(numbers.size() + "");

    }

    /**
     * Question 2
     */
    @Test
    void testDoQuestionTwo() throws Exception {
        // todo: no any idea to support this question
        log.info("to be continue!");
    }


}
