package com.example;

import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class App {
    
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Ввод: ");
            String bracketsInput = input.next();
            System.out.println(isValid(bracketsInput));
        }
    }
    
    static boolean isValid(String bracketsInput) {
        Deque<Character> bracketsDeque = new LinkedList<>();       
        for (int i = 0; i < bracketsInput.length(); i++) {
            if ((bracketsInput.charAt(i) == '(') || (bracketsInput.charAt(i) == '{') || (bracketsInput.charAt(i) == '[')) {
                bracketsDeque.offer(bracketsInput.charAt(i));
            }
            else {
                if (bracketsDeque.isEmpty()) return false;
                if ((bracketsDeque.peekLast() != '(') && (bracketsInput.charAt(i) == ')')) return false;
                if ((bracketsDeque.peekLast() != '{') && (bracketsInput.charAt(i) == '}')) return false;
                if ((bracketsDeque.peekLast() != '[') && (bracketsInput.charAt(i) == ']')) return false;
                bracketsDeque.removeLast();
            }
        }
        return bracketsDeque.isEmpty();
    }
}

