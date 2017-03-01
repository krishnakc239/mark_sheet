package domains;

/**
 * Created by krishna KC on 12/22/2016.
 */
public class Subject {
    private int id;
    public String code;
    private String name;
    private int PM;
    private int FM;
    private String batch;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getFM() {
        return FM;
    }

    public void setFM(int FM) {
        this.FM = FM;
    }

    public int getPM() {
        return PM;
    }

    public void setPM(int PM) {
        this.PM = PM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }




}
