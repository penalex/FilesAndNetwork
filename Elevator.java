public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor) {
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Wrong input! Try again: ");
        } else if (floor == currentFloor) {
            System.out.println();
        } else if (floor > currentFloor && floor <= maxFloor) {
            for (int i = 0; currentFloor != floor; i++) {
                System.out.println("Your floor is : " + currentFloor);
                moveUp();
            }
        } else if (floor < currentFloor && floor >= minFloor) {
            for (int i = 0; currentFloor != floor; i++) {
                System.out.println("Your floor is : " + currentFloor);
                moveDown();
            }
        }

    }
}



