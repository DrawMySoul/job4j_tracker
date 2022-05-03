package ru.job4j.tracker_db;

import org.junit.*;
import ru.job4j.tracker_db.model.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                config.getProperty("url"),
                config.getProperty("username"),
                config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void addTest(){
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("newItem");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void replaceTest() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("newItem");
        tracker.add(item);
        assertTrue(tracker.replace(item.getId(), new Item("replecedItem")));
        assertThat(tracker.findById(item.getId()).getName(), is("replecedItem"));
    }

    @Test
    public void deleteTest() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("newItem");
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void findAllTest() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> expected = List.of(new Item("item1"), new Item("item2"));
        for (Item item :expected) {
            tracker.add(item);
        }
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void findByNameTest() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("newItem");
        tracker.add(item);
        assertThat(tracker.findByName("newItem"), is(List.of(item)));
    }

    @Test
    public void findByIdTest() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("newItem");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }
}