import java.text.SimpleDateFormat;
import java.util.*;

class Korzon{

    static class aRa{

    }

}

public class SomeTests {

    public Map<String, String> mapAB2(Map<String, String> map) {

        if ((map.containsKey("a")) && map.containsKey("b")) {

            if (map.get("a").equals(map.get("b"))) {
                map.remove("a");
                map.remove("b");
            }
        }
        return map;

    }

    public Map<String, String> mapShare(Map<String, String> map) {


        if (map.containsKey("a")) map.put("b", map.get("a"));

        if (map.containsKey("c")) map.remove("c");
        return map;
    }


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String month = in.next();
//        String day = in.next();
//        String year = in.next();
        String s = "";
        String str = "Some stuff";
        s = ""+str.charAt(1);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        numbers.forEach( i -> {System.out.println(i); });

    }

    public int[] makeLast(int[] nums) {
        int l= nums.length;
        int newMatrix[] = new int[2*l];
        newMatrix[(2*l)-1] = nums[l-1];
        return newMatrix;
    }

    public Map<String, String> mapBully(Map<String, String> map) {

        String aValue = map.get("a");
        if (aValue!="") {
            map.put("b", aValue);
            map.put("a", "");
        }
        return map;
    }

    public boolean endsLy(String str) {
        int l = str.length();
        String sub = str.substring(l-2,l-1);
        boolean b = sub.equals("ly");
        return b;
    }

    public boolean startHi(String str) {
        if (str.substring(0,2).equals("hi")) return true;
        return false;
    }

    public String middleThree(String str) {
        int len = str.length()/2;
        return str.substring(len-1,len+1);
    }
    public int countCode(String str) {
        int count = 0;

        for (int i=0; i<str.length()-5; i++){

            if (str.substring(i,i+2).equals("co") && (str.substring(i+3,i+4).equals("e"))) count++;

        }
        return count;
    }
    public boolean bobThere(String str) {
        int l = str.length();

        for (int i=0; i<l;){

            if((str.charAt(i)=='b') && (str.charAt(i+2)=='b')){
                return true;
            }

        }

        return false;
    }

    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<strings.length; i++){
            map.put(strings[i],0);
        }
        return map;
    }
}

