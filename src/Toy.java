/**
 * Игрушка
 */
public class Toy {
    /**
     * Количество видов игрушек, используется для формирования ID
     */
    private static int countTypeOfToys;
    /**
     * ID игрушки
     */
    private int id;
    /**
     * Название игрушки
     */
    private String toyName;
    /**
     * Вес игрушки (в % от 100)
     */
    private int toyWeight;

    /**
     * Конструктор
     *
     * @param toyName   имя создаваемой игрушки
     * @param toyWeight все создаваемой игрушки
     */
    private Toy(String toyName, int toyWeight) {
        this.id = ++countTypeOfToys;
        this.toyName = toyName;
        this.toyWeight = toyWeight;
    }

    /**
     * @param toyName   имя создаванмой игрушки
     * @param toyWeight вес создаваемой игрушки
     * @return Возвращает новый экземпляр Toy
     * @throws MyException ошибка преобразования строки в число
     */
    public static Toy create(String toyName, String toyWeight) throws MyException {
        int tempWeight;
        String info = "weight";
        try {
            tempWeight = Integer.parseInt(toyWeight);
            if (tempWeight < 1 || tempWeight > 100) {
                throw new MyException("Некорректный вес игрушки! Вес должен быть больше 0 и не больше 100!", info);
            }
        } catch (Exception e) {
            throw new MyException("Некорректный вес игрушки! Вес только целое число!", info);
        }
        return new Toy(toyName, tempWeight);
    }

    /**
     * Вес игрушки
     *
     * @return возвращает вес игрушки
     */
    public int getToyWeight() {
        return toyWeight;
    }

    /**
     * Редактирование веса созданной игрушки
     *
     * @param toyWeight новое значение веса
     * @throws MyException ошибка диапазона введенного числа
     */
    public void setToyWeight(int toyWeight) throws MyException {
        if (toyWeight < 1 || toyWeight > 100)
            throw new MyException("Некорректный вес игрушки! Вес должен быть больше 0 и не больше 100!", "weight");
        this.toyWeight = toyWeight;
    }

    @Override
    public String toString() {
        return String.format("Игрушка %s, ID= %d, Вес= %d", toyName, id, toyWeight);
    }
}