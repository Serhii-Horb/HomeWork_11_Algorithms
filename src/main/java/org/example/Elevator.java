package org.example;

import java.util.List;

public class Elevator {
    private int start;
    private int stop;
    private String name;

    public Elevator(int start, int stop, String name) {
        this.start = start;
        this.stop = stop;
        this.name = name;
    }

    public static int getMin(List<Elevator> elevators, Person person) {
        int bestElevatorDistance = Math.abs(elevators.get(0).start - person.getStart());
        int elevatorNumber = 0;
        for (int i = 1; i < elevators.size(); i++) {
            if (Math.abs(elevators.get(i).start - person.getStart()) < bestElevatorDistance) {
                bestElevatorDistance = elevators.get(i).getStart();
                elevatorNumber = i;
            }
        }
        return elevatorNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }
}
