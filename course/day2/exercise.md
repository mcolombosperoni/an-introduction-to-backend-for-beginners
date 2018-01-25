# Learn java in a TDD way 

Download [java-exercises.zip](java-exercises.zip) file and import into your IDE as maven project.

The structure of the project is like following:
```txt
java-exercises/
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── mcs
    │               └── day2
    │                   └── productinventory
    │                       ├── Main.java
    │                       ├── enums
    │                       │   ├── OrderType.java
    │                       │   └── ProductType.java
    │                       ├── exceptions
    │                       │   └── ProductNotExistException.java
    │                       ├── models
    │                       │   ├── AbstractProduct.java
    │                       │   ├── Dvd.java
    │                       │   └── Tv.java
    │                       └── services
    │                           ├── Inventory.java
    │                           └── impl
    │                               └── CollectionInventoryImpl.java
    └── test
        └── java
            └── com
                └── mcs
                    └── day2
                        └── productinventory
                            └── CollectionInventoryImplTest.java
```

GOAL: Implement all methods necessary to make all tests contained inside `CollectionInventoryImplTest.java`.  

You can use all libraries you want to help in your development adding them to maven dependencies. 


HINT:
- Read tests before starting coding because the test contains the expected behaviour
- Think to which collection implementation to use inside `CollectionInventoryImpl`
- remember the importance of hash equal contract and how collections use it to insert element belonging to class type
- remember how you could define natural and custom ordering


Solution: [java-exercises-examplesolution.zip](java-exercises-examplesolution.zip).
