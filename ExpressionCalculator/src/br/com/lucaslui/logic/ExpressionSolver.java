/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucaslui.logic;

import java.util.Stack;

/**
 *
 * @author lucas
 */
public class ExpressionSolver {

    public static double evaluate(String expression) {

        Stack<Double> numberStack = new Stack<>();
        Stack<Character> operationStack = new Stack<>();

        expression = expression.trim(); // elimina espaços antes e depois da expressão
        expression = expression.replaceAll("\\s+",""); // remove espaços dentro da expressão

        for (int i = 0; i < expression.length(); i++) {

            // Caso o elemento seja um número, trata e coloca ele no Stack dos números
            if (Character.isDigit(expression.charAt(i))) {
                StringBuilder numberBuffer = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numberBuffer.append(expression.charAt(i++));
                }
                i--;
                numberStack.push(Double.parseDouble(numberBuffer.toString()));
            } // Caso seja um parenteses a esquerda, insere o parentese no stack de operadores
            else if (expression.charAt(i) == '(') {
                operationStack.push(expression.charAt(i));
            } // Caso seja um parenteses a direita, resolve o ultimo par de elementos internos (já vai ter sido processado os demais elementos)
            else if (expression.charAt(i) == ')') {
                while (operationStack.peek() != '(') {
                    numberStack.push(AtomicEvaluate(numberStack.pop(), numberStack.pop(), operationStack.pop()));
                }
                operationStack.pop();
            } // Caso seja um operador, resolve resolve o par de números no stack se o operador atual tiver 
              // menor procedência que o anterior. E sempre coloca o operador atual no stack.
            else if (expression.charAt(i) == '^' || expression.charAt(i) == '*' || expression.charAt(i) == '/'
                    || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                while (operationStack.size() > 0 && TestPrecedence(expression.charAt(i), operationStack.peek())) {
                    numberStack.push(AtomicEvaluate(numberStack.pop(), numberStack.pop(), operationStack.pop()));
                }
                operationStack.push(expression.charAt(i));
            } else {
                throw new IllegalArgumentException("Expression element wrong");
            }
        }
        // Resolve as operações faltantes
        while (operationStack.size() > 0) {
            numberStack.push(AtomicEvaluate(numberStack.pop(), numberStack.pop(), operationStack.pop()));
        }
        return numberStack.pop();
    }

    // Função retorna verdadeiro somente se o operador atual tem menor procedencia 
    // que o anterior armazenado no stack
    private static Boolean TestPrecedence(char curr_op, char old_op) {
        if (old_op == '(' || old_op == ')') {
            return false;
        }
        if (curr_op == '^') {
            return false;
        }
        if ((curr_op == '*' || curr_op == '/') && (old_op == '+' || old_op == '-')) {
            return false;
        } else {
            return true;
        }
    }

    // Função que evaluate a expressão a nível mínimo desta
    private static double AtomicEvaluate(double b, double a, char operation) {
        switch (operation) {
            case '^':
                return Math.pow(a, b);
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return 0;
        }
    }
}
