// Klasside alamklasside puu
class Animal {
  constructor(name) {
    this.name = name;
  }
  speak() {
    console.log(`${this.name} makes a noise.`);
  }
}

class Dog extends Animal {
  constructor(name) {
    super(name);
  }
  speak() {
    console.log(`${this.name} barks.`);
  }
}

class Cat extends Animal {
  constructor(name) {
    super(name);
  }
  speak() {
    console.log(`${this.name} meows.`);
  }
}

class Horse extends Animal {
  constructor(name) {
    super(name);
  }
  speak() {
    console.log(`${this.name} neighs.`);
  }
}

// Näitprogramm
const dog = new Dog('Buddy');
const cat = new Cat('Luna');
const horse = new Horse('Thunder');

dog.speak(); // "Buddy barks."
cat.speak(); // "Luna meows."
horse.speak(); // "Thunder neighs."
