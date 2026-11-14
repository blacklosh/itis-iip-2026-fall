package ru.itis.collections;

import ru.itis.collections.model.HeroEntity;
import ru.itis.collections.model.SuperHeroEntity;

public class Main3 {

    public static void main(String[] args) {
        MyList<Integer> myList1 = new MyListImpl<>();

        myList1.add(12);
        myList1.add(120);
        myList1.add(1000);

        System.out.println(myList1);

        MyList<String> myList2 = new MyListImpl<>();

        myList2.add("Fedor");
        myList2.add("Igor");
        myList2.add("Marsel");

        System.out.println(myList2);

        MyList<HeroEntity> myList3 = new MyListImpl<>();

        myList3.add(new HeroEntity());
        myList3.add(new SuperHeroEntity());

        HeroEntity heroEntity = myList3.findByIndex(1);
        if (heroEntity instanceof SuperHeroEntity she) {
            
        }
    }
}
