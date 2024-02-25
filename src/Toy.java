public class Toy {
    private int id;
    private String toyName;
    private int toyWeight;
    private Toy(int id, String toyName, int toyWeight) {
        this.id = id;
        this.toyName = toyName;
        this.toyWeight = toyWeight;
    }
    public static Toy create(String toyId, String toyName,String toyWeight) throws Exception{
        int tempId ;
        int tempWeight;
        try{
            tempId = Integer.parseInt(toyId);
        }
        catch (Exception e)
        {
            throw new Exception("Некорректный ID игрушки! ID только целое число!");
        }
        try{
            tempWeight = Integer.parseInt(toyWeight);
            if (tempWeight<1){
                throw new Exception("Некорректный вес игрушки! Вес должен быть больше 0!");
            }
        }
        catch (Exception e)
        {
            throw new Exception("Некорректный вес игрушки! Вес только целое число!");
        }
        return new Toy(tempId,toyName,tempWeight);
    }
    public String getId() {
        return String.valueOf(id);
    }
    public String getToyName() {
        return toyName;
    }
    public int getToyWeight(){
        return toyWeight;
    }
    public String getToyStringWeight() {
        return String.valueOf(toyWeight);
    }
}
