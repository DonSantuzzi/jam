package com.unitedinternet.jam.konten.konto;

import java.io.Serializable;

public class Zinssatz implements Serializable
{
    private float zinssatz;
    
    private final float MAX_ZINSSATZ = 0.5f;
    
    public Zinssatz(float zinssatz) {
        
        if (zinssatz <= MAX_ZINSSATZ) {
            this.zinssatz = zinssatz;
        } else {
            this.zinssatz = MAX_ZINSSATZ;
        }
    }
    
    public float gibWert() {
        return zinssatz;
    }
}
