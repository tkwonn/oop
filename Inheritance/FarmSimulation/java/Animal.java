import java.util.Date;
import java.text.SimpleDateFormat;

// 人間や動物のBMI（Body Mass Index：肥満度を表す指数）を計算するクラスを作成します。
class BMI{
    private double heightM;
    private double weightKg;

    public BMI(double heightM, double weightKg){
        this.heightM = heightM;
        this.weightKg = weightKg;
    }

    public double getWeightKg(){
        return this.weightKg;
    }

    public double getValue(){
        return this.weightKg/(this.heightM*this.heightM);
    }

    public String toString(){
        return this.heightM + " meters, " + this.weightKg + "kg, BMI:" + this.getValue();
    }
}

// 動物クラスの実装、このクラスを継承することで具体的な動物を表現します
class Animal{
    // 動物の基本的な属性を保持するフィールド、protected修飾子は、このクラスと同じパッケージ内またはサブクラスからアクセス可能です。
    // これらがprivateの場合、Mammalは継承された状態にアクセスしているため、エラーが発生します。
    protected String species;
    protected BMI bmi;
    protected double lifeSpanDays;
    protected String biologicalSex;
    protected Date spawnTime;
    protected Date deathTime;
    protected int hungerPercent = 100;
    protected int sleepPercent = 100;

    public Animal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex){
        this.species = species;
        this.bmi = new BMI(heightM, weightKg);
        this.lifeSpanDays = lifeSpanDays;
        this.biologicalSex = biologicalSex;
        this.spawnTime = new java.util.Date();
    }

    public void eat(){
        if(!this.isAlive()) return;
        this.hungerPercent = 0;
    }

    public void setAsHungry(){
        if(!this.isAlive()) return;
        this.hungerPercent = 100;
    }

    public boolean isHungry(){
        return this.hungerPercent >= 70;
    }

    public void sleep(){
        if(!this.isAlive()) return;
        this.sleepPercent = 0;
    }

    public void setAsSleepy(){
        if(!this.isAlive()) return;
        this.sleepPercent = 100;
    }

    public boolean isSleepy(){
        return this.sleepPercent >= 70;
    }

    public void die(){
        this.sleepPercent = 0;
        this.hungerPercent = 0;
        this.deathTime = new java.util.Date();
    }

    public boolean isAlive(){
        return this.deathTime == null;
    }

    public String toString(){
        return this.species + this.bmi + " lives " + this.lifeSpanDays + " days/" + "gender:" + this.biologicalSex + "." + this.status();
    }

    public String status(){
        return this.species + " status:" + " Hunger - " + this.hungerPercent + "%, " + "sleepiness:"+this.sleepPercent + "%" + ", Alive - " + this.isAlive() + ". First created at " + this.dateCreated();
    }

    public String dateCreated(){
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(this.spawnTime);
    }
}

// このコードは、親クラスからの継承を使用して全ての状態や動作を引き継ぐ仕組みを示しています。
// メンバ変数とメソッドの定義は全て子クラスに引き継がれます。
// ここでは具体的に、Animalsクラスを拡張する新しいMammalsクラスを作成しています。この二つのクラス間には継承関係が存在します。
// MammalクラスはAnimalクラスを継承しており、この関係はJavaでは"extends"キーワードによって表現されます。
// "Mammal extends Animal"とは、MammalがAnimalを継承することを意味します。
class Mammal extends Animal{
    // Mammal固有の状態やフィールドを定義
    private double furLengthCm;
    private String furType;
    private int toothCounter;
    private double bodyTemperatureC;
    private double avgBodyTemperatureC;
    private boolean mammaryGland = false;
    private boolean sweatGland = true;
    private boolean isPregnant = false;

    // super()は親クラスのコンストラクタを参照します。これにより、Animalクラスのメンバ変数の初期状態を適切に設定します。
    // それに加えて、Mammal特有のデータも初期化します。これらの新しいメンバ変数はここで定義されています。
    public Mammal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC){

        // スーパークラスのコンストラクタを呼び出して、Animalから継承したメンバーの初期状態を設定します。
        super(species, heightM, weightKg, lifeSpanDays, biologicalSex);

        // 他のメンバ変数の設定をします。
        this.furLengthCm = furLengthCm;
        this.furType = furType;

        // 全てのメスの哺乳類は乳腺があります。
        this.mammaryGland = (biologicalSex == "female");

        this.avgBodyTemperatureC = avgBodyTemperatureC;

        // 初期体温を平均体温Cに設定します。
        this.bodyTemperatureC = this.avgBodyTemperatureC;
    }

    // MammalクラスにはAnimalクラスから継承したメソッドが全て含まれています。
    // 加えて、Mammalクラス特有のメソッドも定義できます。例えば、sweat()メソッドなどです。
    public void sweat(){
        if(!this.isAlive()) return;
        if(this.sweatGland) System.out.print("Sweating....");
        // 体温の低下
        this.bodyTemperatureC -= 0.3;
        System.out.print("Body temperature is now " + this.bodyTemperatureC + "C");
        System.out.println();
    }

    // 哺乳類の一般的な特徴も実装できます。例えば、母乳を出すためには妊娠していて、かつ乳腺が存在する必要があります。
    public void produceMilk(){
        if(!this.isAlive()) return;
        if(this.isPregnant() && this.mammaryGland) System.out.println("Producing milk...");
        else System.out.println("Cannot produce milk");
        System.out.println();
    }

    // 哺乳類は同種の他の哺乳類と交尾します。その際に、動物が雄でパートナーが雌の場合、パートナーは受精します。
    // この動物が雌でパートナーが雄の場合、この動物は受精します。このプロセスにおいて親クラスの状態にアクセスすることに注意が必要です。
    public void mate(Mammal mammal){
        if(!this.isAlive()) return;
        if(this.species != mammal.species) return;
        if(this.biologicalSex == "female" && mammal.biologicalSex == "male") this.fertalize();
        else if(this.biologicalSex == "male" && mammal.biologicalSex == "female") mammal.fertalize();
    }

    public void fertalize(){
        if(!this.isAlive()) return;
        this.isPregnant = true;
    }

    public boolean isPregnant(){
        if(!this.isAlive()) return false;
        return this.isPregnant;
    }

    public void bite(){
        if(!this.isAlive()) return;
        System.out.println(this.species + " bites with their single lower jaws which has" +  (this.toothCounter == 0 ? " not" : "")  + " replaced its teeth: " + (this.toothCounter > 0));
        System.out.println();
    }

    // 哺乳類は一生のうちに一度しか歯を入れ替えることがないという一般的な特性を表現するreplaceTeeth()メソッドも定義しています。
    public void replaceTeeth(){
        if(!this.isAlive()) return;
        if(this.toothCounter == 0) this.toothCounter++;
    }

    // 体温の上昇
    public void increaseBodyHeat(double celcius){
        this.bodyTemperatureC+=celcius;
    }

    // 体温の低下
    public void decreaseBodyHeat(double celcius){
        this.bodyTemperatureC-=celcius;
    }

    // 動物の体温を適切な体温に設定します。
    public void adjustBodyHeat(){
        this.bodyTemperatureC = this.avgBodyTemperatureC;
    }
}

class Bird extends Animal {

}

class Person extends Mammal {

}

class Cow extends Mammal {

}

class Horse extends Mammal {

}

class Parrot extends Bird {

}

class Chicken extends Bird {

}

class Main{
    public static void main(String[] args){
        // 新しいMammalオブジェクト、ここでは"cow"を作成します。
        Mammal cow = new Mammal("Cattle", 1.8,454.5,730, "female", 1.4, "Cowhide", 32.4);
        System.out.println(cow);
        System.out.println();

        // 同じく新しいMammalオブジェクト、ここでは"bull"を作成します。
        Mammal bull = new Mammal("Cattle", 1.8,454.5,730, "male", 1.1, "Cowhide", 30.8);
        System.out.println(bull);
        System.out.println();

        // cowオブジェクトはMammalクラスであり、親クラスであるAnimalsのeatやsleepメソッドを使用できます。
        cow.eat();
        cow.sleep();
        System.out.println(cow.status());

        // 状態を変更し、最後にdieメソッドを呼び出して、cowを"死亡"状態にします。
        cow.setAsHungry();
        cow.setAsSleepy();
        cow.die();
        System.out.println(cow.status());
        System.out.println();

        // 新しいMammalオブジェクト、ここでは"tigerF"と"tigerM"を作成します。
        Mammal tigerF = new Mammal("Tiger", 0.9,140,4745, "female", 1.1, "Tiger Hair", 38.5);
        System.out.println(tigerF);
        System.out.println();

        Mammal tigerM = new Mammal("Tiger", 1.1,280,4045, "male", 1.2, "Tiger Hair", 38.5);
        System.out.println(tigerM);
        System.out.println();

        // tigerMはMammalクラスのメソッドであるbiteとreplaceTeethを使用します。
        tigerM.bite();
        tigerM.replaceTeeth();
        tigerM.bite();

        // tigerFはMammalクラスのメソッドであるproduceMilkとmateを使用します。
        tigerF.produceMilk();
        tigerF.mate(tigerM);
        tigerF.produceMilk();
    }
}