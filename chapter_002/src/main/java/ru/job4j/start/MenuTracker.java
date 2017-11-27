package ru.job4j.start;

import ru.job4j.encapsulation.Item;
import ru.job4j.encapsulation.Tracker;
import ru.job4j.multiformity.Input;

/**
 * Внешний класс exit переопределяем методы UserAction.
 */
class Exit implements UserAction {
    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {
        System.exit(0);

    }

    public String info() {
        return String.format("%s. %s", this.key(), "Exit Program.");
    }
}
/**
 * Menu.
 * @author Ayub Bariev.
 * @since 26.11.2017
 */
public class MenuTracker {
    /**
     * Приватный объект input.
     */
    private Input input;
    /**
     * Приватный объект tracker.
     */
    private Tracker tracker;
    /**
     * Приватный массив userAction.
     */
    private UserAction[] actions = new UserAction[7];
    public int[] getActions() {
        int[] array = new int[actions.length];
        for (int index = 0; index != actions.length; index++) {
            array[index] = index;
        }
        return array;
    }
    /**
     * Конструкто меню трекера.
     * @param input объект ввод.
     * @param tracker объект трекер.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Заполнение.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAll();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new Exit();
    }

    /**
     * Метод выбора действия.
     * @param key ключ.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * метод показывает информацию действия.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Приватный класс AddItem переопределяем методы UserAction.
     */
    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the Item`s name: ");
            String desc = input.ask("Please enter the Item`s desc: ");
            tracker.add(new Item(name, desc));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item.");
        }
    }
    /**
     * Приватный класс ShowAll переопределяем методы UserAction.
     */
    private class ShowAll implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (int index = 0; index != tracker.findAll().length; index++) {
                if (tracker.findAll()[index] != null) {
                    System.out.println(String.format("%s, %s, %s",
                            tracker.findAll()[index].getId(),
                            tracker.findAll()[index].getName(),
                            tracker.findAll()[index].getDesc()));
                }
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }
    /**
     * Приватный класс EditItem переопределяем методы UserAction.
     */
    private static class EditItem implements UserAction {
        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the ID of the application : ");
            String name = input.ask("Enter the name of the application : ");
            String desc = input.ask("Enter the description of the application : ");
            Item item = new Item(name, desc);
            item.setId(id);
            tracker.update(item);
            String.format("%s. %s. %s", item.getId(), item.getName(), item.getDesc());
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }
    /**
     * Приватный класс DeleteItem переопределяем методы UserAction.
     */
    private class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete application --------------");
            String id = input.ask("Enter the Id of the application : ");
            tracker.delete(tracker.findById(id));
            System.out.println("------------ Removed --------------");

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }
    /**
     * Приватный класс FindById переопределяем методы UserAction.
     */
    private class FindById implements UserAction {
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of the application : ");
            System.out.println("------------ Application found by ID is :" + tracker.findById(id));

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }
    }
    /**
     * Приватный класс FindByName переопределяем методы UserAction.
     */
    private class FindByName implements UserAction {
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter the name of the application : ");
            System.out.println("------------ Application found by name is :" + tracker.findByName(name));

        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name.");
        }
    }


}
