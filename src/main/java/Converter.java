public class Converter {

     String convertIntToString(InitializeData data) {
        if (data.getNumber() == 0) {
            return Text.ZERO[data.getCurrentCase().ordinal()][data.getGender().ordinal()]; // частный случай для 0
        }
         int tetradeCount = getTetradeCount(String.valueOf(data.getNumber()).length());
         String result = "";
         long number = data.getNumber();
         for (int i = 0; i < tetradeCount; i++) {
             int hundreds;
             int tens;
             int units;
             int currentTetrade;
             int lastTwoDigits;
             currentTetrade = (int) number % 1000;
             number = number / 1000; // уменьшаем кол-во цифр на тетраду
            if(currentTetrade == 0){
                continue;
            }
            String currentResult = "";
            hundreds = currentTetrade / 100;
            tens = currentTetrade / 10 % 10;
            units = currentTetrade % 10;
            lastTwoDigits = tens * 10 + units;
            if (lastTwoDigits < 20) {                 // если число до 20, возьмем две последние цифры по определенному правилу
                 if (lastTwoDigits < 3 && units != 0) {
                     // если число меньше 3 берем из массива 0-2
                     if (i != 1) { // в тысячах всегда женский род, проверка на разряд тысячь
                         currentResult = Text.FROM_1_TO_2[units - 1][data.getCurrentCase().ordinal()][data.getGender().ordinal()];
                    }else{
                         currentResult = Text.FROM_1_TO_2[units - 1][data.getCurrentCase().ordinal()][Text.Gender.Ж.ordinal()];
                    }
                } else if (units != 0) {
                     //если число больше 3 возьмем из массива от 3 до 19
                     currentResult = Text.FROM_3_TO_19[lastTwoDigits - 3][data.getCurrentCase().ordinal()];
                }
            } else {
                // если число больше 20, число складывается из единиц и десятков
                 currentResult = Text.TENS[tens - 2][data.getCurrentCase().ordinal()]; // взяли десятки
                if (units < 3 && units != 0) {  // берем единицы, из массива от 1 до 2
                    if(i != 1) {
                        // для тысяч используем женский род
                        currentResult = currentResult + " " + Text.FROM_1_TO_2[units - 1][data.getCurrentCase().ordinal()][data.getGender().ordinal()];
                    }else{
                        currentResult = currentResult + " " + Text.FROM_1_TO_2[units - 1][data.getCurrentCase().ordinal()][Text.Gender.Ж.ordinal()];
                    }
                } else if (units != 0) { // берем единицы, из массива от 3 до 19
                    currentResult = currentResult + " " + Text.FROM_3_TO_19[units - 3][data.getCurrentCase().ordinal()];
                }
            }
            if (hundreds > 0) {
                currentResult = Text.HUNDREDS[hundreds - 1][data.getCurrentCase().ordinal()] + " " + currentResult;
                // преписываем к числу сотни
            }
            // преписываем к тетраде разряд
        if(i == 1) {
            currentResult = currentResult + " " +
                    getNumbersCategory(Text.THOUSANDS, units, tens, data.getCurrentCase().ordinal()) + " " + result;
        }else if(i == 2){
            currentResult = currentResult + " " +
                    getNumbersCategory(Text.MILLIONS, units, tens, data.getCurrentCase().ordinal()) + " " + result;
        }else if(i == 3){
            currentResult = currentResult + " " +
                    getNumbersCategory(Text.BILLIONS, units, tens, data.getCurrentCase().ordinal()) + " " + result;
        }
            result = currentResult;
        }
        return result;
    }

    private String getNumbersCategory(String[][] category, int units, int tens, int currentCase) {
        String currentResult;
        if (units == 1 && tens != 2 && tens != 1) {
            currentResult = category[0][currentCase];
        } else if (units > 1 && units < 5 && tens != 1) {
            currentResult = category[1][currentCase];
        }else{
            currentResult = category[2][currentCase];
        }
        return currentResult;
    }

    private int getTetradeCount(int numberLength) {
        int tetradeNumbers = numberLength / 3;
        if (numberLength % 3 != 0) {
            tetradeNumbers = tetradeNumbers + 1; // увеличиваем тетраду на 1 если есть хотябы 1 цифра в тетраде
        }
        return tetradeNumbers;
    }
}
