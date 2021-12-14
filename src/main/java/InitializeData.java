class InitializeData {

    private long number;

    public InitializeData(long number, Text.Case currentCase, Text.Gender gender) {
        this.number = number;
        this.currentCase = currentCase;
        this.gender = gender;
    }
    private Text.Case currentCase; // case - служебное слово
    private Text.Gender gender;

    long getNumber() {
        return number;
    }

    Text.Case getCurrentCase() {
        return currentCase;
    }

    Text.Gender getGender() {
        return gender;
    }


}
