package miu.hotel.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guests {

    public static List<Guest> guestlist = new ArrayList<>();
    static {

        guestlist.add(new Guest("000001","Duy Hanh","Nguyen",  LocalDate.of(1990, 1, 13)  ,"FairField IA","Male"));
        guestlist.add(new Guest("000002","Duy Thai","Nguyen",  LocalDate.of(1991, 1, 13)  ,"FairField IA","Male"));
        guestlist.add(new Guest("000003","Van Thai","Nguyen",  LocalDate.of(1992, 1, 13)  ,"FairField IA","Male"));
        guestlist.add(new Guest("000004","Nhan","Vo",  LocalDate.of(1993, 1, 13)  ,"FairField IA","Male"));
    }

    public static void removeById(String guestId) {
        System.out.println("Remote "+guestId);
        guestlist = guestlist.stream().filter( e -> !e.getId().equals(guestId)).collect(Collectors.toList());
        guestlist.forEach(e -> System.out.println(e.getFirsName()) );
    }
}
