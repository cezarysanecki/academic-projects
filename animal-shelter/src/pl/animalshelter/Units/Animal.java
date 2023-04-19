package pl.animalshelter.Units;

public class Animal {
    private int id_animal;
    private String name;
    private String kindOfAnimal;
    private int age;
    private static int next_id = 1;

    public Animal(String name, String kindOfAnimal, int age) {
        id_animal = next_id++;
        this.name = name;
        this.kindOfAnimal = kindOfAnimal;
        this.age = age;
    }

    public Animal(int id_animal, String name, String kindOfAnimal, int age) {
        this.id_animal = id_animal;
        next_id++;
        this.name = name;
        this.kindOfAnimal = kindOfAnimal;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public String getName() {
        return name;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public static void setNext_id(int next_id) {
        Animal.next_id = next_id;
    }

    @Override
    public String toString() {
        return name;
    }
}
