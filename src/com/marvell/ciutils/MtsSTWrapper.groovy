#!groovy
package com.marvell.ciutils

@Singleton 
class MtsSTWrapper{
    def mts;
    def env
    def steps
    def Init(env, steps){
        this.env = env
        this.steps = steps
       // mts = new MtsUtils(env, steps)
    }
    
    def TestEcho(){
        println "Test123"
    }    
}