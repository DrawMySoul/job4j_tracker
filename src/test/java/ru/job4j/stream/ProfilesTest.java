package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void checkProfiles() {
        List<Profile> profiles = List.of(
                new Profile(new Address("St. Petersburg", "Lenin Street", 19, 17)),
                new Profile(new Address("Moscow", "Stalin street", 19, 37))
        );
        List<Address> expected = List.of(
                new Address("Moscow", "Stalin street", 19, 37),
                new Address("St. Petersburg", "Lenin Street", 19, 17)
        );
        List<Address> result = Profiles.collect(profiles);
        assertThat(result, is(expected));
    }

    @Test
    public void whenThereAreDuplicateItems() {
        List<Profile> profiles = List.of(
                new Profile(new Address("St. Petersburg", "Lenin Street", 19, 17)),
                new Profile(new Address("Moscow", "Stalin street", 19, 37)),
                new Profile(new Address("St. Petersburg", "Lenin Street", 19, 17)),
                new Profile(new Address("Moscow", "Stalin street", 19, 37))
        );
        List<Address> expected = List.of(
                new Address("Moscow", "Stalin street", 19, 37),
                new Address("St. Petersburg", "Lenin Street", 19, 17)
        );
        List<Address> result = Profiles.collect(profiles);
        assertThat(result, is(expected));
    }
}