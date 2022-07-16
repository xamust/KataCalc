package KataCacl;

class CalcRoman {

    String[] inputData;
    String operation;
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    int[] inputValues = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    String[] inputRoman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
    int resultInt;
    String resultStr;

    String getResult() throws MyExeption {
        Calculate();
        return resultStr;
    }

    void setInputData(String[] inputData) {
        this.inputData = inputData;
    }

    void setOperation(String operation) {
        this.operation = operation;
    }

    String ConvertToRoman(String input) {
        StringBuilder roman = new StringBuilder();
        int num = Integer.parseInt(input);
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }

    int ConvertFromRoman(String input) {
        String[] roman = input.split("");
        int num = 0;
        for (int i = 0; i < inputRoman.length; i++) {
            while (input.matches(inputRoman[i])) {
                num = inputValues[i];
                break;
            }
        }
        return num;
    }

    void Calculate() throws MyExeption {
        int tempResult = 0;
        for (String v : inputData) {
            if (!v.toUpperCase().matches("[IVX]+")) {
                throw new MyExeption("Incorrect string! (input nums must be Roman)");
            }
        }
        int num1 = ConvertFromRoman(inputData[0]);
        int num2 = ConvertFromRoman(inputData[1]);
        if (num1 > 10 || num2 > 10 || num1 <= 0 || num2 <= 0) {
            throw new MyExeption("Incorrect Roman string!");
        }
        switch (operation) {
            case "addition":
                tempResult = (int) Math.addExact(num1, num2);
                break;
            case "subtraction":
                tempResult = (int) Math.subtractExact(num1, num2);
                if (tempResult < 1) {
                    throw new MyExeption("Roman nums cannot be less than I");
                }
                break;
            case "multiplication":
                tempResult = (int) Math.multiplyExact(num1, num2);
                break;
            case "divison":
                tempResult = (int) Math.floorDiv(num1, num2);
                if (tempResult < 1) {
                    throw new MyExeption("Roman nums cannot be less than I");
                }
                break;
        }
        resultStr = ConvertToRoman(Integer.toString(tempResult));
    }
}
