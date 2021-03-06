
public class Text {

    static final String NUMBER_MSG = "Введите число, которое хотите перевести, не превышающее триллиона";
    final static String HELP_MSG = "Данная программа предназначена для преобразования целого числа в строку прописью." +
            " В любом падеже и в любом роде. Следуйте инстукциям на экране, и у вас все получится";
    final static String CASE_MSG = "Введите первую букву падежа";
    final static String GENDER_MSG = "Введите Первую букву пола";
    final static long MAX_NUMBER = 999999999999L;
    public enum Gender
    {
        М, Ж, С
    }
    public enum Case
    {
        И, Р, Д, В, Т, П
    }

    static final String[][] ZERO = {
            {"ноль", "ноль", "ноль"},
            {"ноля", "ноля", "ноля"},
            {"нолям", "нолям", "нолям"},
            {"ноль", "ноль", "ноль"},
            {"нолями", "нолями", "нолями"},
            {"нолях", "нолях", "нолях"}

    };
    static final String[][][] FROM_1_TO_2 = {
            {
                    {"один", "одна", "одно"},           //И кто что
                    {"одного", "одной", "одного"},         //Р кого чего
                    {"одному", "одной", "одному"},         //Д кому чему
                    {"один", "одну", "одно"},           //В кого что
                    {"одним", "одной", "одним"},          //Т кем чем
                    {"одном", "одной", "одном"},          //П о ком о чем
            },
            {
                    {"два", "две", "два"},
                    {"двух", "двух", "двух"},
                    {"двум", "двум", "двум"},
                    {"два", "две", "два"},
                    {"двумя", "двумя", "двумя"},
                    {"двух", "двух", "двух"}
            }
    };

    static final String[][] FROM_3_TO_19 = {
            {"три", "трех", "трем", "три", "тремя", "трех"},
            {"четыре", "четырех", "четырем", "четыре", "четырьями", "четырех"},
            {"пять", "пяти", "пяти", "пять", "пятью", "пяти"},
            {"шесть", "шести", "шести", "шесть", "шестью", "шести"},
            {"семь", "семи", "семи", "семь", "семью", "семи"},
            {"восемь", "восьми", "восьми", "восемь", "восемью", "восьми"},
            {"девять", "девяти", "девяти", "девять", "девятью", "девяти"},
            {"десять", "десяти", "десяти", "десять", "десятью", "десяти"},
            {"одиннадцать", "одиннадцати", "одиннадцати", "одиннадцать", "одиннадцатью", "одиннадцати"},
            {"двенадцать", "двенадцати", "двенадцати", "двенадцать", "двенадцатью", "двенадцати"},
            {"тринадцать", "тринадцати", "тринадцати", "тринадцать", "тринадцатью", "тринадцати"},
            {"четырнадцать", "четырнадцати", "четырнадцати", "четырнадцать", "четырнадцатью", "четырнадцати"},
            {"пятнадцать", "пятнадцати", "пятнадцати", "пятнадцать", "пятнадцатью", "пятнадцати"},
            {"шестнадцать", "шестнадцати", "шестнадцати", "шестнадцать", "шестнадцатью", "шестнадцати"},
            {"семнадцать", "семнадцати", "семнадцати", "семнадцать", "семнадцатью", "семнадцати"},
            {"восемнадцать", "восеьнадцати", "восемнадцати", "восемнадцать", "восемнадцатью", "восемнадцати"},
            {"девятнадцать", "девятнадцати", "девятнадцати", "девятнадцать", "девятнадцатью", "девятнадцати"},
    };
    static final String[][] TENS = {
            {"двадцать", "двадцати", "двадцати", "двадцать", "двадцатью", "двадцати"},
            {"тридцать", "тридцати", "тридцати", "тридцать", "тридцатью", "тридцати"},
            {"сорок", "сорока", "сорока", "сорок", "сорока", "сорок"},
            {"пятьдесят", "пятидесяти", "пятидесяти", "пятьдесят", "пятюдесятью", "пятидесяти"},
            {"шестьдесят", "шестидесяти", "шестидесяти", "шестьдесят", "шестьюдесятью", "шестидесяти"},
            {"семьдесят", "семидесяти", "шестидесяти", "семьдесят", "семьюдесятями", "семидесяти"},
            {"восемьдесят", "восьмидесяти", "восьмидесяти", "восемьдесят", "восьмьюдесятью", "восьмидесяти"},
            {"девяносто", "девяносто", "девяносто", "девяносто", "девяносто", "девяносто"}
    };
    static final String[][] HUNDREDS = {
            {"сто", "ста", "ста", "сто", "ста", "ста"},
            {"двести", "двухсот", "двумстам", "двести", "двумястами", "двухстах"},
            {"триста", "трехсот", "тремстам", "триста", "тремястами", "трехстах"},
            {"четыреста", "четырехсот", "четыремстам", "четыреста", "четырястами", "четырехстах"},
            {"пятьсот", "пятисот", "пятистам", "пятьсот", "пятьюстами", "пятистах"},
            {"шестьсот", "шестисот", "шеститам", "шестьсот", "шестьюстами", "шестистах"},
            {"семьсот", "семисот", "семистам", "семьсот", "семьюстами", "семистах"},
            {"восемьсот", "восьмисот", "восьмистам", "восемьсот", "восьмьюстами", "восьмистах"},
            {"девятьсот", "девятисот", "девятистам", "девятьсот", "девятьюстами", "девятистах"}
    };
    static final String[][] THOUSANDS = {
            {"тысяча", "тысячи", "тысяче", "тысячу", "тысячей", "тысяче"}, //1
            {"тысячи", "тысячь", "тысячам", "тысячи", "тысячами", "тысячах"},  //2-4
            {"тысячь", "тысячь", "тысячам", "тысячь", "тысячами", "тысячах"}  //5-20
    };
    static final String[][] MILLIONS = {
            {"миллион", "миллиона", "миллиону", "миллион", "миллионом", "миллионе"}, //1
            {"миллиона", "миллионов", "миллионам", "миллиона", "миллионами", "миллионах"},  //2-4
            {"миллионов", "миллионов", "миллионам", "миллионов", "миллионами", "миллионах"}  //5-20
    };
    static final String[][] BILLIONS = {
            {"миллиард", "миллиарда", "миллиарду", "миллиард", "миллиардом", "миллиарде"}, //1
            {"миллиарда", "миллиардов", "миллиардам", "миллиарда", "миллиардами", "миллиардах"},  //2-4
            {"миллиардов", "миллиардов", "миллиардам", "миллиардов", "миллиардами", "миллиардах"}  //5-20
    };
}