/*
 * У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
 *  Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
 */

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BookServiceTest {

    @Test
    public void testGetBookById() {
        // Создаем мок-объект BookRepository
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        // Создаем экземпляр BookService, передавая мок-объект в конструктор
        BookService bookService = new BookService(bookRepository);

        // Настроим мок-объект для возвращения предполагаемых данных
        Book expectedBook = new Book("123", "Sample Book");
        Mockito.when(bookRepository.getBookById("123")).thenReturn(expectedBook);

        // Вызываем метод, который должен использовать BookRepository
        Book result = bookService.getBookById("123");

        // Проверяем, что метод getBookById был вызван с нужными аргументами
        Mockito.verify(bookRepository).getBookById("123");

        // Проверяем, что результат совпадает с ожидаемым
        assertEquals(expectedBook, result);
    }
}
