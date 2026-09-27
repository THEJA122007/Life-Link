package utils;

public class Java21StringUtils {
    public static String cleanText(String text) {
        if (text == null) {
            return "";
        }
        return text.strip();
    }

    public static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    public static String repeatMessage(String message,int count) {
        if (message == null) {
            return "";
        }
        return message.repeat(count);
    }

    public static String replaceFirstText(String text,String oldText,String newText) {
        if (text == null) {
            return "";
        }        
        return text.replaceFirst(oldText,newText);
    }
}