package ru.gb.family_tree;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private String Name;
    private String Surname;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;

        {
            Name = null;
            Surname = null;
            gender = null;
            birthDate = null;
            deathDate = null;
            children = null;

        }

    public void setName(String Name) {
            this.Name = Name;
        }

        public void setSurname(String Surname) {
            this.Surname = Surname;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public void setDeathDate(LocalDate deathDate) {
            this.deathDate = deathDate;
        }

        public void setFather(Human father) {
            this.father = father;
        }

        public void setMother(Human mother) {
            this.mother = mother;
        }

        public void setChildren(List<Human> children) {
            this.children = children;
        }

        public String getName() {
            return Name;
        }

        public String getSurname() {
            return Surname;
        }

        public Gender getGender() {
            return gender;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public LocalDate getDeathDate() {
            return deathDate;
        }

        public Human getFather() {
            return father;
        }

        public Human getMother() {
            return mother;
        }

        public List<Human> getChildren() {
            return children;
        }

        public Human() {

        }

        public Human(String Name, String Surname, Gender gender, LocalDate BirthDate, LocalDate DeathDate,
                     Human father, Human mother, List<Human> children) {

            this.Name = Name;
            this.Surname = Surname;
            this.gender = gender;

            try {
                this.birthDate = BirthDate;
            } catch (Exception ex) {
                this.birthDate = null;
            }

            try {
                this.deathDate = DeathDate;
            } catch (Exception ex) {
                this.deathDate = null;
            }

            this.father = father;
            this.mother = mother;
            this.children = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            if (Surname != null) {
                stringBuilder.append("Фамилия: ").append(Surname).append("; ");
            } else {
                stringBuilder.append("Фамилия: неизвестна; ");
            }
            if (Name != null) {
                stringBuilder.append("Имя: ").append(Name).append("; ");
            } else {
                stringBuilder.append("Имя: неизвестно; ");
            }
            if (gender != null) {
                stringBuilder.append("Пол: ").append(gender).append("; ");
            } else {
                stringBuilder.append("Пол: не указан; ");
            }
            if (birthDate != null) {
                stringBuilder.append("Возраст(лет):").append(getAge()).append("; ");
            } else {
                stringBuilder.append("Возраст: не известен;");
            }
            if (father != null) {
                stringBuilder.append("Отец: ").append(getFIO(father)).append("; ");
            } else {
                stringBuilder.append("Отец: не указан; ");
            }
            if (mother != null) {
                stringBuilder.append("Мать: ").append(getFIO(mother)).append("; ");
            } else {
                stringBuilder.append("Мать: не указана; ");
            }
            if (getChildren() != null && !children.isEmpty()) {
                stringBuilder.append("Дети: ").append(getChildren(children)).append("; ");
            } else {
                stringBuilder.append("Дети: не указаны; ");
            }
            return stringBuilder.toString();
        }

        public int getAge() {
            if (birthDate == null) {
                return 0;
            }
            else
                return (int) birthDate.until(Objects.requireNonNullElseGet(deathDate, LocalDate::now), ChronoUnit.YEARS);

        }

        public void addChild(Human child) {
            if (children == null) {
                children = new ArrayList<>();
            }
            if (!children.contains(child)) {
                children.add(child);
            }
        }

        public void addParent(Human human) {
            if (human.getGender().equals(Gender.Male)) {
                setFather(human);
            }
            if (human.getGender().equals(Gender.Female)) {
                setMother(human);
            }
        }

        public String getFIO(Human human) {
            String fio = "";
            if (human.getSurname() != null) {
                fio += human.getSurname();
            }
            if (!fio.equals("") && human.getName() != null) {
                fio += " " + human.getSurname().charAt(0);
            } else if (human.getSurname() != null) {
                fio += human.getSurname();
            }
            return fio;
        }

        public String getChildren(List<Human> children) {
            String res = "";
            for (Human child : children) {
                res += getFIO(child) + ",";
            }
            return res.substring(0, res.length() - 1);
        }

        public List<Human> getParents() {
            if (father != null) {
                new ArrayList<>().add(father);
            }
            if (mother != null) {
                new ArrayList<>().add(mother);
            }
            return new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Human human = (Human) o;
            return Objects.equals(Name, human.Name) && Objects.equals(Surname, human.Surname) && gender == human.gender && Objects.equals(birthDate, human.birthDate) && Objects.equals(deathDate, human.deathDate);
        }

        public int compareTo(Human o) {
            return Name.compareTo(o.Name);
        }

    public void setParents(List<Human> parents) {
    }

}
