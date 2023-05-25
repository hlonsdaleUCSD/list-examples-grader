import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}


public class TestListExamples {
  public class PalindromeChecker implements StringChecker{
    public boolean checkString(String s){
        int l = s.length();
        char[] schar = s.toCharArray();
        for(int i = 0; i<=l/2;i++){
            if(i == l-i-1 || l-i-1-i==1){return true;}
            if(schar[i] == (schar[l-i-1])){
                continue;
            }
            else{
                break;
            }
        }
        return false;
    }

}
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
  @Test(timeout = 500)
    public void mergeTest1(){
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("list1 - 1");
        list1.add("list1 - 2");
        list2.add("list2 - 1");
        list2.add("list2 - 2");
        list2.add("list2 - 3");
        List<String> expectOutput = new ArrayList<String>();
        expectOutput.add("list1 - 1"); expectOutput.add("list1 - 2");
        expectOutput.add("list2 - 1"); expectOutput.add("list2 - 2"); 
        expectOutput.add("list2 - 3");
        assertEquals(ListExamples.merge(list1,list2), expectOutput);
    }

    @Test(timeout = 500)
    public void filterPalindromeTest(){
        List<String> list = new ArrayList<String>();
        list.add("bananab");
        list.add("racecar");
        list.add("walkwalk");
        list.add("computer");
        list.add("dad");
        StringChecker sc = new PalindromeChecker();
        List<String> expectOutput = new ArrayList<String>();
        expectOutput.add("bananab"); expectOutput.add("racecar"); expectOutput.add("dad");
        List<String> output = ListExamples.filter(list,sc);
        assertEquals(output, expectOutput);
    }
}
