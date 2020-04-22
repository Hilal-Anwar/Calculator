package Code;

public class Calculator extends CalculatorOperation {

    String mem;
    public Calculator(String ConsoleValue, char measureSystem)
    {
        system=measureSystem;
        int start = 0, end = 0;
        ConsoleValue=Reformat(ConsoleValue);
        mem=ConsoleValue;
        ConsoleValue=ConsoleValue.replace("√","r");
        ConsoleValue=ConsoleValue.replace("asin","s");
        ConsoleValue=ConsoleValue.replace("acos","c");
        ConsoleValue=ConsoleValue.replace("atan","t");
        ConsoleValue=ConsoleValue.replace("sin","S");
        ConsoleValue=ConsoleValue.replace("cos","C");
        ConsoleValue=ConsoleValue.replace("tan","T");
        ConsoleValue=ConsoleValue.replace("log","L");
        ConsoleValue=ConsoleValue.replace("ln","l");
        ConsoleValue=Reorganized(ConsoleValue);
        System.out.println(ConsoleValue);
        while (ConsoleValue.contains("(") || ConsoleValue.contains(")"))
        {
            for (int i = 0; i < ConsoleValue.length(); i++)
            {
                if (ConsoleValue.charAt(i) == '(')
                    start = i;
                if (ConsoleValue.charAt(i) == ')') {
                    end = i;
                    break;
                }
            }
            String x = ConsoleValue.substring(start, end + 1);
            Operation(ConsoleValue.substring(start + 1, end));
            if (start != 0 && Character.isDigit(ConsoleValue.charAt(start - 1)))
                ConsoleValue = ConsoleValue.replace(x, "*" + findAnswers());
            else if (start != 0 && ConsoleValue.charAt(start - 1) == '-') {
                String y = ConsoleValue.substring(start - 1, end + 1);
                ConsoleValue = ConsoleValue.replace(y, -1 + "*" + findAnswers());
            } else if (start != 0 && ConsoleValue.charAt(start - 1) == '*')
                ConsoleValue = ConsoleValue.replace(x, String.valueOf(findAnswers()));
            else

                ConsoleValue = ConsoleValue.replace(x, String.valueOf(findAnswers()));
            System.out.println(ConsoleValue);
        }
        Operation(ConsoleValue);
    }

    public Double findAnswers() {
        power();
        division();
        multiplication();
        AdditionAndSubtraction();
        return FinalValue;
    }
    String Reformat(String co)
    {
        int c1=0,c2=0;
        for (int i=0;i<co.length();i++){
            if (co.charAt(i)=='(')
                c1++;
            if (co.charAt(i)==')')
                c2++;
        }
        if ((c1-c2)>0){
            co = co + ")".repeat(Math.max(0, (c1 - c2)));
        }
        if ((c1-c2)<0){
            co=co.substring(0,(co.length()-(c2-c1)));
        }
        return co;
    }
    String Reorganized(String str){
        StringBuilder tem= new StringBuilder();
        for (int i=0;i<str.length();i++)
        {
            if ((i!=0)&&(str.charAt(i)=='S'||str.charAt(i)=='s'||
                    str.charAt(i)=='C'||str.charAt(i)=='c'||
                    str.charAt(i)=='T'||str.charAt(i)=='t'||
                    str.charAt(i)=='L'|| str.charAt(i)=='l'
                    ||str.charAt(i)=='e'||str.charAt(i)=='π'||str.charAt(i)=='r')
                    &&(Character.isDigit(str.charAt(i-1))||str.charAt(i-1)==')'))
            {
                    tem.append("*").append(str.charAt(i));
            }
            else if((i!=0&&Character.isDigit(str.charAt(i))&&str.charAt(i-1)==')')||
                    (i!=0&&Character.isDigit(str.charAt(i))&&
                            ((str.charAt(i-1)=='π')||(str.charAt(i-1)=='e')||(str.charAt(i-1)=='!')))){
                tem.append("*").append(str.charAt(i));
            }
            else if ((i!=0&&str.charAt(i)=='e'&&str.charAt(i-1)=='π')||((i!=0&&str.charAt(i)=='π'&&str.charAt(i-1)=='e')))
                tem.append("*").append(str.charAt(i));
            else if ((i!=0&&str.charAt(i)=='π'&&str.charAt(i-1)=='π')||((i!=0&&str.charAt(i)=='e'&&str.charAt(i-1)=='e')))
                tem.append("*").append(str.charAt(i));
            else tem.append(str.charAt(i));
        }
        return tem.toString();
    }
}
