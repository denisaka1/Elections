package core;

import java.util.ArrayList;
import java.util.List;

public class Set<T> {
    private List<T> set;

    public Set(T object) {
        setObject(object);
    }

    private boolean setObject(T object) {
        this.set = new ArrayList<T>();

        if (object != null){
            this.set.add(object);
            return true;
        }
        return false;
    }

    public int size(){
        return set.size();
    }

    public boolean add(T object) {
        return this.set.add(object);
    }

    public boolean remove(T object) {
        return set.remove(object);
    }

    public List<T> getSet(){
        return set;
    }

    public boolean equals(Set<T> object) {
        return set.equals(object);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("The Set Contains: {");
        for(int i = 0; i < set.size(); i++) {
            sb.append(set.get(i) + ",");
        }
        sb.replace(set.size(), set.size(), "}");

        return sb.toString();
    }

}
