/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.candhcapital.Stratagem;

import java.time.ZoneId;

/**
 *
 * @author benhernandez
 */
public class TimeStampTzSplit {

  public int getYear() {
    return year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public int getSecond() {
    return second;
  }

  public int getNano() {
    return nano;
  }

  public ZoneId getZone() {
    return zone;
  }
  private int year;
  private int month;
  private int day;
  private int hour;
  private int minute;
  private int second;
  private int nano;
  private ZoneId zone;
  public TimeStampTzSplit(final String timestamptz) {
    String modifiable = timestamptz;
    int index = modifiable.indexOf("-");
    year = Integer.parseInt(timestamptz.substring(0, index));
    modifiable = modifiable.substring(index + 1);

    index = modifiable.indexOf(("-"));
    month = Integer.parseInt(modifiable.substring(0, index));
    modifiable = modifiable.substring(index + 1);

    index = modifiable.indexOf(" ");
    day = Integer.parseInt(modifiable.substring(0, index));
    modifiable = modifiable.substring(index + 1);

    index = modifiable.indexOf(":");
    hour = Integer.parseInt(modifiable.substring(0, index));
    modifiable = modifiable.substring(index + 1);
    //        2016-03-11 07:30:00.119-07
    
    index = modifiable.indexOf(":");
    minute = Integer.parseInt(modifiable.substring(0, index));
    modifiable = modifiable.substring(index + 1);
    
    index = modifiable.indexOf(".");
    second = Integer.parseInt(modifiable.substring(0, index));
    modifiable = modifiable.substring(index + 1);
    
    index = modifiable.indexOf("-");
    if (index == -1) {
      index = modifiable.indexOf("+");
    }
    nano = Integer.parseInt(modifiable.substring(0, index));
    // To convert to nanoseconds;
    nano = nano * 1000000;
    
    modifiable = modifiable.substring(index);
    zone = ZoneId.of(modifiable);
  }
}
