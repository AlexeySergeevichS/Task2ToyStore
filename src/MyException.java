public class MyException extends Exception{
    private String info;
    public MyException(String message, String info) {
        super(message);
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
}