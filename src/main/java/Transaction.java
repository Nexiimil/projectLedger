public class Transaction {
    private int subjectUID;
    private int targetUID;
    private String currency;
    private double value;
    private String ref;

    public Transaction(int subjectUID, int targetUID, String currency, double value, String ref) {
        this.subjectUID = subjectUID;
        this.targetUID = targetUID;
        this.currency = currency;
        this.value = value;
        this.ref = ref;
    }

    public int getSubjectUID() {
        return subjectUID;
    }

    public void setSubjectUID(int subjectUID) {
        this.subjectUID = subjectUID;
    }

    public int getTargetUID() {
        return targetUID;
    }

    public void setTargetUID(int targetUID) {
        this.targetUID = targetUID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
