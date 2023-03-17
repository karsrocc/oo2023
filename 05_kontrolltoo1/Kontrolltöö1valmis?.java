import java.util.ArrayList;
import java.util.List;
//Loon toidu klassi
 class Food {
    private String name;
    private double proteinPct;
    private double fatPct;
    private double carbPct;

    Food(String name, double proteinPct, double fatPct, double carbPct) {
        this.name = name;
        this.proteinPct = proteinPct;
        this.fatPct = fatPct;
        this.carbPct = carbPct;

        // kontrolli et protsent ei ületaks 100%
        double totalPct = proteinPct + fatPct + carbPct;
        if (totalPct > 100.0) {
            throw new IllegalArgumentException("Protsent ei tohi ületada 100!");
        }
    }

    public String getName() {
        return name;
    }

    public double getProteinPct() {
        return proteinPct;
    }

    public double getFatPct() {
        return fatPct;
    }

    public double getCarbPct() {
        return carbPct;
    }
}
//loon komponentide klassi, et hiljem kasutada seda
 class FoodComponent {
    private double quantity;
    private Food food;

    public FoodComponent(double quantity, Food food) {
        this.quantity = quantity;
        this.food = food;
    }

    public double getQuantity() {
        return quantity;
    }

    public Food getFood() {
        return food;
    }

    public double getFatAmount() {
        return quantity * food.getFatPct() / 100.0;
    }
}
//toitude list
 class FoodList {
    private List<Food> foods;

    public FoodList() {
        this.foods = new ArrayList<Food>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public Food getFoodByName(String name) {
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }
//toidu sorteerimine rasvaprotsendi alusel. 
    public List<Food> getFoodsByFatPctRange(double min, double max) {
        List<Food> result = new ArrayList<Food>();
        for (Food food : foods) {
            double fatPct = food.getFatPct();
            if (fatPct >= min && fatPct <= max) {
                result.add(food);
            }
        }
        return result;
    }
}
//toiduretseptide klass
 class Recipe {
    private String name;
    private List<FoodComponent> components;

    public Recipe(String name) {
        this.name = name;
        this.components = new ArrayList<FoodComponent>();
    }

    public void addComponent(FoodComponent component) {
        components.add(component);
    }
//toidus oleva proteiini kogus
    public double getProteinAmount() {
        double total = 0.0;
        for (FoodComponent component : components) {
            total += component.getQuantity() * component.getFood().getProteinPct() / 100.0;
        }
        return total;
    }
//toidus oleva rasva kogus
    public double getFatAmount() {
        double total = 0.0;
        for (FoodComponent component : components) {
            total += component.getFatAmount();
        }
        return total;
    }
//toidus olevate süsivesikute kogus
    public double getCarbAmount() {
        double total = 0.0;
        for (FoodComponent component : components) {
            total += component.getQuantity() * component.getFood().getCarbPct() / 100.0;
        }
        return total;
    }
}
//toiduaine klass
 class FoodItem {
    private Recipe recipe;

    public double getProteinAmount() {
        return recipe.getProteinAmount();
    }

    public double getFatAmount() {
        return recipe.getFatAmount();
    }

    public double getCarbAmount() {
        return recipe.getCarbAmount();
    }

    public static void main(String[] args) {
        // Loo toiduasjad
        Food potato = new Food("Kartul", 2.0, 0.1, 18.4);
        Food sourCream = new Food("Hapukoor", 2.0, 20.0, 3.0);
        Food sausage = new Food("Vorst", 15.0, 25.0, 1.0);

        // loo komponendid salati jaoks
        FoodComponent potatoComp = new FoodComponent(100.0, potato);
        FoodComponent sourCreamComp = new FoodComponent(30.0, sourCream);
        FoodComponent sausageComp = new FoodComponent(50.0, sausage);

        // Kalkuleeri rasvaprotsent kõigis ja prindi vastus
        System.out.println("Kartuli rasv: " + potatoComp.getFatAmount() + "g");
        System.out.println("Hapukoore rasv: " + sourCreamComp.getFatAmount() + "g");
        System.out.println("Vorsti rasv: " + sausageComp.getFatAmount() + "g");

        // Loo toitude list ja lisa asju
        FoodList foodList = new FoodList();
        foodList.addFood(potato);
        foodList.addFood(sourCream);
        foodList.addFood(sausage);

        // Testi kas on olemas
        Food testFood = foodList.getFoodByName("Kartul");
        System.out.println("Testtoidu nimi: " + testFood.getName());

        // Testi toite rasvaprotsendi järgi, alla 20% rasvasisalduse.
        List<Food> testFoods = foodList.getFoodsByFatPctRange(0.0, 20.0);
        System.out.println("Testi toite rasvaprotsendi järgi milles on alla 20% rasva:");
        for (Food food : testFoods) {
            System.out.println(food.getName());
        }

        {
        // loo retsept ja lisa komponendid
        Recipe Kartulisalat = new Recipe("Kartulisalat");
        Kartulisalat.addComponent(potatoComp);
        Kartulisalat.addComponent(sourCreamComp);
        Kartulisalat.addComponent(sausageComp);

        // Testi toiteainete koguseid
        System.out.println("Kartulisalati proteiin: " + Kartulisalat.getProteinAmount() + "g");
        System.out.println("Kartulisalati rasvad: " + Kartulisalat.getFatAmount() + "g");
        System.out.println("Kartulisalati süsivesikud: " + Kartulisalat.getCarbAmount() + "g");
        }
    }
}
