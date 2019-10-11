package com.blu.imdg;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

public class Practica {
    public static void main(String[] args){
        IgniteConfiguration conf = new IgniteConfiguration();
        conf.setClientMode(false);
        Ignite ignite = Ignition.start();



        ignite.close();

    }
}

