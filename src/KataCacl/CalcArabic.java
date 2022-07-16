package KataCacl;

class CalcArabic {
    String[] inputData;
    String operation;
    int result;

    String getResult() throws MyExeption {
        Calculate();
        return Integer.toString(result);
    }

    void setInputData(String[] inputData) {
        this.inputData = inputData;
    }

    void setOperation(String operation) {
        this.operation = operation;
    }

    void Calculate() throws MyExeption {
        long num1 = Integer.parseInt(inputData[0]);
        long num2 = Integer.parseInt(inputData[1]);
        if (num1 > 10 || num2 > 10 || num1 <= 0 || num2 <= 0) {
            throw new MyExeption("Incorrect string! (input nums, must be greater than 0 and less than 10(inclusive))");
        }
        switch (operation) {
            case "addition":
                result = (int) Math.addExact(num1, num2);
                break;
            case "subtraction":
                result = (int) Math.subtractExact(num1, num2);
                break;
            case "multiplication":
                result = (int) Math.multiplyExact(num1, num2);
                break;
            case "divison":
                result = (int) Math.floorDiv(num1, num2);
                break;
        }
    }
}
