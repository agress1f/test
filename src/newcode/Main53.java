package newcode;

public class Main53 {
    public boolean isNumeric(char[] str) {
        String s =new String(str);
        if (s.endsWith("f")||s.endsWith("d")||s.endsWith("E")||s.endsWith("D")){
            return false;
        }
        try{
            Double.parseDouble(s);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
