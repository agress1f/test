package newcode;

import java.util.HashMap;

public class Main54 {
    HashMap<Character,Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    int index = 0;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        map.put(ch,map.getOrDefault(ch,0)+1);
    }
    //return the first appearence once char in current stringstream
    //如果当前字符流没有存在出现一次的字符，返回#字符。
    public char FirstAppearingOnce()
    {
        while ( index<sb.length()){
            if (map.get(sb.charAt(index))==1){
                return sb.charAt(index);
            }
            index++;
        }
        return '#';
    }
}
