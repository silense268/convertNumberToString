class InitializeData {

    public InitializeData(Long number, Text.Case currentCase, Text.Gender gender) {
        this.number = number;
        this.currentCase = currentCase;
        this.gender = gender;
    }

    private Long number;
    private Text.Case currentCase; // case - служебное слово
    private Text.Gender gender;

    public long getNumber() {
        return number;
    }

    void setNumber(long number) {
        this.number = number;
    }

    public Text.Case getCurrentCase() {
        return currentCase;
    }

    void setCurrentCase(Text.Case currentCase) {
        this.currentCase = currentCase;
    }

    public Text.Gender getGender() {
        return gender;
    }

    void setGender(Text.Gender gender) {
        this.gender = gender;
    }

}
