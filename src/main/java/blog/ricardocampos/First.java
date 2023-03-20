package blog.ricardocampos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class First {

  /**
   * Check if a given string sequence have valid opening and closing brackets.
   *
   * @param sequence The string to be checked
   * @return True if is valid, false otherwise
   */
  public static boolean validBracketSequence(String sequence) {
    if (Objects.isNull(sequence) || sequence.isBlank()) {
      return false;
    }

    sequence = sequence.replace("()", "");
    sequence = sequence.replace("[]", "");
    sequence = sequence.replace("{}", "");

    final Map<Character, Character> charValidMap = new HashMap<>();
    charValidMap.put('(', ')');
    charValidMap.put('[', ']');
    charValidMap.put('{', '}');

    final List<Integer> positionsDone = new ArrayList<>();
    final char[] letters = sequence.toCharArray();

    for (int key = 0, len = letters.length; key < len; key++) {
      if (positionsDone.contains(key)) {
        continue;
      }

      final char current = letters[key];
      final char matching = letters[len - key - 1];
      final char rightOne = charValidMap.get(current);

      // Debug
      // String template = "key[%d], current[%s], matching[%s], rightOne[%s]%n";
      // System.out.printf(template, key, current, matching, rightOne);

      if (matching != rightOne) {
        return false;
      }

      positionsDone.add(key);
      positionsDone.add(len - key - 1);
    }

    return true;
  }
}
