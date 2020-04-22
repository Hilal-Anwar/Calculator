package Code;

public class Rational
{
    private long a, b,pos=0,l=0;
    Rational(String input){
        StringBuilder num=new StringBuilder();
        if (!input.contains("."))
            input = input + ".0";
        boolean condition = true;
        l = input.length();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.' && condition) {
                pos = input.indexOf(".") + 1;
                condition = false;
            } else {
                num.append(input.charAt(i));
            }
        }
        a = Long.parseLong(num.toString());
        b = (long) Math.pow(10, l - pos);
    }
    public String P_by_QForm() {
        return a / Hcf(a, b) + "/" + b / Hcf(a, b);
    }
    private long Hcf(long a, long b) {
        long gdc = 0, count = 0;
        for (long i = 1; i <= Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gdc = Math.max(i, gdc);
            } else {
                count++;
                if (count == 500)
                    break;
            }
        }
        return gdc;
    }
}
