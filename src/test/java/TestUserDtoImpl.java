import org.hibernate_test.data.entities.User;
import org.hibernate_test.data.dto.UserDto;
import org.hibernate_test.data.dto.UserDtoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.hibernate_test.data.utils.Utils.getRandomApdeiter;
import static org.hibernate_test.data.utils.Utils.getRandomName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserDtoImpl {


    UserDto dto;

    @BeforeEach
    public void beforeEach() {
        dto = new UserDtoImpl();
    }


    @Test
    void testGetAllShouldReturnSavedUsers() { //TO-DO
        User user1 = new User("Kait", "Kaity");
        User user2 = new User("Halk", "Hogan");
        List<User> users = List.of(user1, user2);
        for (User user : users) {
            dto.addUser(user);
        }
        List<User> actual = dto.getAllUsers();
        assertEquals(users.get(0).getFirst_name(), actual.get(0).getFirst_name());
    }

    @Test
    void testIfEmpIsAdd() {
        User user = new User();
        user.setFirst_name("Olga");
        dto.addUser(user);
        User olga = dto.getById(user.getUserId());
        assertEquals(user.getFirst_name(), olga.getFirst_name());

    }

    @Test
    void testIfUserReturnByIdOk() {
        User user = new User(getRandomName(), getRandomName(), new java.util.Date(1L), new java.util.Date(1L),
                getRandomApdeiter(), new Date(1L), getRandomApdeiter());

        dto.addUser(user);

        User find = dto.getById(user.getUserId());
        assertEquals(user.getFirst_name(), find.getFirst_name());
    }

    @Test
    void testIfDeleteOk() {
        User user = new User(getRandomName(), getRandomName(), new java.util.Date(1L), new java.util.Date(1L),
                getRandomApdeiter(), new Date(1L), getRandomApdeiter());
        dto.addUser(user);
        dto.deleteUser(user);
        User find = dto.getById(user.getUserId());
        assertEquals(null, find);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(getRandomName(), getRandomName(), new java.util.Date(1L), new java.util.Date(1L),
                getRandomApdeiter(), new Date(1L), getRandomApdeiter());
        dto.addUser(user);
        user.setFirst_name("Jon");
        User user1 = dto.updateUser(user);
        User updated = dto.getById(user.getUserId());
        assertEquals(user1.getFirst_name(), updated.getFirst_name());
    }

}


