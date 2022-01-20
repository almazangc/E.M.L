package resources.database.table;

public class ScheduleModel {
    private String TIME;
    private String MON, TUE, WED, THU, FRI, SAT, SUN;

    public ScheduleModel(String TIME, String MON, String TUE, String WED, String THU, String FRI, String SAT, String SUN) {
        this.TIME = TIME;
        this.MON = MON;
        this.TUE = TUE;
        this.WED = WED;
        this.THU = THU;
        this.FRI = FRI;
        this.SAT = SAT;
        this.SUN = SUN;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getMON() {
        return MON;
    }

    public void setMON(String MON) {
        this.MON = MON;
    }

    public String getTUE() {
        return TUE;
    }

    public void setTUE(String TUE) {
        this.TUE = TUE;
    }

    public String getWED() {
        return WED;
    }

    public void setWED(String WED) {
        this.WED = WED;
    }

    public String getTHU() {
        return THU;
    }

    public void setTHU(String THU) {
        this.THU = THU;
    }

    public String getFRI() {
        return FRI;
    }

    public void setFRI(String FRI) {
        this.FRI = FRI;
    }

    public String getSAT() {
        return SAT;
    }

    public void setSAT(String SAT) {
        this.SAT = SAT;
    }

    public String getSUN() {
        return SUN;
    }

    public void setSUN(String SUN) {
        this.SUN = SUN;
    }
}
