import com.example.backend_utvikling.anagram;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class anagramTest {

    @Test
    public void shouldDoSomething(){
        ArrayList<String> words = new ArrayList<>();
        words.add("cba");words.add("abc");
        words.add("lars");words.add("sral");
        words.add("words");words.add("srodw");
        words.add("balls");words.add("labsl");
        words.add("trym");words.add("myrt");
        ArrayList<String> list = anagram.anagrams(words);

        assertEquals(list.get(0),"cba = abc");
        assertEquals(list.get(1),"lars = sral");
        assertEquals(list.get(2),"words = srodw");
        assertEquals(list.get(3),"balls = labsl");
        assertEquals(list.get(4),"trym = myrt");
    }

}