import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    Converter converter = new Converter();

    @Test
    void convertZero() {
        InitializeData data = new InitializeData(0l,Text.Case.Т, Text.Gender.М);
        assertEquals("нолями", converter.convertIntToString(data));
    }

    @Test
    void convert2() {
        InitializeData data = new InitializeData(2l,Text.Case.И, Text.Gender.Ж);
        assertEquals("две", converter.convertIntToString(data));
    }

    @Test
    void convert17() {
        InitializeData data = new InitializeData(17l,Text.Case.Т, Text.Gender.М);
        assertEquals("семнадцатью", converter.convertIntToString(data));
    }

    @Test
    void convert21() {
        InitializeData data = new InitializeData(21l,Text.Case.Т, Text.Gender.С);
        assertEquals("двадцатью одним", converter.convertIntToString(data));
    }

    @Test
    void convert40() {
        InitializeData data = new InitializeData(40l,Text.Case.Р, Text.Gender.С);
        assertEquals("сорока", converter.convertIntToString(data));
    }
    @Test
    void convert100() {
        InitializeData data = new InitializeData(100l,Text.Case.Р, Text.Gender.С);
        assertEquals("ста ", converter.convertIntToString(data));
    }

    @Test
    void convert112() {
        InitializeData data = new InitializeData(112l,Text.Case.И, Text.Gender.С);
        assertEquals("сто двенадцать", converter.convertIntToString(data));
    }

    @Test
    void convert234() {
        InitializeData data = new InitializeData(234l,Text.Case.Р, Text.Gender.С);
        assertEquals("двухсот тридцати четырех", converter.convertIntToString(data));
    }

    @Test
    void convert400() {
        InitializeData data = new InitializeData(400l,Text.Case.П, Text.Gender.С);
        assertEquals("четырехстах ", converter.convertIntToString(data));
    }

    @Test
    void convert957() {
        InitializeData data = new InitializeData(950l,Text.Case.Д, Text.Gender.М);
        assertEquals("девятистам пятидесяти", converter.convertIntToString(data));
    }

    @Test
    void convert2101() {
        InitializeData data = new InitializeData(2101l,Text.Case.И, Text.Gender.М);
        assertEquals("две тысячи сто один", converter.convertIntToString(data));
    }

    @Test
    void convert5537() {
        InitializeData data = new InitializeData(5537l,Text.Case.И, Text.Gender.М);
        assertEquals("пять тысячь пятьсот тридцать семь", converter.convertIntToString(data));
    }

    @Test
    void convert101621() {
        InitializeData data = new InitializeData(101621l,Text.Case.Р, Text.Gender.М);
        assertEquals("ста одной тысячи шестисот двадцати одного", converter.convertIntToString(data));
    }

    @Test
    void convert1203456() {
        InitializeData data = new InitializeData(1203456l,Text.Case.И, Text.Gender.М);
        assertEquals("один миллион двести три тысячи четыреста пятьдесят шесть", converter.convertIntToString(data));
    }

    @Test
    void convert257203456() {
        InitializeData data = new InitializeData(257203456l,Text.Case.Т, Text.Gender.М);
        assertEquals("двумястами пятюдесятью семью миллионами двумястами тремя тысячами четырястами пятюдесятью шестью", converter.convertIntToString(data));
    }
    
    @Test
    void convert1000000000() {
        InitializeData data = new InitializeData(1000000000l,Text.Case.П, Text.Gender.М);
        assertEquals("одном миллиарде ", converter.convertIntToString(data));
    }

}