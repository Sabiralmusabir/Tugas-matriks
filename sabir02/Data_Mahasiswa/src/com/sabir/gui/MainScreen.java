package com.sabir.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends JFrame{
    private JPanel panelMain;
    private JList jListMahasiswa;
    private JButton buttonFilter;
    private JTextField textFieldFilter;
    private JTextField textFieldNim;
    private JTextField textFieldNama;
    private JTextField textFieldIpk;
    private JButton buttonSave;
    private JButton buttonDelete;
    private JButton buttonClear;

    public List<Mahasiswa> arrayList = new ArrayList<>();

    public  DefaultListModel defaultListModel = new DefaultListModel<>();

    class Mahasiswa{
        private String nama;

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public Float getIpk() {
            return ipk;
        }

        public void setIpk(Float ipk) {
            this.ipk = ipk;
        }

        private String nim;
        private Float ipk;
    }

    public MainScreen(){
        super("Data Mahasiswa");
        this.setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nama= textFieldNama.getText();
                String nim= textFieldNim.getText();
                Float ipk= Float.valueOf(textFieldIpk.getText());

                Mahasiswa mahasiswa = new Mahasiswa();

                mahasiswa.setIpk(ipk);
                mahasiswa.setNama(nama);
                mahasiswa.setNim(nim);

                arrayList.add(mahasiswa);
                setBtnClear();

                fromMahasiswaToListModel();
            }
        });
        jListMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int index = jListMahasiswa.getSelectedIndex();

                if(index < 0)
                    return;

                String nama = jListMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arrayList.size() ; i++) {
                    Mahasiswa mahasiswa = arrayList.get(i);
                    textFieldIpk.setText(String.valueOf(mahasiswa.getIpk()));
                    textFieldNama.setText(mahasiswa.getNama());
                    textFieldNim.setText(mahasiswa.getNim());
                    break;
                }

            }
        });
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnClear();
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jListMahasiswa.getSelectedIndex();

                if(index < 0)
                    return;

                String nama =jListMahasiswa.getSelectedValue().toString();

                for (int i = 0; i <arrayList.size() ; i++) {
                    if(arrayList.get(i).getNama().equals(nama)){
                        arrayList.remove(i);
                        break;
                    }
                }

                setBtnClear();
                fromMahasiswaToListModel();
            }
        });
        buttonFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String keyWord = textFieldFilter.getText();

                List<String> filtered = new ArrayList<>();

                for (int i = 0; i <arrayList.size() ; i++) {
                    if(arrayList.get(i).getNama().contains(keyWord)){
                        filtered.add(arrayList.get(i).getNama());
                    }
                }
                refreshListModel(filtered);
            }
        });
    }

    private void fromMahasiswaToListModel(){
        List<String> listNamaMahasiswa = new ArrayList<>();

        for (int i = 0; i < arrayList.size() ; i++) {
            listNamaMahasiswa.add(
                    arrayList.get(i).getNama()
            );
        }
        refreshListModel (listNamaMahasiswa);
    }

    private void setBtnClear(){
        textFieldIpk.setText("");
        textFieldNama.setText("");
        textFieldNim.setText("");
    }
    private void  refreshListModel(List<String> list){
        defaultListModel.clear();
        defaultListModel.addAll(list);
        jListMahasiswa.setModel(defaultListModel);
    }

    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }
}
