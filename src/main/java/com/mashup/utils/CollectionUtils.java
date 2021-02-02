package com.mashup.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.google.common.collect.Lists;

/**
 * Collections Utils
 * <p>
 * process {@link Collection}
 * <p>
 *
 * @author linluhao
 */
public final class CollectionUtils {


    private CollectionUtils() {}

    /**
     * int array to List<String>
     * 
     * @param arr
     * @return
     */
    public static List<String> arrayToList(int[] arr) {

        ArrayList<String> newArrayList = Lists.newArrayList();
        for (int i = 0; i < arr.length; i++) {
            newArrayList.add(String.valueOf(arr[i]));
        }

        return newArrayList;
    }
}
