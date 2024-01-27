package com.example.muistimania;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Kayttoliittyma extends Application {


    private final Button aloitapeliBtn = new Button("Aloita peli");
    private final Button pelitilastoBtn = new Button("Pelitilastot");
    private final Button tietoBtn = new Button("Tietoa pelistä");
    private final Button suljeBtn = new Button("Sulje peli");

    private final Button takaisinBtn = new Button("Takaisin");

    private final VBox alkunaytto = new VBox();

    private final BorderPane borderpane = new BorderPane();

    private StackPane stackPane = new StackPane();
    private Image[] kuvat;
    private GridPane kuvaPane = new GridPane();

    public Kayttoliittyma(){

    }
    @Override
    public void start(Stage stagePaanaytto) throws IOException {


        Button[]buttons = {aloitapeliBtn, pelitilastoBtn, tietoBtn, suljeBtn};

        for(Button button: buttons){
            button.setPrefWidth(200);
            button.setPrefHeight(60);
        }

        alkunaytto.getChildren().addAll(aloitapeliBtn, pelitilastoBtn, tietoBtn, suljeBtn);
        alkunaytto.setAlignment(Pos.CENTER);
        borderpane.setCenter(alkunaytto);


        Image logo = new Image("img.png");
        Scene alkuNaytto = new Scene(borderpane,1000,800, Color.BLUE);
        stagePaanaytto.setTitle("Muistimania");
        stagePaanaytto.setScene(alkuNaytto);
        stagePaanaytto.getIcons().add(logo);
        stagePaanaytto.show();
        Pelaa pelaa = new Pelaa();

        aloitapeliBtn.setOnMouseClicked(e-> {
                pelaa.nayttoAloitapeli();
        });

        pelitilastoBtn.setOnMouseClicked(e->{
            nayttoPelitilastot();
        });

        tietoBtn.setOnMouseClicked(e-> {
            nayttoTietoapelista();
        });
        suljeBtn.setOnMouseClicked(e-> {
            stagePaanaytto.close();
        });


    }

    public void nayttoPelaaapelia(){
        alkunaytto.getChildren();
    }
    public void nayttoPelitilastot(){
        alkunaytto.getChildren().clear();
    }
    public void nayttoTietoapelista(){
        alkunaytto.getChildren().clear();
    }

    public static void main(String[] args) {
        launch();
    }
}