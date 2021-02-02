package com.mashup.service.impl;

import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.google.common.collect.Lists;
import com.mashup.entity.ButtonDO;
import com.mashup.entity.CapitalLetterDO;
import com.mashup.mapper.ButtonMapper;
import com.mashup.mapper.impl.ButtonMapperImpl;
import com.mashup.service.IButtonService;
import com.mashup.utils.CollectionUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ButtonServiceImpl implements IButtonService {

    private ButtonMapper buttonMapper = new ButtonMapperImpl();

    @Override
    public List<String> output(int[] arr) {

        // checkout args
        validate(arr);
        log.info("args are legal");

        // array to List
        List<String> buttonValueList = CollectionUtils.arrayToList(arr);
        log.info("array transform succeed!");

        // query button
        List<ButtonDO> buttonList = buttonMapper.listByValue(buttonValueList);
        log.info("list button succeed!");

        // button to letter
        List<List<CapitalLetterDO>> capitalLetters =
                buttonList.stream().map(ButtonDO::getCapitalLetters).collect(toList());

        return permutations(capitalLetters);
    }

    /**
     * business checkout
     * 
     * @param arr
     */
    private void validate(int[] arr) {
        log.info("--- checkout args ---");
    }

    /**
     * permutation and combination
     * 
     * @param capitalLetters origin letters
     * @return result
     */
    private List<String> permutations(List<List<CapitalLetterDO>> capitalLetters) {

        // decare return List
        List<String> returnList = Lists.newArrayList();

        // descartes
        capitalLetters = descartes(capitalLetters);

        // foreach capitalLetters and add returnList
        capitalLetters.forEach(letters -> {

            returnList.add(capitalLettersToString(letters));

        });

        return returnList;
    }

    /**
     * Returns a string use letter.getValue.lowerCase {@code ["foo",
     * "bar","baz"]}.
     *
     * @param letters
     * @return a string, {@code ["ae",
     * "bar","baz"]}.
     */
    private String capitalLettersToString(List<CapitalLetterDO> letters) {
        return letters.stream().map(letter -> {
            return letter.getValue().toLowerCase();
        }).collect(Collectors.joining());
    }

    /**
     * descartes
     * 
     * @param <T>
     * @param list
     * @return
     */
    private <T> List<List<T>> descartes(List<List<T>> list) {

        // decare return List
        List<List<T>> returnList = new ArrayList<>();

        // recursive start with 0 index
        descartesRecursive(list, 0, returnList, new ArrayList<T>());

        return returnList;
    }


    /**
     * recursive implement: foreach origin List from start index(0) to lastElement
     *
     * @param originalList
     * @param position current position from origin List
     * @param returnList
     * @param cacheList cache list
     */
    private <T> void descartesRecursive(List<List<T>> originalList, int position,
            List<List<T>> returnList, List<T> cacheList) {

        List<T> originalItemList = originalList.get(position);

        for (int i = 0; i < originalItemList.size(); i++) {
            // last element use cacheList
            List<T> childCacheList =
                    (i == originalItemList.size() - 1) ? cacheList : new ArrayList<>(cacheList);
            childCacheList.add(originalItemList.get(i));
            // quit where last element
            if (position == originalList.size() - 1) {
                returnList.add(childCacheList);
                continue;
            }

            descartesRecursive(originalList, position + 1, returnList, childCacheList);
        }
    }

}
