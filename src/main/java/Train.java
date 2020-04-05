public class Train {
    private final int id;
    private final int timeArrive;
    private final int unloadDuration;
    private final int salary;
    private final int unloadEnd;
    private static int count;

    public Train(int id, int timeArrive, int unloadDuration, int salary) {
        this.id = id;
        this.timeArrive = timeArrive;
        this.unloadDuration = unloadDuration;
        this.salary = salary;
        this.unloadEnd = timeArrive + unloadDuration;
        count++;
    }

    public Train() {
        count++;
        this.id = count;
        this.timeArrive = 5 + (int)(Math.random()*((1000-5)+1));
        this.unloadDuration = 5 + (int)(Math.random()*((500-5)+1));
        this.salary = 10 + (int)(Math.random()*((200-10)+1));
        this.unloadEnd = timeArrive + unloadDuration;

    }

    public int getId() {
        return id;
    }

    public int getTimeArrive() {
        return timeArrive;
    }

    public int getUnloadDuration() {
        return unloadDuration;
    }

    public int getSalary() {
        return salary;
    }

    public int getUnloadEnd() {
        return unloadEnd;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", timeArrive=" + timeArrive +
                ", unloadDuration=" + unloadDuration +
                ", salary=" + salary +
                ", unloadEnd=" + unloadEnd +
                '}' + "\n";
    }
}
