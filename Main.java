package ru.gb.family_tree.main;

import ru.gb.family_tree.Gender;
import ru.gb.family_tree.ServiceFamilyTree;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    final static String fileName = "src/familyTree/main/file.txt";

    public static void main(String[] args) throws IOException {

        ServiceFamilyTree service = new ServiceFamilyTree();
        service.addHuman("Кузьмин",
                "Александр",
                Gender.Male,
                LocalDate.of(1989, 6, 30),
                null,
                "Отец: Кузьмин Сергей",
                "Мать: Кузьмина Наталья",
                "Дети: 1");

        service.addHuman("Кузьмин",
                "Антон",
                Gender.Male,
                LocalDate.of(1999, 1, 18),
                null,
                "Отец: Кузьмин Сергей",
                "Мать: Кузьмина Наталья",
                "Дети: 0");
        service.addHuman("Кузьмина",
                "Наталья",
                Gender.Female,
                LocalDate.of(1970, 3, 29),
                null,
                "Отец: Черкасов Василий",
                "Мать: Черкасова Людмила",
                "Дети: 2");

        service.addHuman("Черкасова",
                "Людмила",
                Gender.Female,
                LocalDate.of(1946, 1, 30),
                null,
                null,
                null,
                "Дети: 1");

        service.getFamilyTree();

        service.saveFile("src/familyTree/main/file.txt");

        ServiceFamilyTree serviceFamilyTreeNEW = new ServiceFamilyTree();
        serviceFamilyTreeNEW.openFile("src/familyTree/main/file.txt");
        serviceFamilyTreeNEW.getFamilyTree();

        System.out.println();
        serviceFamilyTreeNEW.sortByName();
        System.out.println();

        serviceFamilyTreeNEW.sortByAge();
        System.out.println();
    }
}