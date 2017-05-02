package com.example.a127107.class_journal_p03_ps;

import java.io.Serializable;

public class DailyCa implements Serializable {
    private String dgGrade;
    private String moduleCode;
    private int week;

    public DailyCa(String dgGrade,String moduleCode, int week) {
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.week = week;
    }


    public String getDgGrade(){
            return dgGrade;}
        public String getModuleCode() {
        return moduleCode;}
        public int getWeek(){
            return week;}
        }
