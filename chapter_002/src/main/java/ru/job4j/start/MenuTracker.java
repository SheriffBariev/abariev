package ru.job4j.start;

import ru.job4j.encapsulation.Item;
import ru.job4j.encapsulation.Tracker;
import ru.job4j.multiformity.BaseAction;
import ru.job4j.multiformity.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * Внешний класс exit переопределяем методы UserAction.
 */
class Exit extends BaseAction {
    public Exit(String name, int key) {
        super(name, key);
    }
    public int key() {
        return 6;
    }

    public void execute(Input input, Tracker tracker) {
        System.exit(0);

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
    private List<UserAction> actions = new ArrayList<>();
    public List<Integer> getActions() {
        List<Integer> array = new ArrayList<>();
        for (UserAction i : actions) {
            array.add(i.key());
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
        actions.add(new AddItem("Add new Item", 0));
        actions.add(new ShowAll("Show all items", 1));
        actions.add(new EditItem("Edit item", 2));
        actions.add(new DeleteItem("Delete item", 3));
        actions.add(new FindById("Find item by Id", 4));
        actions.add(new FindByName("Find items by name", 5));
        actions.add(new Exit("Exit Program.", 6));
    }

    /**
     * Метод выбора действия.
     * @param key ключ.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
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
    private class AddItem extends BaseAction {
        public AddItem(String name, int key) {
            super(name, key);
        }
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the Item`s name: ");
            String desc = input.ask("Please enter the Item`s desc: ");
            tracker.add(new Item(name, desc));
        }
    }
    /**
     * Приватный класс ShowAll переопределяем методы UserAction.
     */
    private class ShowAll extends BaseAction {
        public ShowAll(String name, int key) {
            super(name, key);
        }
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (int index = 0; index != tracker.findAll().size(); index++) {
                if (tracker.findAll().get(index) != null) {
                    System.out.println(String.format("%s, %s, %s",
                            tracker.findAll().get(index).getId(),
                            tracker.findAll().get(index).getName(),
                            tracker.findAll().get(index).getDesc()));
                }
            }
        }
    }
    /**
     * Приватный класс EditItem переопределяем методы UserAction.
     */
    private static class EditItem extends BaseAction {
        public EditItem(String name, int key) {
            super(name, key);
        }
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
    }
    /**
     * Приватный класс DeleteItem переопределяем методы UserAction.
     */
    private class DeleteItem extends BaseAction {
        public DeleteItem(String name, int key) {
            super(name, key);
        }
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete application --------------");
            String id = input.ask("Enter the Id of the application : ");
            tracker.delete(tracker.findById(id));
            System.out.println("------------ Removed --------------");

        }
    }
    /**
     * Приватный класс FindById переопределяем методы UserAction.
     */
    private class FindById extends BaseAction {
        public FindById(String name, int key) {
            super(name, key);
        }
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of the application : ");
            System.out.println("------------ Application found by ID is :" + tracker.findById(id));

        }

    }
    /**
     * Приватный класс FindByName переопределяем методы UserAction.
     */
    private class FindByName extends BaseAction {
        public FindByName(String name, int key) {
            super(name, key);
        }
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter the name of the application : ");
            System.out.println("------------ Application found by name is :" + tracker.findByName(name));

        }
    }
}
