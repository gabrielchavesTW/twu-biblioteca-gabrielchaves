package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class BibliotecaApp {


    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Biblioteca biblioteca;
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String MENU = "----------------------------------------------------------------------------------------------------------" +
            "\n1- List of books\n2- Checkout a book\n3-Return a book\n0- Exit\n" +
            "----------------------------------------------------------------------------------------------------------";
    public static final String INVALID_OPTION_MESSAGE = "\nInvalid option.";
    public static final String CHECKOUT_BOOK_MESSAGE = "\nType the number of the book to checkout it.";
    public static final String RETURN_BOOK_OPTION = "\nType the book number that you want to return:";


    public BibliotecaApp(PrintStream printStream, BufferedReader bufferedReader, Biblioteca biblioteca) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.biblioteca = biblioteca;
    }

    public void showWelcomeMessage() {
        printStream.println(WELCOME_MESSAGE);
    }

    public void showMenu() throws IOException {
        printStream.println(MENU);
        readMenuOption();
    }

    public void readMenuOption() throws IOException {
        String menuOption = bufferedReader.readLine();
        showSelectedMenuOption(menuOption);
    }

    private void showSelectedMenuOption(String menuOption) throws IOException {
        if (menuOption.equals("1")) {
            biblioteca.showListOfBooks();
        } else if (menuOption.equals("2")) {
            showCheckoutOption();
        } else if (menuOption.equals("3")) {
            showReturnBookOption();
        } else if (menuOption.equals("0")) {
            System.exit(0);
        } else {
            showInvalidMenuOptionMessage();
        }

        showMenu();
    }

    public void showInvalidMenuOptionMessage() {
        printStream.println(INVALID_OPTION_MESSAGE);
    }


    public void showCheckoutOption() throws IOException {
        printStream.println(CHECKOUT_BOOK_MESSAGE);
        readCheckoutOption();
    }

    private void readCheckoutOption() throws IOException {
        String checkoutOption = bufferedReader.readLine();
        biblioteca.checkoutBook(Integer.parseInt(checkoutOption));
    }

    public void showReturnBookOption() throws IOException {
        printStream.println(RETURN_BOOK_OPTION);
        readReturnBookOption();
    }

    private void readReturnBookOption() throws IOException {
        String returnBookOption = bufferedReader.readLine();
        biblioteca.returnBook(Integer.parseInt(returnBookOption));
    }
}
