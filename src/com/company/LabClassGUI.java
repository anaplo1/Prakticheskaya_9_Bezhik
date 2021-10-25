package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LabClassGUI extends JFrame {
    private JButton button3 = new JButton("Ввод новых покупателей");
    private JButton button4 = new JButton("Поиск по ID");
    private JButton button5 = new JButton("Поиск по ФИО");
    private JButton button6 = new JButton("Вывод списка на экран");
    private JButton button7 = new JButton("Отсортировать список");
    private JLabel label0 = new JLabel("Меню: ");
    private JLabel space = new JLabel("");
    private JTextField field= new JTextField("", 5);
    protected LabClass Operations = new LabClass();
    protected ArrayList<Student> A = new ArrayList<>();
    public LabClassGUI(){
        this.setBounds(100, 100, 400, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container form = this.getContentPane();
        form.setLayout(new GridLayout(4,3,2,2));
        form.add(label0);
        form.add(field);
        form.add(space);
        button3.addActionListener(new ButtonEvent1());
        form.add(button3);
        button4.addActionListener(new ButtonEvent2());
        form.add(button4);
        button5.addActionListener(new ButtonEvent3());
        form.add(button5);
        button7.addActionListener(new ButtonEvent5());
        form.add(button7);
        button6.addActionListener(new ButtonEvent4());
        form.add(button6);
    }
    class ButtonEvent1 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String message = "Вы успешно добавили элемент!";
            Operations.addArray(A, field.getText());
            JOptionPane.showMessageDialog(null, message, "Успех", JOptionPane.PLAIN_MESSAGE);
        }
    }
    class ButtonEvent2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                String message = Operations.searchByID(A, Integer.parseInt(field.getText()));
                JOptionPane.showMessageDialog(null, message, "Успех", JOptionPane.PLAIN_MESSAGE);
            } catch (SearchException ex) {
                JOptionPane.showMessageDialog(null, "Не найден искомый покупатель", "Ошибка", JOptionPane.PLAIN_MESSAGE);
                ex.printStackTrace();
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Введенный элемент не является числом", "Ошибка", JOptionPane.PLAIN_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
    class ButtonEvent3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                String message = Operations.searchByName(A, field.getText());
                JOptionPane.showMessageDialog(null, message, "Успех", JOptionPane.PLAIN_MESSAGE);
            }
            catch (EmptyStringException a){
                    JOptionPane.showMessageDialog(null, "Введенная строка пустая", "Ошибка", JOptionPane.PLAIN_MESSAGE);
                    a.printStackTrace();
                }
            catch (SearchException a){
                    JOptionPane.showMessageDialog(null, "Не найден искомый клиент", "Ошибка", JOptionPane.PLAIN_MESSAGE);
                    a.printStackTrace();
                }
        }
    }
    class ButtonEvent4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, Operations.readArray(A), "Список", JOptionPane.PLAIN_MESSAGE);
        }
    }
    class ButtonEvent5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Operations.sortArray(A);
            JOptionPane.showMessageDialog(null,"Список успешно отсортирован", "Успех", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
