package JavaBean;

public class ReaderType {
    private int rdType;
    private String rdTypeName;
    private int CanLendQty;
    private int CanLendDay;
    private int CanContinueTimes	;
    private float PunishRate;
    private int DateValid;

    public float getPunishRate() {
        return PunishRate;
    }

    public int getCanContinueTimes() {
        return CanContinueTimes;
    }

    public int getCanLendDay() {
        return CanLendDay;
    }

    public int getCanLendQty() {
        return CanLendQty;
    }

    public int getDateValid() {
        return DateValid;
    }

    public int getRdType() {
        return rdType;
    }

    public String getRdTypeName() {
        return rdTypeName;
    }

    public void setCanContinueTimes(int canContinueTimes) {
        CanContinueTimes = canContinueTimes;
    }

    public void setCanLendDay(int canLendDay) {
        CanLendDay = canLendDay;
    }

    public void setCanLendQty(int canLendQty) {
        CanLendQty = canLendQty;
    }

    public void setDateValid(int dateValid) {
        DateValid = dateValid;
    }

    public void setPunishRate(float punishRate) {
        PunishRate = punishRate;
    }

    public void setRdType(int rdType) {
        this.rdType = rdType;
    }

    public void setRdTypeName(String rdTypeName) {
        this.rdTypeName = rdTypeName;
    }
}
