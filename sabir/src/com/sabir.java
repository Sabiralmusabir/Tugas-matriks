package com;
import java.util.ArrayList;
import  java.util.Scanner;

public class sabir {

    public static void main(String[] args) {

        ArrayList<String> nama = new ArrayList<>();
        ArrayList<String> NIM = new ArrayList<>();
        ArrayList<String> alamat = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int pilihan;

        do {
            System.out.println("\nprogram data mahasiswa");
            System.out.println("========================");
            System.out.println(" tambahkan");
            System.out.println(" tampilkan");
            System.out.println(" cari");
            System.out.println(" hapus");
            System.out.println(" keluar");
            System.out.println("pilih menu:");
            pilihan = input.nextInt();
            if( pilihan ==1){
                System.out.println("masukan nama:");
                String nm= input.next();
                nama.add(nm);

                System.out.println("masukan nim:");
                String nim= input.next();
                NIM.add(nim);

                System.out.println("masukan alamat:");
                String alt= input.next();
                alamat.add(alt);
            } else if (pilihan==2) {
                System.out.println("data mahasiswa");
                System.out.println("===============");

                for (int i = 0; i < NIM.size(); i++) {
                    System.out.println(i+1+"."+ NIM.get(i));
                }
                System.out.println("ketik 3 untuk melihat data lengkap");
            }
            else if (pilihan==3){
                System.out.println(" masukan data berapa yang ingin di cari");
                int cari= input.nextInt();
                if(cari==1){

                    System.out.println("nama:"+ nama.get(0));
                    System.out.println("nim:"+ NIM.get(0));
                    System.out.println("alamat:"+ alamat.get(0));
                }
                if(cari==2){

                    System.out.println("nama:"+ nama.get(1));
                    System.out.println("nim:"+ NIM.get(1));
                    System.out.println("alamat:"+ alamat.get(1));
                }
            } else if (pilihan==4) {
                System.out.println(" data mahasiswa");
                System.out.println("=================");

                for (int i = 0; i < NIM.size(); i++) {
                    System.out.println(i+1 +"."+ NIM.get(i));
                }
                System.out.println("masukan nim yg akan di hapus");
                String nim= input.next();
                NIM.remove(nim);
            } else if (pilihan==5) {
                System.out.println("selesai");
            }else {
                System.out.println("menu tidak ada ");
            }

        }while (pilihan !=5);
    }
}

