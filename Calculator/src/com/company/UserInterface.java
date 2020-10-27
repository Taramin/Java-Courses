package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    /*private static File file = new File ("logs.txt");
    private FileWriter inputFile = new FileWriter(file);
    public UserInterface() throws IOException {
        if (!file.exists()){
            throw new FileNotFoundException("файл был в проекте, а сейчас почему-то исчез");
        }
    }
*/
    public void menu() throws RuntimeException, IOException {
        System.out.println("\nEnter something please");
        Scanner input = new Scanner(System.in);
        String operation = input.nextLine();
        System.out.print("="+formulaAnalysis(operation)+"\n");
        //inputFile.write("="+formulaAnalysis(operation));

    }
    private String formulaAnalysis(String all_operations) throws RuntimeException, IOException {
        ArrayList <String> constituents = new ArrayList<>(divideIntoConstituents(all_operations));
        Calculator calculator = new Calculator();
        constituents = extractRoot(constituents);
        for(int i=0; i<constituents.size(); i++) {
        if (constituents.get(i).equals("^")){
                double res = calculator.exponentiation(constituents.get(i-1),constituents.get(i+1));
                constituents.remove(i+1);
                constituents.remove(i);
                constituents.remove(i-1);
                constituents.add(i-1, String.valueOf(res));
                i--;
            }
        }
        for(int i=0; i<constituents.size(); i++){
            if (constituents.get(i).equals("/")) {
                double res = calculator.division(constituents.get(i - 1), constituents.get(i + 1));
                constituents.remove(i + 1);
                constituents.remove(i);
                constituents.remove(i - 1);
                constituents.add(i - 1, String.valueOf(res));
                i--;
            }
            else if (constituents.get(i).equals("*")){
                double res = calculator.multiplication(constituents.get(i-1),constituents.get(i+1));
                constituents.remove(i+1);
                constituents.remove(i);
                constituents.remove(i-1);
                constituents.add(i-1, String.valueOf(res));
                i--;
            }
        }
        for(int i=0; i<constituents.size(); i++) {
            if(constituents.get(i).equals("+")){
                double res = calculator.sum(constituents.get(i-1),constituents.get(i+1));
                constituents.remove(i+1);
                constituents.remove(i);
                constituents.remove(i-1);
                constituents.add(i-1, String.valueOf(res));
                i--;
            }
            else if(constituents.get(i).equals("-")){
                double res = calculator.difference(constituents.get(i-1),constituents.get(i+1));
                constituents.remove(i+1);
                constituents.remove(i);
                constituents.remove(i-1);
                constituents.add(i-1, String.valueOf(res));
                i--;
            }
        }
        return constituents.get(0);
        //тут надо как-то записать в файл ответ file.toString()
    }

    private ArrayList <String> extractRoot(ArrayList <String> constituents) throws RuntimeException{
        for(int i=0; i<constituents.size(); i++){
            if (constituents.get(i).startsWith("sqrt")){
                if(!(constituents.get(i).startsWith("sqrt(")) && !(constituents.get(i).endsWith(")"))){
                    throw new ExceptionIncorrectFormatSqrt();
                }
                Calculator calculator = new Calculator();
                String number = constituents.get(i).substring(5, constituents.get(i).length()-1);
                constituents.remove(i);
                double res = calculator.squareRootExtraction(number);
                constituents.add(i, String.valueOf(res));
            }
        }
        return constituents;
    }

    private ArrayList <String> divideIntoConstituents(String operations) throws IOException {
        ArrayList <String> constituents = new ArrayList<>();
        int index = 0, iterator = 0;
        if(operations.charAt(0)=='-') {
            iterator++;
        }
        for(int i=iterator; i<operations.length(); i++){
            if(operations.charAt(i) == '+' || operations.charAt(i) == '*' || operations.charAt(i) == '/'
                    ||operations.charAt(i) == '-' || operations.charAt(i) == '^'){
                constituents.add(operations.substring(index, i));
                constituents.add(operations.substring(i, i+1));
                index = i+1;
                i++;
            }
        }
        constituents.add(operations.substring(index, operations.length()));
        for (int i=0; i<constituents.size();i++) {
            System.out.print(constituents.get(i));
            //inputFile.write(constituents.get(i));
        }
        return constituents;
    }
}
