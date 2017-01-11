#!groovy
package com.marvell.ciutils

public class MtsSTWrapper{
    private static final MtsSTWrapper instance = new MtsSTWrapper();
    
    public static MtsSTWrapper getInstance(){
        return instance;
    } 
    
    public def mts
    def env
    def steps
    def Init(env, steps){
        this.env = env
        this.steps = steps
        mts = new MtsUtils(env, steps)
    }
    
    //def TestEcho(){
    //    println "Test123"
    // }    
}
