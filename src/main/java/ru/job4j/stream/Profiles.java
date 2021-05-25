package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
        Comparator<Address> sortByCity = Comparator.comparing(Address::getCity);
        addresses.sort(sortByCity);
        return addresses.stream().distinct().collect(Collectors.toList());
    }
}
