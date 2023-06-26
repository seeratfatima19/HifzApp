package data;

public class StudentData {

    private String id;
    private String date;
    private int para;
    private int surah;
    private String sabaq;
    private int sabqi;
    private int manzil;

    StudentData()
    {
        id="s000";
        date="";
        para=0;
        surah=0;
        sabaq="";
        sabqi=0;
        manzil=0;
    }

    StudentData(String id, String date, int para, int surah, String sabaq, int sabqi, int manzil)
    {
        this.id = id;
        this.date = date;
        this.surah = surah;
        this.sabaq = sabaq;
        this.sabqi = sabqi;
        this.manzil = manzil;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return this.date;
    }

    public void setSurah(int surah){
        this.surah = surah;
    }

    public int getSurah(){
        return this.surah;
    }

    public void setPara(int para){
        this.para= para;
    }

    public int getPara(){
        return this.para;
    }

    public void setSabaq(String s){
        this.sabaq= s;
    }

    public String getSabaq(){
        return this.sabaq;
    }

    public void setSabqi(int s){
        this.sabqi=s;
    }

    public int getSabqi() {
        return this.sabqi;
    }

    public void setManzil(int manzil){
        this.manzil=manzil;
    }

    public int getManzil() {
        return this.manzil;
    }
}
