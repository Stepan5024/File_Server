package server;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean[] files = new boolean[11];
        for (int i = 0; i < files.length; i++) {
            files[i] = false;
        }
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {

            String s1 = scanner.nextLine();

            if (s1.compareTo("exit") == 0) {
                flag = false;
                break;
            }
            String[] temp = s1.split(" ");
            if (s1.contains("add")) {

                if (temp[0].compareTo("add") == 0) {
                    String[] temp2 = temp[1].split("");


                    try {
                        int index = Integer.parseInt(s1.replaceAll("\\D+",""));

                        //int index = Integer.parseInt(temp2[temp2.length - 1]);
                        if (temp[1].contains("file") && index <= 10 && index >= 0 && !files[index]) {
                            System.out.println("The file " + temp[1] + " added successfully");
                            files[index] = true;
                        } else {
                            System.out.println("Cannot add the file " + temp[1]);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Cannot add the file " + temp[1]);
                    }

                }
            }
            //System.out.println("temp 0 = " + temp[0]);
            if (temp[0].compareTo("get") == 0) {
                //System.out.println("Get file");
                String[] temp2 = temp[1].split("");

                int index = Integer.parseInt(temp2[temp2.length - 1]);
                if (temp[1].contains("file") && index < 11 && index >= 0 && files[index]) {
                    System.out.println("The file " + temp[1] + " was sent");

                } else {
                    System.out.println("The file " + temp[1] + " not found");
                }
            }


            if (temp[0].compareTo("delete") == 0) {

                String[] temp2 = temp[1].split("");

                int index = Integer.parseInt(temp2[temp2.length - 1]);
                if (temp[1].contains("file") && index < 11 && index >= 0 && files[index]) {
                    System.out.println("The file " + temp[1] + " was deleted");
                    files[index] = false;
                } else {
                    System.out.println("The file " + temp[1] + " not found");
                }
            }


        }

    }
}