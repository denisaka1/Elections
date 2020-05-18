package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Set<T> {
    private List<T> set;
    private T t; // contains T type // need ?

    /************* Constructor *************/
    public Set(T object) {
        setObject(object);
    }

    public Set(Set<T> objects) {
        Collections.copy(this.set, objects.getSet());
    }

    public Set() {
        set = new ArrayList<T>();
    }

    /************ Set Functions ************/
    private boolean setObject(T object) {
        if (object != null)
            return set.add(object);
        return false;
    }

    private boolean setObjects(T... objects) {
        set = new ArrayList<T>();
        try {
            for (T object: objects) {
                add(object);
            }
            return true;
        } catch (NullPointerException npe) {
            System.out.println("Can't add null to list!");
        }
        return false;
    }

    /************ Get Functions ************/
    public int size() {
        return set.size();
    }

    public List<T> getSet() {
        return set;
    }

    public T get(int index) {
        return set.get(index);
    }

    public T getType() {
        return (T)t.getClass();
    }

    /************** Functions **************/
    public boolean add(T object) {
        if (t == null) {
            t = object;
        }
        if (!set.contains(object))
            return set.add(object);
        return false;
    }

    public boolean remove(T object) {
        return set.remove(object);
    }

    public boolean equals(Set<T> object) {
        return set.equals(object);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("The Set Contains: {");
        for (int i = 0; i < set.size(); i++) {
            sb.append(set.get(i) + ",");
        }
        sb.replace(set.size(), set.size(), "}");

        return sb.toString();
    }
}