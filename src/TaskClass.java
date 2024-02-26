public class TaskClass {
    /**
     * Запуск меню и ввода команд
     */
    public static void run() {
        Magazin mag = new Magazin();
        String command;
        while (true) {
            command = InputData.inputStr("Введи команду (помощь - help)\n-> ").toLowerCase();
            if (command.isEmpty()) {
                System.out.println("Завершение работы приложения.");
                break;
            }
            switch (command) {
                case "help" -> {
                    System.out.println("++++++++++++");
                    System.out.println("Список команд:");
                    System.out.println("add - добавление игрушки");
                    System.out.println("edit - изменить вес игрушки");
                    System.out.println("start - начать розыгрыш и сделать запись в файл");
                    System.out.println("print - вывод ассортимента");
                    System.out.println("clear - очистка ассортимента");
                    System.out.println("пустая строка - выход");
                    System.out.println("++++++++++++");
                }
                case "clear" -> mag.clear();
                case "add" -> {
                    System.out.println("+++ Добавление игрушки +++");
                    String toyName = InputData.inputStr("Название: ");
                    String toyCount = InputData.inputStr("Количество: ");
                    String toyWeight = InputData.inputStr("Вес(в % от 100): ");
                    while (true) {
                        try {
                            mag.addToy(Toys.create(Toy.create(toyName, toyWeight), toyCount));
                            break;
                        } catch (MyException e) {
                            System.out.println(e.getMessage());
                            switch (e.getInfo()) {
                                case "count" -> toyCount = InputData.inputStr("Количество: ");
                                case "weight" -> toyWeight = InputData.inputStr("Вес(в % от 100): ");
                            }
                        }
                    }
                    System.out.println("+++ Игрушка добавлена! +++");
                }
                case "edit" -> {
                    int toyId ;
                    if (!mag.isEmpty()) {
                        System.out.println("+++ Изменение веса игрушки +++");
                        command = InputData.inputStr(String.format("Всего видов игрушек %d\nВведи id игрушки: ", mag.getTypeOfToysCount()));
                        while (true) {
                            try {
                                toyId = Integer.parseInt(command);
                                break;
                            } catch (Exception e) {
                                System.out.println("Некорректный id! Нужно целое число!");
                                command = InputData.inputStr(String.format("Всего видов игрушек %d\nВведи id игрушки: ", mag.getTypeOfToysCount()));
                            }
                        }
                        command = InputData.inputStr("Новый вес(в % от 100): ");
                        while (true) {
                            try {
                                mag.setNewWeight(toyId - 1, command);
                                break;
                            } catch (MyException e) {
                                System.out.println(e.getMessage());
                                command = InputData.inputStr("Новый вес(в % от 100): ");
                            }
                        }
                        System.out.printf("+++ Вес игрушки c ID %d изменен! +++\n", toyId);
                    } else {
                        System.out.println("Нет игрушек для изменения веса. Нужно добавить игрушки в магазин.");
                    }

                }
                case "start" -> {
                    if (!mag.isEmpty() && mag.allToyCount()>0 ) {
                        command = InputData.inputStr("Количество розыгрышей: ");
                        int count;
                        while (true) {
                            try {
                                count = Integer.parseInt(command);
                                break;
                            } catch (Exception e) {
                                System.out.println("Нужно ввести целое число!");
                                command = InputData.inputStr("Количество розыгрышей: ");
                            }
                        }
                        start(mag, count);
                    } else {
                        System.out.println("Нет игрушек для розыгрыша. Нужно добавить игрушки в магазин.");
                    }
                }
                case "aa" -> testMag(mag);
                case "print" -> {
                    System.out.println("++++ Список игрушек ++++");
                    mag.printAllToys();
                    System.out.println("++++");
                }
                default -> System.out.println("Неверная команда!");
            }
        }
    }

    /**
     * Запуск розыгрышей
     *
     * @param mag магазин с игрушками
     * @param n   количество розыгрышей
     */
    private static void start(Magazin mag, int n) {
        try {
            DataToFile.fileCreate(mag.getPrize(n));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Тестовый набор игрушек для магазина
     *
     * @param mag Магазин, в который добавить 5 игрушек
     */
    private static void testMag(Magazin mag) {
        try {
            mag.addToy(Toys.create(Toy.create("Игрушка1", "20"), "10"));
            mag.addToy(Toys.create(Toy.create("Игрушка2", "20"), "10"));
            mag.addToy(Toys.create(Toy.create("Игрушка3", "6"), "10"));
            mag.addToy(Toys.create(Toy.create("Игрушка4", "95"), "10"));
            mag.addToy(Toys.create(Toy.create("Игрушка5", "10"), "10"));
            System.out.println("5 видов игрушек добавлены!");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
