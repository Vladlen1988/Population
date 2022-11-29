# Population
В данной задаче предлагается проанализировать массив данных с информаций о людях с использованием стримов из библиотеки Stream API.

Для работы необходимо подготовить несколько классов, а именно:

Sex, содержащий типы полов:
```java
public enum Sex {
    MAN,
    WOMAN
}
```
Education, содержащий типы образования:
```java
public enum Education {
    ELEMENTARY,
    SECONDARY,
    FURTHER,
    HIGHER
}
```
Person, содержащий информацию об имени, возрасте, поле и образовании человека:
```java
class Person {
    private String name;
    private String family;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}
```
Из коллеции объектов Person необходимо:

Найти количество несовершеннолетних (т.е. людей младше 18 лет).
Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
В классе Main в функции main() необходимо создать коллекцию экземпляров класса Person. Вам потребуется действительно большое количство данных. Для примера будем считать, что Вы производите перепись населения города Лондон с населением в 10 миллионов человек. Для генерации исходных данных воспользуемся следующим способом:
```java
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
```
