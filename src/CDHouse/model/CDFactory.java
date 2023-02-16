/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CDHouse.model;

/**
 *
 * @author Giga P34
 */
public class CDFactory {
    static public CD parse(String cd) {
        String[] tokens = new String[5];
        int tokens_index = 0;
        int previous = 0;
        for (int i = 0; i < cd.length(); ++i) {
            if (cd.charAt(i) == '~') {
                int slashCount = 0;
                while (cd.charAt(i - slashCount - 1) == '\\') {
                    ++slashCount;
                }
                if (slashCount % 2 == 1) {
                    continue;
                }
                tokens[tokens_index++] = cd.substring(previous, i);
                previous = i + 1;
            }
        }
        tokens[tokens_index++] = cd.substring(previous, cd.length());
        CD result = null;
        if (tokens[4].equals("video")) {
            result = new VideoCD(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
        }
        else if (tokens[4].equals("audio")) {
            result = new AudioCD(tokens[0], tokens[1], Double.parseDouble(tokens[2]), tokens[3]);
        }
        return result;
    }
}
