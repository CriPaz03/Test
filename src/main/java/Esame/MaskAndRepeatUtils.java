package Esame;

public class MaskAndRepeatUtils {

    /**
     * Mask characters in a String at a specified interval, then repeat the masked String
     * until reaching the specified maxLength.
     *
     * @param str  the original String to process, may be null
     * @param maskChar  the character to apply as a mask at specified intervals
     * @param interval  the interval at which to apply the mask character in the original String
     * @param maxLength  the maximum length of the resulting String after repeating
     * @return a new String with masked and repeated segments until maxLength, or null if input is null or maxLength <= 0
     */
    public static String maskAndFillToLength(final String str, final char maskChar, final int interval, final int maxLength) {
        if (str == null || maxLength <= 0 || interval <= 0) {
            return null;
        }

        if(str.isEmpty()){
            return str;
        }

        StringBuilder maskedStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((i + 1) % interval == 0) {
                maskedStr.append(maskChar);
            } else {
                maskedStr.append(str.charAt(i));
            }
        }

        if (maskedStr.length() >= maxLength) {
            return maskedStr.substring(0, maxLength);
        }

        StringBuilder result = new StringBuilder();
        while (result.length() + maskedStr.length() <= maxLength) {
            result.append(maskedStr);
        }

        if (result.length() < maxLength) {
            result.append(maskedStr, 0, maxLength - result.length());
        }

        return result.toString();
    }

}
