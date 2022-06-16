import java.time.LocalDateTime;

public class Transaction {
  private String subjectName;
  private String targetName;
  private String currency;
  private double value;
  private String ref;
  private boolean paid;
  private LocalDateTime dateFiled;
  private LocalDateTime datePaid;

  public Transaction(String subjectName, String targetName, String currency, double value,
                     String ref, boolean paid, LocalDateTime dateFiled, LocalDateTime datePaid) {
    this.subjectName = subjectName;
    this.targetName = targetName;
    this.currency = currency;
    this.value = value;
    this.ref = ref;
    this.paid = paid;
    this.dateFiled = dateFiled;
    this.datePaid = datePaid;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public String getTargetName() {
    return targetName;
  }

  public void setTargetName(String targetName) {
    this.targetName = targetName;
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

  public boolean isPaid() {
    return paid;
  }

  public void setPaid(boolean paid) {
    this.paid = paid;
  }

  public LocalDateTime getDateFiled() {
    return dateFiled;
  }

  public void setDateFiled(LocalDateTime dateFiled) {
    this.dateFiled = dateFiled;
  }

  public LocalDateTime getDatePaid() {
    return datePaid;
  }

  public void setDatePaid(LocalDateTime datePaid) {
    this.datePaid = datePaid;
  }

}
