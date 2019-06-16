package programming2018.searching;

/**
 * A symbol Table performance client
 * This ST client counts the frequency of occurrence of the strings in standard input, then prints out one that occurs with highest frequency.
 */
public class FrequencyCounter {

/*    public static void main(programming2018.String[] args)
    {
        int minlen = Integer.parseInt(args[0]);
        ST<programming2018.String, Integer> st ;
        while (!System.in.isEmpty())
        {  // Build symbol table and count frequencies.
            programming2018.String word = null ;//System.in.read();
            if (word.length() < minlen) continue;  // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else                    st.put(word, st.get(word) + 1);
        }
        // Find a key with the highest frequency count.
        programming2018.String max = "";
        st.put(max, 0);
        for (programming2018.String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        System.out.println(max + " " + st.get(max));

    }*/
}
