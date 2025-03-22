package lapisteam.kurampa.kteleportfromvoid.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtils {

    private static final Pattern HEX_PATTERN = Pattern.compile("(?i)&(#\\w{6})");

    public static String applyColors(String input) {
        Matcher matcher = HEX_PATTERN.matcher(input);
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String hexCode = matcher.group(1); // Получаем #RRGGBB
            matcher.appendReplacement(buffer, ChatColor.of(hexCode).toString());
        }
        matcher.appendTail(buffer);

        return ChatColor.translateAlternateColorCodes('&', buffer.toString()); // Заменяем стандартные коды '&' на '§'
    }

    public static String applyGradient(String input, String startColor, String endColor) { // Метод для градиентов
        int length = input.length();
        if (length == 0) return input;

        int[] startRGB = parseColor(startColor);
        int[] endRGB = parseColor(endColor);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < length; i++) {
            float ratio = (float) i / (length - 1);
            int red = (int) (startRGB[0] + ratio * (endRGB[0] - startRGB[0]));
            int green = (int) (startRGB[1] + ratio * (endRGB[1] - startRGB[1]));
            int blue = (int) (startRGB[2] + ratio * (endRGB[2] - startRGB[2]));

            String hexColor = String.format("#%02X%02X%02X", red, green, blue);
            output.append(ChatColor.of(hexColor)).append(input.charAt(i));
        }
        return output.toString();
    }

    private static int[] parseColor(String hexColor) { // Парсинг цвета из HEX-кода
        return new int[]{
                Integer.valueOf(hexColor.substring(1, 3), 16),
                Integer.valueOf(hexColor.substring(3, 5), 16),
                Integer.valueOf(hexColor.substring(5, 7), 16)
        };
    }
}