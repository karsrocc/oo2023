// Liidesed
class IAnimal {
  speak() {}
}

class IPlant {
  photosynthesize() {}
}

// Realiseerivad klassid
class Dog extends IAnimal {
  speak() {
    return "Woof!";
  }
}

class Cactus extends IPlant {
  photosynthesize() {
    return "I can photosynthesize even in the desert!";
  }
}

// Testid
describe("Dog", () => {
  it("should bark", () => {
    const dog = new Dog();
    expect(dog.speak()).toEqual("Woof!");
  });
});

describe("Cactus", () => {
  it("should be able to photosynthesize", () => {
    const cactus = new Cactus();
    expect(cactus.photosynthesize()).toEqual("I can photosynthesize even in the desert!");
  });
});

// Näitprogramm
const dog = new Dog();
console.log(dog.speak()); // "Woof!"

const cactus = new Cactus();
console.log(cactus.photosynthesize()); // "I can photosynthesize even in the desert!"
