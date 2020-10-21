package miu.hotel.database;

import miu.hotel.model.Guest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guests {

    public static List<Guest> guestlist = new ArrayList<>();
    static {

        Guest  guest1 = new Guest("000001","Duy Hanh","Nguyen",  LocalDate.of(1990, 1, 13)  ,"FairField IA","Male");
        guest1.setCreatedDate(LocalDate.now().minusDays(10));
//        guest1.setCreatedMonth(1)
//        guest1.setCreatedYear(13);
        Guest  guest2=new Guest("000002","Duy Thai","Nguyen",  LocalDate.of(1991, 1, 13)  ,"FairField IA","Male");
        guest2.setCreatedDate(LocalDate.now().minusDays(30));
//        guest2.setCreatedMonth(9);
//        guest2.setCreatedYear(13);
        Guest  guest3=new Guest("000003","Van Thai","Nguyen",  LocalDate.of(1992, 1, 13)  ,"FairField IA","Male");
        guest3.setCreatedDate(LocalDate.now().minusDays(90));
//        guest1.setCreatedMonth(1);
//        guest1.setCreatedYear(13);
        Guest  guest4=new Guest("000004","Nhan","Vo",  LocalDate.of(1993, 1, 13)  ,"FairField IA","Male");
        guest4.setCreatedDate(LocalDate.now().minusDays(365));
        //        guest1.setCreatedYear(2020);
//        guest1.setCreatedMonth(10);
//        guest1.setCreatedYear(13);
        guestlist.add(guest1);
        guestlist.add(guest2);
        guestlist.add(guest3);
        guestlist.add(guest4);
    }

    public static void removeById(String guestId) {
        System.out.println("Remote "+guestId);
        guestlist = guestlist.stream().filter( e -> !e.getId().equals(guestId)).collect(Collectors.toList());
        guestlist.forEach(e -> System.out.println(e.getFirsName()) );
    }
}
