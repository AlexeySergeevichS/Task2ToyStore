public class Toys {
    private Toy toy;
    private int toyCount;
    /**
     * Доступность для выбора (если false, то данной модификации игрушек нет в наличии)
     */
    private boolean enabled;

    /**
     * Конструктор
     *
     * @param toy      игрушка
     * @param toyCount количество
     */
    private Toys(Toy toy, int toyCount) {
        this.toy = toy;
        this.toyCount = toyCount;
        enabled = toyCount > 0;
    }

    /**
     * Создание Игрушек
     *
     * @param t     игрушка
     * @param count количество
     * @return возвращает новый экземпляр Toys
     * @throws MyException ошибка преобразования строки в число
     */
    public static Toys create(Toy t, String count) throws MyException {
        int tempCount;
        String info = "count";
        try {
            tempCount = Integer.parseInt(count);
            if (tempCount < 1) {
                throw new MyException("Некорректное количество игрушки! Количество должно быть больше 0!", info);
            }
        } catch (Exception e) {
            throw new MyException("Некорректное количество игрушки! Количество только целое число!", info);
        }
        return new Toys(t, tempCount);
    }

    /**
     * Количество конкретной игрушки
     *
     * @return возвращает количество конкретного вида игрушек
     */
    public int getToyCount() {
        return toyCount;
    }

    @Override
    public String toString() {
        return toy + String.format(", Кол-во= %d", toyCount);
    }

    /**
     * Игрушка
     *
     * @return возвращает Toy
     */
    public Toy getToy() {
        return toy;
    }

    /**
     * Уменьшение количества конкретного вида игрушек на 1 шт
     */
    public void reduceToyCount() {
        if (enabled) {
            toyCount--;
            if (toyCount == 0) {
                enabled = false;
            }
        }
    }
}