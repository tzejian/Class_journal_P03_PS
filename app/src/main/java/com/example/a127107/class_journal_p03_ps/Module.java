package com.example.a127107.class_journal_p03_ps;

import java.io.Serializable;

public class Module implements Serializable{
    private String moduleCode;
    private String moduleName;

    public Module(String moduleCode,String moduleName){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }
    public String getModuleCode()  {
        return moduleCode;
    }{
    }
    public String getModuleName()  {
        return moduleName;
    }{
    }
}
