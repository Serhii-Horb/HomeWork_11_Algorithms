package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Задача: вызов лифта
В доме два лифта.
Реализовать алгоритм отправки ближайшего лифта на вызывающий этаж.
Алгоритм будет применяться в домах разной этажности.
*Алгоритм будет применяться в домах с количеством >= 2 лифтов
Пример:
в доме 19 этажей
работают лифт А и лифт В
лифт А находиться на 0 этаже
лифт В находиться на 8 этаже
на вход: 1
отправляем лифт А*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько этажей в вашем доме :");
        int startFloor = 1;
        int finishFloor = scanner.nextInt();

        List<Elevator> elevators = new ArrayList<>();
        elevators.add(new Elevator(startFloor, finishFloor, "Лифт №1"));
        elevators.add(new Elevator(startFloor, finishFloor, "Лифт №2"));

        while (startFloor != 0) {
            System.out.print("С какого этажа едем: ");
            int personStart = scanner.nextInt();
            if (personStart <= 0 || personStart > finishFloor) {
                System.out.println("Вы ввели неверный этаж");
            }

            System.out.print("На какой этаж едем: ");
            int personFinish = scanner.nextInt();
            if (personFinish <= 0 || personFinish > finishFloor) {
                System.out.println("Вы ввели неверный этаж");
            }

            if (personFinish == 0) {
                System.out.println("Мы закончили");
                break;
            }

            Person person = new Person(personStart, personFinish);

            int elevatorRunNumber = Elevator.getMin(elevators, person);
            Elevator runElevator = elevators.get(elevatorRunNumber);
            System.out.println("Мы едем на " + runElevator.getName());
            runElevator.setStart(personFinish);
            elevators.set(elevatorRunNumber, runElevator);
        }
    }
}