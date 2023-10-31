package com.tom.java.test.hackerrank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/*
photo.jpg, Warsaw, 2013-09-05 14:08:15
john.png, London, 2015-06-20 15:13:22
myFriends.png, Warsaw, 2013-09-05 14:07:13
Eiffel.jpg, Paris, 2015-07-23 08:03:02
pisatower.jpg, Paris, 2015-07-22 23:59:59
BOB.jpg, London, 2015-08-05 00:02:03
notredame.png, Paris, 2015-09-01 12:00:00
me.jpg, Warsaw, 2013-09-06 15:40:22
a.png, Warsaw, 2016-02-13 13:33:50
b.jpg, Warsaw, 2016-01-02 15:12:22
c.jpg, Warsaw, 2016-01-02 14:34:30
d.jpg, Warsaw, 2016-01-02 15:15:01
e.png, Warsaw, 2016-01-02 09:49:09
f.png, Warsaw, 2016-01-02 10:55:32
g.jpg, Warsaw, 2016-02-29 22:13:11


Warsaw02.jpg
London1.png
Warsaw01.png
Paris2.jpg
Paris1.jpg
London2.jpg
Paris3.png
Warsaw03.jpg
Warsaw09.png
Warsaw07.jpg
Warsaw06.jpg
Warsaw08.jpg
Warsaw04.png
Warsaw05.png
Warsaw10.jpg

 */
public class Main {

    public static void main(String[] args) throws Exception {
        String s = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
                "john.png, London, 2015-06-20 15:13:22\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11";
        solution(s);
    }

    public static String solution(String S) throws Exception {
        String[] strArr = S.split("\n");
        List<String> photoStrs = new ArrayList<>();
        for (String s : strArr) {
            photoStrs.add(s);
        }

        List<Photo> list = new ArrayList<>();
        Map<String, List<Photo>> map = new HashMap<>();
        String result = "";

        // creates photos line by line and add them to the list
        for (String photoStr : photoStrs) {
            String[] tokens = photoStr.split(",\\s+");

            String suffix = tokens[0].substring(tokens[0].lastIndexOf(".") + 1);
            String city = tokens[1];
            DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(tokens[2]);
            list.add(new Photo(suffix, city, date));
        }

        // groups photos by city
        for (Photo pic : list) {
            List<Photo> temp = map.getOrDefault(pic.getCity(), new ArrayList<>());
            temp.add(pic);
            map.put(pic.getCity(), temp);
        }


        // generates the final string
        for (int i = 0; i < list.size(); i++) {
            Photo p = list.get(i);
            List<Photo> myLisSort = map.get(p.getCity());
            Collections.sort(myLisSort);
            int counter = myLisSort.indexOf(p) + 1;
            String leadingZeros = "";
            if (myLisSort.size() >= 10 && counter < 10) {
                leadingZeros = "0";
            }
            p.setCity(p.getCity() + leadingZeros + counter);
            result = result + p + "\n";
        }
        System.out.println(result);
        return result;
    }

}

class Photo implements Comparable<Photo> {
    private String city;
    private String suffix;
    private Date takenTime;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getTakenTime() {
        return takenTime;
    }

    public void setTakenTime(Date takenTime) {
        this.takenTime = takenTime;
    }

    public Photo(String suffix, String city, Date takenTime) {
        this.suffix = suffix;
        this.city = city;
        this.takenTime = takenTime;
    }

    @Override
    public int compareTo(Photo o) {
        return this.getTakenTime().compareTo(o.getTakenTime());
    }

    @Override
    public String toString() {
        return city + "." + suffix;
    }
}
