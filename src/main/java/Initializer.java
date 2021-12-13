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
        System.out.println(Text.helpMsg);
        System.out.println(Text.numberMsg);

        while (shouldTryAgain) {
            try {
                if(!numberIsOk) {
                    number = Integer.parseInt(scanner.nextLine());
                    numberIsOk = true;
                }
                if(!caseIsOk) {
                    System.out.println(Text.caseMsg);
                    currentCase = Text.Case.valueOf(scanner.nextLine().toUpperCase());
                    caseIsOk = true;
                }
                System.out.println(Text.genderMsg);
                gender = Text.Gender.valueOf(scanner.nextLine().toUpperCase());
                shouldTryAgain = false;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число, не превышающее триллиона");
            } catch (IllegalArgumentException e) {
                System.out.println("Необходимо ввести первую букву падежа и первую букву рода");
            }  catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
        scanner.close();
        InitializeData data = new InitializeData(number, currentCase, gender); //заполнил все и вернул
        return data;
    }

}
