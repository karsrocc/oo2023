class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }
}


class Main {
    public static void main(String[] args) {
        
        Person person = new Person("Alice");

        
        person.sayHello();
    }
}
