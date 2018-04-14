package com.prayforme.shmuel.prayforme.model.entities;

/**
 * Created by User on 01/04/2018.
 */

public class TehilimGroup {
    String groupID;
    String forWhoID;
    int dayOfWeek;
    int hour;
    int minute;
    String tehilimPerek[]=new String[150];
    int tehilimFinished;
    int numberOfUsers;

}
