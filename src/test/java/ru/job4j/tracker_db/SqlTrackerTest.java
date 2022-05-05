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
        Item item = tracker.add(new Item("Item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndThenReplaceItNameMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("newItem"));
        assertTrue(tracker.replace(item.getId(), new Item("replecedItem")));
        assertThat(tracker.findById(item.getId()).getName(), is("replecedItem"));
    }

    @Test
    public void whenSaveItemAndDeleteThenMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("newItem;"));
        assertTrue(tracker.delete(item.getId()));
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenSaveItemsAndFindAllThenMustBeTheSameList() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("Item1"));
        Item item2 = tracker.add(new Item("Item2"));
        assertThat(tracker.findAll(), is(List.of(item1, item2)));
    }

    @Test
    public void whenSaveItemAndFindByNameThenMustBeTheSameList() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("Item"));
        tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        Item item1 = tracker.add(new Item("Item"));
        assertThat(tracker.findByName("Item"), is(List.of(item, item1)));
    }

    @Test
    public void whenSaveItemAndFindByIdThenMustBeTheSameId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("Item"));
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }
}