package JavaBean;

import java.util.Date;

public class Borrow {
    private float BorrowID;//   Numeric(12,0)	借书顺序号【主键】（逻辑控制）第几个借书的
    private int rdID;// 	Int	读者序号【外键TB_Reader】
    private int bkID;// 	Int	图书序号【外键TB_Book】
    private int ldContinueTimes;//   Int	续借次数（第一次借时，记为0）查询主键，来看是不是第一次借这本书，还书后改为0，续借不新添信息，还是这一行
    private Date ldDateOut;// 	DateTime	借书日期
    private Date ldDateRetPlan;// 	DateTime	应还日期
    private Date ldDateRetAct;// 	DateTime	实际还书日期
    private int ldOverDay;// 	Int	超期天数
    private float ldOverMoney;// 	Money	超期金额（应罚款金额）
    private float ldPunishMoney;// 	Money	罚款金额（先不设置规则，按超期金额算）
    private byte isHasReturn;// 	Bit	是否已经还书，缺省为0-未还
    private String operatorLend;// 	Nvarchar(20)（名字？）	借书操作员
    private String operatorRet;// 	Nvarchar(20)	还书操作员

    public void setBkID(int bkID) {
        this.bkID = bkID;
    }

    public void setRdID(int rdID) {
        this.rdID = rdID;
    }

    public void setBorrowID(float borrowID) {
        BorrowID = borrowID;
    }

    public void setIsHasReturn(byte isHasReturn) {
        this.isHasReturn = isHasReturn;
    }

    public void setLdContinueTimes(int ldContinueTimes) {
        this.ldContinueTimes = ldContinueTimes;
    }

    public void setLdDateOut(Date ldDateOut) {
        this.ldDateOut = ldDateOut;
    }

    public void setLdDateRetAct(Date ldDateRetAct) {
        this.ldDateRetAct = ldDateRetAct;
    }

    public void setLdDateRetPlan(Date ldDateRetPlan) {
        this.ldDateRetPlan = ldDateRetPlan;
    }

    public void setLdOverDay(int ldOverDay) {
        this.ldOverDay = ldOverDay;
    }

    public void setLdOverMoney(float ldOverMoney) {
        this.ldOverMoney = ldOverMoney;
    }

    public void setLdPunishMoney(float ldPunishMoney) {
        this.ldPunishMoney = ldPunishMoney;
    }

    public void setOperatorLend(String operatorLend) {
        this.operatorLend = operatorLend;
    }

    public void setOperatorRet(String operatorRet) {
        this.operatorRet = operatorRet;
    }

    public int getRdID() {
        return rdID;
    }

    public byte getIsHasReturn() {
        return isHasReturn;
    }

    public Date getLdDateOut() {
        return ldDateOut;
    }

    public Date getLdDateRetAct() {
        return ldDateRetAct;
    }

    public Date getLdDateRetPlan() {
        return ldDateRetPlan;
    }

    public float getBorrowID() {
        return BorrowID;
    }

    public float getLdOverMoney() {
        return ldOverMoney;
    }

    public float getLdPunishMoney() {
        return ldPunishMoney;
    }

    public int getLdContinueTimes() {
        return ldContinueTimes;
    }

    public int getLdOverDay() {
        return ldOverDay;
    }

    public String getOperatorLend() {
        return operatorLend;
    }

    public String getOperatorRet() {
        return operatorRet;
    }

    public int getBkID() {
        return bkID;
    }


}
