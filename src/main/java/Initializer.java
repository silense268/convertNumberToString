import java.util.Scanner;

class Initializer {

     InitializeData initializeFromConsoleInput() {

        Scanner scanner = new Scanner(System.in, "UTF-8");
        boolean numberIsOk = false;
        boolean caseIsOk = false;
        boolean shouldTryAgain = true;
        long number = 0;
        Text.Case currentCase = Text.Case.И;
        Text.Gender gender = Text.Gender.М;
        System.out.println(Text.HELP_MSG);
        System.out.println(Text.NUMBER_MSG);

        while (shouldTryAgain) {
            try {
                if(!numberIsOk) {
                    String check = scanner.nextLine();
                    if (Long.parseLong(check) >= Text.MAX_NUMBER) {
                        throw new NumberFormatException();
                    }
                    number = Integer.parseInt(check);
                    numberIsOk = true;
                }
                if(!caseIsOk) {
                    System.out.println(Text.CASE_MSG);
                    currentCase = Text.Case.valueOf(scanner.nextLine().toUpperCase());
                    caseIsOk = true;
                }
                System.out.println(Text.GENDER_MSG);
                gender = Text.Gender.valueOf(scanner.nextLine().toUpperCase());
                shouldTryAgain = false;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число, не превышающее триллиона");
            } catch (IllegalArgumentException e) {
                System.out.println("Необходимо ввести первую букву падежа и первую букву рода");
            }
        }
        scanner.close();
        return  new InitializeData(number, currentCase, gender); //заполнил все и вернул
    }

}
