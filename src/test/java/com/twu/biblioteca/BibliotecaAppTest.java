package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {
    PrintStream printStream;
    BibliotecaApp bibliotecaApp;
    Biblioteca biblioteca;
    BufferedReader bufferedReader;
    int bookId;

    @BeforeEach
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        bookId = 1;

        bibliotecaApp = new BibliotecaApp(printStream, bufferedReader, biblioteca);
    }

    @Test
    public void shouldShowWelcomeMessage() {
        bibliotecaApp.showWelcomeMessage();
        verify(printStream).println(BibliotecaApp.WELCOME_MESSAGE);
    }

    @Test
    public void shouldShowInvalidOptionMessage() {
        bibliotecaApp.showInvalidMenuOptionMessage();
        verify(printStream).println(BibliotecaApp.INVALID_OPTION_MESSAGE);
    }

    @Test
    public void shouldShowCheckoutBookMessageAndCallCheckoutBook() throws IOException {
        when(bufferedReader.readLine()).thenReturn(String.valueOf(bookId));
        bibliotecaApp.showCheckoutOption();
        verify(printStream).println(BibliotecaApp.CHECKOUT_BOOK_MESSAGE);
        verify(biblioteca).checkoutBook(bookId);
    }

    @Test
    public void shouldShowReturnBookOptionAndCallReturnBook() throws IOException {
        when(bufferedReader.readLine()).thenReturn(String.valueOf(bookId));
        bibliotecaApp.showReturnBookOption();
        verify(printStream).println(BibliotecaApp.RETURN_BOOK_OPTION);
        verify(biblioteca).returnBook(bookId);
    }
}