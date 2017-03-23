package de.kriegergilde.daily;

import android.widget.TextView;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Klaus on 05.05.2015.
 */
public class Discipline implements Serializable {

    private String id;
    private long startDate;
    private long regenerationInterval;
    private long repeatsPerTraining;
    private long repeatsActual;
    private transient long repeatsOutstanding;

    public Discipline(String id, long startDate, long regenerationIntervall, long repeatsPerTraining, long repeatsActual) {
        this.id = id;
        this.startDate = startDate;
        this.regenerationInterval = regenerationIntervall;
        this.repeatsPerTraining = repeatsPerTraining;
        this.repeatsActual = repeatsActual;
    }

    public void incBy(long amount){
        repeatsActual += amount;
        recalc();
    }

    public void recalc(){
        long today = System.currentTimeMillis();
        long timePassed = today - startDate;
        if (timePassed < 0){
            repeatsOutstanding = 0; // wg. prob von div bei neg. werten!
        }else {
            long intervalsPassed = timePassed / regenerationInterval;
            long repeatsTarget = (intervalsPassed + 1) * repeatsPerTraining;
            repeatsOutstanding = repeatsTarget - repeatsActual;
        }

    }

    public String getId() {
        return id;
    }

    public long getStartDate() {
        return startDate;
    }

    public long getRegenerationIntervall() {
        return regenerationInterval;
    }

    public long getRepeatsPerTraining() {
        return repeatsPerTraining;
    }

    public long getRepeatsActual() {
        return repeatsActual;
    }

    public long getRepeatsOutstanding() {
        return repeatsOutstanding;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id='" + id + '\'' +
                ", startDate=" + startDate +
                ", regenerationInterval=" + regenerationInterval +
                ", repeatsPerTraining=" + repeatsPerTraining +
                ", repeatsActual=" + repeatsActual +
                ", repeatsOutstanding=" + repeatsOutstanding +
                '}';
    }
}
