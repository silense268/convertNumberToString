
public class Main {

    public static void main(String[] args) {
        InitializeData data;
        Initializer initializer = new Initializer();
        Converter converter = new Converter();
        data = initializer.initializeFromConsoleInput();
        String result = converter.convertIntToString(data);
        System.out.println(result);
    }
}
