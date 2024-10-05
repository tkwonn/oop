// 問題のレベル：Easy
// コンテンツ挿入箇所：関連と継承/集約とコンポジション（１）

// PC Watts * Running Hours / 1000

class CPU {
    private String name;
    private int wattage;
    private int amount;

    public CPU(String cpuName, int wattage, int amount) {
        this.name = cpuName;
        this.wattage = wattage;
        this.amount = amount;
    }

    public String toString() {
        return "Name " + this.name + "\n Wattage: " + this.wattage + " W \n Item Count: " + this.amount;
    }
}

class GraphicCard {
    private String name;
    private int wattage;
    private int amount;

    public GraphicCard(String gcName, int wattage, int amount) {
        this.name = gcName;
        this.wattage = wattage;
        this.amount = amount;
    }

    public String toString() {
        return "Name " + this.name + "\n Wattage: " + this.wattage + " W \n Item Count: " + this.amount;
    }
}

class Motherboard {
    private String name;
    private int wattage;
    private int amount;

    public Motherboard(String name, int wattage, int amount) {
        this.name = name;
        this.wattage = wattage;
        this.amount = amount;
    }

    public String toString() {
        return "Name " + this.name + "\n Wattage: " + this.wattage + " W \n Item Count: " + this.amount;
    }
}

class RAM {
    private String name;
    private int wattage;
    private int amount;

    public RAM(String name, int wattage, int amount) {
        this.name = name;
        this.wattage = wattage;
        this.amount = amount;
    }

    public String toString() {
        return "Name " + this.name + "\n Wattage: " + this.wattage + " W \n Item Count: " + this.amount;
    }
}

class Storage {
    private String name;
    private int wattage;
    private int amount;

    public Storage(String name, int wattage, int amount) {
        this.name = name;
        this.wattage = wattage;
        this.amount = amount;
    }

    public String toString() {
        return "Name " + this.name + "\n Wattage: " + this.wattage + " W \n Item Count: " + this.amount;
    }
}

// pc watts * running hours / 1000
// cost per month, year
class Computer {
    private CPU cpu;
    private GraphicCard graphicCard;
    private Motherboard motherboard;
    private RAM ram;
    private Storage storage;

    public Computer(CPU cpu, GraphicCard graphicCard, Motherboard motherboard, RAM ram, Storage storage) {
        this.cpu = cpu;
        this.graphicCard = graphicCard;
        this.motherboard = motherboard;
        this.ram = ram;
        this.storage = storage;
    }
}

class Main {
    public static void main(String[] args) {

    }
}