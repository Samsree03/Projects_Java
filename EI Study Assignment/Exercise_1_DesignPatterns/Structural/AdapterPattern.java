interface NewSystem {
    void newRequest();
}

class OldSystem {
    public void oldRequest() {
        System.out.println("Old system request");
    }
}

class Adapter implements NewSystem {
    private OldSystem oldSystem;
    
    public Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }
    
    @Override
    public void newRequest() {
        oldSystem.oldRequest();  // Adapter converts call
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        OldSystem oldSystem = new OldSystem();
        NewSystem adapter = new Adapter(oldSystem);
        adapter.newRequest();
    }
}
