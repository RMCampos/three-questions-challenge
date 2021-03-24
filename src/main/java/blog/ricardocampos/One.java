package blog.ricardocampos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class One {
    
    public boolean validBracketSequence(String sequence) {
        if (sequence == null || sequence.isEmpty()) {
            return false;
        }

        sequence = sequence.replace("()", "");
        sequence = sequence.replace("[]", "");
        sequence = sequence.replace("{}", "");

        final Map<Character,Character> charValidMap = new HashMap<>();
        charValidMap.put('(', ')');
        charValidMap.put('[', ']');
        charValidMap.put('{', '}');
        
        final List<Integer> positionsDone = new ArrayList<>();
        
        final char[] letters = sequence.toCharArray();
        final int len = letters.length;
        
        for (Integer key=0; key<len; key++) {
            if (positionsDone.contains(key)) {
                continue;
            }
            
            final Character current = letters[key];
            final Character matching = letters[len-key-1];
            final Character rightOne = charValidMap.get(current);
            
            System.out.println(String.format("key[%d], current[%s], matching[%s], rightOne[%s]", key, current, matching, rightOne));
            
            if (!matching.equals(rightOne)) {
                return false;
            }
            
            positionsDone.add(key);
            positionsDone.add(len-key-1);
        }
        
        return true;
    }
}
