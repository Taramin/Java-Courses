package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /*Домашка по stream api и collections
Реализовать алгоритмы, для решения следующих задач двумя способоми: через stream api и просто через банальные инструменты java

Есть сущность фильм
У фильма есть название и рейтинг
1) Есть список фильмов, копировать его в другой список
2) Есть два списка фильмов, найти их пересечение (фильмы, которые есть и в первом списке и во втором)
3) Есть два списка, объединить их в в один
4) Отсортировать список фильмов по рейтингу, если рейтинг у двух фильмов одинаков, то сортруем эти фильмы по алфавиту
5) Есть два списка, удалить элементы первого из второго
6) Есть список, преобразовать его в Map, где ключем является рейтинг, а значением количсетво фильмов с данным рейтингом
7) Отфильтровать фильмы с рейтингом выше заданного
8) Проверить, что все названия фильмов содержат только ЛАТИНСКИЕ буквы
9) Проверить, что все фильмы имеют рейтинг в заданном диапазоне
10) Найти фильмы с самым большим и маленьким рейтингами
консольный ввод делать не надо, список фильмов можно инциализировать самим в коде*/
    public static void main(String[] args) {
        Film film1 = new Film("Человук-повек 2", 7.5);
        Film film2 = new Film("Гарри Поттер 17", 8.3);
        Film film3 = new Film("Киану Ривз крутой", 9.3);
        Film film4 = new Film("Путин - возрождение", 2.1);
        Film film5 = new Film("ОСТИС непобежденный", 9.9);
        Film film6 = new Film("Фильм-2020", 4.1);
        Film film7 = new Film("История создания коронавируса", 0.4);

        List<Film> list1 = new ArrayList<>();
        list1.add(film1);
        list1.add(film2);
        list1.add(film3);
        list1.add(film4);
        list1.add(film5);


        System.out.println("Исходный список 1: ");

        for (Film i : list1) {
            i.printInfo();
        }

        List<Film> list2 = new ArrayList<Film>();
        list2.add(film1);
        list2.add(film2);
        list2.add(film6);
        list2.add(film7);

        System.out.println("\nИсходный список 2: ");

        for (Film i : list2) {
            i.printInfo();
        }


        Film film10 = new Film("Chelovuk Povek", 4.0);
        Film film11 = new Film("harry potter", 8.0);
        Film film12 = new Film("heLLLLLLLLo", 7.5);

        List<Film> list3 = new ArrayList<>();

        list3.add(film10);
        list3.add(film11);
        list3.add(film12);

        System.out.println("\nИсходный список 3: ");

        for (Film i : list3) {
            i.printInfo();
        }

        List<Film> listResult, listResultWithoutStream;

        System.out.println("\nЗадание 1.");
        System.out.println("Задание - есть список фильмов, копировать его в другой список (копируем 1 список)");
        listResult = list1.stream().collect(Collectors.toList());

        for (Film i : listResult) {
            i.printInfo();
        }

        //Реализация без использования Stream
        listResultWithoutStream = new ArrayList<>(list1);
        System.out.println("...........................................\nРешение без использования Stream");

        for (Film i : listResultWithoutStream) {
            i.printInfo();
        }

        List<Film> finalList = list2;
        listResult = list1.stream().filter(c -> finalList.contains(c)).collect(Collectors.toList());
        System.out.println("\nЗадание 2.");
        System.out.println("Задание - есть два списка фильмов, найти их пересечение (пересечение 1 и 2 списков)");

        for (Film i : listResult) {
            i.printInfo();
        }

        listResultWithoutStream.clear();
        //Реализация без использования Stream
        for (int i = 0; i < list1.size(); i++) {

            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i) == list2.get(j)) {
                    listResultWithoutStream.add(list1.get(i));
                }
            }

        }
        System.out.println("...........................................\nРешение без использования Stream");

        for (Film i : listResultWithoutStream) {
            i.printInfo();
        }

        listResult.clear();
        listResultWithoutStream.clear();

        listResult = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println("\nЗадание 3.");
        System.out.println("Задание - eсть два списка, объединить их в в один (объединяем 1 и 2 списки)");

        for (Film i : listResult) {
            i.printInfo();
        }

        //Реализация без использования Stream
        listResultWithoutStream = new ArrayList<>(list1);

        for (int i = 0; i < list2.size(); i++) {
            listResultWithoutStream.add(list2.get(i));
        }

        System.out.println("...........................................\nРешение без использования Stream");

        for (Film i : listResultWithoutStream) {
            i.printInfo();
        }

        listResult = listResult.stream().sorted((o1, o2) -> o1.compareTo(o2)).distinct().collect(Collectors.toList());
        System.out.println("\nЗадание 4.");
        System.out.println("Задание - отсортировать список фильмов по рейтингу (сортируем 1 список)");

        for (Film i : listResult) {
            i.printInfo();
        }

        //Реализация без использования Stream

        for (int i = 0; i < listResultWithoutStream.size(); i++) {

            for (int j = i + 1; j < listResultWithoutStream.size(); j++) {
                double prevRang = listResultWithoutStream.get(i).getRang();
                double nextRang = listResultWithoutStream.get(j).getRang();
                if (prevRang > nextRang) {
                    Film current = listResultWithoutStream.get(j);
                    listResultWithoutStream.remove(j);
                    listResultWithoutStream.add(i, current);
                }
            }

        }

        System.out.println("...........................................\nРешение без использования Stream");

        for (Film i : listResultWithoutStream) {
            i.printInfo();
        }

        listResult.clear();
        listResultWithoutStream.clear();

        listResult = list2.stream().filter(c -> !(list1.contains(c))).collect(Collectors.toList());

        System.out.println("\nЗадание 5.");
        System.out.println("Задание - есть два списка, удалить элементы первого из второго (используем 1 и 2 списки)");

        for (Film i : listResult) {
            i.printInfo();
        }

        //Реализация без использования Stream
        for (Film value : list2) {
            boolean exist = false;

            for (Film film : list1) {
                if (film == value) {
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                listResultWithoutStream.add(value);
            }
        }

        System.out.println("...........................................\nРешение без использования Stream");

        for (Film i : listResultWithoutStream) {
            i.printInfo();
        }


        listResultWithoutStream.clear();
        listResult.clear();

        //пока что не готово!!!!
        //6) Есть список, преобразовать его в Map, где ключем является рейтинг, а значением количсетво фильмов с данным рейтингом
        System.out.println("\nЗадание 6.");
        System.out.println("Задание - есть список, преобразовать его в Map, где ключом является рейтинг, а значением количество фильмов с данным рейтингом (используем 1 список)");
        //Map<Double, Integer> result = (Map<Double, Integer>) list1.stream().map(((c)->c.getRang() + list1.stream().filter((p)->p.getRang() == c.getRang()).count()));
        //Stream<Object> mapRes = list1.stream().map((c)->c.getRang() + );

        int count = (int) list1.stream().filter((p) -> p.getRang() == 7.5).count();
        Map<Double, String> mapResult = list1.stream()
                .collect(Collectors.toMap(Film::getRang, Film::getName));
        System.out.println(mapResult.entrySet());

        //Реализация без использования Stream
        Map<Double, Integer> mapResultWithoutStream = new HashMap<>();

        for (int i = 0; i < list1.size(); i++) {
            double rang = list1.get(i).getRang();
            int countOfThisRang = 0;

            for (int j = 0; j < list1.size(); j++) {
                if (list1.get(j).getRang() == rang) {
                    countOfThisRang++;
                }
            }

            mapResultWithoutStream.put(rang, countOfThisRang);
        }

        System.out.println(mapResultWithoutStream.entrySet());

        listResult.clear();

        //7) Отфильтровать фильмы с рейтингом выше заданного
        System.out.println("\nЗадание 7.");
        System.out.println("Задание - отфильтровать фильмы с рейтингом выше заданного (рейтинг от 8.0)");

        double maxRang = 8;
        listResult = list1.stream().filter(c -> c.getRang() > maxRang).collect(Collectors.toList());

        for (Film i : listResult) {
            i.printInfo();
        }

        //Реализация без использования Stream
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getRang() >= maxRang) {
                listResultWithoutStream.add(list1.get(i));
            }
        }

        System.out.println("...........................................\nРешение без использования Stream");

        for (Film i : listResultWithoutStream) {
            i.printInfo();
        }


        listResultWithoutStream.clear();
        listResult.clear();

        System.out.println("\nЗадание 8.");
        System.out.println("Задание - проверить, что все названия фильмов содержат только ЛАТИНСКИЕ буквы");

        boolean res = list1.stream().allMatch((c) -> c.getName().matches("([a-z]*[A-Z]*\\s*)*"));
        System.out.println("Результат в 1 списке: " + res);
        res = list3.stream().allMatch((c) -> c.getName().matches("([a-z]*[A-Z]*\\s*)*"));
        System.out.println("Результат в 3 списке: " + res);

        //Реализация без использования Stream
        res = true;

        for (int i = 0; i < list1.size(); i++) {
            String currentName = list1.get(i).getName();
            if (!currentName.matches("([a-z]*[A-Z]*\\s*)*")) {
                res = false;
                break;
            }
        }

        System.out.println("...........................................\nРешение без использования Stream");
        System.out.println("Результат в 1 списке: " + res);

        res = true;

        for (int i = 0; i < list3.size(); i++) {
            String currentName = list3.get(i).getName();
            if (!currentName.matches("([a-z]*[A-Z]*\\s*)*")) {
                res = false;
                break;
            }
        }

        System.out.println("Результат в 3 списке: " + res);

        System.out.println("\nЗадание 9.");
        System.out.println("Задание - проверить, что все фильмы имеют рейтинг в заданном диапазоне (от 4 до 8)");

        double minRang = 4;
        res = list1.stream().allMatch((c) -> (c.getRang() <= maxRang) && (c.getRang() >= minRang));
        System.out.println("Результат в 1 списке: " + res);
        res = list3.stream().allMatch((c) -> (c.getRang() <= maxRang) && (c.getRang() >= minRang));
        System.out.println("Результат в 3 списке: " + res);

        //Реализация без использования Stream
        res = true;

        for (int i = 0; i < list1.size(); i++) {
            double currentRang = list1.get(i).getRang();
            if (!(currentRang >= minRang) || !(currentRang <= maxRang)) {
                res = false;
                break;
            }
        }

        System.out.println("...........................................\nРешение без использования Stream");
        System.out.println("Результат в 1 списке: " + res);

        res = true;

        for (int i = 0; i < list3.size(); i++) {
            double currentRang = list3.get(i).getRang();
            if (!(currentRang >= minRang) || !(currentRang <= maxRang)) {
                res = false;
                break;
            }
        }

        System.out.println("Результат в 3 списке: " + res);

        System.out.println("\nЗадание 10.");
        System.out.println("Задание - найти фильмы с самым большим и маленьким рейтингами");

        list1.stream().max(Film::compareTo).get().printInfo();
        list1.stream().min(Film::compareTo).get().printInfo();

        //Реализация без использования Stream
        double maxy = 0;
        double miny = 10;

        Film filmWithMaxRang = null, filmWithMinRang = null;

        for (int i = 0; i < list1.size(); i++) {
            double currentRang = list1.get(i).getRang();
            if (currentRang > maxy) {
                maxy = currentRang;
                filmWithMaxRang = list1.get(i);
            }
            if (currentRang < miny) {
                miny = currentRang;
                filmWithMinRang = list1.get(i);
            }
        }

        System.out.println("...........................................\nРешение без использования Stream");
        filmWithMaxRang.printInfo();
        filmWithMinRang.printInfo();

    }
}
