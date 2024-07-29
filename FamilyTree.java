package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class FamilyTree implements Iterable<Human> {
    private final List<Human> familyTree = new ArrayList<>();

    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            addToParent(human);
            addToChildren(human);
            return true;
        }
        return false;

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Human human : familyTree) {

            if (human.getSurname() != null) {
                stringBuilder.append("Фамилия: ").append(human.getSurname()).append("; ");
            } else {
                stringBuilder.append("Фамилия: неизвестна; ");
            }
            if (human.getName() != null) {
                stringBuilder.append("Имя: ").append(human.getName()).append("; ");
            } else {
                stringBuilder.append("Имя: неизвестно; ");
            }
            if (human.getGender() != null) {
                stringBuilder.append("Пол: ").append(human.getGender()).append("; ");
            } else {
                stringBuilder.append("Пол: не указан; ");
            }
            if (human.getBirthDate() != null) {
                stringBuilder.append("Возраст(лет):").append(human.getAge()).append("; ");
            } else {
                stringBuilder.append("Возраст: не известен;");
            }
            if (human.getFather() != null) {
                stringBuilder.append("Отец: ").append(human.getFIO(human.getFather())).append("; ");
            } else {
                stringBuilder.append("Отец: не указан; ");
            }
            if (human.getMother() != null) {
                stringBuilder.append("Мать: ").append(human.getFIO(human.getMother())).append("; ");
            } else {
                stringBuilder.append("Мать: не указана; ");
            }
            if (human.getChildren() != null && !human.getChildren().isEmpty()) {
                stringBuilder.append("Дети: ").append(human.getChildren(human.getChildren())).append("; ");
            } else {
                stringBuilder.append("Дети: не указаны; ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    private void addToParent(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        if (human.getChildren() != null) {
            for (Human child : human.getChildren()) {
                child.addParent(human);
            }
        }
    }

    public Object getHuman() {
        if (familyTree == null) {
            return null;
        }
        return familyTree;

    }

    @Override
    public Iterator<Human> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Human> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Human> spliterator() {
        return Iterable.super.spliterator();
    }

  }