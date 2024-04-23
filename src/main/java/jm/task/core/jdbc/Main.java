package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Ivan", "Ivanov", (byte) 30);
        userService.saveUser("Petr", "Petrov", (byte) 17);
        userService.saveUser("Sidor", "Sidorov", (byte) 29);

        userService.getAllUsers().forEach(System.out :: println);
        userService.cleanUsersTable();
        userService.dropUsersTable();

        // реализуйте алгоритм здесь
    }
}
