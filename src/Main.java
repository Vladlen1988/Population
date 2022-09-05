import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long count = persons.stream()
                .filter(age -> age.getAge() < 18).count();
        System.out.println("Количество несовершеннолетних " + count);

        List<String> conscriptFamily = persons.stream()
                .filter(value -> value.getAge() >= 18 && value
                        .getAge() < 27 && value.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Cписок фамилий призывников " + conscriptFamily);

        Collection<Person> workerFamily = persons.stream()
                .filter(value -> value.getEducation() == Education.HIGHER)
                .filter(value -> value.getAge() >= 18 && value.getAge() <= 60 && value.getSex() == Sex.WOMAN ||
                        value.getAge() >= 18 && value.getAge() <= 65 && value.getSex() == Sex.MAN)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("Cписок  потенциально работоспособных людей с высшим образованием " + workerFamily.toString());
    }
}
