package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //String suffixExpression = "3 4 + 5 * 6 -";
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpression = toInfixExpressionList(expression);
        //System.out.println(infixExpression);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpression);
        System.out.println("后缀表达式"+ suffixExpressionList);
        //List<String> rpnList = getListString(suffixExpression);
        //System.out.println("rpnList="+rpnList);
        //int res = calculate(rpnList);
        //System.out.println(res);
        System.out.println(calculate(suffixExpressionList));
    }
    public static List<String> getListString(String str){
        String[] split =str.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele:split){
            list.add(ele);
        }
        return list;
    }
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int i = 0;//指针，用于遍历中缀表达式字符串
        String str;//多位数拼接
        char c;
        do {
            //如果不是数字，需要放入到c
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                ls.add(""+c);
                i++;
            }else {//如果是数字，需要考虑多位数
                str = "";//先将str置成“”
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
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
     public static List<String> parseSuffixExpressionList(List<String> s){
        Stack<String> s1 = new Stack<>();
        //因为s2没有POP操作还需要逆序输出，因此比较麻烦这里我们就不用stack
         List<String> s2 = new ArrayList<>();
         for (String item: s){
             if (item.matches("\\d+")){
                 s2.add(item);
             }else if (item.equals("(")){
                 s1.push(item);
             }else if (item.equals(")")){
                 while (!s1.peek().equals("(")){
                     s2.add(s1.pop());
                 }
                 s1.pop();
             }else {
                while (s1.size()!=0 &&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将运算符压入s1
                s1.push(item);
             }
         }
         while (s1.size()!=0){
             s2.add(s1.pop());
         }
         return s2;
     }
}
class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 1;
    private static int DIV = 2;
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}