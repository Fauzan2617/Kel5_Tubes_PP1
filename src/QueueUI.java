import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueUI extends JFrame {
    private StrukturQueue queue;

    private JTextField namaField;
    private JTextField nimField;
    private JTextField universitasField;
    private JTextField MatkulField;
    private JTextArea displayArea;

    private String String;

    public QueueUI() {
        queue = new StrukturQueue();
        setupUI();
    }

    private void setupUI() {
        setTitle("System Database Mahasiswa");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 3));

        inputPanel.add(new JLabel("Nama:"));
        namaField = new JTextField();
        inputPanel.add(namaField);

        inputPanel.add(new JLabel("NIM:"));
        nimField = new JTextField();
        inputPanel.add(nimField);

        inputPanel.add(new JLabel("Universitas:"));
        universitasField = new JTextField();
        inputPanel.add(universitasField);

        
        inputPanel.add(new JLabel("Matkul:"));
        MatkulField = new JTextField();
        inputPanel.add(MatkulField);

        JButton addButton = new JButton("Tambah Mahasiswa");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMahasiswa();
            }
        });
        inputPanel.add(addButton);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);



        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        JButton removeButton = new JButton("Hapus Mahasiswa");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeMahasiswa();
            }
        });
        buttonPanel.add(removeButton);

        JButton searchButton = new JButton("Cari Mahasiswa");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchMahasiswa();
            }
        });
        buttonPanel.add(searchButton);

        JButton displayButton = new JButton("Tampilkan Semua Mahasiswa");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });
        buttonPanel.add(displayButton);

        // Add Panels to Frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addMahasiswa() {
        String nama = namaField.getText();
        String universitas = universitasField.getText();
        int nim = Integer.parseInt(nimField.getText());

        String Matkul = MatkulField.getText();

        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, universitas, Matkul);
        queue.enqueue(mahasiswa);

        JOptionPane.showMessageDialog(this, "Mahasiswa berhasil ditambahkan.");
        namaField.setText("");
        nimField.setText("");
        universitasField.setText("");
        MatkulField.setText("");
    }

    private void removeMahasiswa() {
        Mahasiswa mahasiswa = queue.dequeue();
        if (mahasiswa != null) {
            JOptionPane.showMessageDialog(this, "Mahasiswa yang dihapus: " + mahasiswa);
        } else {
            JOptionPane.showMessageDialog(this, "Queue kosong");
        }
    }

    private void searchMahasiswa() {
        String nimStr = JOptionPane.showInputDialog(this, "Masukkan NIM:");
        if (nimStr != null) {
            int nim = Integer.parseInt(nimStr);
            Mahasiswa mahasiswa = queue.search(nim);
            if (mahasiswa != null) {
                JOptionPane.showMessageDialog(this, "Mahasiswa ditemukan: " + mahasiswa);
            } else {
                JOptionPane.showMessageDialog(this, "Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            }
        }
    }

    private void displayAll() {
        displayArea.setText("");
        NodeQueue curNode = queue.getFRONT();
        while (curNode != null) {
            displayArea.append(curNode.getData().toString() + "\n");
            curNode = curNode.getNext();
        }
    }
}
