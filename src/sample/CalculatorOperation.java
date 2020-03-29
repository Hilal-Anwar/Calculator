package sample;

import java.util.ArrayList;

class CalculatorOperation {
    int sign, finalSign;
    Double FinalValue = 0.0;
    ArrayList<Double> Memory = new ArrayList<>();
    ArrayList<Integer> divisionOperator = new ArrayList<>();
    ArrayList<Integer> multiplicationOperator = new ArrayList<>();
    ArrayList<Integer> powerOperator = new ArrayList<>();
    String tem = "";
    char system;
    void Operation(String ConsoleValue) {
        Memory.clear();
        divisionOperator.clear();
        multiplicationOperator.clear();
        powerOperator.clear();
        tem = "";
        sign = 1;finalSign = 1;
        FinalValue = 0.0;
        ConsoleValue = ConsoleValue + "+";
        for (int i = 0; i < ConsoleValue.length(); i++) {
            if ((Character.isDigit(ConsoleValue.charAt(i)) || ConsoleValue.charAt(i) == '.') || ConsoleValue.charAt(i) == 'E') {
                tem = String.format("%s%s", tem, ConsoleValue.charAt(i));
                if (tem.length() == 1)
                    finalSign = sign;
            }
            if (ConsoleValue.charAt(i) == '!') {
                tem = String.valueOf(factorial(Double.parseDouble(tem)));
            }
            if (ConsoleValue.charAt(i)=='e')
                tem=String.valueOf(Math.E);
            if (ConsoleValue.charAt(i)=='π')
                tem=String.valueOf(Math.PI);
            if (ConsoleValue.charAt(i) == 'S') {
                i = function(i, 'S', ConsoleValue);
            }
            if (ConsoleValue.charAt(i) == 'C') {
                i = function(i, 'C', ConsoleValue);
            }
            if (ConsoleValue.charAt(i) == 'T') {
                i = function(i, 'T', ConsoleValue);
            }
            if (ConsoleValue.charAt(i) == 'l') {
                i = function(i, 'l', ConsoleValue);
            }
            if (ConsoleValue.charAt(i) == 'L') {
                i = function(i, 'L', ConsoleValue);
            }
            if (ConsoleValue.charAt(i) == 's') {
                i = function(i, 's', ConsoleValue);
            }
            if (ConsoleValue.charAt(i) == 'c') {
                i = function(i, 'c', ConsoleValue);
            }
            if (ConsoleValue.charAt(i) == 't') {
                i = function(i, 't', ConsoleValue);
            }
            if (ConsoleValue.charAt(i) == 'r') {
                i = function(i, 'r', ConsoleValue);
            }
            if (ConsoleValue.charAt(i) == '-'){
                sign = (-1);
            }
            if (ConsoleValue.charAt(i) == '+')
                sign = 1;
            if (ConsoleValue.charAt(i) == '-' || ConsoleValue.charAt(i) == '+') {
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem) * finalSign);
                    tem = "";
                }
            }
            if (ConsoleValue.charAt(i) == '/') {
                sign = 1;
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem) * finalSign);
                    tem = "";
                }
                divisionOperator.add(Memory.size() - 1);
            }
            if (ConsoleValue.charAt(i) == '*') {
                sign = 1;
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem) * finalSign);
                    tem = "";
                }
                multiplicationOperator.add(Memory.size() - 1);
            }
            if (ConsoleValue.charAt(i) == '^') {
                sign = 1;
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem) * finalSign);
                    tem = "";
                }
                powerOperator.add(Memory.size() - 1);
            }
        }
    }

    void power() {
        for (int j = 0; j < powerOperator.size(); j++) {
            Memory.set(powerOperator.get(j), Math.pow(Memory.get(powerOperator.get(j)), (Memory.get(powerOperator.get(j) + 1))));
            Memory.remove(powerOperator.get(j) + 1);
            powerOperator = sizeReducer(powerOperator, powerOperator, j);
            divisionOperator = sizeReducer(divisionOperator, powerOperator, j);
            multiplicationOperator = sizeReducer(multiplicationOperator, powerOperator, j);
        }
    }

    void division() {
        for (int i = 0; i < divisionOperator.size(); i++) {
            Memory.set(divisionOperator.get(i), Memory.get(divisionOperator.get(i)) / Memory.get(divisionOperator.get(i) + 1));
            Memory.remove(divisionOperator.get(i) + 1);
            divisionOperator = sizeReducer(divisionOperator, divisionOperator, i);
            multiplicationOperator = sizeReducer(multiplicationOperator, divisionOperator, i);
        }
    }

    void multiplication() {
        for (int j = 0; j < multiplicationOperator.size(); j++) {
            Memory.set(multiplicationOperator.get(j), Memory.get(multiplicationOperator.get(j)) * Memory.get(multiplicationOperator.get(j) + 1));
            Memory.remove(multiplicationOperator.get(j) + 1);
            multiplicationOperator = sizeReducer(multiplicationOperator, multiplicationOperator, j);
        }
    }

    void AdditionAndSubtraction() {
        for (Double aDouble : Memory) FinalValue = FinalValue + aDouble;
    }

    ArrayList<Integer> sizeReducer(ArrayList<Integer> memoryList1, ArrayList<Integer> memoryList2, int a) {
        for (int b = 0; b < memoryList1.size(); b++) {
            if ((memoryList2.get(a)) < memoryList1.get(b))
                memoryList1.set(b, (memoryList1.get(b) - 1));
        }
        return memoryList1;
    }

    int function(int i, char type, String Data) {
        i = i + 1;
        tem = "";
        finalSign=sign;
        while (true) {
            if (Character.isDigit(Data.charAt(i)) || Data.charAt(i) == '.' || Data.charAt(i) == 'E' || tem.equals(""))
            {
                tem = tem + Data.charAt(i);
                i = i + 1;
            }
            else {
                if (system == 'R') {
                    if (type == 'S')
                        tem = String.valueOf(Math.sin(Double.parseDouble(tem)));
                    if (type == 'C')
                        tem = String.valueOf(Math.cos(Double.parseDouble(tem)));
                    if (type == 'T')
                        tem = String.valueOf(Math.tan(Double.parseDouble(tem)));
                    if (type == 's')
                        tem = String.valueOf(Math.asin(Double.parseDouble(tem)));
                    if (type == 'c')
                        tem = String.valueOf(Math.acos(Double.parseDouble(tem)));
                    if (type == 't')
                        tem = String.valueOf(Math.atan(Double.parseDouble(tem)));
                } if (system=='D'){
                    if (type == 'S')
                        tem = String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(tem))));
                    if (type == 'C')
                        tem = String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(tem))));
                    if (type == 'T'){
                        if(!tem.equals("90.0"))
                        tem = String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(tem))));
                        else tem="+";
                    }
                    if (type == 's')
                        tem = String.valueOf(Math.toDegrees(Math.asin(Double.parseDouble(tem))));
                    if (type == 'c')
                        tem = String.valueOf(Math.toDegrees(Math.acos(Double.parseDouble(tem))));
                    if (type == 't')
                        tem = String.valueOf(Math.toDegrees(Math.atan(Double.parseDouble(tem))));
                }
                if (type == 'l')
                    tem = String.valueOf(Math.log(Double.parseDouble(tem)));
                if (type == 'L')
                    tem = String.valueOf(Math.log10(Double.parseDouble(tem)));
                if (type == 'r')
                    tem = String.valueOf(Math.sqrt(Double.parseDouble(tem)));
                break;
            }
        }
        return i;
    }

    double factorial(double n) {
        double f = 1;
        for (double i = 1; i <= n; i++)
            f = f * i;
        return f;
    }
}
