package JavaBean;

import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.util.Date;

public class Book {
    private int bkID;//	Int	图书序号【标识列，主键】
    private String bkCode;//	Nvarchar (20)	图书编号或条码号（前文中的书号）
    private String bkName;//	Nvarchar(50)	书名
    private String bkAuthor;//	Nvarchar(30)	作者
    private String bkPress;//	Nvarchar(50)	出版社
    private Timestamp bkDatePress;//	datetime	出版日期
    private String bkISBN;//	Nvarchar (15)	ISBN书号
    private int bkLanguage;//	SmallInt	语言，0-中文，1-英文，2-日文，3-俄文，4-德文，5-法文
    private int bkPages;//	Int	页数
    private float bkPrice;//	Money	价格
    private Timestamp bkDateIn;//	DateTime	入馆日期
    private String bkBrief;//	Text	内容简介
    private String bkCover;//	image	图书封面照片
    private String bkStatus;// NChar(2)图书状态，在馆、借出、遗失、变卖、销毁
    private String bkCatalog;// Nvarchar(30)	分类号（如：TP316-21/123）

    public Timestamp getBkDateIn() {
        return bkDateIn;
    }

    public float getBkPrice() {
        return bkPrice;
    }

    public Timestamp getBkDatePress() {
        return bkDatePress;
    }

    public int getBkID() {
        return bkID;
    }

    public int getBkLanguage() {
        return bkLanguage;
    }

    public int getBkPages() {
        return bkPages;
    }

    public String getBkAuthor() {
        return bkAuthor;
    }

    public String getBkCatalog() {
        return bkCatalog;
    }

    public String getBkCode() {
        return bkCode;
    }

    public String getBkCover() {
        return bkCover;
    }

    public String getBkISBN() {
        return bkISBN;
    }

    public String getBkName() {
        return bkName;
    }

    public String getBkPress() {
        return bkPress;
    }

    public String getBkStatus() {
        return bkStatus;
    }

    public String getBkBrief() {
        return bkBrief;
    }

    public void setBkAuthor(String bkAuthor) {
        this.bkAuthor = bkAuthor;
    }

    public void setBkBrief(String bkBrief) {
        this.bkBrief = bkBrief;
    }

    public void setBkCatalog(String bkCatalog) {
        this.bkCatalog = bkCatalog;
    }

    public void setBkCode(String bkCode) {
        this.bkCode = bkCode;
    }

    public void setBkCover(String bkCover) {
        this.bkCover = bkCover;
    }

    public void setBkDateIn(Timestamp bkDateIn) {
        this.bkDateIn = bkDateIn;
    }

    public void setBkDatePress(Timestamp bkDatePress) {
        this.bkDatePress = bkDatePress;
    }

    public void setBkID(int bkID) {
        this.bkID = bkID;
    }

    public void setBkISBN(String bkISBN) {
        this.bkISBN = bkISBN;
    }

    public void setBkLanguage(int bkLanguage) {
        this.bkLanguage = bkLanguage;
    }

    public void setBkName(String bkName) {
        this.bkName = bkName;
    }

    public void setBkPages(int bkPages) {
        this.bkPages = bkPages;
    }

    public void setBkPress(String bkPress) {
        this.bkPress = bkPress;
    }

    public void setBkPrice(float bkPrice) {
        this.bkPrice = bkPrice;
    }

    public void setBkStatus(String bkStatus) {
        this.bkStatus = bkStatus;
    }
}
