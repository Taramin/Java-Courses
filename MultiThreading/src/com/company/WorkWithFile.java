package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFile {

    public void readFile(int t) {
        String path = "src\\com\\company\\FilesDirectory\\";
        char typeOfOperation = '0';
        List<Double> numbers = new ArrayList<>();
        List<String> numbersString = new ArrayList<>();
        try {
            FileReader reader = new FileReader(path + "in_" + t + ".txt");

            int symbol;
            String numb = "";
            boolean firstSymbol = true;
            while ((symbol = reader.read()) != -1) {
                if ((firstSymbol) && (((char) symbol == '*') || ((char) symbol == '+')
                        || ((char) symbol == '#') || ((char) symbol == '^'))) {
                    typeOfOperation = (char) symbol;
                    firstSymbol = false;
                    continue;
                } else if (firstSymbol) {
                    throw new ExceptionIncorrectFormatInFile();
                }
                if ((char) symbol == ' ') {
                    numbersString.add(numb);
                    numb = "";
                } else {
                    numb += (char) symbol;
                }
            }
            numbersString.add(numb);
            Operation operation = new Operation();

            for (String s : numbersString) {
                if (!(s.matches("\\s*[-]?\\d+\\*(10)\\^[-]?\\d+\\s*"))) {
                    throw new ExceptionIncorrectFormatInFile();
                } else {
                    double power = 0, n = 0;
                    for (int k = 0; k < s.length(); k++) {
                        if (s.charAt(k) == '*') {
                            String nString = s.substring(0, k);
                            n = Double.parseDouble(nString);
                        } else if (s.charAt(k) == '^') {
                            String powerString = s.substring(k + 1);
                            power = Double.parseDouble(powerString);
                        }
                    }
                    double newNumber = n * (Math.pow(10, power));
                    numbers.add(newNumber);
                }
            }

            String pathToResult = "C:\\Users\\Даша\\IdeaProjects\\MultiThreading\\" +
                    "src\\com\\company\\FilesDirectory\\result.txt";
            writeToFile(pathToResult, typeOfOperation, numbers, t);

        } catch (IOException e) {
        }
        numbersString.clear();
        numbers.clear();
    }

    private void writeToFile(String path, char typeOfOperation, List<Double> numbers, int iteration) throws IOException {

        FileWriter writer = new FileWriter(path, true);
        Operation operation = new Operation();

        if (typeOfOperation == '*') {
            double result = operation.multiplication(numbers);
            writer.write(iteration + ") " + result + "\n");
        } else if (typeOfOperation == '+') {
            double result = operation.sum(numbers);
            writer.write(iteration + ") " + result + "\n");
        } else if (typeOfOperation == '#') {
            double result = operation.average(numbers);
            writer.write(iteration + ") " + result + "\n");
        } else if (typeOfOperation == '^') {
            writer.write(iteration + ") Sorry idk what is сумма квадратов\n" +
                    "_________________8#88111111111____________________\n" +
                    "____________1#####81111__1111111818_______________\n" +
                    "_________1#####888881111______118#####8___________\n" +
                    "_______#########811____________18#8######_________\n" +
                    "_____####88811181111_____1_________88#818#1_______\n" +
                    "____####_________11_____________________11________\n" +
                    "__1###8_________________________________1_1__1____\n" +
                    "_8###8__________________________________118888#___\n" +
                    "_###8___________________________________1188####__\n" +
                    "####811__________________________________18#####__\n" +
                    "####811__________________________________18#####__\n" +
                    "###8111_________________________________18#######_\n" +
                    "####1111_______________________________11########_\n" +
                    "###88111________________________________8#######8_\n" +
                    "###88111_______________________________1_8######8#\n" +
                    "###88811_1____________________________11_8######8#\n" +
                    "###818###########1111188#########8__111___######18\n" +
                    "_1#118#############88###############81____8#####18\n" +
                    "_11111188181#####1#81###8811###88##11_____1#1881__\n" +
                    "__811__11881188188#1_##81181___1__________181__#__\n" +
                    "__1181____18881_1_81_1#_1_8818811_______111##8____\n" +
                    "____#881_________#1___8________________1111_______\n" +
                    "____8#8811______#1_____11__________11118111_______\n" +
                    "_____#8881_____188____1__8______11111888111_______\n" +
                    "_____##8811____1#8______18_____11888888#818_______\n" +
                    "_____8###811____8########1_____118##888881________\n" +
                    "______####811_111######11_______8888888888________\n" +
                    "_______#######88111##888888##88888#8##8##_##______\n" +
                    "________##########################8######_####____\n" +
                    "__1#########88###818818####888#8##8#####__######8_\n" +
                    "#########8###818###88##8811818#########___########\n" +
                    "########___###81111111__11188########_____########\n" +
                    "#######_____#######################______#########\n" +
                    "######_______###################8_______##########\n" +
                    "#####__________###############_________###########\n");
        }
        writer.flush();
    }
}
