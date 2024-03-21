package org.hibernate_test.data.utils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static String getRandomName(){
        List<String> list = Arrays.asList("Boris"," Jonson", "Junior"," Second", "Kait"," Midelton", "Ormando"," Banuchi",
                "Boby"," Faraday","Pablo"," Eskobar","Kristy"," K","Amanda"," Urega","Sofi"," Terner");
        return list.get(ThreadLocalRandom.current().nextInt(18));
    }

    public static String getRandomApdeiter(){
        List<String> list = Arrays.asList("Admin", "some user", "worker33", "Director", "Tarantino");
        return list.get(ThreadLocalRandom.current().nextInt(5));
    }
}
