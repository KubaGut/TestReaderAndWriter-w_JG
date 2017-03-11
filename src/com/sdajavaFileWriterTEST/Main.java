package com.sdajavaFileWriterTEST;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public String text;

    public Main(){                                                             // TWORZENIE Zmiennej STRING
        String text = "";
        for (int i = 0; i <10000; i++){
            text += "wyrazNumer" + i;
        }
        this.text = text;
    }
    public void konsola() throws FileNotFoundException, IOException{
        System.out.println("Podaj co chcesz przetetować");
        System.out.println("1 - wpisanie tekstu do pliku za pomocą PrintWritera");
        System.out.println("2 - wpisanie tekstu do pliku za pomocą Scannera");
        System.out.println("3 - odczytanie tekstu za pomocą Scannera");
        System.out.println("4 - odczytanie tekstu za pomocą BufferReader");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch(a){
            case 1 : WpisanieDoPlikuFW(); break;
            case 2 : WpisanieDoPlikuFunkcyjnie(); break;
            case 3 : czytanieSC(); break;
            case 4 : czytanieBR(); break;
        }
    }
    public void WpisanieDoPlikuFW() throws FileNotFoundException {             // Wpis do pliku za pomocą PW
        long startTime = System.currentTimeMillis();
        File output = new File( "C://Users//RENT//Desktop//output.txt" );
        PrintWriter pw = new PrintWriter(output);
        pw.println (this.text);
        pw.close();
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
    public void WpisanieDoPlikuFunkcyjnie() throws IOException{                // Wpis do pliku funkcyjnie
        long startTime = System.currentTimeMillis();
        List<String> lines = Arrays.asList(this.text);
        Files.write(Paths.get("C://Users//RENT//Desktop//output2.txt"),lines);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    public void czytanieSC(){                                                  // Czytanie Scanner
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(this.text);
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
    public void czytanieBR() throws FileNotFoundException, IOException {       // Czytanie BufferReader
        long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("C://Users//RENT//Desktop//output.txt"));
        System.out.println(br.readLine());
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        Main test = new Main();
        test.konsola();

    }
}
