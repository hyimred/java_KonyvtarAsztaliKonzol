package com.ptrkcsak;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            Statisztika db = new Statisztika();
            int i = 0;
            int j = 0;
            int eq;
            int darab =0;
            int k = 0;
            int max = 0;
            int max2 = 0;
            String title = "";
            String szerzo = "";
            int kiadas = 0;
            int oldal= 0;
            String legtobbetSzerzo = "";
            String konyv = "";
            String statusz = "";

            ArrayList<Konyv> lista = ((Statisztika) db).ListaFeltoltes();
            ArrayList<String> authors = new ArrayList<>();
            ArrayList<Integer> authorsdb = new ArrayList<>();

            for (Konyv e : lista) {

                if(!authors.contains(e.getAuthor())){
                    authors.add(e.getAuthor());
                }

                i++;
                if (e.getPage_count()>500){
                    j++;
                }

                if (e.getPage_count()>max){
                    max =e.getPage_count();
                    title = e.getTitle();
                    szerzo = e.getAuthor();
                    kiadas = e.getPublish_year();
                    oldal = e.getPage_count();
                }

                if(e.getPublish_year()<1950){
                    k++;
                    if(k>0){
                        statusz = "Van 1950-nél régebbi könyv";
                    } else {
                        statusz = "Nincs 1950-nél régebbi könyv";
                    }
                }
            }

            for (String a : authors) {
                for (Konyv e : lista) {
                    if(e.getAuthor().equals(a)){darab++;}
                }
                authorsdb.add(darab);
                darab =0;
            }

            for (int z : authorsdb) {
                if (z > max2 ){
                    max2 = z;
                }
                legtobbetSzerzo = authors.get(z);
            }

            System.out.print( "500 oldalnál hosszabb könyvek száma: " + j + "\n" +
                                statusz + "\n" +
                                "A leghosszabb könyv: \n" +
                                "\t" + "Szerző: " + szerzo + "\n" +
                                "\t" + "Cím: "+ title + "\n" +
                                "\t" + "Kiadás éve: " + kiadas + "\n" +
                                "\t" + "Oldalszám: " + oldal + "\n" +
                                "A legtöbb könyvvel rendelkező szerző: " + legtobbetSzerzo + "\n" +
                                "Adjon meg egy könyv címet: ");

                                String konyv2 = sc.nextLine();
                                String adott = "";
            for (Konyv e : lista) {
                if (e.getTitle().equals(konyv2)){
                    adott = e.getAuthor();
                } else {
                    adott = "\"nincs ilyen könyv\"";
                }
            }
            System.out.println("A megadott könyv szerzője " + adott);




        } catch (Exception e) {
            System.out.println("Ismeretlen Hiba!");
        }
    }

    private static void ListaKeres() {
    }


}