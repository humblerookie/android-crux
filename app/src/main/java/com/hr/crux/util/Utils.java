package com.hr.crux.util;

import java.util.List;
import java.util.Map;

public class Utils {

    public static boolean isEmpty(Object object) {

        if (object == null) {
            return true;
        }

        if (object instanceof String) {
            return object.toString().trim().length() == 0;
        }

        if (object instanceof List) {
            List list = (List) object;
            return list.size() == 0;

        }

        if (object instanceof Map) {
            Map map = (Map) object;

            return map.size() == 0;
        }

        return false;
    }

}
