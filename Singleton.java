class Singleton {

    private int val;
    private Singleton() {
        this.val = 5;
    }

    public int getVal() {
        return val;
    }

    private static class InitializerClass {
        private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
        return InitializerClass.INSTANCE;
    }
}
