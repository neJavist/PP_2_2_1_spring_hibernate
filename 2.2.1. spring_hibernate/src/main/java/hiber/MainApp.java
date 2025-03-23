package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        Car car1 = new Car("1",1);
        Car car2 = new Car("2",2);
        Car car3 = new Car("3",3);
        Car car4 = new Car("4",4);

        User user1 = new User("1","1", "1");
        User user2 = new User("2","2", "2");
        User user3 = new User("3","3", "3");
        User user4 = new User("4","4", "4");

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        users.forEach(System.out::println);

        List<User> usersByCar1 = userService.listUsersByCar("2", 2);
        usersByCar1.forEach(System.out::println);

        List<User> userByCar2 = userService.listUsersByCar("4", 4);
        userByCar2.forEach(System.out::println);

        context.close();
    }
}
