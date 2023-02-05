package com.example.alworithmss_2;

public interface ListIntegerInteface {
    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    Integer add(Integer number) throws IntegerListException, IntegerListException;

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    Integer add(int index, Integer number) throws IntegerListException, IntegerListException;

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    Integer set(int index, Integer number) throws IntegerListException, IntegerListException;

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    Integer remove(Integer number) throws IntegerListException, IntegerListException;

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    Integer remove(int index) throws IntegerListException, IntegerListException;

    // Проверка на существование элемента.
    // Вернуть true/false;
    boolean contains(Integer number) throws IntegerListException;

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int indexOf(Integer number);

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int lastIndexOf(Integer number);

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    Integer get(int index) throws IntegerListException, IntegerListException;

    // Вернуть фактическое количество элементов.
    int size() throws IntegerListException;

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    boolean isEmpty();

    // Удалить все элементы из списка.
    void clear();

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    Integer[] toArray() throws IntegerListException;

}
