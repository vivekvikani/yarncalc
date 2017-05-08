package com.yarncostingindia.parse;

import java.math.BigDecimal;

/**
 * Created by Parsania Hardik on 19/02/2016.
 */
public class DecimalUtils {

    public static double round(double value, int numberOfDigitsAfterDecimalPoint) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numberOfDigitsAfterDecimalPoint,
                BigDecimal.ROUND_HALF_UP);
        return bigDecimal.doubleValue();
    }
}