public class Converter {

     String convertIntToString(InitializeData data) {
        if (data.getNumber() == 0) {
            return Text.from0To2[0][data.getCurrentCase().ordinal()][data.getGender().ordinal()];
        }
        int numberLength = String.valueOf(data.getNumber()).length();
        int tetradeNumbers = numberLength / 3;
        if (numberLength % 3 != 0) {
            tetradeNumbers = tetradeNumbers + 1;
        }
        int hundreds;
        int dozens;
        int units;
        int currentTetrade;
        int lastTwoNumbers;
        String result = "";
        for (int i = 0; i < tetradeNumbers; i++) {
            currentTetrade = (int) data.getNumber() % 1000;
            data.setNumber(data.getNumber() / 1000); // уменьшаем кол-во цифр на тетраду
            if(currentTetrade == 0){
                continue;
            }
            String currentResult = "";
            hundreds = currentTetrade / 100;
            dozens = currentTetrade / 10 % 10;
            units = currentTetrade % 10;
            lastTwoNumbers = dozens * 10 + units;
            if (lastTwoNumbers < 20) {
                //  мы из массива до 20 возьмем единицы и 10
                if (lastTwoNumbers < 3 && units != 0) {
                    // берем из массива 0-2
                    if(i != 1) {
                        currentResult = Text.from0To2[units][data.getCurrentCase().ordinal()][data.getGender().ordinal()];
                    }else{
                        // в тысячах всегда женский род
                        currentResult = Text.from0To2[units][data.getCurrentCase().ordinal()][Text.Gender.Ж.ordinal()];
                    }
                } else if (units != 0) {
                    //берем из массива 3-19
                    currentResult = Text.from3To19[lastTwoNumbers - 3][data.getCurrentCase().ordinal()];
                }
            } else {
                // если число больше 20, без исключений
                currentResult = Text.dozens[dozens - 2][data.getCurrentCase().ordinal()];
                if (units < 3 && units != 0) {
                    if(i != 1) {
                        // для тысяч используем женский род
                        currentResult = currentResult + " " + Text.from0To2[units][data.getCurrentCase().ordinal()][data.getGender().ordinal()];
                    }else{
                        currentResult = currentResult + " " + Text.from0To2[units][data.getCurrentCase().ordinal()][Text.Gender.Ж.ordinal()];
                    }
                } else if (units != 0) {
                    currentResult = currentResult + " " + Text.from3To19[units - 3][data.getCurrentCase().ordinal()];
                }
            }
            if (hundreds > 0) {
                currentResult = Text.hundreds[hundreds - 1][data.getCurrentCase().ordinal()] + " " + currentResult;
            }
            // преписываем к тетраде разряд
        if(i == 1) {
            currentResult = currentResult + " " +
                    getNumbersCategory(Text.thousands, units, dozens, data.getCurrentCase().ordinal()) + " " + result;
        }else if(i == 2){
            currentResult = currentResult + " " +
                    getNumbersCategory(Text.millions, units, dozens, data.getCurrentCase().ordinal()) + " " + result;
        }else if(i == 3){
            currentResult = currentResult + " " +
                    getNumbersCategory(Text.billions, units, dozens, data.getCurrentCase().ordinal()) + " " + result;
        }
            result = currentResult;
        }
        return result;
    }

     private String getNumbersCategory(String[][] category, int units, int dozens, int currentCase){
        String currentResult;
        if (units == 1 && dozens != 2 && dozens != 1) {
            currentResult = category[0][currentCase];
        }else if(units > 1 && units < 5  && dozens != 1){
            currentResult = category[1][currentCase];
        }else{
            currentResult = category[2][currentCase];
        }
        return currentResult;
    }
}
