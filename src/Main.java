import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws SQLException {

//        String url = "jdbc:mysql://localhost:3306/person2?useUnicode=true&serverTimezone=UTC";
//        String user = "root";
//        String password = "root";
//
//        Connection connection = DriverManager.getConnection(url,user,password);
//        PreparedStatement preparedStatement = connection.prepareStatement("select * from person2.client");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<Person> people = new ArrayList<>();
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            int age = resultSet.getInt("age");
//            String e_mail = resultSet.getString("e_mail");
//            int sum = resultSet.getInt("sum");
//            String currency = resultSet.getString("currency");
//            people.add(new Person(id,name,age,e_mail,sum,currency));
//        }
////        System.out.println(people);
//        Stream<Person> stream = people.stream();
//
//       List<Person> users = people.stream()
//                .sorted((o1, o2) -> o1.getId()- o2.getId())
//                .filter(person -> {return person.getSum()<10000 && person.getCurrency().equals("euro");})
//                .collect(Collectors.toList());
//
//        System.out.println(users);


//Створюємо базу. (важлива тільки таблиця з клієнтами) Створюємо модель під цю таблицю.
//Дістаємо всіх клієтів Сортуємо за кожним полем окремо
//Фільтруємо тих в кого пошта gmail.com + кредит меньше 7000 (в євро)
//Все робимо через stream api


        String url = "jdbc:mysql://localhost:3306/person2?useUnicode=true&serverTimezone=UTC";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement query = connection.prepareStatement("select * from client");
        ResultSet resultSet = query.executeQuery();
        ArrayList<Person> people = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String e_mail = resultSet.getString(4);
            int sum = resultSet.getInt(5);
            String currency = resultSet.getString(6);
            people.add(new Person(id,name,age,e_mail,sum,currency));
        }
        for (Person person : people) {
            System.out.println(person);
        }
//        System.out.println("_______________________-");
       List<Person> qwe  = people.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
//                .filter(person -> {return person.getSum()>5000 && person.getCurrency().equals("dollar");})
                .filter(person -> person.getCurrency().equals("euro"))
                .sorted((o1, o2) -> o2.getSum() - o1.getSum())
                .filter(person -> person.getE_mail().endsWith(".net"))
                .collect(Collectors.toList());
//        System.out.println(qwe);


        long count = people.stream().count();
        Person person = people.stream().findFirst().orElse(new Person(84, "xxx", 74, "dkdkcm@kfkfk", 5600, "euro"));
        boolean b = people.stream().anyMatch(person1 -> person1.getAge() == 20);
        boolean net = people.stream().noneMatch(person1 -> person1.getE_mail().endsWith("net"));
        Person person1 = people.stream().min((o1, o2) -> o1.getSum() - o2.getSum()).get();


    }
}
