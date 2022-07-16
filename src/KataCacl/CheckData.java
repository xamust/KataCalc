package KataCacl;

class CheckData {
    String input;
    String[] nums;
    String oper;

    void setInput(String input) {
        this.input = input;
    }

    String[] getOutput() {
        return new String[]{nums[0], oper, nums[1]};
    }

    String GetType() throws MyExeption {
        int count = 0;
        for (String v : nums) {
            try {
                Integer.parseInt(v);
            } catch (Exception e) {
                count++;
            }
        }
        if (count == 2) {
            return "roman";
        } else if (count == 0) {
            return "arabic";
        } else {
            throw new MyExeption("Incorrect string!");
        }
    }

    CheckData(String input) throws MyExeption {
        setInput(input);
        SeparateNums();
        SeparateOper();
    }

    void SeparateNums() throws MyExeption {
        //separate nums..
        String[] data = input.split("[ ]*[+\\-\\\\/*]{1}[ ]*");
        if (data.length != 2) {
            throw new MyExeption("Incorrect string!");
        }
        nums = data;
    }

    void SeparateOper() throws MyExeption {
        String[] data = input.split("[a-zA-Z0-9]+");
        if (data.length > 3) {
            throw new MyExeption("Incorrect string!");
        }
        switch (data[1]) {
            case "+":
                oper = "addition";
                break;
            case "-":
                oper = "subtraction";
                break;
            case "*":
                oper = "multiplication";
                break;
            case "\\":
                oper = "divison";
                break;
            default:
                throw new MyExeption("Incorrect string!");
        }
    }
}
