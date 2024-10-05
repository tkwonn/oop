```mermaid
classDiagram
    Animal <|-- Mammal
    Animal <|-- Bird
    Mammal <|-- Cow
    Mammal <|-- Horse
    Mammal <|-- Person
    Bird <|-- Chicken
    Bird <|-- Parrot
    Barn --> Cow : contains
    Barn --> Horse : contains
    Barn --> Chicken : contains
    Person "1" -- "1" Barn : owns

    class Animal {
        #String species
        #BMI bmi
        #double lifeSpanDays
        #String biologicalSex
        #Date spawnTime
        #Date deathTime
        #int hungerPercent
        #int sleepPercent
        +Animal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex)
        +void eat()
        +void setAsHungry()
        +boolean isHungry()
        +void sleep()
        +void setAsSleepy()
        +boolean isSleepy()
        +void die()
        +boolean isAlive()
        +String toString()
        +String status()
        +String dateCreated()
    }

    class BMI {
        -double heightM
        -double weightKg
        +BMI(double heightM, double weightKg)
        +double getWeightKg()
        +double getValue()
        +String toString()
    }

    class Mammal {
        -double furLengthCm
        -String furType
        -int toothCounter
        -double bodyTemperatureC
        -double avgBodyTemperatureC
        -boolean mammaryGland
        -boolean sweatGland
        -boolean isPregnant
        +Mammal(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC)
        +void sweat()
        +void produceMilk()
        +void mate(Mammal mammal)
        +void fertalize()
        +boolean isPregnant()
        +void bite()
        +void replaceTeeth()
        +void increaseBodyHeat(double celcius)
        +void decreaseBodyHeat(double celcius)
        +void adjustBodyHeat()
    }

    class Bird {
        -double wingspanCm
        -String featherColor
        +Bird(String species, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double wingspanCm, String featherColor)
        +void fly()
        +void layEgg()
    }

    class Cow {
        -double milkProduction
        +Cow(double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC, double milkProduction)
        +double produceMilk()
    }

    class Horse {
        -double speed
        +Horse(double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC, double speed)
        +double run()
    }

    class Chicken {
        -int eggProduction
        +Chicken(double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double wingspanCm, String featherColor, int eggProduction)
        +int layEgg()
    }

    class Parrot {
        -String[] vocabulary
        +Parrot(double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double wingspanCm, String featherColor)
        +void speak()
        +void learnWord(String word)
    }

    class Barn {
        -List~Animal~ animals
        -double revenue
        -double expenses
        +void addAnimal(Animal animal)
        +void removeAnimal(Animal animal)
        +void feedAnimals()
        +double calculateProfit()
        +List~Animal~ getAnimals()
    }

    class Person {
        -String name
        -double money
        -Barn barn
        +Person(String name, double heightM, double weightKg, double lifeSpanDays, String biologicalSex, double furLengthCm, String furType, double avgBodyTemperatureC, double money)
        +void manageFarm()
        +void sellAnimal(Animal animal)
        +void buyAnimal(Animal animal)
        +void collectEggs()
        +void milkCows()
        +double getMoney()
    }