package com.prayforme.shmuel.prayforme.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 01/04/2018.
 */

public class User {
    String ID;
    PrayForHim prayForMe;
    int perakimCount;
    ArrayList<String> prayingGroups=new ArrayList<>();
    Map<String,String> wishWall=new HashMap<>();

}
