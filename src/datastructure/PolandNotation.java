package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList="+rpnList);
        int res = calculate(rpnList);
        System.out.println(res);
    }
    public static List<String> getListString(String str){
        String[] split =str.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele:split){
            list.add(ele);
        }
        return list;
    }
     public static int calculate(List<String> ls){
        Stack<String> stack=new Stack<String>();
        for (String item:ls){
            if (item.matches("\\d+")){
                //匹配多位数
                stack.push(item);
            }else {
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res=num1+num2;
                }else if (item.equals("-")){
                    res=num1-num2;
                }else if (item.equals("*")){
                    res = num1*num2;
                }else if (item.equals("/")){
                    res = num1/num2;
                }else {
                    throw new RuntimeException("运算符错误");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
     }
}
