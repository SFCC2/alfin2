/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo2;

/**
 *
 * @author Asus-PC
 */
public class Excercise {

    int idExcercise;
    String CAT;
    String END;
    String TOPIC;
    int MAXTP;

    public Excercise(int idExcercise, String CAT, String END, String TOPIC, int MAXTP) {
        this.idExcercise = idExcercise;
        this.CAT = CAT;
        this.END = END;
        this.TOPIC = TOPIC;
        this.MAXTP = MAXTP;
    }
    
    public Excercise() {
       
    }

    public int getIdExcercise() {
        return idExcercise;
    }

    public void setIdExcercise(int idExcercise) {
        this.idExcercise = idExcercise;
    }

    public String getCAT() {
        return CAT;
    }

    public void setCAT(String CAT) {
        this.CAT = CAT;
    }

    public String getEND() {
        return END;
    }

    public void setEND(String END) {
        this.END = END;
    }

    public String getTOPIC() {
        return TOPIC;
    }

    public void setTOPIC(String TOPIC) {
        this.TOPIC = TOPIC;
    }

    public int getMAXTP() {
        return MAXTP;
    }

    public void setMAXTP(int MAXTP) {
        this.MAXTP = MAXTP;
    }
    
}
