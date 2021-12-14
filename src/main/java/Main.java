
public class Main {

    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        Converter converter = new Converter();
        InitializeData data = initializer.initializeFromConsoleInput();
        String result = converter.convertIntToString(data);
        System.out.println(result);
    }
}
