```mermaid
classDiagram
    Person o-- Barn
    Barn o-- "0..*" Cow
    Barn o-- "0..*" Horse
    Barn o-- "0..*" Chicken

    class Person {
    }

    class Barn {
    }

    class Cow {
    }

    class Horse {
    }

    class Chicken {
    }