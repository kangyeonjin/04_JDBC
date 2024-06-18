package com.ohgiraffers.model;

import java.util.Date;

public class employeeDTO {

    private int EMP_ID;
    private String EMP_NAME;
    private String EMP_NO;
    private String EMAIL;
    private String PHONE;
    private String DEPT_CODE;
    private String JOB_CODE;
    private String SAL_LEVEL;
    private double SALARY;
    private double BONUS;
    private int MANAGER_ID;
    private Date HIRE_DATE;
    private Date ENT_DATE;
    private String ENT_YN;


    public String getENT_YN() {
        return ENT_YN;
    }

    public void setENT_YN(String ENT_YN) {
        this.ENT_YN = ENT_YN;
    }

    public Date getENT_DATE() {
        return ENT_DATE;
    }

    public void setENT_DATE(Date ENT_DATE) {
        this.ENT_DATE = ENT_DATE;
    }

    public Date getHIRE_DATE() {
        return HIRE_DATE;
    }

    public void setHIRE_DATE(Date HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    public int getMANAGER_ID() {
        return MANAGER_ID;
    }

    public void setMANAGER_ID(int MANAGER_ID) {
        this.MANAGER_ID = MANAGER_ID;
    }

    public double getBONUS() {
        return BONUS;
    }

    public void setBONUS(int BONUS) {
        this.BONUS = BONUS;
    }

    public double getSALARY() {
        return SALARY;
    }

    public void setSALARY(int SALARY) {
        this.SALARY = SALARY;
    }

    public String getSAL_LEVEL() {
        return SAL_LEVEL;
    }

    public void setSAL_LEVEL(String SAL_LEVEL) {
        this.SAL_LEVEL = SAL_LEVEL;
    }

    public String getJOB_CODE() {
        return JOB_CODE;
    }

    public void setJOB_CODE(String JOB_CODE) {
        this.JOB_CODE = JOB_CODE;
    }

    public String getDEPT_CODE() {
        return DEPT_CODE;
    }

    public void setDEPT_CODE(String DEPT_CODE) {
        this.DEPT_CODE = DEPT_CODE;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getEMP_NO() {
        return EMP_NO;
    }

    public void setEMP_NO(String EMP_NO) {
        this.EMP_NO = EMP_NO;
    }

    public String getEMP_NAME() {
        return EMP_NAME;
    }

    public void setEMP_NAME(String EMP_NAME) {
        this.EMP_NAME = EMP_NAME;
    }

    public int getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(int EMP_ID) {
        this.EMP_ID = EMP_ID;
    }


    @Override
    public String toString() {
        return "employeeDTO{" +
                "EMP_ID=" + EMP_ID +
                ", EMP_NAME='" + EMP_NAME + '\'' +
                ", EMP_NO=" + EMP_NO +
                ", EMAIL='" + EMAIL + '\'' +
                ", PHONE=" + PHONE +
                ", DEPT_CODE='" + DEPT_CODE + '\'' +
                ", JOB_CODE='" + JOB_CODE + '\'' +
                ", SAL_LEVEL='" + SAL_LEVEL + '\'' +
                ", SALARY=" + SALARY +
                ", BONUS=" + BONUS +
                ", MANAGER_ID=" + MANAGER_ID +
                ", HIRE_DATE=" + HIRE_DATE +
                ", ENT_DATE=" + ENT_DATE +
                ", ENT_YN='" + ENT_YN + '\'' +
                '}';
    }


}
