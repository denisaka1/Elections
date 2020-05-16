package model;

import java.util.ArrayList;
import java.util.List;

public class Set<T> {
    private final Class<T> typeParameterClass;
    private List<T> set;

    /************* Constructor *************/
    public Set(T object, Class<T> typeParameterClass) {
        setObject(object);
        this.typeParameterClass = typeParameterClass;
    }

    public Set(Class<T> typeParameterClass) {
        this(null, typeParameterClass);
    }


    /************ Set Functions ************/
    private boolean setObject(T object) {
        this.set = new ArrayList<T>();

        if (object != null) {
            this.set.add(object);
            return true;
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

    public Class<T> getType() {
        return typeParameterClass;
    }

    /************** Functions **************/
    public boolean add(T object) {
        if (set.contains(object))
            return false;
        set.add(object);
        return true;
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