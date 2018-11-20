package com.company;

import java.util.Scanner;

public class VariableInHexadecimalFormat {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        int decNumber = Integer.parseInt(command, 16);

        System.out.println(decNumber);
    }
}
