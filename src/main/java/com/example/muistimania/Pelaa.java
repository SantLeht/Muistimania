package com.example.muistimania;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Pelaa {

     private final Image[]kuvat = {
            new Image("kolmio.png"),
            new Image("nelio.png"),
            new Image("nuoliOikea.png"),
            new Image("nuoliVasen.png"),
            new Image("sirppi.png"),
            new Image("tahti.png"),
            new Image("viisikulmio.png"),
            new Image("ympyra.png")
    };
    Image[] kuvatKahdesti = new Image[16];
    GridPane kuvaPane = new GridPane();
    Random kuvatRandom = new Random();
    Rectangle[]suorakulmio = new Rectangle[16];
    GridPane suorakulmioPane = new GridPane();

    public Pelaa() {
    }

    public void nayttoAloitapeli(){
        kuvat();
        sekoitaKuvat();
        asetaPelikentta();

    }
    public void kuvat(){

        for(int i = 0; i<kuvatKahdesti.length;i++) {
            kuvatKahdesti[i]=kuvat[i%kuvat.length];
        }



    }
    public void sekoitaKuvat(){
        Collections.shuffle(Arrays.asList(kuvatKahdesti),kuvatRandom);

        int vaakarivit = 4;
        int pystyrivit = 4;
        int kuvaindex =0;

        for(int i = 0; i<pystyrivit;i++){
            for(int j = 0; j<vaakarivit; j++){
                ImageView imageView = new ImageView(kuvatKahdesti[kuvaindex++]);

                kuvaPane.add(imageView,j,i);
            }
        }
        if(kuvaindex>= kuvatKahdesti.length){
            System.out.println("Kaikki kuvat lisätty");
        }
    }
    public void asetaPelikentta(){

        suorakulmioPane.setVgap(10);
        suorakulmioPane.setHgap(10);
        suorakulmioPane.setAlignment(Pos.CENTER);

        int ruudukkoSuorakulmio = 4;
        for(int i = 0; i<suorakulmio.length;i++){

            suorakulmio[i].setHeight(150);
            suorakulmio[i].setWidth(150);

            suorakulmio[i].setOnMouseClicked(e -> {
                Rectangle klikkaus = (Rectangle) e.getSource();
                klikkaus.setVisible(false);


            } );

            int rivi = i / ruudukkoSuorakulmio;
            int sarake = i % ruudukkoSuorakulmio;

            suorakulmioPane.add(suorakulmio[i], sarake, rivi);
        }

    }

}
