public class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MyTestingClass)) {
            return false;
        }
        
        MyTestingClass other = (MyTestingClass) obj;
        return this.id == other.id;
    }
}