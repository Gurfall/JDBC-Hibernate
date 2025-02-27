package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan","Zaharov", (byte) 66);
        userService.saveUser("Egor","Ivanov", (byte) 16);
        userService.saveUser("Mike","Jackson", (byte) 32);
        userService.saveUser("Jack","Black", (byte) 45);
        userService.saveUser("Joe","Gump", (byte) 45);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
